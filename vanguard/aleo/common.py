import argparse
import subprocess
import logging
import inspect
import shlex
import shutil
import json
import os

from pathlib import Path
from typing import List, Union

# ref (Aleo grammar): https://developer.aleo.org/aleo/grammar/

def run_command(cmd: Union[str, List[Union[str, Path]]], decode=True):
    if isinstance(cmd, str):
        logging.info(f"  cmd: {cmd}")
        proc = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, shell=True)
    elif isinstance(cmd, list):
        logging.info(f"  cmd: {shlex.join(map(str, cmd))}")
        proc = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    else:
        raise Exception(f"unsupported command type, got: {cmd}")
    
    if proc.returncode != 0:
        err_contents = proc.stdout.decode("utf-8")
        raise Exception(f"command failed with message:\n{err_contents}")
    
    return proc.stdout.decode() if decode else proc.stdout

def aleo2json(path: Union[str, Path]):
    cmd = ["aleo2json", path]
    out = run_command(cmd)
    return json.loads(out)

def get_public_inputs(node):
    assert "inputs" in node.keys(), f"Can't find \"inputs\" key in node"

    pub_ins = []
    for inst in node["inputs"]:
        tokens = inst["str"].strip(";").split()
        match tokens:

            case ["input", r, "as", t] if t.endswith(".public"):
                pub_ins.append(r)
            # FIXME: add record tracking
            case _:
                pass
    
    return pub_ins

def get_public_outputs(node):
    assert "outputs" in node.keys(), f"Can't find \"outputs\" key in node"

    pub_outs = []
    for inst in node["outputs"]:
        tokens = inst["str"].strip(";").split()
        match tokens:

            case ["output", r, "as", t] if t.endswith(".public"):
                pub_outs.append(r)
            # FIXME: add record tracking
            case _:
                pass
    
    return pub_outs

def get_ifg_edges(node):
    assert "instructions" in node.keys(), f"Can't find \"instructions\" key in node"

    edges = []

    # process instructions
    for inst in node["instructions"]:
        tokens = inst["str"].strip(";").split()
        match tokens:

            case ["is.eq", o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            case ["is.neq", o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            
            case ["assert.eq", o1, o2]:
                edges.append((o1, o2))
                edges.append((o2, o1))
            case ["assert.neq", o1, o2]:
                edges.append((o1, o2))
                edges.append((o2, o1))

            case ["cast", o, "into", r, "as", d]:
                edges.append((o, r))

            case ["call", f, *os, "into", r]:
                # for now we assume everything flows through
                for o in os:
                    edges.append((o, r))

            case [cop, o1, o2, "into", r, "as", t] if cop.startswith("commit"):
                # no edge in commitment computation
                pass

            case [hop, o1, "into", r, "as", t] if hop.startswith("hash"):
                # no edge in hash computation
                pass

            case [binop, o1, o2, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
            case [unop, o, "into", r]:
                edges.append((o, r))
            case [terop, o1, o2, o3, "into", r]:
                edges.append((o1, r))
                edges.append((o2, r))
                edges.append((o3, r))
            
            case _:
                raise Exception(f"Unknown instruction pattern, got: {inst}")

    return edges