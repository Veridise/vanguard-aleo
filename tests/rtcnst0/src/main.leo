// The 'rtcnst0' program.
program rtcnst0.aleo {
    transition vanguard_helper() -> [bool; 8] {
        return [
            label_ex0, label_ex1, label_ex2, label_ex3,
            label_ex4, label_ex5, label_ex6, label_ex7,
        ];
    }

    // compilable, runnable with warning
    // label: bad
    const label_ex0: bool = true;
    transition ex0() -> u8 {
        return 0u8;
    }

    // compilable, runable
    // label: bad
    const label_ex1: bool = true;
    transition ex1(a: u8) -> u8 {
        return a;
    }

    // compilable, runnable
    // label: good
    const label_ex2: bool = false;
    transition ex2(a: u8, b: u8) -> u8 {
        return a+b;
    }

    // compilable, runnable
    // label: bad
    const label_ex3: bool = true;
    mapping map_ex3: u8 => u8;
    transition ex3() ->  u8 {
        return 7u8 then finalize(7u8);
    }
    finalize ex3(a: u8) {
        Mapping::set(map_ex3, a, a);
    }

    // compilable, runnable
    // label: good
    const label_ex4: bool = false;
    mapping map_ex4: u8 => u8;
    transition ex4(a: u8, b: u8) -> u8 {
        return a*b then finalize(a+b);
    }
    finalize ex4(c: u8) {
        Mapping::set(map_ex4, c, c);
    }
    
    // compilable, runnable
    // label: bad
    const label_ex5: bool = true;
    transition ex5() -> u8 {
        return helper_ex5(7u8);
    }
    function helper_ex5(a: u8) -> u8 {
        return a+0u8;
    }

    // compilable, runnable
    // label: bad
    const label_ex6: bool = true;
    transition ex6(a: u8) -> bool {
        if a > 10u8 { return true; }
        else { return true; }
    }

    // compilable, runnable
    // label: good
    const label_ex7: bool = false;
    transition ex7(a: u8) -> bool {
        if a > 10u8 { return true; }
        else { return false; }
    }
}
