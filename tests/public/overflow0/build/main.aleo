program overflow0.aleo;



function vanguard_helper:
    cast true into r0 as [boolean; 1u32];
    output r0 as [boolean; 1u32].private;


function ex0:
    add 255u8 255u8 into r0;
    output r0 as u8.private;
