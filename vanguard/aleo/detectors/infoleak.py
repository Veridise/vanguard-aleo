import networkx as nx

from ..common import get_ifg_edges

def detector_simple_infoleak(prog, func):
    """Detect for information leak in a simplified way
    Args:
      - prog:
      - func:
    Rets: (result, info)
    """
    # FIXME: correct the assumption when impl is ready
    edges = get_ifg_edges(prog, func, hash=False, call=True, inline=False)
    prv_inps = prog.get_function_arguments(func, "private", "inputs")
    pub_outs = prog.get_function_arguments(func, "public", "outputs")

    G = nx.DiGraph()
    G.add_edges_from(edges)

    paths = []
    for sig_in in prv_inps:
        for sig_out in pub_outs:
            if nx.has_path(G, sig_in, sig_out):
                paths.append((sig_in, sig_out))
    
    return (len(paths)>0, paths)