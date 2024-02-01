
program alo_xxxxx_alo_v8.aleo;

function alo_xxxxx_alo_v8:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record ALEOONE:
    owner as address.private;
    juice as u64.private;

record ALEOTWO:
    owner as address.private;
    juice as u64.private;

