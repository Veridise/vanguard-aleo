
program issuer_verifier_zpass_test1.aleo;

struct Credentials:
    issuer as address;
    leaves_hashes as [field; 8u32];
    expiration as u32;

record SignedCredential:
    owner as address.private;
    issuer as address.private;
    root_hash as field.private;
    leaves_hashes as [field; 8u32].private;
    expiration as u32.private;

struct DateTime:
    seconds as u8;
    minutes as u8;
    hours as u8;
    day as u8;
    month as u32;
    year as u32;

closure get_algo:
    input r0 as field;
    input r1 as field;
    hash.psd4 r0 into r2 as field;
    is.eq r2 r1 into r3;
    output r3 as boolean;

closure get_merkle_tree:
    input r0 as [field; 8u32];
    input r1 as boolean;
    add r0[0] r0[1] into r2;
    hash.psd2 r2 into r3 as field;
    hash.bhp512 r2 into r4 as field;
    ternary r1 r3 r4 into r5;
    add r0[2] r0[3] into r6;
    hash.psd2 r6 into r7 as field;
    hash.bhp512 r6 into r8 as field;
    ternary r1 r7 r8 into r9;
    add r0[4] r0[5] into r10;
    hash.psd2 r10 into r11 as field;
    hash.bhp512 r10 into r12 as field;
    ternary r1 r11 r12 into r13;
    add r0[6] r0[7] into r14;
    hash.psd2 r14 into r15 as field;
    hash.bhp512 r14 into r16 as field;
    ternary r1 r15 r16 into r17;
    cast r5 r9 r13 r17 into r18 as [field; 4u32];
    add r18[0] r18[1] into r19;
    hash.psd2 r19 into r20 as field;
    hash.bhp512 r19 into r21 as field;
    ternary r1 r20 r21 into r22;
    add r18[2] r18[3] into r23;
    hash.psd2 r23 into r24 as field;
    hash.bhp512 r23 into r25 as field;
    ternary r1 r24 r25 into r26;
    cast r22 r26 into r27 as [field; 2u32];
    add r27[0] r27[1] into r28;
    hash.psd2 r28 into r29 as field;
    hash.bhp512 r28 into r30 as field;
    ternary r1 r29 r30 into r31;
    output r31 as field;
    output r27 as [field; 2u32];
    output r18 as [field; 4u32];

closure signature_verification:
    input r0 as field;
    input r1 as signature;
    input r2 as address;
    sign_verify r1 r2 r0 into r3;
    output r3 as boolean;

function issue:
    input r0 as signature.private;
    input r1 as Credentials.private;
    cast self.caller into r2 as field;
    call get_algo r2 r1.leaves_hashes[0] into r3;
    cast self.caller into r4 as field;
    hash.psd4 r4 into r5 as field;
    hash.bhp1024 r4 into r6 as field;
    ternary r3 r5 r6 into r7;
    assert.eq r7 r1.leaves_hashes[0];
    cast r1.expiration into r8 as field;
    hash.psd4 r8 into r9 as field;
    hash.bhp1024 r8 into r10 as field;
    ternary r3 r9 r10 into r11;
    assert.eq r11 r1.leaves_hashes[3];
    call get_merkle_tree r1.leaves_hashes r3 into r12 r13 r14;
    call signature_verification r12 r0 r1.issuer into r15;
    assert.eq r15 true;
    cast self.caller r1.issuer r12 r1.leaves_hashes r1.expiration into r16 as SignedCredential.record;
    output r16 as SignedCredential.record;

closure generate_proof_path:
    input r0 as u8;
    xor r0 1u8 into r1;
    rem r1 2u8 into r2;
    is.neq r2 0u8 into r3;
    pow 2u8 1u8 into r4;
    div r0 r4 into r5;
    xor r5 1u8 into r6;
    rem r6 2u8 into r7;
    is.neq r7 0u8 into r8;
    pow 2u8 2u8 into r9;
    div r0 r9 into r10;
    xor r10 1u8 into r11;
    rem r11 2u8 into r12;
    is.neq r12 0u8 into r13;
    cast r3 r8 r13 into r14 as [boolean; 3u32];
    output r14 as [boolean; 3u32];

closure verify_proof:
    input r0 as field;
    input r1 as [field; 3u32];
    input r2 as [boolean; 3u32];
    input r3 as field;
    input r4 as boolean;
    hash.psd4 r0 into r5 as field;
    hash.bhp1024 r0 into r6 as field;
    ternary r4 r5 r6 into r7;
    add r7 r1[0] into r8;
    hash.psd2 r8 into r9 as field;
    hash.bhp512 r8 into r10 as field;
    ternary r4 r9 r10 into r11;
    add r1[0] r7 into r12;
    hash.psd2 r12 into r13 as field;
    hash.bhp512 r12 into r14 as field;
    ternary r4 r13 r14 into r15;
    ternary r2[0] r11 r15 into r16;
    add r16 r1[1] into r17;
    hash.psd2 r17 into r18 as field;
    hash.bhp512 r17 into r19 as field;
    ternary r4 r18 r19 into r20;
    add r1[1] r16 into r21;
    hash.psd2 r21 into r22 as field;
    hash.bhp512 r21 into r23 as field;
    ternary r4 r22 r23 into r24;
    ternary r2[1] r20 r24 into r25;
    add r25 r1[2] into r26;
    hash.psd2 r26 into r27 as field;
    hash.bhp512 r26 into r28 as field;
    ternary r4 r27 r28 into r29;
    add r1[2] r25 into r30;
    hash.psd2 r30 into r31 as field;
    hash.bhp512 r30 into r32 as field;
    ternary r4 r31 r32 into r33;
    ternary r2[2] r29 r33 into r34;
    is.eq r34 r3 into r35;
    output r35 as boolean;

