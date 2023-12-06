// The 'underflow0' program.
program underflow0.aleo {
    transition main(public a: u32, b: u32) -> u32 {
        let c: u32 = a + b;
        return c;
    }

    // compilable, exception at runtime
    // label: bad
    transition ex0() -> u8 {
        let a: u8 = 0u8 - 1u8; // integer underflow
        return a;
    }

    // compilable, exception at runtime when a < b
    // label: bad
    transition ex1(a: u8, b: u8) -> u8 {
        let c: u8 = a - b; // potential integer underflow
        return c;
    }
}
