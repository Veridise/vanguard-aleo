from .common import aleo2json
from .grammar import AleoProgram
from .detectors.infoleak import detector_infoleak
from .detectors.rtcnst import detector_rtcnst
from .detectors.unused import detector_unused
from .detectors.divz import detector_divz
from .detectors.divrd import detector_divrd

def run_test_suite(path, detector):
    obj = aleo2json(path)
    ap = AleoProgram(json=obj)

    # locate the vanguard_helper function and retrieve the label info
    vanguard_helper = ap.sjson["functions"]["vanguard_helper"]
    raw_labels = vanguard_helper["instructions"][0]["value"]["operands"]
    
    # parse labels
    expected_labels = [p["value"]["value"]["boolean"] for p in raw_labels]
    expected_infos = [] # FIXME: add support for this

    # run detector on all benchmarks, and compare
    actual_labels = []
    actual_infos = []
    for i in range(len(expected_labels)):
        # call detector directly
        label, info = detector(ap, f"ex{i}")
        actual_labels.append(label)
        actual_infos.append(info)

    return (expected_labels, expected_infos, actual_labels, actual_infos)

