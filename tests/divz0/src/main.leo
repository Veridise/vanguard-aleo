// The 'divz0' program.
program divz0.aleo {
    // by default, arguments without visibility are private
    // but in finalize, they have to be public
    transition vanguard_helper() -> [bool; 26] {
        return [
            label_ex0, label_ex1, label_ex2, label_ex3,
            label_ex4, label_ex5, label_ex6, label_ex7,
            label_ex8, label_ex9, label_ex10, label_ex11,
            label_ex12, label_ex13, label_ex14, label_ex15,
            label_ex16, label_ex17, label_ex18, label_ex19,
            label_ex20, label_ex21, label_ex22, label_ex23,
            label_ex24, label_ex25,
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

    // compilable, exception at runtime
    // label: bad
    const label_ex12: bool = true;
    transition ex12() -> u8 {
        let a: u8 = 225u8;
        let b: u8 = 0u8;
        let c: u8 = helper_ex12(a, b);
        return c;
    }
    inline helper_ex12(a: u8, b: u8) -> u8 {
        return a/b;
    }

    // compilable, runnable
    // label: bad
    const label_ex13: bool = true;
    mapping account_ex13: u8 => u8;
    transition ex13(a: u8, b: u8) -> u8 {
        return a+b then finalize(a, b);
    }
    finalize ex13(x: u8, y: u8) {
        let c: u8 = x/y;
        assert(true);
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex14: bool = true;
    transition ex14(a: u8) -> u8 {
        const b: u8 = 0u8;
        return a/b;
    }

    // compilable, runnable
    // label: bad
    const label_ex15: bool = true;
    transition ex15(a: u8) -> u8 {
        const b: u8 = 0u8;
        return b then finalize(a, b);
    }
    finalize ex15(a: u8, b: u8) {
        let c: u8 = a/b;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex16: bool = true;
    struct struct_ex16 {
        a: u8,
        b: u8,
    }
    transition ex16() -> u8 {
        let c: struct_ex16 = struct_ex16{ a: 7u8, b: 0u8 };
        return c.a / c.b;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex17: bool = true;
    transition ex17() -> bool {
        let a: [u8; 4] = [3u8, 2u8, 1u8, 0u8];
        let b: [u8; 4] = [4u8, 3u8, 2u8, 1u8];
        for i: u8 in 0u8..4u8 {
            let c: u8 = b[i] / a[i];
        }
        return true;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex18: bool = true;
    transition ex18() -> u8 {
        let a: (u8, u8) = (1u8, 0u8);
        let result: u8 = a.0 / a.1;
        return result;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex19: bool = true;
    record rec_ex19 {
        owner: address,
        data: u8,
    }
    transition ex19() -> u8 {
        let a: rec_ex19 = rec_ex19 {
            owner: aleo1ezamst4pjgj9zfxqq0fwfj8a4cjuqndmasgata3hggzqygggnyfq6kmyd4,
            data: 0u8,
        };
        let b: u8 = 128u8 / a.data;
        return b;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex20: bool = true;
    transition ex20() -> u8 {
        let a: u8 = true as u8;
        let b: u8 = false as u8;
        return a / b;
    }

    // compilable, exception when b = 0
    // label: bad, when b = 0
    const label_ex21: bool = true;
    transition ex21() {
        return then finalize();
    }
    finalize ex21() {
        // the following won't be optimized out for leo 1.10.0
        let a: u32 = ChaCha::rand_u32();
        let b: u32 = ChaCha::rand_u32();
        let c: u32 = a / b;
    }

    // compilable, exception when a != 0
    // label: bad, when a != 0
    const label_ex22: bool = true;
    transition ex22(a: u8) -> u8 {
        let b: u8 = 9u8;
        if a == 0u8 { b = 1u8; } else { b = 0u8; }
        let c: u8 = 128u8;
        return c / b;
    }

    // compilable, exception when a != 0
    // label: bad, when a != 0
    const label_ex23: bool = true;
    transition ex23(a: u8) -> u8 {
        let b: u8 = a == 0u8? 1u8: 0u8;
        let c: u8 = 128u8;
        return c / b;
    }

    // compilable, exception at runtime
    // label: bad
    const label_ex24: bool = true;
    transition ex24() -> u8 {
        let a: field = 0field;
        let b: field = 123field;
        return (b / a) as u8;
    }

    // NOTE: division is not supported in group (official doc)
    //       but here it's still compilable
    // NOTE: division is not supported in scalar (won't compile)
    // NOTE: runtime exception is different (snarkVM parsing error)
    // compilable, exception at runtime
    // label: bad
    const label_ex25: bool = true;
    transition ex25() -> u8 {
        let a: group = 0group;
        let b: group = 123group;
        return (b / a) as u8;
    }

}
