import networkx as nx

from ..grammar import *
from ..graphs import get_dfg_edges

def detector_infoleak(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]
    
    edges = get_dfg_edges(env, pid, fid, hash=False)

    # DEBUG
    for p in edges:
        print(f"{p[0]} -> {p[1]}")

    prv_inps = [k for k,v in func.inputs if v.visibility in {AleoModifier.PRIVATE, AleoModifier.DEFAULT}]
    pub_outs = [k for k,v in func.outputs if v.visibility==AleoModifier.PUBLIC]

    G = nx.DiGraph()
    G.add_edges_from(edges)

    paths = []
    for sig_in in prv_inps:
        print(f"# [debug] sig_in: {sig_in}")
        if not G.has_node(sig_in):
            # signal is not in graph, meaning it's not used
            # since it's not used, it's not leaked
            # this detector doesn't detect unused variable, so do nothing
            continue

        for sig_out in pub_outs:
            if nx.has_path(G, sig_in, sig_out):
                if readable:
                    paths.append((f"{sig_in}", f"{sig_out}"))
                else:
                    paths.append((sig_in, sig_out))

    return (len(paths)>0, paths)