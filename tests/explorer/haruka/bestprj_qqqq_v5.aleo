
program bestprj_qqqq_v5.aleo;

function bestprj_qqqq_v5:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record QQQ:
    owner as address.private;
    amount as u64.private;
    wallet as u64.private;
    balance as u64.private;

record WWWW:
    owner as address.private;
    amount as u64.private;
    wallet as u64.private;
    balance as u64.private;

