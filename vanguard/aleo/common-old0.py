import argparse
import subprocess
import logging
import inspect
import shlex
import shutil
import json
import os
import re

from pathlib import Path
from typing import List, Union
from lark import Lark, Token, Tree, Transformer, Discard

# https://stackoverflow.com/questions/74550878/lark-how-to-ignore-whitespace-after-parsing
class SpaceTransformer(Transformer):
    def WS(self, tok: Token):
        return Discard
    def CWS(self, tok: Token):
        return Discard

# ref (Aleo grammar): https://developer.aleo.org/aleo/grammar/
# ref (Aleo grammar): https://github.com/AleoHQ/grammars/blob/master/aleo.abnf
# load a parser in the module
with open(Path(__file__).parent.resolve() / "program-compatible.lark", "r") as f:
    raw_lark = f.read()
parser = Lark(raw_lark)

def aleo2json(path: Union[str, Path]):
    with open(path, "r") as f:
        raw_aleo = f.read()
    tree0 = parser.parse(raw_aleo)
    tree1 = SpaceTransformer().transform(tree0)
    obj = tree2json(tree1)
    return obj

def tree2json(node):
    if isinstance(node, Tree):
        if node.children is None:
            return [node.data.value]
        else:
            return [node.data.value] + [tree2json(p) for p in node.children]
    elif isinstance(node, Token):
        return node.value
    elif node is None:
        # None is for missed match of alternative token (epxressed in [] in lark)
        return None
    else:
        raise NotImplementedError(f"Unsupported type for tree2json, got: {node}")
    
