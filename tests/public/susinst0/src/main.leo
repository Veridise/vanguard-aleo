// The 'susinst0' program.
program susinst0.aleo {
    // by default, arguments without visibility are private
    // but in finalize, they have to be public
    transition vanguard_helper() -> [bool; 3] {
        return [
            label_ex0, label_ex1, label_ex2
        ];
    }

    const label_ex0: bool = true;
    transition ex0() {
        assert(true);
    }

    const label_ex1: bool = true;
    transition ex1() -> u8 {
        let a: u8 = 123u8 + 0u8;
        return a;
    }

    const label_ex2: bool = true;
    transition ex2() -> u8 {
        let a: u8 = 123u8 * 1u8;
        return a;
    }


}
