from ..grammar import *
from ..graphs import get_dfg_edges

def detector_magicv(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]

    mvs = []

    def mm(node):
        match node:
            case AleoAddressLiteral():
                mvs.append(f"{node}" if readable else node)
            case AleoUnsignedLiteral() | AleoSignedLiteral():
                if node.value >= 2 or node.value <= -2:
                    mvs.append(f"{node}" if readable else node)
            case _:
                # not interested
                pass

    # check for magic values
    AleoNode.visit(func, fn_pre=mm)

    return (len(mvs)>0, mvs)