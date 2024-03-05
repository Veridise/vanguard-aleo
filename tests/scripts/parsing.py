from vanguard.aleo.grammar import AleoEnvironment

if __name__ == "__main__":
    project_name = "divz0"
    build_path = f"./tests/public/{project_name}/build/"
    env = AleoEnvironment.from_project(build_path)
    main = env.main
    print("# Done.")