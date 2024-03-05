from vanguard.aleo.grammar import AleoEnvironment
from vanguard.aleo.detectors import detector_divz

if __name__ == "__main__":
    project_name = "divz0"
    build_path = f"./tests/public/{project_name}/build/"
    env = AleoEnvironment.from_project(build_path)
    main = env.main
    fid = "ex0"
    res, info = detector_divz(env, main.id, fid)
    assert res, f"Test failed for {fid}, expected: True, got: {res}"