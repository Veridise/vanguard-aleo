import networkx as nx

from enum import Enum

from ..grammar import AleoProgram, AleoEnvironment

class Dom(Enum):
    # abstract domain

    NEG = -1
    ZERO = 0
    POS = 1

    FALSE = 100
    TRUE = 101

class Val:
    # some pre-defined set
    # NOTE: this is a normal class, so values don't get hased and are iterable

    # this is usually not used, use with caution
    TOP = {Dom.NEG, Dom.ZERO, Dom.POS, Dom.FALSE, Dom.TRUE}

    ALLINT = {Dom.NEG, Dom.ZERO, Dom.POS}
    NNINT = {Dom.ZERO, Dom.POS} # non-negative int
    NPINT = {Dom.NEG, Dom.ZERO} # non-positive int

    ALLBOOL = {Dom.FALSE, Dom.TRUE}

    BOT = set() # exception status

def fabs(p):
    if p[0] == "boolean":
        # bool
        if p[1] == True:
            return {Dom.TRUE}
        else:
            return {Dom.FALSE}
    elif p[0] == "number":
        # integers
        if p[2] == 0:
            return {Dom.ZERO}
        elif p[2] < 0:
            return {Dom.NEG}
        else:
            return {Dom.POS}
    elif p[0] == "address":
        # address
        return Val.BOT
    else:
        raise NotImplementedError(f"Unsupported type for abstraction, got: {p}")
    
def generate_absop(ltab):
    # ltab: look-up table
    # construct function
    def do(a, b):
        r = set()
        for a0 in a:
            for b0 in b:
                r.update(ltab[a0][b0])
        return r
    # return the function
    return do

class AbsOp:
    # NOTE: let it throw an exception if abs value is not found, as Aleo should be type checked
    #       and it's usually the interpreter's issue when there's an exception

    ADD = generate_absop({
        Dom.NEG:  { Dom.NEG: {Dom.NEG}, Dom.ZERO: {Dom.NEG}, Dom.POS: Val.ALLINT },
        Dom.ZERO: { Dom.NEG: {Dom.NEG}, Dom.ZERO: {Dom.ZERO}, Dom.POS: {Dom.POS} },
        Dom.POS:  { Dom.NEG: Val.ALLINT, Dom.ZERO: {Dom.POS}, Dom.POS: {Dom.POS} },
    })

    MUL = generate_absop({
        Dom.NEG:  { Dom.NEG: {Dom.POS}, Dom.ZERO: {Dom.ZERO}, Dom.POS: {Dom.NEG} },
        Dom.ZERO: { Dom.NEG: {Dom.ZERO}, Dom.ZERO: {Dom.ZERO}, Dom.POS: {Dom.ZERO} },
        Dom.POS:  { Dom.NEG: {Dom.NEG}, Dom.ZERO: {Dom.ZERO}, Dom.POS: {Dom.POS} },
    })

    DIV = generate_absop({
        Dom.NEG:  { Dom.NEG: {Dom.POS},  Dom.ZERO: set(), Dom.POS: {Dom.NEG} },
        Dom.ZERO: { Dom.NEG: {Dom.ZERO}, Dom.ZERO: set(), Dom.POS: {Dom.ZERO} },
        Dom.POS:  { Dom.NEG: {Dom.NEG},  Dom.ZERO: set(), Dom.POS: {Dom.POS} },
    })

    GTE = generate_absop({
        Dom.NEG:  { Dom.NEG: Val.ALLBOOL, Dom.ZERO: {Dom.FALSE}, Dom.POS: {Dom.FALSE} },
        Dom.ZERO: { Dom.NEG: {Dom.TRUE},  Dom.ZERO: {Dom.TRUE},  Dom.POS: {Dom.FALSE} },
        Dom.POS:  { Dom.NEG: {Dom.TRUE},  Dom.ZERO: {Dom.TRUE}, Dom.POS: Val.ALLBOOL },
    })

    ISNEQ = generate_absop({
        Dom.NEG:  { Dom.NEG: Val.ALLBOOL, Dom.ZERO: {Dom.TRUE},  Dom.POS: {Dom.TRUE} },
        Dom.ZERO: { Dom.NEG: {Dom.TRUE},  Dom.ZERO: {Dom.FALSE}, Dom.POS: {Dom.TRUE} },
        Dom.POS:  { Dom.NEG: {Dom.TRUE},  Dom.ZERO: {Dom.TRUE},  Dom.POS: Val.ALLBOOL },
        Dom.FALSE:{ Dom.FALSE: {Dom.FALSE}, Dom.TRUE: {Dom.TRUE} },
        Dom.TRUE: { Dom.FALSE: {Dom.TRUE},  Dom.TRUE: {Dom.FALSE} },
    })

    ISEQ = generate_absop({
        Dom.NEG:  { Dom.NEG: Val.ALLBOOL, Dom.ZERO: {Dom.FALSE}, Dom.POS: {Dom.FALSE} },
        Dom.ZERO: { Dom.NEG: {Dom.FALSE}, Dom.ZERO: {Dom.TRUE},  Dom.POS: {Dom.FALSE} },
        Dom.POS:  { Dom.NEG: {Dom.FALSE}, Dom.ZERO: {Dom.FALSE}, Dom.POS: Val.ALLBOOL },
    })

