from typing import Union
from enum import Enum
from collections import defaultdict

from ..grammar import *
from ..abstract import AleoAbstractLiteral, absop1, absop2

def abs(node):
    # all will return negative if abs is EVER required
    # but type checking is still required
    match node:
        case AleoAddressLiteral():
            return AleoAbstractLiteral({AbsDom.NEG})
        case AleoBooleanLiteral():
            return AleoAbstractLiteral({AbsDom.NEG})
        case AleoFieldLiteral() | AleoUnsignedLiteral() | AleoSignedLiteral():
            return AleoAbstractLiteral({AbsDom.NEG})
        case _:
            raise NotImplementedError(f"Unsupported literal, got: {node}")
class AbsDom(Enum):

    NEG = 0
    POS = 1 # indicates private input and its flow of data

# load class attribute
absops = {

    # binary operators
    AleoBinaryOp.ADD: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.ADDW: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.SUB: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.SUBW: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.MUL: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.MULW: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.DIV: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.DIVW: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
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
    AleoBinaryOp.AND: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.OR: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    # AleoBinaryOp.XOR: lambda: 1/0,
    # AleoBinaryOp.NAND: lambda: 1/0,
    # AleoBinaryOp.NOR: lambda: 1/0,
    AleoBinaryOp.GT: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.GTE: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.LT: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoBinaryOp.LTE: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),

    # is operators
    AleoIsOp.NEQ: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),
    AleoIsOp.EQ: absop2({
        AbsDom.NEG:  { AbsDom.NEG: {AbsDom.NEG}, AbsDom.POS: {AbsDom.POS} },
        AbsDom.POS:  { AbsDom.NEG: {AbsDom.POS}, AbsDom.POS: {AbsDom.POS} },
    }),

    # unary operators
    AleoUnaryOp.ABS: absop1({
        AbsDom.NEG: {AbsDom.NEG},
        AbsDom.POS: {AbsDom.POS},
    }),
    AleoUnaryOp.NOT: absop1({
        AbsDom.NEG: {AbsDom.NEG},
        AbsDom.POS: {AbsDom.POS},
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
        
# check whether a value contains POS
def tainted(node):
    match node:
        case AleoAbstractLiteral():
            return AbsDom.POS in node.value
        case [*items]:
            return any([ tainted(p) for p in node ])
        case {**items}:
            return any([ tainted(p) for p in node.values() ])
        case _:
            raise NotImplementedError(f"Unsupported value type for tainted, got: {node}, type: {type(node)}")

def detector_infoleak(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]
    
    # store problematic instructions
    pvars = [] # potentially publicized variables
    lines = [] # corresponding instructions

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
            # print(f"# [debug] pid: {pid}, fid: {fid}, inst: {inst}")
            match inst:

                case AleoUnary():
                    av = a(env.mget(pid, inst.operand, ctx=ctx))
                    # compute
                    ao = absops[inst.op](av)
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoBinary() | AleoIs():
                    av0 = a(env.mget(pid, inst.operands[0], ctx=ctx))
                    av1 = a(env.mget(pid, inst.operands[1], ctx=ctx))
                    # compute
                    ao = absops[inst.op](av0, av1)
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoTernary():
                    av0 = a(env.mget(pid, inst.operands[0], ctx=ctx))
                    av1 = a(env.mget(pid, inst.operands[1], ctx=ctx))
                    av2 = a(env.mget(pid, inst.operands[2], ctx=ctx))
                    ao = AleoAbstractLiteral(set())
                    # compute
                    if AbsDom.POS in av0.value or AbsDom.POS in av1.value or AbsDom.POS in av2.value:
                        ao.value.add(AbsDom.POS)
                    # set
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoAssert() | AleoAwait():
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
                    # detect: finalize will publicize all its parameters
                    for i in range(len(params)):
                        if tainted(params[i]):
                            pvars.append(f"{inst.operands[i]}" if readable else inst.operands[i])
                            lines.append(f"{inst}" if readable else inst)
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
                    # NOTE: we assume random won't easily hit the same info being tracked
                    ao = AleoAbstractLiteral({AbsDom.NEG})
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoHash1() | AleoSignVerify():
                    # compute
                    # this operator removes any flows of target data
                    ao = AleoAbstractLiteral({AbsDom.NEG})
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoContains():
                    # id is mapping, not interested
                    av = a(env.mget(pid, inst.operand, ctx=ctx))
                    ao = AleoAbstractLiteral(set())
                    if AbsDom.POS in av.value:
                        ao.value.add(AbsDom.POS)
                    else:
                        ao.value.add(AbsDom.NEG)
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoGet() | AleoGetOrUse():
                    # NOTE: operand can be both literal or var, so we give up reasoning here
                    # since we give up, we lose track of types, so we need to turn on auto_typing
                    ao = AleoAbstractLiteral({AbsDom.NEG, AbsDom.POS})
                    ao.enable_auto_typing(lambda x:AleoAbstractLiteral({AbsDom.NEG, AbsDom.POS}))
                    env.mset(pid, inst.regacc, ao, ctx=ctx)

                case AleoRemove():
                    # give up
                    pass
                
                case _:
                    raise NotImplementedError(f"Unsupported instruction, got: {inst}, type: {type(inst)}")
        
        if isinstance(fn, AleoFinalize):
            # FIXME: we assume status of finalize execution doesn't leak (though it could still be possible)
            return [AleoAbstractLiteral({AbsDom.NEG})]
        else:
            # closure/function: return
            rets = [ a(env.mget(pid, k, ctx=ctx)) for k,v in fn.outputs ]
            # detect: output instruction can explicitly change the visibility
            for i in range(len(fn.outputs)):
                k, v = fn.outputs[i]
                if tainted(rets[i]) and v.visibility == AleoModifier.PUBLIC:
                    pvars.append(f"{k}" if readable else k)
                    lines.append(f"output {k} as {v};")
            return rets
        
    def av_constructor(vtype):
        ao = None
        match vtype:

            case AleoLiteralType():
                _av = {AbsDom.POS} if vtype.visibility in {AleoModifier.PRIVATE, AleoModifier.DEFAULT} else {AbsDom.NEG}
                return AleoAbstractLiteral(_av)
            case AleoIdentifier() | AleoLocator():
                # determine internal or external program id and id
                _pid = pid if type(vtype) is AleoIdentifier else vtype.pid
                _id = vtype if type(vtype) is AleoIdentifier else vtype.id
                _pr = env.programs[_pid]
                if _id.visibility == AleoModifier.RECORD:
                    # record type, use value constructor mode
                    ao = _pr.records[_id].instantiate(av_constructor)
                elif _id.visibility in {AleoModifier.PRIVATE, AleoModifier.DEFAULT}:
                    # struct type, use value constructor mode
                    ao = _pr.structs[_id].instantiate(av_constructor)
                else:
                    raise NotImplementedError(f"Unsupported type for av constructor, got: {vtype}, type: {type(vtype)}, visibility: {_id.visibility}")
            case AleoArrayType():
                assert len(vtype.dim) == 1, f"Only 1d array is supported, got: {vtype.dim}"
                _avs = [ av_constructor(vtype.btype) for _ in range(vtype.dim[0]) ]
                return _avs

            case _:
                raise NotImplementedError(f"Unsupported type for input constructor, got: {vtype}, type: {type(vtype)}")
        
        return ao
    
    params = [
        av_constructor(v)
        for k,v in func.inputs
    ]
    ret = visitor(pid, fid, params)
    # print(f"# [debug] ret: {[str(p) for p in ret]}")
    # print(f"# [debug] pvars: {pvars}")
    # print(f"# [debug] lines: {lines}")
    return (len(lines)>0, lines)