from typing import Union
from enum import Enum
from collections import defaultdict

from ..grammar import *
from ..abstract import AleoAbstractLiteral, absop2

class AbsDom(Enum):
    NEG = -1
    ZERO = 0
    POS = 1
    FALSE = 100
    TRUE = 101

    def TOP(): return {AbsDom.NEG, AbsDom.ZERO, AbsDom.POS, AbsDom.FALSE, AbsDom.TRUE}
    def ALLINT(): return {AbsDom.NEG, AbsDom.ZERO, AbsDom.POS}
    def NNINT(): return {AbsDom.ZERO, AbsDom.POS} # non-negative int
    def NPINT(): return {AbsDom.NEG, AbsDom.ZERO} # non-positive int
    def ALLBOOL(): return {AbsDom.FALSE, AbsDom.TRUE}
    def BOT(): return set()

# define and load abstract function
def abs(node):
    match node:
        case AleoAddressLiteral():
            return AleoAbstractLiteral(AbsDom.BOT())
        case AleoBooleanLiteral():
            if node.value:
                return AleoAbstractLiteral({AbsDom.TRUE})
            else:
                return AleoAbstractLiteral({AbsDom.FALSE})
        case AleoFieldLiteral() | AleoUnsignedLiteral() | AleoSignedLiteral():
            if node.value == 0:
                return AleoAbstractLiteral({AbsDom.ZERO})
            elif node.value > 0:
                return AleoAbstractLiteral({AbsDom.POS})
            else:
                return AleoAbstractLiteral({AbsDom.NEG})
        case _:
            raise NotImplementedError(f"Unsupported literal, got: {node}, type: {type(node)}")

# load class attribute
absops = {

    # binary operators
    AleoBinaryOp.ADD: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.ZERO: {AbsDom.NEG}, AbsDom.POS: AbsDom.ALLINT() },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.NEG}, AbsDom.ZERO: {AbsDom.ZERO}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: AbsDom.ALLINT(), AbsDom.ZERO: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.ADDW: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.ZERO: {AbsDom.NEG}, AbsDom.POS: AbsDom.ALLINT() },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.NEG}, AbsDom.ZERO: {AbsDom.ZERO}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: AbsDom.ALLINT(), AbsDom.ZERO: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    # AleoBinaryOp.SUB: lambda: 1/0,
    # AleoBinaryOp.SUBW: lambda: 1/0,
    AleoBinaryOp.MUL: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.ZERO: {AbsDom.ZERO}, AbsDom.POS: {AbsDom.NEG} },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.ZERO}, AbsDom.ZERO: {AbsDom.ZERO}, AbsDom.POS: {AbsDom.ZERO} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.ZERO: {AbsDom.ZERO}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.MULW: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.ZERO: {AbsDom.ZERO}, AbsDom.POS: {AbsDom.NEG} },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.ZERO}, AbsDom.ZERO: {AbsDom.ZERO}, AbsDom.POS: {AbsDom.ZERO} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.ZERO: {AbsDom.ZERO}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.DIV: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.POS},  AbsDom.ZERO: set(), AbsDom.POS: {AbsDom.NEG}  },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.ZERO}, AbsDom.ZERO: set(), AbsDom.POS: {AbsDom.ZERO} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.NEG},  AbsDom.ZERO: set(), AbsDom.POS: {AbsDom.POS}  },
    }),
    AleoBinaryOp.DIVW: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.POS},  AbsDom.ZERO: set(), AbsDom.POS: {AbsDom.NEG}  },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.ZERO}, AbsDom.ZERO: set(), AbsDom.POS: {AbsDom.ZERO} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.NEG},  AbsDom.ZERO: set(), AbsDom.POS: {AbsDom.POS}  },
    }),
    # AleoBinaryOp.REM: lambda: 1/0,
    # AleoBinaryOp.REMW: lambda: 1/0,
    # AleoBinaryOp.POW: lambda: 1/0,
    # AleoBinaryOp.POWW: lambda: 1/0,
    # AleoBinaryOp.SHL: lambda: 1/0,
    # AleoBinaryOp.SHLW: lambda: 1/0,
    # AleoBinaryOp.SHR: lambda: 1/0,
    # AleoBinaryOp.SHRW: lambda: 1/0,
    # AleoBinaryOp.MOD: lambda: 1/0,
    # AleoBinaryOp.AND: lambda: 1/0,
    # AleoBinaryOp.OR: lambda: 1/0,
    # AleoBinaryOp.XOR: lambda: 1/0,
    # AleoBinaryOp.NAND: lambda: 1/0,
    # AleoBinaryOp.NOR: lambda: 1/0,
    # AleoBinaryOp.GT: lambda: 1/0,
    AleoBinaryOp.GTE: absop2({
        AbsDom.NEG:  { AbsDom.NEG: AbsDom.ALLBOOL(), AbsDom.ZERO: {AbsDom.FALSE}, AbsDom.POS: {AbsDom.FALSE} },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.TRUE},  AbsDom.ZERO: {AbsDom.TRUE},  AbsDom.POS: {AbsDom.FALSE} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.TRUE},  AbsDom.ZERO: {AbsDom.TRUE}, AbsDom.POS: AbsDom.ALLBOOL() },
    }),
    # AleoBinaryOp.LT: lambda: 1/0,
    # AleoBinaryOp.LTE: lambda: 1/0,

    # is operators
    AleoIsOp.NEQ: absop2({
        AbsDom.NEG:  { AbsDom.NEG: AbsDom.ALLBOOL(), AbsDom.ZERO: {AbsDom.TRUE},  AbsDom.POS: {AbsDom.TRUE} },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.TRUE},  AbsDom.ZERO: {AbsDom.FALSE}, AbsDom.POS: {AbsDom.TRUE} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.TRUE},  AbsDom.ZERO: {AbsDom.TRUE},  AbsDom.POS: AbsDom.ALLBOOL() },
        AbsDom.FALSE:{ AbsDom.FALSE: {AbsDom.FALSE}, AbsDom.TRUE: {AbsDom.TRUE} },
        AbsDom.TRUE: { AbsDom.FALSE: {AbsDom.TRUE},  AbsDom.TRUE: {AbsDom.FALSE} },
    }),
    AleoIsOp.EQ: absop2({
        AbsDom.NEG:  { AbsDom.NEG: AbsDom.ALLBOOL(), AbsDom.ZERO: {AbsDom.FALSE}, AbsDom.POS: {AbsDom.FALSE} },
        AbsDom.ZERO: { AbsDom.NEG: {AbsDom.FALSE}, AbsDom.ZERO: {AbsDom.TRUE},  AbsDom.POS: {AbsDom.FALSE} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.FALSE}, AbsDom.ZERO: {AbsDom.FALSE}, AbsDom.POS: AbsDom.ALLBOOL() },
    }),
}
    
