program hello.aleo;

struct StUnused1:
    a0 as u8;
    a1 as u8;


function main:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;


function ex_downcast0:
    cast 65530u16 into r0 as u8;
    output r0 as u8.private;


function ex_downcast1:
    cast 65530u16 into r0 as u8;
    output r0 as u8.private;


function ex_overflow0:
    add 255u8 255u8 into r0;
    output r0 as u8.private;


function ex_underflow0:
    sub 0u8 1u8 into r0;
    output r0 as u8.private;


function ex_underflow1:
    input r0 as u8.private;
    input r1 as u8.private;
    sub r0 r1 into r2;
    output r2 as u8.private;


function ex_unused0:
    output 255u8 as u8.private;


function ex_unused1:
    input r0 as StUnused1.public;
    output r0.a0 as u8.private;


function ex_divrd0:
    div 225u8 16u8 into r0;
    output r0 as u8.private;


function ex_divz0:
    div 225u8 0u8 into r0;
    output r0 as u8.private;


function ex_divz1:
    div 225u8 0u8 into r0;
    output r0 as u8.private;


function ex_divz2:
    input r0 as u8.private;
    div 255u8 r0 into r1;
    output r1 as u8.private;


function ex_divz3:
    div 255u8 0u8 into r0;
    output r0 as u8.private;


function ex_divz4:
    input r0 as u8.private;
    is.neq r0 0u8 into r1;
    assert.eq r1 true;
    div 255u8 r0 into r2;
    output r2 as u8.private;


function ex_rtcnst0:
    output 0u8 as u8.private;


function ex_leak0:
    input r0 as u8.public;
    output r0 as u8.public;


function ex_leak1:
    input r0 as u8.public;
    hash.keccak256 1u8 into r1 as address;
    output r1 as address.public;


function ex_leak2:
    input r0 as i8.public;
    abs r0 into r1;
    output r1 as i8.public;


function ex_leak3:
    input r0 as u8.public;
    add r0 3u8 into r1;
    output r1 as u8.public;


function ex_leak4:
    input r0 as u8.public;
    input r1 as u8.public;
    add r0 r1 into r2;
    output r2 as u8.public;
