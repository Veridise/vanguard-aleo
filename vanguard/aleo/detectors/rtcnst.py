from ..grammar import *
from ..graphs import get_dfg_edges

def detector_rtcnst(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]
    
    cnsts = []
    for k,v in func.outputs:
        if isinstance(k, AleoLiteral):
            if readable:
                cnsts.append(f"{k}")
            else:
                cnsts.append(k)

    return (len(cnsts)>0, cnsts)