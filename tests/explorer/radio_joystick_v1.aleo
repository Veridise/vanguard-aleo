
program radio_joystick_v1.aleo;

function radio_joystick_v1:
    input r0 as u32.public;
    input r1 as u32.private;
    add r0 r1 into r2;
    output r2 as u32.private;

record JOY:
    owner as address.private;
    amount as u64.private;

record CASINO:
    owner as address.private;
    amount as u64.private;

