
program just_callme_aleov1.aleo;

function just_callme_aleov1:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record HOLY:
    owner as address.private;
    amount as u64.private;
    wallet as u64.private;

record TEDY:
    owner as address.private;
    amount as u64.private;
    wallet as u64.private;

