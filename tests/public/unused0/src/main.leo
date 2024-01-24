// The 'unused0' program.
program unused0.aleo {
    transition vanguard_helper() -> [bool; 7] {
        return [
            label_ex0, label_ex1, label_ex2, label_ex3,
            label_ex4, label_ex5, label_ex6,
        ];
    }

    // compilable, runnable
    // label: good
    //   b will be optimized out in the .aleo file
    const label_ex0: bool = false;
    transition ex0() -> u8 {
        let a: u8 = 255u8;
        let b: u8 = 255u8;
        return a;
    }

    // compilable, runnable
    // label: bad
    //   only member a0 is used, and a1 is not used
    const label_ex1: bool = true;
    struct St1 {
        a0: u8,
        a1: u8,
    }
    transition ex1(public a: St1) -> u8 {
        return a.a0;
    }

    // compilable, runnable
    // label: bad
    //   compiler won't optimize b out
    const label_ex2: bool = true;
    transition ex2(a: u8, b: u8) -> u8 {
        return a;
    }

    // compilable, runnable
    // label: good
    const label_ex3: bool = false;
    mapping accounts3: u8 => bool;
    transition ex3(a: u8, b: u8) -> u8 {
        return a then finalize(b);
    }
    finalize ex3(x: u8) {
        Mapping::set(accounts3, x, true);
    }

    // compilable, runnable
    // label: bad
    const label_ex4: bool = true;
    mapping accounts4: u8 => bool;
    transition ex4(a: u8, b: u8) -> u8 {
        return a then finalize(a,b);
    }
    finalize ex4(x: u8, y: u8) {
        Mapping::set(accounts4, x, true);
    }

    // compilable, runnable
    // label: good
    const label_ex5: bool = false;
    transition ex5(a: [bool; 6]) -> u8 {
        let sum: u8 = 0u8;
        for i: u8 in 0u8..6u8 {
            if a[i] { sum += 1u8; }
        }
        return sum;
    }

    // compiable, runnable
    // label: bad
    //   a[2] and a[3] are not used
    const label_ex6: bool = true;
    transition ex6(a: [u8; 4], ind: u8) -> u8 {
        if ind > 9u8 { return a[0u8]; } else { return a[1u8]; }
    }
}
