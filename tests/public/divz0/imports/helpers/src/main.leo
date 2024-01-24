// The 'helpers' program.
program helpers.aleo {
    transition division(a: u8, b: u8) -> u8 {
        let c: u8 = a / b;
        return c;
    }
}
