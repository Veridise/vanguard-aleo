program divrd0.aleo;



function vanguard_helper:
    cast  true true false true false true true into r0 as [boolean; 7u32];
    output r0 as [boolean; 7u32].private;


function ex0:
    div 225u8 16u8 into r0;
    output r0 as u8.private;


function ex1:
    div 15u8 2u8 into r0;
    mul r0 2u8 into r1;
    output r1 as u8.private;


function ex2:
    div 16u8 2u8 into r0;
    mul r0 2u8 into r1;
    output r1 as u8.private;


function ex3:
    input r0 as u8.private;
    div r0 2u8 into r1;
    mul r1 2u8 into r2;
    output r2 as u8.private;


function ex4:
    mul 15u8 2u8 into r0;
    div r0 2u8 into r1;
    output r1 as u8.private;


function ex5:
    input r0 as u8.private;
    mul r0 2u8 into r1;
    div r1 2u8 into r2;
    output r2 as u8.private;


function ex6:
    mul 15u8 2u8 into r0;
    div r0 9u8 into r1;
    output r1 as u8.private;