function verify_dob:
    input r0 as SignedCredential.record;
    input r1 as address.private;
    input r2 as u32.private;
    input r3 as u32.private;
    input r4 as boolean.private;
    assert.eq self.caller r0.owner;
    assert.eq r1 r0.owner;
    call get_merkle_tree r0.leaves_hashes r4 into r5 r6 r7;
    call generate_proof_path 1u8 into r8;
    call generate_proof_path 0u8 into r9;
    cast r2 into r10 as field;
    cast r0.leaves_hashes[0] r7[1] r6[1] into r11 as [field; 3u32];
    call verify_proof r10 r11 r8 r5 r4 into r12;
    assert.eq r12 true;
    cast r1 into r13 as field;
    cast r0.leaves_hashes[1] r7[1] r6[1] into r14 as [field; 3u32];
    call verify_proof r13 r14 r9 r5 r4 into r15;
    assert.eq r15 true;
    gte r0.expiration r3 into r16;
    output r16 as boolean.private;

function verify_nationality:
    input r0 as SignedCredential.record;
    input r1 as address.private;
    input r2 as field.private;
    input r3 as u32.private;
    input r4 as boolean.private;
    assert.eq self.caller r0.owner;
    assert.eq r1 r0.owner;
    call get_merkle_tree r0.leaves_hashes r4 into r5 r6 r7;
    call generate_proof_path 2u8 into r8;
    call generate_proof_path 0u8 into r9;
    cast r0.leaves_hashes[3] r7[0] r6[1] into r10 as [field; 3u32];
    call verify_proof r2 r10 r8 r5 r4 into r11;
    assert.eq r11 true;
    cast r1 into r12 as field;
    cast r0.leaves_hashes[1] r7[1] r6[1] into r13 as [field; 3u32];
    call verify_proof r12 r13 r9 r5 r4 into r14;
    assert.eq r14 true;
    gte r0.expiration r3 into r15;
    output r15 as boolean.private;

closure timestamp_to_datetime:
    input r0 as u32;
    rem r0 60u32 into r1;
    div r0 60u32 into r2;
    rem r2 60u32 into r3;
    div r2 60u32 into r4;
    rem r4 24u32 into r5;
    div r4 24u32 into r6;
    mul 4u32 r6 into r7;
    add r7 102032u32 into r8;
    div r8 146097u32 into r9;
    add r9 15u32 into r10;
    add r6 2442113u32 into r11;
    add r11 r10 into r12;
    div r10 4u32 into r13;
    sub r12 r13 into r14;
    mul 20u32 r14 into r15;
    sub r15 2442u32 into r16;
    div r16 7305u32 into r17;
    mul 365u32 r17 into r18;
    sub r14 r18 into r19;
    div r17 4u32 into r20;
    sub r19 r20 into r21;
    mul r21 1000u32 into r22;
    div r22 30601u32 into r23;
    mul r23 30u32 into r24;
    sub r21 r24 into r25;
    mul r23 601u32 into r26;
    div r26 1000u32 into r27;
    sub r25 r27 into r28;
    gt r23 13u32 into r29;
    ternary r29 4715u32 4716u32 into r30;
    ternary r29 13u32 1u32 into r31;
    sub r17 r30 into r32;
    sub r23 r31 into r33;
    cast r1 into r34 as u8;
    cast r3 into r35 as u8;
    cast r5 into r36 as u8;
    cast r28 into r37 as u8;
    cast r33 into r38 as u32;
    cast r32 into r39 as u32;
    cast r34 r35 r36 r37 r38 r39 into r40 as DateTime;
    output r40 as DateTime;

function verify_age_condition:
    input r0 as SignedCredential.record;
    input r1 as u32.private;
    input r2 as u32.private;
    input r3 as u32.private;
    input r4 as u8.private;
    input r5 as boolean.private;
    assert.eq self.caller r0.owner;
    call get_merkle_tree r0.leaves_hashes r5 into r6 r7 r8;
    call generate_proof_path 1u8 into r9;
    cast r1 into r10 as field;
    cast r0.leaves_hashes[0] r8[1] r7[1] into r11 as [field; 3u32];
    call verify_proof r10 r11 r9 r6 r5 into r12;
    assert.eq r12 true;
    call timestamp_to_datetime r1 into r13;
    call timestamp_to_datetime r3 into r14;
    sub r14.year r13.year into r15;
    is.eq r4 0u8 into r16;
    gte r15 r2 into r17;
    is.eq r4 1u8 into r18;
    gt r15 r2 into r19;
    is.eq r4 2u8 into r20;
    lte r15 r2 into r21;
    is.eq r4 3u8 into r22;
    lt r15 r2 into r23;
    is.eq r15 r2 into r24;
    not r16 into r25;
    not r18 into r26;
    and r25 r26 into r27;
    not r20 into r28;
    and r27 r28 into r29;
    and r29 r22 into r30;
    ternary r30 r23 r24 into r31;
    not r16 into r32;
    not r18 into r33;
    and r32 r33 into r34;
    and r34 r20 into r35;
    ternary r35 r21 r31 into r36;
    not r16 into r37;
    and r37 r18 into r38;
    ternary r38 r19 r36 into r39;
    ternary r16 r17 r39 into r40;
    output r40 as boolean.private;

