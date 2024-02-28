import argparse
import subprocess
import logging
import inspect
import shlex
import shutil
import json
import os
import re

from pathlib import Path
from typing import List, Union
from lark import Lark, Token, Tree, Transformer, Discard

# https://stackoverflow.com/questions/74550878/lark-how-to-ignore-whitespace-after-parsing
class SpaceTransformer(Transformer):
    def WS(self, tok: Token):
        return Discard
    def CWS(self, tok: Token):
        return Discard

# ref (Aleo grammar): https://developer.aleo.org/aleo/grammar/
# ref (Aleo grammar): https://github.com/AleoHQ/grammars/blob/master/aleo.abnf
# load a parser in the module
with open(Path(__file__).parent.resolve() / "program-r1.lark", "r") as f:
    raw_lark = f.read()
parser = Lark(raw_lark)

def aleo2json(path: Union[str, Path]):
    # by default, simplification is applied
    with open(path, "r") as f:
        raw_aleo = f.read()
    tree0 = parser.parse(raw_aleo)
    tree1 = SpaceTransformer().transform(tree0)
    obj = tree2json(tree1)
    return obj

def tree2json(node):
    if isinstance(node, Tree):
        if node.children is None:
            return [node.data.value]
        else:
            return [node.data.value] + [tree2json(p) for p in node.children]
    elif isinstance(node, Token):
        return node.value
    elif node is None:
        # None is for missed match of alternative token (epxressed in [] in lark)
        return None
    else:
        raise NotImplementedError(f"Unsupported type for tree2json, got: {node}")
