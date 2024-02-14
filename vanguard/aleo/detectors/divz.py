from enum import Enum
from collections import defaultdict

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
    
def fabs(v):
    if isinstance(v, bool):
        return {Dom.TRUE} if v else {Dom.FALSE}
    elif isinstance(v, int):
        if v == 0:
            return {Dom.ZERO}
        else:
            return {Dom.POS} if v > 0 else {Dom.NEG}
    elif isinstance(v, str):
        return Val.BOT
    else:
        raise NotImplementedError(f"Unsupported type for abstraction, got: {v}")
    
def cast2int(v):
    # invalid cast
    if (Dom.FALSE not in v) and (Dom.TRUE not in v) and len(v) > 0:
        return Val.BOT
    
    r = set()
    if Dom.FALSE in v:
        r.add(Dom.ZERO)
    if Dom.TRUE in v:
        r.add(Dom.POS)
    return r
    
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

def detector_divz(env: AleoEnvironment, pid: str, fid: str):

    # store problematic instructions
    lines = []

    # create linked visitor
    def visitor(pid: str, fid: str, inps: list, finalize=False):
        """Visit a program's function with inputs
        Arguments:
        - pid (str): id of program to visit
        - fid (str): id of function/closure to visit
        - inps (list): inputs to function
        - finalize (bool): whether or not to visit the finalize block instead
        """
        # load function
        pr = env.programs[pid]
        fn = None
        if fid in pr.functions.keys():
            if finalize:
                fn = pr.functions[fid]["finalize"]
            else:
                fn = pr.functions[fid]
        else:
            assert not finalize, f"Closure {fid} doesn't have a finalize block"
            fn = pr.closures[fid]
        assert len(inps) == len(fn["inputs"]), f"Numbers of arguments mismatch, expected: {len(fn["inputs"])}, got: {len(inps)}"

        # create local context
        # SYNTAX: function input is always register
        ctx = {
            fn["inputs"][i][0] : inps[i]
            for i in range(len(inps))
        }

        # interpret
        for inst in fn["instructions"]:
            print(f"# [debug] inst: {inst}")
            match inst:

                # special instruction that triggers the detector
                case [op, d0, d1, r0] if op in {"div", "div.w"}:
                    # get
                    pd0, pd1 = env.rget(pid, d0, ctx=ctx, vfn=fabs), env.rget(pid, d1, ctx=ctx, vfn=fabs)
                    # detect
                    if Dom.ZERO in pd1:
                        lines.append(inst)
                    # compute, both sharing DIV abstract op
                    pr0 = AbsOp.DIV(pd0, pd1)
                    # set
                    env.rset(pid, r0, pr0, ctx=ctx)

                # regular instruction
                case [op, d0, d1, r0] if op in \
                    {"is.neq", "is.eq", "add", "mul"}:
                    # get
                    pd0, pd1 = env.rget(pid, d0, ctx=ctx, vfn=fabs), env.rget(pid, d1, ctx=ctx, vfn=fabs)
                    # compute
                    OP = op.replace(".", "").upper()
                    pr0 = getattr(AbsOp, OP)(pd0, pd1)
                    # set
                    env.rset(pid, r0, pr0, ctx=ctx)

                case ["ternary", d0, d1, d2, r0]:
                    # get
                    pd0 = env.rget(pid, d0, ctx=ctx, vfn=fabs)
                    pd1 = env.rget(pid, d1, ctx=ctx, vfn=fabs)
                    pd2 = env.rget(pid, d2, ctx=ctx, vfn=fabs)
                    # compute
                    pr0 = set()
                    if Dom.TRUE in pd0:
                        pr0.update(pd1)
                    if Dom.FALSE in pd0:
                        pr0.update(pd2)
                    # set
                    env.rset(pid, r0, pr0, ctx=ctx)
                
                # skipped instruction
                case ["assert.eq", *vs]:
                    # no ctx change, skip for simplicity
                    pass

                case ["call", *vs]:
                    # extract call components
                    idx_into = inst.index("into")
                    l0 = inst[1]
                    ds = inst[2:idx_into]
                    rs = inst[idx_into+1:]
                    # collect parameters
                    params = [ env.rget(pid, d, ctx=ctx, vfn=fabs) for d in ds ]
                    # locate function
                    p, f = env.locate_fc(pid, l0)
                    # dispatch
                    outs = visitor(p, f, params)
                    # update ctx
                    assert len(outs) == len(rs), f"Lengths mismatch of return, expected: {len(rs)}, got: {len(outs)}"
                    for r, o in zip(rs, outs):
                        env.rset(pid, r, o, ctx=ctx)

                case ["async", l0, *ds, r0]:
                    # async in Aleo is finalize in Leo
                    assert l0 == fid, f"Async id does not match function id, expected: {fid}, got: {l0}"
                    # collect parameters
                    params = [ env.rget(pid, d, ctx=ctx, vfn=fabs) for d in ds ]
                    # locate function
                    p, f = env.locate_fc(pid, l0)
                    # dispatch to finalize function
                    outs = visitor(p, f, params, finalize=True)
                    assert len(outs) == 1, f"Length of async return is always one, got: {len(outs)}"
                    # update ctx
                    env.rset(pid, r0, outs[0], ctx=ctx)

                case ["set", d0, m0, d1]:
                    # set d0 into m0[d1]
                    # SYNTAX: m0 is identifier of mapping
                    # set all, as d1 may be abstract already
                    # so here we collect all possible values
                    # and set the mapping as defaultdict
                    pd0 = env.rget(pid, d0, ctx=ctx, vfn=fabs)
                    # collect all possible values
                    pm0 = env.rget(pid, m0, ctx=None) # mapping, don't apply fabs
                    ss = set(pm0.values()) | pd0 # merge existing
                    # set mapping as defaultdict
                    pr.mem[m0] = defaultdict(lambda: ss)

                case ["cast", *ds, "into", r0, "as", dest0]:
                    # get
                    pds = [ env.rget(pid, d, ctx=ctx, vfn=fabs) for d in ds ]
                    # analyze cast destination
                    it = None
                    match dest0:
                        case s if isinstance(s, str):
                            # identifier as type, usually struct or record
                            # FIXME: find struct first, then records
                            if s in pr.struct_constructors.keys():
                                it = pr.struct_constructors[s](*pds)
                            elif s in pr.record_constructors.keys():
                                it = pr.record_constructors[s](*pds)
                            else:
                                raise Exception(f"Can't locate struct/record, got: {s}")
                        case ["register_type", t0, p0]:
                            # SYNTAX: p0 can be .future or .record
                            # FIXME: ignore modifier p0
                            # FIXME: find struct first, then records
                            if t0 in pr.struct_constructors.keys():
                                it = pr.struct_constructors[t0](*pds)
                            elif t0 in pr.record_constructors.keys():
                                it = pr.record_constructors[t0](*pds)
                            else:
                                raise Exception(f"Can't locate struct/record, got: {t0}")
                        case ["array_type", t0, shape0]:
                            assert len(shape0) == 1, f"Only 1-d array destination is supported for now, got: {dest0}"
                            assert len(pds) == shape0[0], f"Mismatch with array length, expected: {shape0[0]}, got: {len(pds)}"
                            it = pds # pds is a list/array already
                        case ["unsigned_type", t0]:
                            # cast to number
                            assert len(ds) == 1, f"{t0} type can only have 1 operand, got: {len(ds)}"
                            it = cast2int(pds[0])
                        # FIXME: add more patterns
                        case _:
                            raise NotImplementedError(f"Unsupported cast destination, got: {dest0}")
                    # set
                    env.rset(pid, r0, it, ctx=ctx)

                case ["random.chacha", *ds, r0, t0]:
                    # overapproximate
                    env.rset(pid, r0, Val.ALLINT, ctx=ctx)
                
                case _:
                    raise NotImplementedError(f"Unsupported instruction, got: {inst}")
        
        # pack and return
        if finalize:
            # return all bool for safe
            return [Val.ALLBOOL]
        else:
            return [ env.rget(pid, p[0], ctx, vfn=fabs) for p in fn["outputs"] ]

    # prepare to visit
    prog = env.programs[pid]
    func = prog.functions[fid] if fid in prog.functions.keys() else prog.closures[fid]
    # call visitor
    visitor(
        pid,
        fid,
        [
            Val.ALLINT # FIXME: determine values by type
            for i in range(len(func["inputs"]))
        ]
    )

    return (len(lines)>0, lines)