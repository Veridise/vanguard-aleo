from vanguard.aleo.grammar import AleoEnvironment
from vanguard.aleo.detectors import detector_infoleak

if __name__ == "__main__":
    project_name = "infoleak0"
    build_path = f"./tests/public/{project_name}/build/"
    env = AleoEnvironment(build_path)
    main = env.main

    fid = "ex0"
    res, info = detector_infoleak(env, main.id, fid)
    assert res, f"Test failed for {fid}, expected: True, got: {res}"

    fid = "ex1"
    res, info = detector_infoleak(env, main.id, fid)
    assert not res, f"Test failed for {fid}, expected: False, got: {res}"