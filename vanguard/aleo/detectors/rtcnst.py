from ..grammar import AleoProgram, AleoEnvironment

def detector_rtcnst(env: AleoEnvironment, pid: str, fid: str):

    cnsts = []
    
    prog = env.programs[pid]
    func = prog.functions[fid] if fid in prog.functions.keys() else prog.closures[fid]

    for o in func["outputs"]:
        p = env.resolve(o[0])
        if p[0] == "val":
            cnsts.append(o)
    
    return (len(cnsts)>0, cnsts)
    