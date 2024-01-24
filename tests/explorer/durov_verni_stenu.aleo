
program durov_verni_stenu.aleo;

function verni_stenu:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record DUROV:
    owner as address.private;
    amount as u64.private;

record STENA:
    owner as address.private;
    amount as u64.private;

