
program vvvzkmaleoaleo_v10.aleo;

record Token:
    owner as address.private;
    balance as u32.private;
    amount as u32.public;

function mint:
    input r0 as u32.private;
    rem r0 2u32 into r1;
    is.eq r1 0u32 into r2;
    assert.eq r2 true;
    cast self.caller r0 r0 into r3 as Token.record;
    output r3 as Token.record;

function burn:
    input r0 as Token.record;

function transfer:
    input r0 as address.private;
    input r1 as u32.private;
    input r2 as Token.record;
    sub r2.balance r1 into r3;
    cast r0 r1 r1 into r4 as Token.record;
    cast self.caller r3 r3 into r5 as Token.record;
    output r4 as Token.record;
    output r5 as Token.record;

