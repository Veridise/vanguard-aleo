
program private_app_with_voo.aleo;

function private_app_with_voo:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record VOO:
    owner as address.private;
    amount as u64.private;

record VUU:
    owner as address.private;
    amount as u64.private;

