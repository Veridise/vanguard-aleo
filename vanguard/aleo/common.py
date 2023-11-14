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

def get_program_id(node):
    match node:
        case { "type": "ProgramCore", "id": {"type": "ProgramID", "name": name, **kv0}, **kv1}:
            return name
        case _:
            raise Exception(f"Error getting program id, got: {node}")