# abstract wrapper
def a(node):
    match node:
        # NOTE: match abstract literal first, before concrete literal
        case AleoAbstractLiteral():
            return node
        case AleoLiteral():
            return abs(node)
        case [*items]:
            # collection, directly return since each element should've been visited already
            return [ a(p) for p in node ]
        case {**items}:
            return { k : a(v) for k,v in node.items() }
        case _:
            raise NotImplementedError(f"Can't wrap a non-literal, got: {node}")

def detector_divz(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]
    
    # store problematic instructions
    lines = []

    # FIXME: get better naming for pid and fid
    def visitor(pid, fid, inps: list, finalize=False):
        
        # determine block
        pr = env.programs[pid]
        fn = None
        if fid in pr.functions.keys():
            if finalize:
                fn = pr.functions[fid].finalize
            else:
                fn = pr.functions[fid]
        else:
            fn = pr.closures[fid]
            assert not finalize, f"Closure {fid} doesn't have a finalize block"
        
        assert len(fn.inputs) == len(inps), \
            f"Argument lengths mismatch, expected: {len(fn.inputs)}, got:{len(inps)}"
        # create local context
        ctx = { fn.inputs[i][0] : inps[i] for i in range(len(fn.inputs))}

        # interpret
        for inst in fn.instructions:
            # print(f"# [debug] inst: {inst}")
            match inst:

                case AleoBinary() | AleoIs():
                    av0 = a(env.mget(pid, inst.operands[0], ctx=ctx))
                    av1 = a(env.mget(pid, inst.operands[1], ctx=ctx))
                    # detect
                    if inst.op in {AleoBinaryOp.DIV, AleoBinaryOp.DIVW}:
                        if AbsDom.ZERO in av1.value:
                            lines.append(f"{inst}" if readable else inst)
                    # compute
                    ao = absops[inst.op](av0, av1)
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoTernary():
                    av0 = a(env.mget(pid, inst.operands[0], ctx=ctx))
                    av1 = a(env.mget(pid, inst.operands[1], ctx=ctx))
                    av2 = a(env.mget(pid, inst.operands[2], ctx=ctx))
                    # compute
                    ao = AleoAbstractLiteral(set())
                    if AbsDom.TRUE in av0.value:
                        ao.value.update(av1.value)
                    if AbsDom.FALSE in av0.value:
                        ao.value.update(av2.value)
                    # set
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoAssert():
                    # no ctx change, skip
                    pass

                case AleoCall():
                    # collect parameters
                    params = [ a(env.mget(pid, p, ctx=ctx)) for p in inst.operands ]
                    # locate function
                    (_pid, _fid) = env.resolve_function(pid, inst.callee)
                    # dispatch
                    outs = visitor(_pid, _fid, params)
                    # update ctx
                    assert len(outs) == len(inst.regaccs), \
                        f"Lengths of return mismatch, expected: {(len(inst.regaccs))}, got: {len(outs)}"
                    for r,o in zip(inst.regaccs, outs):
                        env.mset(pid, r, o, ctx=ctx)

                case AleoAsync():
                    # NOTE: async in Aleo is finalize in Leo
                    assert inst.callee == fid, \
                        f"Async id doesn't match function id, expected: {fid}, got: {inst.callee}"
                    # collect parameters
                    params = [ a(env.mget(pid, p, ctx=ctx)) for p in inst.operands ]
                    # locate function
                    (_pid, _fid) = env.resolve_function(pid, inst.callee)
                    # dispatch
                    outs = visitor(_pid, _fid, params, finalize=True)
                    # update ctx
                    assert len(outs) == 1, \
                        f"Lengths of return mismatch, expected: 1, got: {len(outs)}"
                    env.mset(pid, inst.regacc, outs[0], ctx=ctx)

                case AleoSet():
                    _src = a(env.mget(pid, inst.src, ctx=ctx))
                    # FIXME: if source is dict (record/struct) or list (array), 
                    #        you can't perform simple merge, but replace;
                    #        otherwise, merge
                    # collect all possible values of mapping
                    _map = a(env.mget(pid, inst.id, ctx=ctx))
                    _ss = None
                    match _src:
                        case AleoAbstractLiteral():
                            _vv = set([p.value for p in _map.values()]) | _src.value # merge existing
                            _ss = AleoAbstractLiteral(_vv)
                        case [*items] | {**items}:
                            # dict/list, can't simply merge, then just replace
                            _ss = _src
                        case _:
                            raise NotImplementedError(f"Unsupported source of set, got: {inst}")
                    # set mapping as defaultdict
                    env.mset(pid, inst.id, defaultdict(lambda: _ss), ctx=ctx)

                case AleoCast():
                    avs = [ a(env.mget(pid, p, ctx=ctx)) for p in inst.operands ]
                    ao = None
                    # NOTE: dest is about type, not register, not value, just type
                    match inst.dest:
                        # identifier with modifier
                        case AleoIdentifier() | AleoLocator():
                            # determine internal or external program id and id
                            _pid = pid if type(inst.dest) is AleoIdentifier else inst.dest.pid
                            _id = inst.dest if type(inst.dest) is AleoIdentifier else inst.dest.id
                            _pr = env.programs[_pid]
                            # NOTE: for locator, its current visibility overrides 
                            #       the visibility of the location it refers to
                            if _id.visibility == AleoModifier.RECORD:
                                # record type specified
                                ao = _pr.records[_id].instantiate(avs)
                            elif _id.visibility == AleoModifier.DEFAULT:
                                # struct type
                                ao = _pr.structs[_id].instantiate(avs)
                            else:
                                raise NotImplementedError(f"Unsupported identifier modifier in cast destination, got: {inst.dest}")
                        case AleoArrayType():
                            assert len(inst.dest.dim) == 1, f"Only 1d array as cast destination is supported, got: {inst.dest.dim}"
                            assert len(avs) == inst.dest.dim[0], f"Array lengths mismatch, expected: {inst.dest.dim}, got: {len(avs)}"
                            ao = avs
                        case AleoLiteralType():
                            # NOTE: this is actually value casting, not value packing as in other cases
                            # FIXME: add actual casting
                            assert len(avs) == 1, f"When casting to literal type, only one value is allowed, got: {avs}"
                            ao = avs[0]
                        case _:
                            raise NotImplementedError(f"Unsupported cast destination, got: {inst.dest}")
                    # set
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoRandom():
                    # over-approximate
                    ao = AleoAbstractLiteral(AbsDom.ALLINT())
                    env.mset(pid, inst.regacc, ao, ctx=ctx)
                
                case _:
                    raise NotImplementedError(f"Unsupported instruction, got: {inst}")
        
        if isinstance(fn, AleoFinalize):
            # finalize: no output, return all bool for safe
            return [AleoAbstractLiteral(AbsDom.ALLBOOL())]
        else:
            # closure/function: return
            return [ a(env.mget(pid, k, ctx=ctx)) for k,v in fn.outputs ]
    
    # FIXME: construct params according to types (could also be struct/record/mapping/etc.)
    params = [
        AleoAbstractLiteral(AbsDom.TOP()) 
        for _ in range(len(func.inputs))
    ]
    visitor(pid, fid, params)
    return (len(lines)>0, lines)