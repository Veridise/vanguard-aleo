
program infinity_jjj_nine.aleo;

function infinity_jjj_nine:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record myFirst:
    owner as address.private;
    count as u64.private;

record mySenond:
    owner as address.private;
    count as u64.private;

