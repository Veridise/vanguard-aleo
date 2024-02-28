from vanguard.aleo.grammar import AleoEnvironment
from vanguard.aleo.detectors.rtcnst import detector_rtcnst

if __name__ == "__main__":
    project_name = "rtcnst0"
    build_path = f"./tests/public/{project_name}/build/"
    env = AleoEnvironment(build_path)
    main = env.main
    fid = "ex0"
    res, info = detector_rtcnst(env, main.id, fid)
    assert res, f"Test failed for {fid}, expected: True, got: {res}"