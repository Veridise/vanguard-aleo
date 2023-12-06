# Vanguard for Aleo

This repo hosts an open-source Python branch of the static analysis tool Vanguard developed by Veridise. This version is optimized for analyzing Leo/Aleo programs.

## Prerequisites

The following libraries are required for running (different components of) the tool:

- Rust (1.73+) for running `aleo2json`
- Python (3.10+) for running Vanguard and its Aleo detectors
  - [NetworkX](https://networkx.org/documentation/stable/install.html) (2.8.4+) for speeding up graph reachability in detectors

## The Aleo to JSON Compiler

Running of Vanguard for Aleo relies on a compiler that converts Aleo programs into JSON, which allows the program to be further analyzed by various tools and extensions. It's adapted from Aleo's [snarkVM](https://github.com/AleoHQ/snarkVM/). To allow Vanguard to directly process Aleo programs, we recommend installing the compiler while testing out the tool via:

```bash
git clone https://github.com/Veridise/aleo2json.git
cd aleo2json/
cargo install --path . --bin aleo2json
```

To remove it in the future, simply do:

```bash
cargo uninstall aleo2json
```

### Usage

The `aleo2json` tool takes as input a path to `*.aleo` file, and directly outputs the compiled JSON, which includes enhanced information of the program and basic analysis results (e.g., variable types, visibilities, etc.):

```bash
aleo2json <path-to-aleo-file>
```

## Vanguard for Aleo

The library of Vanguard for Aleo provides both integration with the `aleo2json` tool, as well as basic utilities for writing detectors based on static analysis. We've also included detectors for several common vulnerabilities.

### Library Usage

The analyzer can be installed via `pip` setup tools by running:

```bash
pip install .
```

and if you want to remove it:

```bash
pip uninstall vanguard
```

You can write detectors by simply utilizing some functions provided by the analyzer. Here's an example that analyze and get all public outputs/signals from a given Aleo program:

```python
from vanguard.aleo.common import aleo2json, get_public_outputs

aleo_path = ...
aleo_json = aleo2json(aleo_path)

pub_outs = get_public_outputs(aleo_json["functions"]["main"])
if len(pub_outs)>0:
  print(f"There are public outputs: {pub_outs}.")
```

### APIs (Coming Soon)

APIs are located in `vanguard/aleo/common.py` and `vanguard/aleo/detectors/*`, we are working on adding more of them as well as a documentation. Stay tuned!

## Example Leo/Aleo Vulnerabilities

You can find examples showing Leo/Aleo vulnerabilities with comments and annotations in projects in `tests/`:

| Project     | Vulnerability Description               |
| ----------- | --------------------------------------- |
| divrd0/     | Division round-down/truncation (part 0) |
| divz0/      | Division by zero (part 0)               |
| downcast0/  | Division downcast (part 0)              |
| infoleak0/  | Information leakage (part 0)            |
| overflow0/  | Arithmetic overflow (part 0)            |
| rtcnst0/    | Returning constant (part 0)             |
| underflow0/ | Arithmetic underflow (part 0)           |
| unused0/    | Unused variable/signal (part 0)         |

