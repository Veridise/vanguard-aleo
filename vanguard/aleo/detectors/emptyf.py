from ..grammar import *
from ..graphs import get_dfg_edges

def detector_emptyf(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]

    efs = []
    
    # check for function level redundancy
    if len(func.instructions) == 0:
        efs.append(f"transition {func.id}")

    if func.finalize is not None:
        if len(func.finalize.instructions) == 0:
            efs.append(f"finalize {func.finalize.id}")

    # check for statement level redundancy
    all_insts = func.instructions + ([] if func.finalize is None else func.finalize.instructions)
    for inst in all_insts:
        match inst:
            case AleoAssert():
                g = True
                for p in inst.operands:
                    if not isinstance(p, AleoLiteral):
                        g = False
                        break
                if g:
                    efs.append(f"{inst}" if readable else inst)

            case _:
                # not interested
                pass

    return (len(efs)>0, efs)