import requests
import time

from bs4 import BeautifulSoup

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

def crawl_from_haruka_explorer(istart, iend, folder):
    url_template = "https://explorer.hamp.app/programs?no_helloworld={}"
    headers = {
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36',
        'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
        'Accept-Language': 'en-US,en;q=0.9',
        # 'Accept-Encoding': 'gzip, deflate, br'
    }
    for i in range(istart, iend):
        url = url_template.format(i)
        # let the exception pop for the first layer, don't capture here

        print(f"# Fetching page {i}...")
        # fetch list of programs
        res0 = requests.get(url, headers=headers)
        res0.raise_for_status()
        soup0 = BeautifulSoup(res0.text, 'html.parser')
        rows = soup0.find_all('tr')
        for r in rows:
            s = r.find_all("td")
            if len(s) == 0:
                continue
            fname = s[0].span.a.string
            furl = "https://explorer.hamp.app{}".format(s[0].span.a["href"])
            print(f"# Fetching: file={fname}, url={furl} ... ", end="")
            
            # fetch program itself
            try:
                res1 = requests.get(furl, headers=headers)
                res1.raise_for_status()
            except:
                print("skip for exception")
                continue

            soup1 = BeautifulSoup(res1.text, 'html.parser')
            src = soup1.find(id="source")
            raw = src.pre.string

            # write to folder
            with open(f"{folder}/{fname}", "w") as f:
                f.write(raw)
            
            print("done")
            time.sleep(2)