import networkx as nx

from ..grammar import AleoProgram
from ..common import get_dfg_edges

def detector_unused(prog: AleoProgram, func: str):
    """Detect for unused variable
    Args:
      - prog (AleoProgram):
      - func (str):
    Rets: (result, info)
    """

    edges = get_dfg_edges(prog, func)
    # add special edge to account for direct return of input signal
    for inst in prog.functions[func]["outputs"]:
        tokens = inst["str"].strip(";").split()
        match tokens:
            case ["output", o, "as", t]:
                edges.append((o,o))

    prv_inps = prog.get_function_arguments(func, "private", "inputs")
    pub_inps = prog.get_function_arguments(func, "public", "inputs")
    prv_outs = prog.get_function_arguments(func, "private", "outputs")
    pub_outs = prog.get_function_arguments(func, "public", "outputs")

    G = nx.DiGraph()
    G.add_edges_from(edges)

    vars = []
    for sig_in in prv_inps+pub_inps:

        if not G.has_node(sig_in):
            # signal is not in graph, meaning it's not used
            vars.append(sig_in)
            continue
        
        is_used = False
        for sig_out in prv_outs+pub_outs:

            if nx.has_path(G, sig_in, sig_out):
                is_used = True
                break
        
        if not is_used:
            vars.append(sig_in)
    
    return (len(vars)>0, vars)