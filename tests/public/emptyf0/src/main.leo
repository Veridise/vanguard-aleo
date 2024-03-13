// The 'emptyf0' program.
program emptyf0.aleo {
    // by default, arguments without visibility are private
    // but in finalize, they have to be public
    transition vanguard_helper() -> [bool; 2] {
        return [
            label_ex0, label_ex1,
        ];
    }

    const label_ex0: bool = true;
    transition ex0() {
    }

    const label_ex1: bool = true;
    transition ex1() -> u8 {
        return 9u8 then finalize();
    }
    finalize ex1() {
        assert(true);
    }


}
