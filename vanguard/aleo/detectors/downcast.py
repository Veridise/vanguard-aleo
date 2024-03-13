from ..grammar import *
from ..graphs import get_dfg_edges

def detector_downcast(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]

    dinsts = []

    # check for statement level redundancy
    all_insts = func.instructions + ([] if func.finalize is None else func.finalize.instructions)
    for inst in all_insts:
        match inst:
            case AleoCast() if len(inst.operands) == 1:
                dinsts.append(f"{inst}" if readable else inst)

            case _:
                # not interested
                pass

    return (len(dinsts)>0, dinsts)