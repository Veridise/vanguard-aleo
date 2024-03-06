program infoleak0.aleo;

record rec:
    owner as address.private;

struct struct_ex19:
    a as u8;
    b as u8;

struct struct_ex20:
    a as u8;
    b as u8;

struct struct_ex21:
    a as u8;
    b as u8;

struct struct_ex22:
    a as u8;
    b as u8;

struct struct_ex22_box:
    content as struct_ex22;

record rec_ex23:
    owner as address.private;
    data as u8.private;

record rec_ex24:
    owner as address.public;
    data as u8.public;


mapping account_leak5:
	key as u8.public;
	value as boolean.public;


mapping account_ex10:
	key as u8.public;
	value as u8.public;


mapping account_ex11:
	key as u8.public;
	value as u8.public;

function vanguard_helper:
    cast  true false true true true true true false true true true false true true true true true true true true true true true true false into r0 as [boolean; 25u32];
    output r0 as [boolean; 25u32].private;


function generate_record:
    cast aleo15g9c69urtdhvfml0vjl8px07txmxsy454urhgzk57szmcuttpqgq5cvcdy into r0 as rec.record;
    output r0 as rec.record;


function ex0:
    input r0 as u8.private;
    output r0 as u8.public;


function ex1:
    input r0 as u8.private;
    hash.keccak256 1u8 into r1 as address;
    output r1 as address.public;


function ex2:
    input r0 as i8.private;
    abs r0 into r1;
    output r1 as i8.public;


function ex3:
    input r0 as u8.private;
    add r0 3u8 into r1;
    output r1 as u8.public;


function ex4:
    input r0 as u8.private;
    input r1 as u8.private;
    add r0 r1 into r2;
    output r2 as u8.public;


function ex5:
    input r0 as u8.private;
    input r1 as u8.public;
    async ex5 r0 into r2;
    output r1 as u8.public;
    output r2 as infoleak0.aleo/ex5.future;

finalize ex5:
    input r0 as u8.public;
    set true into account_leak5[r0];


closure helper_ex6:
    input r0 as u8;
    add r0 3u8 into r1;
    output r1 as u8;


function ex6:
    input r0 as u8.private;
    call helper_ex6 r0 into r1;
    output r1 as u8.public;


closure helper_ex7:
    input r0 as u8;
    add r0 3u8 into r1;
    output r1 as u8;


function ex7:
    input r0 as u8.private;
    input r1 as u8.public;
    call helper_ex7 r1 into r2;
    output r2 as u8.public;


function ex8:
    input r0 as [boolean; 2u32].private;
    add 100u8 10u8 into r1;
    ternary r0[0u32] r1 100u8 into r2;
    add r2 10u8 into r3;
    ternary r0[1u32] r3 r2 into r4;
    output r4 as u8.public;


function ex9:
    input r0 as u8.private;
    input r1 as u8.public;
    add r0 8u8 into r2;
    mul r2 r1 into r3;
    add r1 8u8 into r4;
    mul r4 r1 into r5;
    add r3 r5 into r6;
    output r6 as u8.public;


function ex10:
    input r0 as u8.private;
    input r1 as u8.private;
    add r0 r1 into r2;
    async ex10 r0 r1 into r3;
    output r2 as u8.private;
    output r3 as infoleak0.aleo/ex10.future;

finalize ex10:
    input r0 as u8.public;
    input r1 as u8.public;
    add r0 r1 into r2;
    div r0 r1 into r3;
    set r3 into account_ex10[r2];


function ex11:
    input r0 as u8.private;
    input r1 as u8.private;
    add r0 r1 into r2;
    output r2 as u8.public;


function ex12:
    input r0 as address.private;
    async ex12 r0 into r1;
    output r1 as infoleak0.aleo/ex12.future;

finalize ex12:
    input r0 as address.public;
    assert.eq true true;


function ex13:
    input r0 as address.private;
    async ex13 r0 into r1;
    output r1 as infoleak0.aleo/ex13.future;

finalize ex13:
    input r0 as address.public;
    assert.eq true true;


function ex14:
    input r0 as u8.private;
    cast r0 into r1 as u32;
    output r1 as u32.public;


function ex15:
    input r0 as u16.private;
    cast r0 into r1 as u8;
    output r1 as u8.public;


function ex16:
    input r0 as u8.private;
    is.eq r0 10u8 into r1;
    ternary r1 10u8 r0 into r2;
    output r2 as u8.public;


closure helper_ex17:
    input r0 as u8;
    add r0 0u8 into r1;
    output r1 as u8;


function ex17:
    input r0 as u8.private;
    call helper_ex17 r0 into r1;
    output r1 as u8.public;




function ex18:
    input r0 as u8.private;
    output r0 as u8.public;


function ex19:
    input r0 as struct_ex19.private;
    output r0.a as u8.public;


function ex20:
    input r0 as struct_ex20.private;
    add r0.a 8u8 into r1;
    cast r1 r0.b into r2 as struct_ex20;
    output r2.b as u8.public;


function ex21:
    input r0 as struct_ex21.private;
    add r0.a 8u8 into r1;
    cast r1 r0.b into r2 as struct_ex21;
    output r2 as struct_ex21.public;


function ex22:
    input r0 as struct_ex22_box.private;
    output r0.content as struct_ex22.public;


function ex23:
    input r0 as rec_ex23.record;
    output r0.data as u8.public;


function ex24:
    input r0 as rec_ex24.record;
    cast r0.owner r0.data into r1 as rec_ex24.record;
    output r1 as rec_ex24.record;
