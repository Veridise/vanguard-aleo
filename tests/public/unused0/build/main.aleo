program unused0.aleo;

struct St1:
    a0 as u8;
    a1 as u8;


mapping accounts3:
	key as u8.public;
	value as boolean.public;


mapping accounts4:
	key as u8.public;
	value as boolean.public;

function vanguard_helper:
    cast  false true true false true false true into r0 as [boolean; 7u32];
    output r0 as [boolean; 7u32].private;


function ex0:
    output 255u8 as u8.private;


function ex1:
    input r0 as St1.public;
    output r0.a0 as u8.private;


function ex2:
    input r0 as u8.private;
    input r1 as u8.private;
    output r0 as u8.private;


function ex3:
    input r0 as u8.private;
    input r1 as u8.private;
    async ex3 r1 into r2;
    output r0 as u8.private;
    output r2 as unused0.aleo/ex3.future;

finalize ex3:
    input r0 as u8.public;
    set true into accounts3[r0];


function ex4:
    input r0 as u8.private;
    input r1 as u8.private;
    async ex4 r0 r1 into r2;
    output r0 as u8.private;
    output r2 as unused0.aleo/ex4.future;

finalize ex4:
    input r0 as u8.public;
    input r1 as u8.public;
    set true into accounts4[r0];


function ex5:
    input r0 as [boolean; 6u32].private;
    add 0u8 1u8 into r1;
    ternary r0[0u32] r1 0u8 into r2;
    add r2 1u8 into r3;
    ternary r0[1u32] r3 r2 into r4;
    add r4 1u8 into r5;
    ternary r0[2u32] r5 r4 into r6;
    add r6 1u8 into r7;
    ternary r0[3u32] r7 r6 into r8;
    add r8 1u8 into r9;
    ternary r0[4u32] r9 r8 into r10;
    add r10 1u8 into r11;
    ternary r0[5u32] r11 r10 into r12;
    output r12 as u8.private;


function ex6:
    input r0 as [u8; 4u32].private;
    input r1 as u8.private;
    gt r1 9u8 into r2;
    ternary r2 r0[0u32] r0[1u32] into r3;
    output r3 as u8.private;
