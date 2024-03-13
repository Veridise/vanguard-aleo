from ..grammar import *
from ..graphs import get_dfg_edges

def detector_divrd(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]

    dinsts = []

    # check for statement level redundancy
    all_insts = func.instructions + ([] if func.finalize is None else func.finalize.instructions)
    for inst in all_insts:
        match inst:
            case AleoBinary() if inst.op in {AleoBinaryOp.DIV, AleoBinaryOp.DIVW}:
                if isinstance(inst.operands[0], AleoLiteral) and isinstance(inst.operands[1], AleoLiteral):
                    # pattern 1: literal division
                    a = inst.operands[0].value
                    b = inst.operands[1].value
                    if a % b != 0:
                        dinsts.append(f"{inst}" if readable else inst)
                else:
                    # FIXME: need to infer value, for now, just ignore
                    # dinsts.append(f"{inst}" if readable else inst)
                    pass

            case _:
                # not interested
                pass

    # pattern 2: division before multiplication
    # FIXME: values are not tracked across transition/finalize, neither in external calls
    # FIXME: data structures are not considered
    div_dests = [] # tracking division destinations
    div_lines = []
    for inst in func.instructions:
        match inst:
            case AleoBinary() if inst.op in {AleoBinaryOp.DIV, AleoBinaryOp.DIVW}:
                div_dests.append(f"{inst.regacc}")
                div_lines.append(inst)
            case AleoBinary() if inst.op in {AleoBinaryOp.MUL, AleoBinaryOp.MULW}:
                ind = None
                if f"{inst.operands[0]}" in div_dests:
                    ind = div_dests.index(f"{inst.operands[0]}")
                elif f"{inst.operands[1]}" in div_dests:
                    ind = div_dests.index(f"{inst.operands[1]}")
                else:
                    # do nothing
                    pass
                if ind is not None:
                    dinsts.append(
                        (f"{div_lines[ind]}", f"{inst}") if readable else\
                        (div_lines[ind], inst)
                    )
        
            case _:
                # not interested
                pass

    return (len(dinsts)>0, dinsts)