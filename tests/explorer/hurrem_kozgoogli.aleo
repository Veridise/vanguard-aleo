
program hurrem_kozgoogli.aleo;

function hurrem_kozgoogli:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record HUR:
    owner as address.private;
    amount as u64.private;

record REM:
    owner as address.private;
    amount as u64.private;

