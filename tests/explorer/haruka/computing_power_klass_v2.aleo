import hello_16ng0h4td.aleo;

program computing_power_klass_v2.aleo;

record Output:
    owner as address.private;
    result as u32.private;

function test_add:
    input r0 as u32.public;
    input r1 as u32.private;
    call hello_16ng0h4td.aleo/main r0 r1 into r2;
    cast self.caller r2 into r3 as Output.record;
    output r3 as Output.record;

