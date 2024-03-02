program uncat0.aleo;



function vanguard_helper:
    cast  true true true into r0 as [boolean; 3u32];
    output r0 as [boolean; 3u32].private;


function ex0:
    input r0 as u8.private;
    is.eq r0 0u8 into r1;
    div 224u8 r0 into r2;
    ternary r1 1u8 r2 into r3;
    output r3 as u8.private;


function ex1:
    input r0 as u8.private;
    is.eq r0 0u8 into r1;
    div 224u8 1u8 into r2;
    div 224u8 r0 into r3;
    ternary r1 r2 r3 into r4;
    output r4 as u8.private;


function ex2:
    input r0 as u8.private;
    gte r0 200u8 into r1;
    add 56u8 r0 into r2;
    ternary r1 r0 r2 into r3;
    output r3 as u8.private;