def simplify_json(node):
    # post-order traversal
    match node:
        case ["uppercase_letter", v]:
            return v
        case ["lowercase_letter", v]:
            return v
        case ["letter", v]:
            return simplify_json(v)
        
        case ["digit", v]:
            return int(v)
        
        case ["identifier", *vs]:
            return "".join(map(str, [ simplify_json(v) for v in vs ]))
        case ["lowercase_identifier", *vs]:
            return "".join(map(str, [ simplify_json(v) for v in vs ]))
        # skipped: program_name
        # skipped: program_domain
        case ["program_id", v0, ".", v1]:
            return ["program_id", simplify_json(v0), simplify_json(v1)]
        case ["locator", v0, "/", v1]:
            return ["locator", simplify_json(v0), simplify_json(v1)]
        
        case ["register", *vs]:
            return "".join(map(str, [ simplify_json(v) for v in vs ]))
        # register accessor variants
        case ["register_accessor", ".", v0]:
            return ["register_accessor", simplify_json(v0)]
        case ["register_accessor", "[", v0, "]"]:
            # could be u32 or single digit
            return ["register_accessor", simplify_json(v0)]
        case ["register_accessor", "[", *vs, "]"]:
            # multiple digits
            return ["register_accessor"] + [int("".join(map(str, [simplify_json(v) for v in vs])))]
        # skipped: register_access

        case ["signed_literal", v0, *vs, v1]:
            # v0: sign | vs: digits | v1: type
            if v0 is None:
                return ["signed_literal"] + [ int("".join(map(str, [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
            else:
                return ["signed_literal"] + [ int("".join(map(str, [simplify_json(v0)] + [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
        case ["unsigned_literal", v0, *vs, v1]:
            # v0: sign | vs: digits | v1: type
            if v0 is None:
                return ["unsigned_literal"] + [ int("".join(map(str, [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
            else:
                return ["unsigned_literal"] + [ int("".join(map(str, [simplify_json(v0)] + [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
        case ["integer_literal", v0]:
            return simplify_json(v0)
        case ["field_literal", v0, *vs, v1]:
            # v0: sign | vs: digits | v1: type
            if v0 is None:
                return ["field_literal"] + [ int("".join(map(str, [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
            else:
                return ["field_literal"] + [ int("".join(map(str, [simplify_json(v0)] + [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
        case ["group_literal", v0, *vs, v1]:
            # v0: sign | vs: digits | v1: type
            if v0 is None:
                return ["group_literal"] + [ int("".join(map(str, [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
            else:
                return ["group_literal"] + [ int("".join(map(str, [simplify_json(v0)] + [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
        case ["scalar_literal", v0, *vs, v1]:
            # v0: sign | vs: digits | v1: type
            if v0 is None:
                return ["scalar_literal"] + [ int("".join(map(str, [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
            else:
                return ["scalar_literal"] + [ int("".join(map(str, [simplify_json(v0)] + [ simplify_json(v) for v in vs ]))) ] + [simplify_json(v1)]
        case ["arithmetic_literal", v0]:
            return simplify_json(v0)
        case ["u32_literal", v0, *vs, "u32"]:
            # v0: sign
            if v0 is None:
                return ["u32_literal"] + [ int("".join(map(str, [ simplify_json(v) for v in vs ]))) ]
            else:
                return ["u32_literal"] + [ int("".join(map(str, [simplify_json(v0)] + [ simplify_json(v) for v in vs ]))) ]

        case ["address_literal", "aleo1", *vs]:
            return ["address_literal"] + ["aleo1"+"".join([simplify_json(v) for v in vs])]
        case ["signature_literal", "sign1", *vs]:
            return ["signature_literal"] + ["sign1"+"".join([simplify_json(v) for v in vs])]
        case ["address_or_signature_char", v]:
            return v
        
        case ["boolean_literal", v0]:
            return ["boolean_literal", True if v0 == "true" else False]

        case ["literal", v0]:
            return simplify_json(v0)
        
        case ["operand", v0]:
            if isinstance(v0, str):
                return ["operand", simplify_json(v0)]
            else:
                return simplify_json(v0)
            
        # skipped: unsigned_type
        # skipped: signed_type
        case ["integer_type", v0]:
            return simplify_json(v0)
        # skipped: field_type
        # skipped: group_type
        # skipped: scalar_type
        case ["arithmetic_type", v0]:
            return simplify_json(v0)
        # skipped: address_type
        # skipped: boolean_type
        # skipped: signature_type
        case ["literal_type", v0]:
            return simplify_json(v0)
        case ["array_type", "[", v0, ";", v1, "]"]:
            return ["array_type", simplify_json(v0), simplify_json(v1)]
        case ["plaintext_type", v0]:
            return simplify_json(v0)
        case ["value_type", v0, v1]:
            # v0: subtype | v1: visibility
            return ["value_type", simplify_json(v0), simplify_json(v1)]
        case ["mapping_type", v0, v1]:
            return ["mapping_type", simplify_json(v0), simplify_json(v1)]
        case ["finalize_type", v0, v1]:
            return ["finalize_type", simplify_json(v0), simplify_json(v1)]
        case ["entry_type", v0, v1]:
            return ["entry_type", simplify_json(v0), simplify_json(v1)]
        case ["register_type", *vs]:
            if len(vs) == 1:
                # subtype of plaintext_type, just append
                return simplify_json(vs[0])
            else:
                return ["register_type"] + [ simplify_json(v) for v in vs ]

        case ["import", "import", v0, ";"]:
            return ["import", simplify_json(v0)]

        case ["mapping", "mapping", v0, ":", *vs]:
            return ["mapping", simplify_json(v0)] + [ simplify_json(v) for v in vs ]
        case ["mapping_key", v0, "as", v1, ";"]:
            return ["mapping_key", simplify_json(v0), simplify_json(v1)]
        case ["mapping_value", v0, "as", v1, ";"]:
            return ["mapping_value", simplify_json(v0), simplify_json(v1)]

        case ["struct", "struct", v0, ":", *vs]:
            return ["struct", simplify_json(v0)] + [ simplify_json(v) for v in vs ]
        case ["tuple", v0, "as", v1, ";"]:
            return ["tuple", simplify_json(v0), simplify_json(v1)]
        
        case ["record", "record", v0, ":", "owner", "as", v1, ";", *vs]:
            return ["record", simplify_json(v0), simplify_json(v1)] + [ simplify_json(v) for v in vs ]
        case ["entry", v0, "as", v1, ";"]:
            return ["entry", simplify_json(v0), simplify_json(v1)]

        # skipped: unary_op
        # skipped: binary_op
        # skipped: is_op
        # skipped: assert_op
        # skipped: commit_op
        # skipped: hash1_op
        # skipped: hash2_op
        # skipped: cast_op
        case ["cast_destination", v0]:
            if isinstance(v0, str):
                return ["cast_destination", simplify_json(v0)]
            else:
                return simplify_json(v0)
        case ["unary", v0, v1, "into", v2]:
            # v0: binary_op | v1: operand | v2: ra
            return [v0[1], simplify_json(v1), simplify_json(v2)]
        case ["binary", v0, v1, v2, "into", v3]:
            # v0: binary_op | v1, v2: operand | v3: ra
            return [v0[1], simplify_json(v1), simplify_json(v2), simplify_json(v3)]
        case ["ternary", "ternary", v0, v1, v2, "into", v3]:
            # v0, v1, v2: operand | v3: ra
            return ["ternary", simplify_json(v0), simplify_json(v1), simplify_json(v2), simplify_json(v3)]
        case ["is", v0, v1, v2, "into", v3]:
            # v0: is_op | v1, v2: operand | v3: ra
            return [v0[1], simplify_json(v1), simplify_json(v2), simplify_json(v3)]
        case ["assert", v0, v1, v2]:
            # v0: assert_op | v1, v2: operand
            return [v0[1], simplify_json(v1), simplify_json(v2)]
        case ["commit", v0, v1, v2, v3, v4]:
            # v0: commit_op | v1, v2: operand | v3: ra | v4: ...
            return [v0[1], simplify_json(v1), simplify_json(v2), simplify_json(v3), simplify_json(v4)]
        case ["hash1", v0, v1, v2, v3]:
            return [v0[1], simplify_json(v1), simplify_json(v2), simplify_json(v3)]
        case ["hash2", v0, v1, v2, v3, v4]:
            return [v0[1], simplify_json(v1), simplify_json(v2), simplify_json(v3), simplify_json(v4)]
        case ["hash", v0]:
            return simplify_json(v0)
        case ["signverify", s0, v0, v1, v2, "into", v3]:
            return [s0, simplify_json(v0), simplify_json(v1), simplify_json(v2), simplify_json(v3)]
        case ["cast", v0, *vs, v1, v2]:
            # v0: cast_op | vs: operands | v1: ra | v2: cast_destination
            return [v0[1]] + [simplify_json(v) for v in vs] + [simplify_json(v1), simplify_json(v2)]
        case ["call", "call", *vs]:
            # FIXME: multiple stars not supported, keep "into" instead
            return ["call"] + [simplify_json(v) for v in vs]
        case ["async", "async", v0, *vs, "into", v1]:
            # v0: identifier | vs: operands | v1: ra
            return ["async", simplify_json(v0)] + [simplify_json(v) for v in vs] + [simplify_json(v1)]
        case ["instruction", v0, ";"]:
            return ["instruction", simplify_json(v0)]
        case ["contains", "contains", v0, "[", v1, "]", "into", v2, ";"]:
            return ["contains", simplify_json(v0), simplify_json(v1), simplify_json(v2)]
        case ["get", "get", v0, "[", v1, "]", "into", v2, ";"]:
            # v0: identifier | v1: operand | v2: ra
            return ["get", simplify_json(v0), simplify_json(v1), simplify_json(v2)]
        case ["get_or_use", "get.or_use", v0, "[", v1, "]", v2, "into", v3, ";"]:
            return ["get.or_use", simplify_json(v0), simplify_json(v1), simplify_json(v2), simplify_json(v3)]
        case ["set", "set", v0, "into", v1, "[", v2, "]", ";"]:
            return ["set", simplify_json(v0), simplify_json(v1), simplify_json(v2)]
        case ["remove", "remove", v0, "[", v1, "]", ";"]:
            return ["remove", simplify_json(v0), simplify_json(v1)]
        case ["random", "rand.chacha", "into", v0, "as", v1, ";"]:
            return ["random.chacha", simplify_json(v0), simplify_json(v1)]
        # skipped: label
        case ["position", "position", v0, ";"]:
            return ["position", simplify_json(v0)]
        # skipped: branch_op
        case ["branch", v0, v1, v2, "to", v3, ";"]:
            # v0: branch_op | v1, v2: operand | v3: label
            return [v0[1], simplify_json(v1), simplify_json(v2), simplify_json(v3)]
        case ["await", "await", v0, ";"]:
            return ["await", v0]
        case ["command", v0]:
            return ["command", simplify_json(v0)]
        
        case ["closure", "closure", v0, ":", *vs]:
            # closure doesn't have a finalize block
            # vs's length is varying, with inputs/instructions/outputs
            return ["closure", simplify_json(v0)] + [ simplify_json(v) for v in vs ]
        case ["closure_input", "input", v0, "as", v1, ";"]:
            return ["closure_input", simplify_json(v0), simplify_json(v1)]
        case ["closure_output", "output", v0, "as", v1, ";"]:
            return ["closure_output", simplify_json(v0), simplify_json(v1)]
        
        case ["function", "function", v0, ":", *vs, v1]:
            # v1 is the finalize block
            # vs's length is varying, with inputs/instructions/outputs
            return ["function", simplify_json(v0)] + [ simplify_json(v) for v in vs ] + [simplify_json(v1)]
        case ["function_input", "input", v0, "as", v1, ";"]:
            return ["function_input", simplify_json(v0), simplify_json(v1)]
        case ["function_output", "output", v0, "as", v1, ";"]:
            return ["function_output", simplify_json(v0), simplify_json(v1)]
        case ["finalize", "finalize", v0, ":", *vs]:
            return ["finalize", simplify_json(v0)] + [simplify_json(v) for v in vs]
        case ["finalize_input", "input", v0, "as", v1, ";"]:
            return ["finalize_input", simplify_json(v0), simplify_json(v1)]

        case ["program", *vs]:
            return ["program"] + [ simplify_json(v) for v in vs if isinstance(v, list) ]
        case ["start", v]:
            return simplify_json(v)

        case _:
            if isinstance(node, dict):
                return { k: simplify_json(v) for k,v in node.items() }
            elif isinstance(node, list):
                return [ simplify_json(v) for v in node ]
            else:
                return node

def trim_inst(inst: str):
    # remove space in "; " in array literals
    # remove tailing semi-colon ";"
    return inst.replace("; ", ";").strip(";")

def parse_word(v: str):
    # parse register/constants
    # returns a tuple (type, parsed_value)
    # NOTE: some values are parsed but some are not, 
    #       based on convenience of computation

    if v == "true":
        return ("boolean", True)
    elif v == "false":
        return ("boolean", False)
    elif v.startswith("r"):
        # register
        return ("register", v)
    elif v.startswith("aleo1"):
        # address constant
        return ("address", v)
    elif "[" in v and "]" in v:
        # array access
        r = re.match( r"^(.*?)\[(.*?)\]$", v )
        identifier = r.group(1)
        operand = r.group(2)
        return ("array", identifier, operand)
    elif "/" in v:
        assert v.count("/") == 1, f"Unrecognized external reference pattern, got: {v}"
        ps = v.split("/")
        loc = ps[0]
        fn = ps[1]
        return ("external", loc, fn)
    elif v[0].isdigit():
        ts = [
            "u128", "u64", "u32", "u16", "u8",
            "i128", "i64", "i32", "i16", "i8",
            "field", "group", "scalar"
        ]
        for p in ts:
            if v.endswith(p):
                return ("number", p, int(v[:len(p)-1]))
        raise NotImplementedError(f"Unsupported number type, got: {v}")
    else:
        # if no pattern is eventually matched, parse as identifier
        return ("identifier", v)

def get_ifg_edges(prog, func, hash=False, call=False, inline=False):
    """Get information flow graph edges.
    Args:
      - prog: 
      - func
      - hash (default: False): whether to treat a hash function call directly as an edge
      - call (default: False): whether to treat a call directly as an edge
      - inline (default: False): whether to inline call invocations recursively to generate edges;
        if `call` is True, this argument is then overridden and no inlining will take place.
    Rets: A list of pairs of strings
    """
    node = prog.functions[func]
    assert_node_field(node, "instructions")

    edges = []
    # process instructions
    for inst in node["instructions"] + node["outputs"]:
        tokens = trim_inst(inst["str"]).split()
        match tokens:

            case ["is.eq", o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            case ["is.neq", o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            
            case ["assert.eq", o1, o2]:
                edges.append((o1, o2))
                edges.append((o2, o1))
            case ["assert.neq", o1, o2]:
                edges.append((o1, o2))
                edges.append((o2, o1))

            case ["cast", o, "into", r, "as", d]:
                edges.append((o, r))

            case ["call", *ts]:
                # manualy match the call component since there are two sequences of varying lengths
                idx_into = tokens.index("into")
                f = tokens[1]
                os = tokens[2:idx_into]
                rs = tokens[idx_into+1:]
                if call:
                    for o in os:
                        for r in rs:
                            # overapproximated edges from every o to every r
                            edges.append((o, r))
                elif inline:
                    # TODO: add impl
                    raise NotImplementedError
                else:
                    # no inline, no call, then no edge
                    pass
            
            case ["async", *ts]:
                # FIXME: can't find official documentation for now, treated as call
                # manualy match the call component since there are two sequences of varying lengths
                idx_into = tokens.index("into")
                f = tokens[1]
                os = tokens[2:idx_into]
                rs = tokens[idx_into+1:]
                if call:
                    for o in os:
                        for r in rs:
                            # overapproximated edges from every o to every r
                            edges.append((o, r))
                elif inline:
                    # TODO: add impl
                    raise NotImplementedError
                else:
                    # no inline, no call, then no edge
                    pass

            case [cop, o1, o2, "into", r, "as", t] if cop.startswith("commit"):
                # no edge in commitment computation
                pass

            case [hop, o1, "into", r, "as", t] if hop.startswith("hash"):
                # no edge in hash computation
                pass

            case [binop, o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            
            case [unop, o, "into", r]:
                edges.append((o, r))
            
            case [terop, o1, o2, o3, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
                edges.append((o3, r))

            case ["cast", *os, "into", dst, "as", typ]:
                for o in os:
                    edges.append((o, dst))
            
            case ["output", o, "as", typ]:
                # no edge in output command
                pass

            case _:
                raise NotImplementedError(f"Unknown instruction pattern, got: {inst['str']}")

    return edges

def get_dfg_edges(prog, func):
    """Get data flow graph edges.
    Args:
      - prog: 
      - func:
    Rets: A list of pairs of strings
    """
    node = prog.functions[func]
    assert_node_field(node, "instructions")

    edges = []
    # process instructions
    for inst in node["instructions"]:
        tokens = trim_inst(inst["str"]).split()
        match tokens:

            case ["is.eq", o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            case ["is.neq", o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            
            case ["assert.eq", o1, o2]:
                edges.append((o1, o2))
                edges.append((o2, o1))
            case ["assert.neq", o1, o2]:
                edges.append((o1, o2))
                edges.append((o2, o1))

            case ["cast", o, "into", r, "as", d]:
                edges.append((o, r))
            
            case ["call", *ts]:
                # manualy match the call component since there are two sequences of varying lengths
                idx_into = tokens.index("into")
                f = tokens[1]
                os = tokens[2:idx_into]
                rs = tokens[idx_into+1:]
                # no inlining, just add edge from this level
                for o in os:
                    for r in rs:
                        # overapproximated edges from every o to every r
                        edges.append((o, r))

            case ["async", *ts]:
                # FIXME: can't find official documentation for now, treated as call
                # manualy match the call component since there are two sequences of varying lengths
                idx_into = tokens.index("into")
                f = tokens[1]
                os = tokens[2:idx_into]
                rs = tokens[idx_into+1:]
                # no inlining, just add edge from this level
                for o in os:
                    for r in rs:
                        # overapproximated edges from every o to every r
                        edges.append((o, r))

            case [cop, o1, o2, "into", r, "as", t] if cop.startswith("commit"):
                edges.append((o1, r))
                edges.append((o2, r))

            case [hop, o1, "into", r, "as", t] if hop.startswith("hash"):
                edges.append((o1, r))

            case [binop, o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            
            case [unop, o, "into", r]:
                edges.append((o, r))
            
            case [terop, o1, o2, o3, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
                edges.append((o3, r))

            case ["cast", *os, "into", dst, "as", typ]:
                for o in os:
                    edges.append((o, dst))

            case ["output", o, "as", typ]:
                # no edge in output command
                pass
            
            case _:
                raise NotImplementedError(f"Unknown instruction pattern, got: {inst['str']}")

    return edges