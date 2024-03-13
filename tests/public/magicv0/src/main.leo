// The 'magicv0' program.
program magicv0.aleo {
    // by default, arguments without visibility are private
    // but in finalize, they have to be public
    transition vanguard_helper() -> [bool; 2] {
        return [
            label_ex0, label_ex1,
        ];
    }

    const label_ex0: bool = true;
    transition ex0() -> address {
        let a: address = aleo1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq3ljyzc;
        return a;
    }

    const label_ex1: bool = true;
    transition ex1() -> u8 {
        let a: u8 = 123u8;
        return a;
    }


}
