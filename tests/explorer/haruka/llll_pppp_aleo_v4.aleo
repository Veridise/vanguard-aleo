
program llll_pppp_aleo_v4.aleo;

function llll_pppp_aleo_v4:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record ONE:
    owner as address.private;
    amount as u64.private;
    wallet as u64.private;

record SECOND:
    owner as address.private;
    amount as u64.private;
    wallet as u64.private;

