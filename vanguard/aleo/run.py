#!/usr/bin/env python
# NOTE: this is project script and shall not be called directly

import argparse

from tabulate import tabulate

from .common import detect
from . import detectors as dlib

def run():
    # get all available detectors
    dlib_choices = [ p.replace("detector_", "") for p in dir(dlib) if p.startswith("detector_") ]

    # parse
    ap = argparse.ArgumentParser()
    ap.add_argument("-b", "--build", default="./", type=str, help="project build path, default: ./")
    ap.add_argument("-p", "--pid", default=None, type=str, help="program id, default: <project main entrance>")
    ap.add_argument("-f", "--fids", default=None, type=str, help="function ids (separated by comma, no space), default: <all functions of project>")
    ap.add_argument("-d", "--detector", default="infoleak", type=str, choices=dlib_choices, help="detector to use, default: infoleak")
    ap.add_argument("-v", "--verbose", action="store_true", help="whether or not to return extra info, default: False")
    args = ap.parse_args()

    # process
    _build = args.build
    _pid = args.pid
    _fids = args.fids if args.fids is None else args.fids.split(",")
    _detector = args.detector

    # call
    ret = detect(_build, pid=_pid, fids=_fids, detector=_detector, readable=True)

    # format and print
    # compute indentation
    headers = ["id", "program", "function", "detector", "result", "info"]

    sret = [
        (p[0], p[1], _detector, "unsafe" if p[2] else "safe", p[3]) if args.verbose else\
        (p[0], p[1], _detector, "unsafe" if p[2] else "safe")
        for p in ret
    ]

    print(tabulate(sret, headers=headers, showindex=True, tablefmt="github"))

if __name__ == "__main__":
    run()