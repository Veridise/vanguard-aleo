import networkx as nx

from ..common import get_ifg_edges, trim_inst

def detector_infoleak(prog, func):
    """Detect for information leak
    Args:
      - prog:
      - func:
    Rets: (result, info)
    """

    edges = get_ifg_edges(prog, func, hash=False, call=True, inline=False)
    # add special edge to account for direct return of input signal
    for inst in prog.functions[func]["outputs"]:
        tokens = trim_inst(inst["str"]).split()
        match tokens:
            case ["output", o, "as", t]:
                edges.append((o,o))

    prv_inps = prog.get_function_arguments(func, "private", "inputs")
    pub_outs = prog.get_function_arguments(func, "public", "outputs")

    G = nx.DiGraph()
    G.add_edges_from(edges)

    paths = []
    for sig_in in prv_inps:
        if not G.has_node(sig_in):
            # signal is not in graph, meaning it's not used
            # since it's not used, it's not leaked
            # this detector doesn't detect unused variable, so do nothing
            continue

        for sig_out in pub_outs:
            if nx.has_path(G, sig_in, sig_out):
                paths.append((sig_in, sig_out))
    
    return (len(paths)>0, paths)