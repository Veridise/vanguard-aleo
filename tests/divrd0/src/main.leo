// The 'divrd0' program.
program divrd0.aleo {
    
    transition vanguard_helper() -> [bool; 4] {
        return [
            label_ex0, label_ex1, label_ex2, label_ex3,
            label_ex4, label_ex5, label_ex6,
        ];
    }

    // compilable, runnable
    // label: bad
    const label_ex0: bool = true;
    transition ex0() -> u8 {
        let a: u8 = 225u8;
        let b: u8 = 16u8;
        let c: u8 = a / b; // division round-down / truncation
        return c;
    }

    // compilable, runnable
    // label: bad
    const label_ex1: bool = true;
    transition ex1() -> u8 {
        let a: u8 = 15u8;
        let b: u8 = a / 2u8 * 2u8; // div before mul, truncation
        return b;
    }

    // compilable, runnable
    // label good
    const label_ex2: bool = false;
    transition ex2() -> u8 {
        let a: u8 = 16u8;
        let b: u8 = a / 2u8 * 2u8; // div before mul, but no truncation
        return b;
    }

    // compilable, runnable
    //label bad
    const label_ex3: bool = true;
    transition ex3(a: u8) -> u8 {
        let b: u8 = a / 2u8 * 2u8; // div before mul
        return b;
    }

    // compilable, runnable
    // label: good
    const label_ex4: bool = false;
    transition ex4() -> u8 {
        let a: u8 = 15u8;
        let b: u8 = a * 2u8 / 2u8;
        return b;
    }

    // compilable, runnable
    // label bad
    const label_ex5: bool = true;
    transition ex5(a: u8) -> u8 {
        let b: u8 = a * 2u8 / 2u8;
        return b;
    }

    // compilable, runnable
    // label: bad
    const label_ex6: bool = true;
    transition ex6() -> u8 {
        let a: u8 = 15u8;
        let b: u8 = a * 2u8 / 9u8;
        return b;
    }
}
