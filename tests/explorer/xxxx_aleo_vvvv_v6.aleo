
program xxxx_aleo_vvvv_v6.aleo;

function xxxx_aleo_vvvv_v6:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record XXX:
    owner as address.private;
    wallet as u64.private;
    apple as u64.private;

record VVV:
    owner as address.private;
    wallet as u64.private;
    apple as u64.private;

