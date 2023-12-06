// The 'downcast0' program.
program downcast0.aleo {
    transition main(public a: u32, b: u32) -> u32 {
        let c: u32 = a + b;
        return c;
    }

    // compilable, exception at runtime
    // label: bad
    transition ex0() -> u8 {
        let a: u16 = 65530u16;
        let b: u8 = a as u8; // downcasting
        return b;
    }

    // compilable, exception at runtime
    // label: bad
    transition ex1() -> u8 {
        let a: u8 = 65530u16 as u8; // downcasting
        return a;
    }
}
