import requests
import time
import json
import pandas as pd

from bs4 import BeautifulSoup

from .grammar import AleoEnvironment

def run_test_suite(build_path, detector, verbose=False):
    env = AleoEnvironment.from_project(build_path)

    # locate the vanguard_helper function and retrieve the label info
    expected_labels = env.main.functions["vanguard_helper"].instructions[0].operands
    expected_labels = [ p.value for p in expected_labels ]
    expected_infos = [] # FIXME: add support when available

    # run detector on all benchmarks, and compare
    actual_labels = []
    actual_infos = []
    ncorrect = 0
    for i in range(len(expected_labels)):
        # call detector directly
        label, info = detector(env, env.main.id, f"ex{i}")
        actual_labels.append(label)
        actual_infos.append(info)
        result = "✗"
        if label == expected_labels[i]:
            result = "✓"
            ncorrect += 1
        if verbose:
            print(f"# [{result}][test] pid: {env.main.id}, fid: ex{i}, expected: {expected_labels[i]}, actual: {label}")

    if verbose:
        print(f"# [test] accuracy: {ncorrect}/{len(actual_labels)} ({ncorrect/len(actual_labels):.4f})")

    if verbose:
        pd_expected = pd.Series(expected_labels, name="expected")
        pd_actual = pd.Series(actual_labels, name="actual")
        mtx =pd.crosstab(pd_expected, pd_actual)
        mtx_norm = mtx.div(mtx.sum(axis=1), axis="index")
        print(f"# [test] confusion matrix:\n  {mtx}")
        print(f"# [test] normalized confusion matrix:\n  {mtx_norm}")
    
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

def crawl_from_aleo_explorer(folder):
    url = "https://api.explorer.aleo.org/v1/testnet3/explorer/programs"
    headers = {
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36',
        'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
        'Accept-Language': 'en-US,en;q=0.9',
        # 'Accept-Encoding': 'gzip, deflate, br'
    }
    res0 = requests.get(url, headers=headers)
    res0.raise_for_status()
    js0 = json.loads(res0.text)
    # ok this API returns ALL info (including src) of programs
    for p in js0:
        # write to folder
        print(f"# Writing {p["id"]} ...")
        with open(f"{folder}/{p["id"]}", "w") as f:
            f.write(p["program"])

    # soup0 = BeautifulSoup(res0.text, 'html.parser')
    # rows = soup0.find_all("div", class_="ShortHash")
    # for r in rows:
    #     fname = r.a.string
    #     furl = "https://explorer.aleo.org{}".format(r.a["href"])
    #     print(f"# Fetching: file={fname}, url={furl} ...", end="")
    #     # fetch program itself
    #     try:
    #         res1 = requests.get(furl, headers=headers)
    #         res1.raise_for_status()
    #     except:
    #         print("skip for exception")
    #         continue

    #     soup1 = BeautifulSoup(res1.text, 'html.parser')
    #     src = soup1.find("div", class_="ant-typography")
    #     raw = src.pre.string

    #     # write to folder
    #     with open(f"{folder}/{fname}", "w") as f:
    #         f.write(raw)

    #     print("done")
    #     time.sleep(100)