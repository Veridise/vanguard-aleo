import networkx as nx

from ..grammar import AleoProgram

def detector_rtcnst(prog: AleoProgram, func: str):
    """Detect for returning of constant
    Args:
      - prog (AleoProgram):
      - func (str):
    Rets: (result, info)
    """

    cnsts = []
    # process output instructions
    for inst in prog.functions[func]["outputs"]:
        tokens = inst["str"].strip(";").split()
        match tokens:

            case ["output", val, "as", typ] if not val.startswith("r"):
                cnsts.append(val)

            case _:
                # fine for other cases
                pass
    
    return (len(cnsts)>0, cnsts)
    