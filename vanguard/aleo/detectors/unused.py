import networkx as nx

from ..grammar import *
from ..graphs import get_dfg_edges

def detector_unused(env: AleoEnvironment, pid: str, fid: str, readable=False):
    # initialize
    prog: AleoProgram = env.programs[pid]
    func: AleoFunction = prog.functions[fid]
    
    edges = get_dfg_edges(env, pid, fid)

    # DEBUG
    # for p in edges:
    #     print(f"{p[0]} -> {p[1]}")

    inps = [k for k,v in func.inputs]
    outs = [k for k,v in func.outputs]

    G = nx.DiGraph()
    G.add_edges_from(edges)

    vars = []
    for sig_in in inps:
        # print(f"# [debug] sig_in: {sig_in}")
        if not G.has_node(sig_in):
            # signal is not in graph, meaning it's not used
            if readable:
                vars.append(f"{sig_in}")
            else:
                vars.append(sig_in)
            continue

        used = False
        for sig_out in outs:
            if nx.has_path(G, sig_in, sig_out):
                used = True
                break
        
        if not used:
            if readable:
                vars.append(f"{sig_in}")
            else:
                vars.append(sig_in)

    return (len(vars)>0, vars)