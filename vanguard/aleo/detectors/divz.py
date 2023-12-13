import networkx as nx

from ..grammar import AleoProgram

def detector_divz(prog: AleoProgram, func: str):
    """Detect for division by zero
    Args:
      - prog (AleoProgram):
      - func (str):
    Rets: (result, info)
    """

    lines = []
    # process output instructions
    for inst in prog.functions[func]["instructions"]:
        tokens = inst["str"].strip(";").split()
        match tokens:

            case ["div", v0, v1, "into", r]:
                if v1.startswith("0u"):
                    lines.append(inst["str"])

            case _:
                # fine for other cases
                pass
    
    return (len(lines)>0, lines)
    