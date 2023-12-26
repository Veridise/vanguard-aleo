// The 'divrd0' program.
program divrd0.aleo {
    
    transition vanguard_helper() -> [bool; 1] {
        return [
            label_ex0,
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
}
