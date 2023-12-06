// The 'overflow0' program.
program overflow0.aleo {
    transition main(public a: u32, b: u32) -> u32 {
        let c: u32 = a + b;
        return c;
    }

    // compilable, exception at runtime
    // label: bad
    transition ex0() -> u8 {
        let a: u8 = 255u8 + 255u8; // integer overflow
        return a;
    }
}
