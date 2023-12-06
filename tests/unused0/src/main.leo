// The 'unused0' program.
program unused0.aleo {
    transition main(public a: u32, b: u32) -> u32 {
        let c: u32 = a + b;
        return c;
    }

    // compilable, runnable
    // label: good
    //   b will be optimized out in the .aleo file
    transition ex0() -> u8 {
        let a: u8 = 255u8;
        let b: u8 = 255u8;
        return a;
    }

    // compilable, runnable
    // label: bad
    //   only member a0 is used, and a1 is not used
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
    transition ex2(a: u8, b: u8) -> u8 {
        return a;
    }

    // compilable, runnable
    // label: good
    mapping accounts3: u8 => bool;
    transition ex3(a: u8, b: u8) -> u8 {
        return a then finalize(b);
    }
    finalize ex3(x: u8) {
        Mapping::set(accounts3, x, true);
    }

    // compilable, runnable
    // label: bad
    mapping accounts4: u8 => bool;
    transition ex4(a: u8, b: u8) -> u8 {
        return a then finalize(a,b);
    }
    finalize ex4(x: u8, y: u8) {
        Mapping::set(accounts4, x, true);
    }

    // compilable, runnable
    // label: good
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
    transition ex6(a: [u8; 4], ind: u8) -> u8 {
        if ind > 9u8 { return a[0u8]; } else { return a[1u8]; }
    }
}
