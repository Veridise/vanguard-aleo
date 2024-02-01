
program juggernaut_blade.aleo;

function juggernaut_blad:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record JAGGERNARI:
    owner as address.private;
    amount as u64.private;

record JUGEGER:
    owner as address.private;
    amount as u64.private;

