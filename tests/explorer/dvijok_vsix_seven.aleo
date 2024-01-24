
program dvijok_vsix_seven.aleo;

function dvijok_vsix_seven:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record SEX:
    owner as address.private;
    amount as u64.private;

record SEVEN:
    owner as address.private;
    amount as u64.private;

