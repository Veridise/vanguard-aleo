// The 'overflow0' program.
program overflow0.aleo {
    transition vanguard_helper() -> [bool; 1] {
        return [
            label_ex0,
        ];
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex0: bool = true;
    transition ex0() -> u8 {
        let a: u8 = 255u8 + 255u8; // integer overflow
        return a;
    }
}
