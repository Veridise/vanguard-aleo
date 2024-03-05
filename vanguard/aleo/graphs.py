from .grammar import *

def get_dfg_edges(env: AleoEnvironment, pid: str, fid: str, hash=True, call=False):
    """Get a set of edges for data flow graph
    Args:
        - hash: whether or not to include edges from hash function
        - call: whether or not to inline/expand internal/external call/async
    """
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]
    edges = []
    # process instructions
    for inst in func.instructions:
        match inst:

            case AleoUnary():
                if not isinstance(inst.operand, AleoLiteral):
                    # only consider non-literal
                    edges.append((inst.operand, inst.regacc))

            case AleoBinary():
                for p in inst.operands:
                    if not isinstance(p, AleoLiteral):
                        # only consider non-literal
                        edges.append((p, inst.regacc))

            case AleoHash1():
                if hash:
                    if not isinstance(inst.operand, AleoLiteral):
                        # only consider non-literal
                        edges.append((inst.operand, inst.regacc))
                # else: do nothing
                        
            case AleoAsync():
                if call:
                    # FIXME
                    raise NotImplementedError()
                else:
                    # do not model
                    pass

            case AleoCall():
                if call:
                    # FIXME
                    raise NotImplementedError()
                else:
                    # do not model
                    pass

            case AleoTernary():
                for p in inst.operands:
                    if not isinstance(p, AleoLiteral):
                        # only consider non-literal
                        edges.append((p, inst.regacc))

            case AleoCast():
                for p in inst.operands:
                    if not isinstance(p, AleoLiteral):
                        # only consider non-literal
                        edges.append((p, inst.regacc))

            case AleoIs():
                for p in inst.operands:
                    if not isinstance(p, AleoLiteral):
                        # only consider non-literal
                        edges.append((p, inst.regacc))

            case AleoAssert():
                # no data flow
                pass

            case _:
                raise NotImplementedError(f"Unsupported instruction, got: {inst}, type: {type(inst)}")

    return edges