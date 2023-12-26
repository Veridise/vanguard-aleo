// The 'downcast0' program.
program downcast0.aleo {
     transition vanguard_helper() -> [bool; 2] {
        return [
            label_ex0, label_ex1,
        ];
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex0: bool = true;
    transition ex0() -> u8 {
        let a: u16 = 65530u16;
        let b: u8 = a as u8; // downcasting
        return b;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex1: bool = true;
    transition ex1() -> u8 {
        let a: u8 = 65530u16 as u8; // downcasting
        return a;
    }
}
