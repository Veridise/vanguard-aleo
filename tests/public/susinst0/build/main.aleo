program susinst0.aleo;



function vanguard_helper:
    cast  true true true into r0 as [boolean; 3u32];
    output r0 as [boolean; 3u32].private;


function ex0:
    assert.eq true true;


function ex1:
    add 123u8 0u8 into r0;
    output r0 as u8.private;


function ex2:
    mul 123u8 1u8 into r0;
    output r0 as u8.private;
