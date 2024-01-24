
program wirtual_drivers.aleo;

function w_virtual:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record WD:
    owner as address.private;
    amount as u64.private;

record DW:
    owner as address.private;
    amount as u64.private;

