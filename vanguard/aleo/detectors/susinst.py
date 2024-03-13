from ..grammar import *
from ..graphs import get_dfg_edges

def detector_susinst(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]

    sinsts = []

    # check for statement level redundancy
    all_insts = func.instructions + ([] if func.finalize is None else func.finalize.instructions)
    for inst in all_insts:
        match inst:
            case AleoAssert():
                if f"{inst.operands[0]}" == f"{inst.operands[1]}":
                    sinsts.append(f"{inst}" if readable else inst)

            case AleoBinary():
                match inst.op:
                    case AleoBinaryOp.ADD | AleoBinaryOp.ADDW:
                        for p in inst.operands:
                            if isinstance(p, AleoLiteral) and p.value == 0:
                                sinsts.append(f"{inst}" if readable else inst)
                    case AleoBinaryOp.SUB | AleoBinaryOp.SUBW:
                        if isinstance(inst.operands[1], AleoLiteral) and inst.operands[1].value == 0:
                            sinsts.append(f"{inst}" if readable else inst)
                    case AleoBinaryOp.MUL | AleoBinaryOp.MULW:
                        for p in inst.operands:
                            if isinstance(p, AleoLiteral) and p.value == 1:
                                sinsts.append(f"{inst}" if readable else inst)
                    case _:
                        # not interested
                        pass

            case _:
                # not interested
                pass

    return (len(sinsts)>0, sinsts)