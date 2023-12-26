// The 'underflow0' program.
program underflow0.aleo {
    transition vanguard_helper() -> [bool; 2] {
        return [
            label_ex0, label_ex1,
        ];
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex0: bool = true;
    transition ex0() -> u8 {
        let a: u8 = 0u8 - 1u8; // integer underflow
        return a;
    }

    // compilable, exception at runtime when a < b
    // label: bad
    const label_ex1: bool = true;
    transition ex1(a: u8, b: u8) -> u8 {
        let c: u8 = a - b; // potential integer underflow
        return c;
    }
}
