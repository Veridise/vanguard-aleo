import networkx as nx

from ..common import get_ifg_edges, get_public_inputs, get_public_outputs

# `node` corresponds to a function, closure or finalize
def detector_simple_ileak(node):
    assert "inputs" in node.keys(), f"Can't find \"inputs\" key in node"
    assert "outputs" in node.keys(), f"Can't find \"outputs\" key in node"
    assert "instructions" in node.keys(), f"Can't find \"instructions\" key in node"

    edges = get_ifg_edges(node)
    pub_ins = get_public_inputs(node)
    pub_outs = get_public_outputs(node)

    G = nx.DiGraph()
    G.add_edges_from(edges)

    paths = []
    for sig_in in pub_ins:
        for sig_out in pub_outs:
            if nx.has_path(G, sig_in, sig_out):
                paths.append((sig_in, sig_out))
    
    return paths
    