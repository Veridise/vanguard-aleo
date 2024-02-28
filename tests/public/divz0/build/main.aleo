import helpers.aleo;
program divz0.aleo;

struct struct_ex16:
    a as u8;
    b as u8;

record rec_ex19:
    owner as address.private;
    data as u8.private;


mapping account_ex8:
	key as u8.public;
	value as u8.public;


mapping account_ex9:
	key as u8.public;
	value as u8.public;


mapping account_ex13:
	key as u8.public;
	value as u8.public;

function vanguard_helper:
    cast  true true true true false true true false true false false true true true true true true true true true true true true true true true into r0 as [boolean; 26u32];
    output r0 as [boolean; 26u32].private;


function ex0:
    div 225u8 0u8 into r0;
    output r0 as u8.private;


function ex1:
    div 225u8 0u8 into r0;
    output r0 as u8.private;


function ex2:
    input r0 as u8.private;
    div 255u8 r0 into r1;
    output r1 as u8.private;


function ex3:
    div 255u8 0u8 into r0;
    output r0 as u8.private;


function ex4:
    input r0 as u8.private;
    is.neq r0 0u8 into r1;
    assert.eq r1 true;
    div 255u8 r0 into r2;
    output r2 as u8.private;


function ex5:
    div.w 255u8 0u8 into r0;
    output r0 as u8.private;


closure helper_ex6:
    input r0 as u8;
    input r1 as u8;
    div r0 r1 into r2;
    output r2 as u8;


function ex6:
    input r0 as u8.private;
    input r1 as u8.private;
    call helper_ex6 r0 r1 into r2;
    output r2 as u8.private;


function ex7:
    div 225u8 0u8 into r0;
    output r0 as u8.private;


function ex8:
    input r0 as u8.private;
    input r1 as u8.private;
    add r0 r1 into r2;
    async ex8 r0 r1 into r3;
    output r2 as u8.private;
    output r3 as divz0.aleo/ex8.future;

finalize ex8:
    input r0 as u8.public;
    input r1 as u8.public;
    add r0 r1 into r2;
    div r0 r1 into r3;
    set r3 into account_ex8[r2];


function ex9:
    input r0 as u8.private;
    input r1 as u8.private;
    add r0 r1 into r2;
    async ex9 r0 r1 into r3;
    output r2 as u8.private;
    output r3 as divz0.aleo/ex9.future;

finalize ex9:
    input r0 as u8.public;
    input r1 as u8.public;
    add r0 r1 into r2;
    mul r0 r1 into r3;
    set r3 into account_ex9[r2];


function ex10:
    div 255u8 5u8 into r0;
    output r0 as u8.private;


closure helper_ex11:
    input r0 as u8;
    input r1 as u8;
    div r0 r1 into r2;
    output r2 as u8;


function ex11:
    call helper_ex11 225u8 0u8 into r0;
    output r0 as u8.private;




function ex12:
    div 225u8 0u8 into r0;
    output r0 as u8.private;


function ex13:
    input r0 as u8.private;
    input r1 as u8.private;
    add r0 r1 into r2;
    async ex13 r0 r1 into r3;
    output r2 as u8.private;
    output r3 as divz0.aleo/ex13.future;

finalize ex13:
    input r0 as u8.public;
    input r1 as u8.public;
    div r0 r1 into r2;
    assert.eq true true;


function ex14:
    input r0 as u8.private;
    div r0 0u8 into r1;
    output r1 as u8.private;


function ex15:
    input r0 as u8.private;
    async ex15 r0 0u8 into r1;
    output 0u8 as u8.private;
    output r1 as divz0.aleo/ex15.future;

finalize ex15:
    input r0 as u8.public;
    input r1 as u8.public;
    div r0 r1 into r2;


function ex16:
    cast 7u8 0u8 into r0 as struct_ex16;
    div r0.a r0.b into r1;
    output r1 as u8.private;


function ex17:
    cast  3u8 2u8 1u8 0u8 into r0 as [u8; 4u32];
    cast  4u8 3u8 2u8 1u8 into r1 as [u8; 4u32];
    div r1[0u32] r0[0u32] into r2;
    div r1[1u32] r0[1u32] into r3;
    div r1[2u32] r0[2u32] into r4;
    div r1[3u32] r0[3u32] into r5;
    output true as boolean.private;


function ex18:
    div 1u8 0u8 into r0;
    output r0 as u8.private;


function ex19:
    cast aleo1ezamst4pjgj9zfxqq0fwfj8a4cjuqndmasgata3hggzqygggnyfq6kmyd4 0u8 into r0 as rec_ex19.record;
    div 128u8 r0.data into r1;
    output r1 as u8.private;


function ex20:
    cast true into r0 as u8;
    cast false into r1 as u8;
    div r0 r1 into r2;
    output r2 as u8.private;


function ex21:
    async ex21 into r0;
    output r0 as divz0.aleo/ex21.future;

finalize ex21:
    rand.chacha into r0 as u32;
    rand.chacha into r1 as u32;
    div r0 r1 into r2;


function ex22:
    input r0 as u8.private;
    is.eq r0 0u8 into r1;
    ternary r1 1u8 0u8 into r2;
    div 128u8 r2 into r3;
    output r3 as u8.private;


function ex23:
    input r0 as u8.private;
    is.eq r0 0u8 into r1;
    ternary r1 1u8 0u8 into r2;
    div 128u8 r2 into r3;
    output r3 as u8.private;


function ex24:
    div 123field 0field into r0;
    cast r0 into r1 as u8;
    output r1 as u8.private;


function ex25:
    call helpers.aleo/division 224u8 0u8 into r0;
    output r0 as u8.private;
