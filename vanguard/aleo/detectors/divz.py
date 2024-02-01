import networkx as nx

from enum import Enum

from ..grammar import AleoProgram
from ..common import parse_instance

def detector_divz(prog: AleoProgram, func: str):
    """Detect for division by zero
    Args:
      - prog (AleoProgram):
      - func (str):
    Rets: (result, info)
    """

    lines = []
    # process output instructions
    for inst in prog.functions[func]["instructions"]:
        tokens = inst["str"].strip(";").split()
        match tokens:

            case ["div", v0, v1, "into", r]:
                if v1.startswith("0u"):
                    lines.append(inst["str"])

            case _:
                # fine for other cases
                pass
    
    return (len(lines)>0, lines)

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

def fabs(v):
    if isinstance(v, bool):
        # bool
        if v == True:
            return {Dom.TRUE}
        else:
            return {Dom.FALSE}
    elif isinstance(v, int):
        # integers
        if v == 0:
            return {Dom.ZERO}
        elif v < 0:
            return {Dom.NEG}
        else:
            return {Dom.POS}
    elif isinstance(v, str):
        # address
        return Val.BOT
    else:
        raise NotImplementedError(f"Unsupported type for abstraction, got: {v}")
    
def pget(mem, pid, env, path):
    # fetch variable from environment
    # if it's a literal, then convert to abstract value
    # otherwise, fetch directly from program's mem or function's env
    target = parse_instance(path)
    match target[0]:
        case "register":
            return env[target[1]]
        case "mapping":
            id = target[1][0]
            ac = target[1][1]
            ac_0 = pget(mem, pid, env, ac) # recursive, as operand can also be a path
            return mem[pid][id][ac_0]
        case "u128" | "u64" | "u32" | "u16" | "u8" | \
             "i128" | "i64" | "i32" | "i16" | "i8" | \
             "field" | "group" | "scalar" | "bool" | \
             "address":
            return fabs(target[1])
        case _:
            raise NotImplementedError(f"Unsupported path type for pget, got: {target}")

def pset(mem, pid, env, path, v):
    # set value
    target = parse_instance(path)
    match target[0]:
        case "register":
            env[target[1]] = v
        case "mapping":
            id = target[1][0]
            ac = target[1][1]
            ac_0 = pget(mem, pid, env, ac) # recursive, as operand can also be a path
            mem[pid][id][ac_0] = v
        case _:
            raise NotImplementedError(f"Unsupported path type for pset, got: {target}")
        
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

