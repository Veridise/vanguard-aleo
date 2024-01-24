
program lspd_los_santos_v2.aleo;

function lspd_los_santos:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record LSPD:
    owner as address.private;
    amount as u64.private;

record JUNG:
    owner as address.private;
    amount as u64.private;

