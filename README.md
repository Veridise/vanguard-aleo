# Vanguard for Aleo

This repo hosts an open-source Python branch of the static analysis tool Vanguard developed by Veridise. This version is optimized for analyzing Leo/Aleo programs.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Usage](#usage)
  - [Commandline Executable](#commandline-executable)
    - [Example Commands](#example-commands)
  - [Calling from Source](#calling-from-source)
  - [Calling as Library](#calling-as-library)
- [Detectors Available](#detectors-available)
- [Example Leo/Aleo Vulnerabilities](#example-leoaleo-vulnerabilities)
- [Parser/Lexer Generation](#parserlexer-generation)
- [Test Suite and Static Analysis APIs](#test-suite-and-static-analysis-apis)

## Prerequisites

The following libraries are required for running (different components of) the tool:

- Python (3.10+) for running Vanguard and its Aleo detectors
  - [NetworkX](https://networkx.org/documentation/stable/install.html) (3.2.1+) for speeding up graph reachability in detectors
  - [Antlr](https://www.antlr.org/) (4.13.1) and its Python binding for loading and parsing Aleo programs
    - `pip install antlr4-python3-runtime==4.13.1`
    - `pip install antlr4-tools`
  - [Beautiful Soup](https://www.crummy.com/software/BeautifulSoup/) (4.12.2+) for crawling benchmarks from public explorers in test suite
  - [pandas](https://pandas.pydata.org/)  (2.1.4+) for data analysis in test suite
  - [tabulate](https://github.com/astanin/python-tabulate) (0.9.0+) for result table rendering
- <u>Leo (**7ac50d8**) for compiling and running all benchmarks enclosed</u>
  - The tools is tested under this version, but newer version of Lao may also work.

## Usage

The library of Vanguard for Aleo provides common vulnerability detectors and basic utilities for writing detectors based on static analysis. There are three ways to use and integrate the tool into your workflow, namely: commandline executable, calling from source and calling as library.

### Commandline Executable

The analyzer can be installed via `pip` setup tools by running:

```bash
pip install .
```

and if you want to remove it:

```bash
pip uninstall vanguard
```

After installation, you can directly use the commandline executable `vanguard-aleo` provided:

```bash
usage: vanguard-aleo [-h] [-b BUILD] [-p PID] [-f FIDS] [-d {divz,infoleak,rtcnst,unused}] [-v]

options:
  -h, --help            show this help message and exit
  -b BUILD, --build BUILD
                        project build path, default: ./
  -p PID, --pid PID     program id, default: <project main entrance>
  -f FIDS, --fids FIDS  function ids (separated by comma, no space), default: <all functions of project>
  -d {divz,infoleak,rtcnst,unused}, --detector {divz,infoleak,rtcnst,unused}
                        detector to use, default: infoleak
  -v, --verbose         whether or not to return extra info, default: False
```

#### Example Commands

- Test detector `infoleak` on all functions of the main program of a project:

  ```bash
  vanguard-aleo -b ./tests/public/infoleak0/build/ -d infoleak
  ```

- Test detector `infoleak` on function `ex0` of the main program of a project:

  ```bash
  vanguard-aleo -b ./tests/public/infoleak0/build/ -f ex0 -d infoleak
  ```

- Test detector `infoleak` of multiple functions `ex0`, `ex1` and `ex2` of the program `infoleak0.aleo`:

  ```bash
  vanguard-aleo -b ./tests/public/infoleak0/build/ -f ex0,ex1,ex2 -p infoleak0.aleo -d infoleak
  ```

- Test detector `infoleak` of multiple functions `ex0`, `ex1` and `ex2` of the program `infoleak0.aleo`, and print out extra information about the finding:

  ```bash
  vanguard-aleo -b ./tests/public/infoleak0/build/ -f ex0,ex1,ex2 -p infoleak0.aleo -d infoleak -v
  ```

  This will produce the following output:

  ```
  |   id | program        | function   | detector   | result   | info                 |
  |------|----------------|------------|------------|----------|----------------------|
  |    0 | infoleak0.aleo | ex0        | infoleak   | unsafe   | ['output r0 as u8;'] |
  |    1 | infoleak0.aleo | ex1        | infoleak   | safe     | []                   |
  |    2 | infoleak0.aleo | ex2        | infoleak   | unsafe   | ['output r1 as i8;'] |
  ```

  where the info column provides more information about the detected vulnerability. For example, in function `ex0` there's information leakage of `r0` via output command. 

### Calling from Source

To call the detectors directly from source code, first make sure all prerequisites are satisfied, and call from the repo root directly:

```python
from .vanguard.aleo.grammar import AleoEnvironment
from .vanguard.aleo.detectors import detector_divz

project_name = "divz0"
function_name = "ex1"
build_path = f"./tests/public/{project_name}/build/"
env = AleoEnvironment.from_project(build_path) # load project
detector_divz(env, env.main.id, function_name, readable=True) # detect
```

### Calling as Library

The analyzer can be installed via `pip` setup tools by running:

```bash
pip install .
```

and if you want to remove it:

```bash
pip uninstall vanguard
```

You can write detectors by simply utilizing some functions provided by the analyzer. Here's an example that loads a project called `divz0` and call the division-by-zero detector:

```python
from vanguard.aleo.grammar import AleoEnvironment
from vanguard.aleo.detectors import detector_divz

project_name = "divz0"
function_name = "ex1"
build_path = f"./tests/public/{project_name}/build/"
env = AleoEnvironment.from_project(build_path) # load project
detector_divz(env, env.main.id, function_name, readable=True) # detect
```

## Detectors Available

```python
from vanguard.aleo.detectors import detector_infoleak
from vanguard.aleo.detectors import detector_rtcnst
from vanguard.aleo.detectors import detector_unused
from vanguard.aleo.detectors import detector_divz
...
```

(More coming soon...)

## Example Leo/Aleo Vulnerabilities

You can find examples showing Leo/Aleo vulnerabilities with comments and annotations in projects in `tests/public/`:

| Project     | Vulnerability Description     |
| ----------- | ----------------------------- |
| divrd0/     | Division truncation/rounddown |
| divz0/      | Division by zero              |
| downcast0/  | Type downcast                 |
| infoleak0/  | Information leakage           |
| overflow0/  | Arithmetic overflow           |
| rtcnst0/    | Returning constant            |
| underflow0/ | Arithmetic underflow          |
| unused0/    | Unused variable/signal        |

## Parser/Lexer Generation

In case the parser is not compatible with your environment, you can generate it again using Antlr:

```bash
cd ./vanguard/aleo/parser/
antlr4 -v 4.13.1 -Dlanguage=Python3 ./AleoLexer.g4 # generate lexer
antlr4 -v 4.13.1 -Dlanguage=Python3 ./AleoParser.g4 # generate parser
```

The parser/lexer file is located in `./vanguard/aleo/parser/AleoLexer.g4` and `./vanguard/aleo/parser/AleoParser.g4`.

## Test Suite and Static Analysis APIs

(Coming soon...)
