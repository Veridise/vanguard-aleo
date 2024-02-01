
program fy_best_player_vers.aleo;

function fy_best:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record FY:
    owner as address.private;
    amount as u64.private;

record CHINAMAN:
    owner as address.private;
    amount as u64.private;

