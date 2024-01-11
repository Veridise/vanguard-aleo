// The 'divz0' program.
program divz0.aleo {
    // by default, arguments without visibility are private
    // but in finalize, they have to be public
    transition vanguard_helper() -> [bool; 12] {
        return [
            label_ex0, label_ex1, label_ex2, label_ex3,
            label_ex4, label_ex5, label_ex6, label_ex7,
            label_ex8, label_ex9, label_ex10, label_ex11,
        ];
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex0: bool = true;
    transition ex0() -> u8 {
        let a: u8 = 225u8;
        let b: u8 = 0u8;
        let c: u8 = a / b; // division by 0 (var)
        return c;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex1: bool = true;
    transition ex1() -> u8 {
        let a: u8 = 225u8;
        let c: u8 = a / 0u8; // division by 0 (literal)
        return c;
    }

    // compilable, exception at runtime when b = 0
    // label: bad
    const label_ex2: bool = true;
    transition ex2(b: u8) -> u8 {
        let a: u8 = 255u8;
        let c: u8 = a / b; // potential division by 0 (input)
        return c;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex3: bool = true;
    transition ex3() -> u8 {
        let a: u8 = 255u8;
        let c: u8 = a.div(0u8); // division by 0 using div
        return c;
    }

    // compilable, exception at runtime when b = 0
    // label: good
    //   assert captures the error
    //   NOTE: but the exception is not assertion exception, could be an issue
    const label_ex4: bool = false;
    transition ex4(b: u8) -> u8 {
        let a: u8 = 255u8;
        assert(b != 0u8);
        let c: u8 = a / b; // potential division by 0 (input)
        return c;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex5: bool = true;
    transition ex5() -> u8 {
        let a: u8 = 255u8;
        let c: u8 = a.div_wrapped(0u8); // division by 0 using div
        return c;
    }

    // compilable, exception at runtime when b=0
    // label: bad
    const label_ex6: bool = true;
    transition ex6(a: u8, b: u8) -> u8 {
        let c: u8 = helper_ex6(a,b);
        return c;
    }
    function helper_ex6(x: u8, y: u8) -> u8 {
        return x / y;
    }

    // compilable, runnable
    // label: good
    const label_ex7: bool = false;
    transition ex7() -> u8 {
        let a: u8 = 225u8;
        let b: u8 = 0u8;
        let c: u8 = a / b; // division by 0 (var)
        return c;
    }

    // compilable, runnable
    // label: bad
    const label_ex8: bool = true;
    mapping account_ex8: u8 => u8;
    transition ex8(a: u8, b: u8) -> u8 {
        return a+b then finalize(a, b);
    }
    finalize ex8(x: u8, y: u8) {
        Mapping::set(account_ex8, x+y, x/y);
    }

    // compilable, runnable
    // label: good
    const label_ex9: bool = false;
    mapping account_ex9: u8 => u8;
    transition ex9(a: u8, b: u8) -> u8 {
        return a+b then finalize(a, b);
    }
    finalize ex9(x: u8, y: u8) {
        Mapping::set(account_ex9, x+y, x*y);
    }

    // compilable, runnable
    // label: good
    const label_ex10: bool = false;
    transition ex10() -> u8 {
        let a: u8 = 255u8;
        let c: u8 = a.div(5u8);
        return c;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex11: bool = true;
    transition ex11() -> u8 {
        let a: u8 = 225u8;
        let b: u8 = 0u8;
        let c: u8 = helper_ex11(a, b);
        return c;
    }
    function helper_ex11(a: u8, b: u8) -> u8 {
        return a/b;
    }
}
