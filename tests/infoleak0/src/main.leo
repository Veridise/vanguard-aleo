// The 'infoleak0' program.
program infoleak0.aleo {
    transition vanguard_helper() -> [bool; 10] {
        return [
            label_ex0, label_ex1, label_ex2, label_ex3,
            label_ex4, label_ex5, label_ex6, label_ex7,
            label_ex8, label_ex9,
        ];
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
}
