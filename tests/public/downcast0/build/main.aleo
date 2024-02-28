program downcast0.aleo;



function vanguard_helper:
    cast  true true into r0 as [boolean; 2u32];
    output r0 as [boolean; 2u32].private;


function ex0:
    cast 65530u16 into r0 as u8;
    output r0 as u8.private;


function ex1:
    cast 65530u16 into r0 as u8;
    output r0 as u8.private;
