// The 'uncat0' program.
program uncat0.aleo {
    transition vanguard_helper() -> [bool; 3] {
        return [
            label_ex0, label_ex1, label_ex2,
        ];
    }

    // conditional trap
    // compilable, exception at runtime
    // label: bad
    const label_ex0: bool = true;
    transition ex0(a: u8) -> u8 {
        if a == 0u8 { return 1u8; }
        let c: u8 = 224u8 / a;
        return c;
    }

    // conditional trap
    // compilable, exception at runtime
    // label: bad
    const label_ex1: bool = true;
    transition ex1(a: u8) -> u8 {
        let c: u8 = a == 0u8 ? 224u8 / 1u8 : 224u8 / a;
        return c;
    }

    // conditional trap
    // compilable, exception when a >= 200
    // label: bad
    const label_ex2: bool = true;
    transition ex2(a: u8) -> u8 {
        let c: u8 = a >= 200u8 ? a : 56u8 + a;
        return c;
    }
}
