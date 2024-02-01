import finalize_fail_import.aleo;

program finalize_fail_testing_1.aleo;

function main:
    input r0 as u32.private;
    call finalize_fail_import.aleo/testing 1u32 r0 into r1;
    async main r0 into r2;
    output 1u32 as u32.private;
    output r2 as finalize_fail_testing_1.aleo/main.future;
finalize main:
    input r0 as u32.public;
    gt r0 1000u32 into r1;
    assert.eq r1 true;

