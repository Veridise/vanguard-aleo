program helpers.aleo;



function division:
    input r0 as u8.private;
    input r1 as u8.private;
    div r0 r1 into r2;
    output r2 as u8.private;
