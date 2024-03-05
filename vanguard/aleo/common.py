from pathlib import Path
from typing import List, Union

from antlr4 import FileStream, CommonTokenStream, Parser
from antlr4.Utils import escapeWhitespace
from antlr4.tree.Trees import Trees, Tree

# ref: toStringTree method
#      https://github.com/parrt/antlr4-python3/blob/master/src/antlr4/tree/Trees.py#L48
@classmethod
def toJsonTree(cls, t: Tree, ruleNames: list=None, recog: Parser=None):
    '''Get s-expression of the parse tree in json'''
    if recog is not None:
        ruleNames = recog.ruleNames
    s = escapeWhitespace(cls.getNodeText(t, ruleNames), False)
    if t.getChildCount() == 0:
        return s
    ret = [s]
    for i in range(0, t.getChildCount()):
        ret.append(cls.toJsonTree(t.getChild(i), ruleNames))
    return ret
# install class method
Trees.toJsonTree = toJsonTree

from .parser.AleoLexer import AleoLexer
from .parser.AleoParser import AleoParser

def aleo2json(path: Union[str, Path]):
    input_stream = FileStream(path)
    lexer = AleoLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = AleoParser(stream)
    tree = parser.start()
    return Trees.toJsonTree(tree, None, parser)

def detect(build_path: Union[str, Path], pid: str=None, fids: List=None, detector: str=None, **kwargs):
    # pid (default: main program of environment) - program id
    # fids (default: all functions of selected program) - list of function ids
    # detector (default: infoleak) - detector to use

    # NOTE: for clarity, only one detector can be used in each call

    from .grammar import AleoEnvironment
    from . import detectors as dlib

    env = AleoEnvironment.from_project(build_path)
    _detector = getattr(dlib, "detector_infoleak") if detector is None else getattr(dlib, f"detector_{detector}")
    
    prog = env.main if pid is None else env.programs[pid]
    funcs = list(prog.functions.values()) if fids is None else [prog.functions[p] for p in fids]

    # start detection
    ret = [ (str(prog.id), str(fn.id)) + _detector(env, prog.id, fn.id, **kwargs) for fn in funcs ]
    return ret
