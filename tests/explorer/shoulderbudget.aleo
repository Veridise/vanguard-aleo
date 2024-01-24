
program shoulderbudget.aleo;

function fast_sort:
    input r0 as u32.private;
    input r1 as u32.private;
    input r2 as u32.private;
    input r3 as u32.private;
    input r4 as u32.private;
    input r5 as u32.private;
    input r6 as u32.private;
    input r7 as u32.private;
    lt r1 r0 into r8;
    ternary r8 r1 r0 into r9;
    ternary r8 r0 r1 into r10;
    lt r2 r10 into r11;
    ternary r11 r2 r10 into r12;
    ternary r11 r10 r2 into r13;
    lt r3 r13 into r14;
    ternary r14 r3 r13 into r15;
    ternary r14 r13 r3 into r16;
    lt r4 r16 into r17;
    ternary r17 r4 r16 into r18;
    ternary r17 r16 r4 into r19;
    lt r5 r19 into r20;
    ternary r20 r5 r19 into r21;
    ternary r20 r19 r5 into r22;
    lt r6 r22 into r23;
    ternary r23 r6 r22 into r24;
    ternary r23 r22 r6 into r25;
    lt r7 r25 into r26;
    ternary r26 r7 r25 into r27;
    ternary r26 r25 r7 into r28;
    lt r12 r9 into r29;
    ternary r29 r12 r9 into r30;
    ternary r29 r9 r12 into r31;
    lt r15 r31 into r32;
    output r23 as boolean.private;
    output r32 as boolean.private;
    output r29 as boolean.private;
    output r26 as boolean.private;

struct DaughterRespond:
    first as u32;
    second as u32;
    third as u32;

function processstatus:
    input r0 as DaughterRespond.public;
    cast r0.first r0.second r0.third into r1 as DaughterRespond;
    output r1 as DaughterRespond.public;

function filterreport:
    input r0 as DaughterRespond.public;
    cast r0.first r0.second r0.third into r1 as DaughterRespond;
    output r1 as DaughterRespond.public;

function processgraph:
    input r0 as DaughterRespond.public;
    cast r0.first r0.second r0.third into r1 as DaughterRespond;
    output r1 as DaughterRespond.public;

function setdetails:
    input r0 as DaughterRespond.public;
    cast r0.first r0.second r0.third into r1 as DaughterRespond;
    output r1 as DaughterRespond.public;

function updategraph:
    input r0 as DaughterRespond.public;
    cast r0.first r0.second r0.third into r1 as DaughterRespond;
    output r1 as DaughterRespond.public;

function getinfo:
    input r0 as DaughterRespond.public;
    cast r0.first r0.second r0.third into r1 as DaughterRespond;
    output r1 as DaughterRespond.public;

