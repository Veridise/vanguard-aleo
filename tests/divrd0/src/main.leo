// The 'divrd0' program.
program divrd0.aleo {
    transition main(public a: u32, b: u32) -> u32 {
        let c: u32 = a + b;
        return c;
    }

    // compilable, runnable
    // label: bad
    transition ex0() -> u8 {
        let a: u8 = 225u8;
        let b: u8 = 16u8;
        let c: u8 = a / b; // division round-down / truncation
        return c;
    }
}
