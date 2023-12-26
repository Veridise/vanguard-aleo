// The 'rtcnst0' program.
program rtcnst0.aleo {
    transition vanguard_helper() -> [bool; 1] {
        return [
            label_ex0,
        ];
    }

    // compilable, runnable with warning
    // label: bad
    const label_ex0: bool = true;
    transition ex0() -> u8 {
        return 0u8;
    }
}
