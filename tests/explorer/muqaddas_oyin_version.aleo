
program muqaddas_oyin_version.aleo;

function muqaddas_oyin_version:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record OYIN:
    owner as address.private;
    amount as u64.private;

record MUQQ:
    owner as address.private;
    amount as u64.private;

