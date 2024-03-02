program underflow0.aleo;



function vanguard_helper:
    cast  true true into r0 as [boolean; 2u32];
    output r0 as [boolean; 2u32].private;


function ex0:
    sub 0u8 1u8 into r0;
    output r0 as u8.private;


function ex1:
    input r0 as u8.private;
    input r1 as u8.private;
    sub r0 r1 into r2;
    output r2 as u8.private;
