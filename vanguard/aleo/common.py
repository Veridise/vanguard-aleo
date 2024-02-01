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

# ref (Aleo grammar): https://developer.aleo.org/aleo/grammar/

def run_command(cmd: Union[str, List[Union[str, Path]]], decode=True):
    if isinstance(cmd, str):
        logging.info(f"  cmd: {cmd}")
        proc = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, shell=True)
    elif isinstance(cmd, list):
        logging.info(f"  cmd: {shlex.join(map(str, cmd))}")
        proc = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    else:
        raise Exception(f"unsupported command type, got: {cmd}")
    
    if proc.returncode != 0:
        err_contents = proc.stdout.decode("utf-8")
        raise Exception(f"command failed with message:\n{err_contents}")
    
    return proc.stdout.decode() if decode else proc.stdout

def aleo2json(path: Union[str, Path]):
    cmd = ["aleo2json", path]
    out = run_command(cmd)
    return json.loads(out)

def assert_node_field(node, field, val=None):
    assert field in node.keys(), f"Can't find filed {field} in node"
    if val is not None:
        assert node[field] == val, f"Mismatch of {field} of node, expected: {val}, got: {node[field]}"

def assert_range(value, range):
    assert value in range, f"Value {value} is not in range {range}"

def trim_inst(inst: str):
    # remove space in "; " in array literals
    # remove tailing semi-colon ";"
    return inst.replace("; ", ";").strip(";")

def parse_instance(v: str):
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
        # mapping access
        r = re.match( r"^(.*?)\[(.*?)\]$", v )
        identifier = r.group(1)
        operand = r.group(2)
        return ("mapping", identifier, operand)
    else:
        ts = [
            "u128", "u64", "u32", "u16", "u8",
            "i128", "i64", "i32", "i16", "i8",
            "field", "group", "scalar"
        ]
        for p in ts:
            if v.endswith(p):
                return (p, int(v[:len(p)-1]))
        raise NotImplementedError(f"Unsupported instance: {v}")

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