def detector_divz_new(prog: AleoProgram, func:str):

    # store problematic instructions
    lines = []

    # memory/storage for storing program-wise structures, e.g., mapping
    # needs a program name as key, separate between different programs
    mem = {}

    def visitor(pid, f, inps):
        # load inputs, purely positional
        assert len(f["inputs"]) == len(inps), f"Numbers of argument mismatch calling {f['name']}, expected {len(f['inputs'])}, got {len(inps)}"
        env = {
            f"r{f['inputs'][i]['register']['value']}" : inps[i]
            for i in range(len(f["inputs"]))
        }

        # interpretation
        for inst in f["instructions"]:
            print(f"# [debug] executing: {inst["str"]}")
            tokens = inst["str"].strip(";").split()
            match tokens:

                # special abstract interpretation with detection
                case [op, v0, v1, "into", r0] if op in ["div", "div.w"]:
                    # parse
                    pv0 = pget(mem, pid, env, v0)
                    pv1 = pget(mem, pid, env, v1)
                    # detect
                    if Dom.ZERO in pv1:
                        lines.append(inst["str"])
                    # compute
                    cr0 = AbsOp.DIV(pv0, pv1)
                    # set
                    pset(mem, pid, env, r0, cr0)

                # regular abstract interpretation
                case [op, v0, v1, "into", r0] if op in \
                     {"add", "mul", "is.neq", "is.eq", "gte"}:
                    # parse
                    pv0 = pget(mem, pid, env, v0)
                    pv1 = pget(mem, pid, env, v1)
                    # compute
                    OP = op.replace(".", "").upper()
                    cr0 = getattr(AbsOp, OP)(pv0, pv1)
                    # set
                    pset(mem, pid, env, r0, cr0)

                case ["ternary", v0, v1, v2, "into", r0]:
                    # parse
                    pv0 = pget(mem, pid, env, v0)
                    pv1 = pget(mem, pid, env, v1)
                    pv2 = pget(mem, pid, env, v2)
                    # compute
                    cr0 = set()
                    if Dom.TRUE in pv0:
                        cr0.update(pv1)
                    if Dom.FALSE in pv0:
                        cr0.update(pv2)
                    # set
                        pset(mem, pid, env, r0, cr0)

                case ["assert.eq", v0, v1]:
                    # no env change, skip for simplicity
                    pass

                case ["call", *ts]:
                    # extract call components
                    idx_into = tokens.index("into")
                    fn = tokens[1]
                    vs = tokens[2:idx_into]
                    rs = tokens[idx_into+1:]
                    # collect parameters
                    params = [ pget(mem, pid, env, v) for v in vs ]
                    # dispatch
                    outs = visitor(pid, prog.closures[fn], params)
                    # load outputs back to env
                    assert len(outs) == len(rs), f"Mismatch lengths of return, expected: {len(rs)}, got: {len(outs)}"
                    for r, o in zip(rs, outs):
                        pset(mem, pid, env, r, o)
                
                case ["async", fn, *vs, "into", r0]:
                    # async (Aleo) is finalize (Leo)
                    assert fn == f["name"], f"Call of async need to have the same name, expected: {f["name"]}, got: {fn}"
                    assert "finalize_logic" in f.keys(), f"Function {f["name"]} doesn't have a finalize block"
                    # collect parameters
                    params = [ pget(mem, pid, env, v) for v in vs ]
                    # dispatch
                    outs = visitor(pid, f["finalize_logic"], params)
                    assert len(outs) == 1, f"Finalize must only return one single status, got: {len(outs)}"
                    # load outputs back to env
                    pset(mem, pid, env, r0, outs[0])

                case ["set", v, "into", r]:
                    # set
                    pset(mem, pid, env, v, r)

                case _:
                    raise NotImplementedError(f"Unsupported instruction: {inst['str']}")
        
        # get returning registers and return
        if f["type"] == "FunctionCore" or f["type"] == "ClosureCore":
            # outs = [
            #     env[f"r{p['operand']['value']['value']}"]
            #     for p in f["outputs"]
            # ]
            outs = []
            for p in f["outputs"]:
                match p["operand"]["value"]["type"]:
                    case "Register":
                        outs.append(pget(mem, pid, env, f"r{p["operand"]["value"]["value"]}"))
                    case "Literal":
                        if p["operand"]["value"]["value"]["type"] == "Integer":
                            outs.append(int(p["operand"]["value"]["value"]["integer"]))
                        else:
                            raise NotImplementedError(f"Unsupported return literal type, got: {p["operand"]["value"]["value"]["type"]}")
                    case _:
                        raise NotImplementedError(f"Unsupported return type, got: {p["operand"]["value"]["type"]}")
            return outs
        elif f["type"] == "FinalizeCore":
            # return all bool for safe
            return [Val.ALLBOOL]
        else:
            raise NotImplementedError(f"Unsupported visitor node type, got: {f["type"]}")

    # initialize program-wise structures: mapping
    mem[prog.id] = { mvar: {} for mvar in prog.mappings.keys() }

    # call visitor
    visitor(
        prog.id,
        prog.functions[func],
        [
            Val.ALLINT # FIXME: determine values by type
            for i in range(len(prog.functions[func]["inputs"]))
        ]
    )

    return (len(lines)>0, lines)