def detector_divz(env: AleoEnvironment, prog: str, func: str):

    # store problematic instructions
    lines = []

    def visitor(pr: AleoProgram, fn: dict, inps: list):
        """Visit a program's function with inputs
        Arguments:
        - pr (AleoProgram): program to visit
        - fn (dict / JSON object): target function
        - inps (list): inputs to function
        """
        # load inputs, purely positional
        assert len(fn["inputs"]) == len(inps), f"Numbers of argument mismatch calling {fn['name']}, expected {len(fn['inputs'])}, got {len(inps)}"
        ctx = {
            f"r{fn['inputs'][i]['register']['value']}" : inps[i]
            for i in range(len(fn["inputs"]))
        }

        # interpretation
        for inst in fn["instructions"]:
            print(f"# [debug] executing: {inst["str"]}")
            tokens = inst["str"].strip(";").split()
            match tokens:

                # special abstract interpretation with detection
                case [op, v0, v1, "into", r0] if op in ["div", "div.w"]:
                    # parse
                    pv0 = env.evaluate_word(pr.id, ctx, v0, callback=fabs)
                    pv1 = env.evaluate_word(pr.id, ctx, v1, callback=fabs)
                    # detect
                    if Dom.ZERO in pv1:
                        lines.append(inst["str"])
                    # compute
                    cr0 = AbsOp.DIV(pv0, pv1)
                    # set
                    env.memory_set(pr.id, ctx, r0, cr0)

                # regular abstract interpretation
                case [op, v0, v1, "into", r0] if op in \
                     {"add", "mul", "is.neq", "is.eq", "gte"}:
                    # parse
                    pv0 = env.evaluate_word(pr.id, ctx, v0, callback=fabs)
                    pv1 = env.evaluate_word(pr.id, ctx, v1, callback=fabs)
                    # compute
                    OP = op.replace(".", "").upper()
                    cr0 = getattr(AbsOp, OP)(pv0, pv1)
                    # set
                    env.memory_set(pr.id, ctx, r0, cr0)

                case ["ternary", v0, v1, v2, "into", r0]:
                    # parse
                    pv0 = env.evaluate_word(pr.id, ctx, v0, callback=fabs)
                    pv1 = env.evaluate_word(pr.id, ctx, v1, callback=fabs)
                    pv2 = env.evaluate_word(pr.id, ctx, v2, callback=fabs)
                    # compute
                    cr0 = set()
                    if Dom.TRUE in pv0:
                        cr0.update(pv1)
                    if Dom.FALSE in pv0:
                        cr0.update(pv2)
                    # set
                    env.memory_set(pr.id, ctx, r0, cr0)

                case ["assert.eq", v0, v1]:
                    # no ctx change, skip for simplicity
                    pass

                case ["call", *ts]:
                    # extract call components
                    idx_into = tokens.index("into")
                    f = tokens[1]
                    vs = tokens[2:idx_into]
                    rs = tokens[idx_into+1:]
                    # collect parameters
                    params = [ env.evaluate_word(pr.id, ctx, v, callback=fabs) for v in vs ]
                    # locate function
                    p0, f0 = env.locate_function(pr.id, f)
                    # call function
                    outs = visitor(p0, f0, params)
                    # load outputs back to ctx
                    assert len(outs) == len(rs), f"Mismatch lengths of return, expected: {len(rs)}, got: {len(outs)}"
                    for r, o in zip(rs, outs):
                        env.memory_set(pr.id, ctx, r, o)
                
                case ["async", fn0, *vs, "into", r0]:
                    # async (Aleo) is finalize (Leo)
                    assert fn0 == fn["name"], f"Call of async need to have the same name, expected: {fn["name"]}, got: {fn0}"
                    assert "finalize_logic" in fn.keys(), f"Function {fn["name"]} doesn't have a finalize block"
                    # collect parameters
                    params = [ env.evaluate_word(pr.id, ctx, v, callback=fabs) for v in vs ]
                    # dispatch
                    outs = visitor(pr, fn["finalize_logic"], params)
                    assert len(outs) == 1, f"Finalize must only return one single status, got: {len(outs)}"
                    # load outputs back to ctx
                    env.memory_set(pr.id, ctx, r0, outs[0])

                case ["cast", *vs, "into", r0, "as", t0]:
                    print(tokens)
                    raise Exception()

                case ["set", v, "into", r]:
                    # set
                    env.memory_set(pr.id, ctx, v, r)

                case _:
                    raise NotImplementedError(f"Unsupported instruction: {inst['str']}")
        
        # get returning registers and return
        if fn["type"] == "FunctionCore" or fn["type"] == "ClosureCore":
            outs = []
            for p in fn["outputs"]:
                match p["operand"]["value"]["type"]:
                    case "Register":
                        outs.append(env.memory_get(pr.id, ctx, f"r{p["operand"]["value"]["value"]}"))
                    case "Literal":
                        if p["operand"]["value"]["value"]["type"] == "Integer":
                            outs.append(int(p["operand"]["value"]["value"]["integer"]))
                        else:
                            raise NotImplementedError(f"Unsupported return literal type, got: {p["operand"]["value"]["value"]["type"]}")
                    case _:
                        raise NotImplementedError(f"Unsupported return type, got: {p["operand"]["value"]["type"]}")
            return outs
        elif fn["type"] == "FinalizeCore":
            # return all bool for safe
            return [Val.ALLBOOL]
        else:
            raise NotImplementedError(f"Unsupported visitor node type, got: {fn["type"]}")

    # call visitor
    visitor(
        env.programs[prog],
        env.programs[prog].functions[func],
        [
            Val.ALLINT # FIXME: determine values by type
            for i in range(len(env.programs[prog].functions[func]["inputs"]))
        ]
    )

    return (len(lines)>0, lines)