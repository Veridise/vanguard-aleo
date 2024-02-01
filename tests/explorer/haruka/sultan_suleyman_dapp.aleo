
program sultan_suleyman_dapp.aleo;

function sultan_suleyman_dapp:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record SULIK:
    owner as address.private;
    amount as u64.private;

record SASULIK:
    owner as address.private;
    amount as u64.private;

