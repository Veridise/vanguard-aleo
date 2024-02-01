
program hello_my_friend_tech.aleo;

function friend_tech:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record DOST:
    owner as address.private;
    amount as u64.private;

record FRIEN:
    owner as address.private;
    amount as u64.private;

