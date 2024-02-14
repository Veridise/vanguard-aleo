from ..grammar import AleoProgram, AleoEnvironment

from .divz import detector_divz
def detector_divrd(env: AleoEnvironment, pid: str, fid: str):
    return detector_divz(env, pid, fid)