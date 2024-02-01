
program itisthebestprojectv1.aleo;

function itisthebestprojectv1:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record firtsRecord:
    owner as address.private;
    amount as u64.private;

record secondRecord:
    owner as address.private;
    amount as u64.private;

