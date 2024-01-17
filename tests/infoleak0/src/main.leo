// The 'infoleak0' program.
// NOTE: for record generation and consumption, use the following key-address pairs
// 
// private_key: APrivateKey1zkpGKaJY47BXb6knSqmT3JZnBUEGBDFAWz2nMVSsjwYpJmm
// address: aleo15g9c69urtdhvfml0vjl8px07txmxsy454urhgzk57szmcuttpqgq5cvcdy
//
// input record must belong to the signer
// set your private key in the ".env" file
program infoleak0.aleo {
    transition vanguard_helper() -> [bool; 24] {
        return [
            label_ex0, label_ex1, label_ex2, label_ex3,
            label_ex4, label_ex5, label_ex6, label_ex7,
            label_ex8, label_ex9, label_ex10, label_ex11,
            label_ex12, label_ex13, label_ex14, label_ex15,
            label_ex16, label_ex17, label_ex18, label_ex19,
            label_ex20, label_ex21, label_ex22, label_ex23
        ];
    }
    record rec {
        owner: address,
    }
    // use this function to get a new nonce, which you can attach
    // to any record instance owned by the current signer
    transition generate_record() -> rec {
        return rec {
            owner: aleo15g9c69urtdhvfml0vjl8px07txmxsy454urhgzk57szmcuttpqgq5cvcdy,
        };
    }

    // compilable, runnable
    // label: bad
    const label_ex0: bool = true;
    transition ex0(private a: u8) -> public u8 {
        return a;
    }

    // compilable, runnable
    // label: good
    //   keccak256 is considered to block the data flow
    const label_ex1: bool = false;
    transition ex1(private a: u8) -> public address {
        let result: address = Keccak256::hash_to_address(1u8);
        return result;
    }

    // compilable, runnable
    // label: bad, when a >= 0
    //   when a < 0, the info is "semi-leaked"
    const label_ex2: bool = true;
    transition ex2(private a: i8) -> public i8 {
        return a.abs();
    }

    // compilable, runnable
    // label: bad
    //   leaked by addition with constant
    const label_ex3: bool = true;
    transition ex3(private a: u8) -> public u8 {
        return a + 3u8;
    }

    // compilable, runnable
    // label: bad
    //   leaked by addition with two private variables
    const label_ex4: bool = true;
    transition ex4(private a: u8, private b: u8) -> public u8 {
        return a + b;
    }

    // compilable, runnable
    // label: bad
    //   leakded to mapping (FIXME: on-chain state is public?)
    const label_ex5: bool = true;
    mapping account_leak5: u8 => bool;
    transition ex5(private a: u8, public b: u8) -> public u8 {
        return b then finalize(a);
    }
    finalize ex5(public k: u8) {
        Mapping::set(account_leak5, k, true);
    }

    // compilable, runnable
    // label: bad
    //   leaked in helper function
    const label_ex6: bool = true;
    transition ex6(private a: u8) -> public u8 {
        let b: u8 = helper_ex6(a);
        return b;
    }
    function helper_ex6(x: u8) -> u8 {
        return x + 3u8;
    }

    // compilable, runnable
    // label: good
    //   there's no leakage
    const label_ex7: bool = false;
    transition ex7(private a: u8, public b: u8) -> public u8 {
        let c: u8 = helper_ex7(b);
        return c;
    }
    function helper_ex7(x: u8) -> u8 {
        return x + 3u8;
    }

    // compilable, runnable
    // label: bad
    //   leaked by control flow
    const label_ex8: bool = true;
    transition ex8(private a: [bool; 2]) -> public u8 {
        let sum: u8 = 100u8;
        for i: u8 in 0u8..2u8 {
            if a[i] { sum += 10u8; }
        }
        return sum;
    }

    // compilable, runnable
    // label: bad
    //   leaked by sequence of instructions (alias analysis)
    const label_ex9: bool = true;
    transition ex9(private a: u8, public b: u8) -> public u8 {
        let a1: u8 = (a + 8u8) * b;
        let a2: u8 = (b + 8u8) * b;
        let c: u8 = a1 + a2;
        return c;
    }

    // compilable, runnable 
    // label: bad
    const label_ex10: bool = true;
    mapping account_ex10: u8 => u8;
    transition ex10(a: u8, b: u8) -> u8 {
        return a+b then finalize(a, b);
    }
    finalize ex10(public x: u8, public y: u8) {
        Mapping::set(account_ex10, x+y, x/y);
    }

    // compilable, runnable 
    // label: good
    const label_ex11: bool = false;
    mapping account_ex11: u8 => u8;
    transition ex11(private a: u8, private b: u8) -> public u8 {
        return a+b;
    }

    // `finalize` function forces arguments to be public
    // compilable, runnable
    // label: bad
    const label_ex12: bool = true;
    transition ex12(private a: address) {
        return then finalize(a);
    }
    finalize ex12(b: address) {
        assert(true);
    }

    // by default `transition` arguments are private
    // `finalize` function forces arguments to be public
    // compilable, runnable
    // label: bad
    const label_ex13: bool = true;
    transition ex13(a: address) {
        return then finalize(a);
    }
    finalize ex13(b: address) {
        assert(true);
    }

    // type up-casting can be leaking information
    // compilable, runnable
    // label: bad
    const label_ex14: bool = true;
    transition ex14(a: u8) -> public u32 {
        return a as u32;
    }

    // type down-casting can be leaking (partial) information
    // compilable, runnable
    // label: bad
    const label_ex15: bool = true;
    transition ex15(a: u16) -> public u8 {
        return a as u8;
    }

    // ternary operator
    // compilable, runnable
    // label: bad
    const label_ex16: bool = true;
    transition ex16(a: u8) -> public u8 {
        let b: u8 = a == 10u8? 10u8: a;
        return b;
    }

    // compilable, runnable
    // label: bad
    const label_ex17: bool = true;
    transition ex17(a: u8) -> public u8 {
        return helper_ex17(a);
    }
    function helper_ex17(a: u8) -> u8 {
        // use `+ 0u8` to bypass SnarkVM empty body error
        return a + 0u8;
    }

    // compilable, runnable
    // label: bad
    const label_ex18: bool = true;
    transition ex18(a: u8) -> public u8 {
        return helper_ex18(a);
    }
    inline helper_ex18(a: u8) -> u8 {
        // no `+ 0u8` is required
        return a;
    }

    // misleading variable and struct field name
    // compilable, runnable
    // label: bad
    const label_ex19: bool = true;
    struct struct_ex19 {
        a: u8,
        b: u8,
    }
    transition ex19(a: struct_ex19) -> public u8 {
        return a.a;
    }

    // new struct instance creation but leaks unmodified field `b`
    // compilable, runnable
    // label: bad
    const label_ex20: bool = true;
    struct struct_ex20 {
        a: u8,
        b: u8,
    }
    transition ex20(z: struct_ex20) -> public u8 {
        let c: struct_ex20 = struct_ex20 {
            a: z.a + 8u8,
            b: z.b,
        };
        return c.b;
    }

    // returning a new struct instance with unmodified field `b`
    // compilable, runnable
    // label: bad
    const label_ex21: bool = true;
    struct struct_ex21 {
        a: u8,
        b: u8,
    }
    transition ex21(z: struct_ex21) -> public struct_ex21 {
        let c: struct_ex21 = struct_ex21 {
            a: z.a + 8u8,
            b: z.b,
        };
        return c;
    }

    // nested struct unboxing
    // compilable, runnable
    // label: bad
    const label_ex22: bool = true;
    struct struct_ex22_box {
        content: struct_ex22;
    }
    struct struct_ex22 {
        a: u8,
        b: u8,
    }
    transition ex22(z: struct_ex22_box) -> public struct_ex22 {
        return z.content;
    }

    // record info leak
    // compilable, runnable
    // label: bad
    const label_ex23: bool = true;
    record rec_ex23 {
        owner: address,
        data: u8,
    }
    transition ex23(a: rec_ex23) -> u8 {
        return a.data;
    }

}
