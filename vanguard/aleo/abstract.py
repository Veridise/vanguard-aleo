from typing import Callable

from .grammar import *

class AleoAbstractType(AleoType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "$"

class AleoAbstractLiteral(AleoLiteral):
            
    def __init__(self, value, type = AleoAbstractType()):
        super().__init__(value, type)
        # need to turn on manually
        # if turned on, this can be treated as both a singleton and a collection
        # this will be used in "completely unknown (including type)" situation
        self.auto_typing = False
        self.auto_value_generator = None

    # once enabled, there's no way back
    def enable_auto_typing(self, vgen: Callable):
        self.auto_typing = True
        self.auto_value_generator = vgen

    def __str__(self):
        return f"{self.type}{self.value}"
    
    def __getitem__(self, key):
        if self.auto_typing:
            return self.auto_value_generator(key)
        else:
            raise AttributeError()
        
    def __setitem__(self, key, value):
        if self.auto_typing:
            pass
        else:
            raise AttributeError()
    
# unary abstract operator generator
def absop1(ltab):
    # ltab: look-up table
    # construct function
    def do(a: AleoAbstractLiteral):
        r = set()
        for a0 in a.value:
            if a0 in ltab.keys():
                r.update(ltab[a0])
        return AleoAbstractLiteral(r)
    # return the function
    return do
    
# binary abstract operator generator
def absop2(ltab):
    # ltab: look-up table
    # construct function
    def do(a: AleoAbstractLiteral, b: AleoAbstractLiteral):
        r = set()
        for a0 in a.value:
            if a0 in ltab.keys():
                for b0 in b.value:
                    if b0 in ltab[a0].keys():
                        r.update(ltab[a0][b0])
        return AleoAbstractLiteral(r)
    # return the function
    return do

# ternary abstract operator generator
def absop3(ltab):
    # ltab: look-up table
    # construct function
    def do(a: AleoAbstractLiteral, b: AleoAbstractLiteral, c: AleoAbstractLiteral):
        r = set()
        for a0 in a.value:
            if a0 in ltab.keys():
                for b0 in b.value:
                    if b0 in ltab[a0].keys():
                        for c0 in c.value:
                            if c0 in ltab[a0][b0].keys():
                                r.update(ltab[a0][b0][c0])
        return AleoAbstractLiteral(r)
    # return the function
    return do