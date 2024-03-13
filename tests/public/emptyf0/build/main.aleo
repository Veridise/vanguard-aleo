program emptyf0.aleo;



function vanguard_helper:
    cast  true into r0 as [boolean; 1u32];
    output r0 as [boolean; 1u32].private;


function ex0:


function ex1:
    async ex1 into r0;
    output 9u8 as u8.private;
    output r0 as emptyf0.aleo/ex1.future;

finalize ex1:
    assert.eq true true;
