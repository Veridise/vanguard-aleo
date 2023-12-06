// The 'rtcnst0' program.
program rtcnst0.aleo {
    transition main(public a: u32, b: u32) -> u32 {
        let c: u32 = a + b;
        return c;
    }

    // compilable, runnable with warning
    // label: bad
    transition ex0() -> u8 {
        return 0u8;
    }
}
