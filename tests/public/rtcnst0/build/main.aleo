program rtcnst0.aleo;



mapping map_ex3:
	key as u8.public;
	value as u8.public;


mapping map_ex4:
	key as u8.public;
	value as u8.public;

function vanguard_helper:
    cast  true true false true false true true false into r0 as [boolean; 8u32];
    output r0 as [boolean; 8u32].private;


function ex0:
    output 0u8 as u8.private;


function ex1:
    input r0 as u8.private;
    output r0 as u8.private;


function ex2:
    input r0 as u8.private;
    input r1 as u8.private;
    add r0 r1 into r2;
    output r2 as u8.private;


function ex3:
    async ex3 7u8 into r0;
    output 7u8 as u8.private;
    output r0 as rtcnst0.aleo/ex3.future;

finalize ex3:
    input r0 as u8.public;
    set r0 into map_ex3[r0];


function ex4:
    input r0 as u8.private;
    input r1 as u8.private;
    mul r0 r1 into r2;
    add r0 r1 into r3;
    async ex4 r3 into r4;
    output r2 as u8.private;
    output r4 as rtcnst0.aleo/ex4.future;

finalize ex4:
    input r0 as u8.public;
    set r0 into map_ex4[r0];


closure helper_ex5:
    input r0 as u8;
    add r0 0u8 into r1;
    output r1 as u8;


function ex5:
    call helper_ex5 7u8 into r0;
    output r0 as u8.private;


function ex6:
    input r0 as u8.private;
    gt r0 10u8 into r1;
    ternary r1 true true into r2;
    output r2 as boolean.private;


function ex7:
    input r0 as u8.private;
    gt r0 10u8 into r1;
    ternary r1 true false into r2;
    output r2 as boolean.private;
