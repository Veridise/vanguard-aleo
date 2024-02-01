
program young_ggg_loveit6.aleo;

function young_ggg_loveit6:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record YYY:
    owner as address.private;
    count as u64.private;
    wallet as u64.private;

record XXX:
    owner as address.private;
    amount as u64.private;
    balance as u64.private;

