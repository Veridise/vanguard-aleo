
program tos_electonik_v0.aleo;

function tos_electonik:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record TOS:
    owner as address.private;
    amount as u64.private;

record NIKI:
    owner as address.private;
    amount as u64.private;

