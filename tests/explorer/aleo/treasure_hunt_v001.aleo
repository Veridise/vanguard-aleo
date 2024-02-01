program treasure_hunt_v001.aleo;

record Game:
    owner as address.private;
    challenger_commit as field.private;
    opponent_answer as field.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;
    game_multisig as address.private;
    game_state as field.private;

record GameReqNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;

record WaitingAcceptanceNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;

record StakeRenegedNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;
    renege_address as address.private;

record ChallengerWagerNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;

record OpponentWagerNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;

record WaitingRevealNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;

record RevealAnswerNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;
    opponent_answer as field.private;

record GameFinishReqNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;

record GameFinishedNotification:
    owner as address.private;
    game_multisig as address.private;
    game_state as field.private;
    your_turn as boolean.private;
    total_pot as u64.private;
    challenger_address as address.private;
    opponent_address as address.private;
    winner as address.private;
    loser as address.private;

record Piece:
    owner as address.private;
    amount as u64.private;
    ix as u32.private;

record AuditMint:
    owner as address.private;
    minter as address.private;
    amount as u64.private;
    ix as u32.private;

record AuditTransfer:
    owner as address.private;
    sender as address.private;
    receiver as address.private;
    amount as u64.private;
    ix as u32.private;

record PieceStake:
    owner as address.private;
    amount as u64.private;
    challenger as address.private;
    opponent as address.private;
    ix as u32.private;

record AuditStakeIn:
    owner as address.private;
    staker as address.private;
    amount_in as u64.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;
    ix as u32.private;

record AuditStakeOut:
    owner as address.private;
    staker as address.private;
    amount_in as u64.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;
    ix as u32.private;

record PieceClaim:
    owner as address.private;
    amount as u64.private;
    claimer as address.private;
    message_1 as field.private;
    message_2 as field.private;
    message_3 as field.private;
    message_4 as field.private;
    message_5 as field.private;
    challenger as address.private;
    opponent as address.private;
    ix as u32.private;

record ClaimSignature:
    owner as address.private;
    sig as signature.private;
    amount as u64.private;
    game_multisig as address.private;
    challenger as address.private;
    opponent as address.private;
    ix as u32.private;

record JointPieceTimeClaim:
    owner as address.private;
    amount as u64.private;
    time_claimer_address as address.private;
    state_updater_address as address.private;
    message_1 as field.private;
    message_2 as field.private;
    message_3 as field.private;
    message_4 as field.private;
    message_5 as field.private;
    game_multisig as address.private;
    challenger as address.private;
    opponent as address.private;
    block_ht as u32.private;
    ix as u32.private;

record PieceJointStake:
    owner as address.private;
    amount as u64.private;
    time_claimer_address as address.private;
    state_updater_address as address.private;
    block_ht as u32.private;
    ix as u32.private;

record JointPieceState:
    owner as address.private;
    amount as u64.private;
    time_claimer_address as address.private;
    state_updater_address as address.private;
    message_1 as field.private;
    message_2 as field.private;
    message_3 as field.private;
    message_4 as field.private;
    message_5 as field.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;
    ix as u32.private;

record AuditJointStake:
    owner as address.private;
    amount as u64.private;
    time_claimer_address as address.private;
    state_updater_address as address.private;
    block_ht as u32.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;
    ix as u32.private;

record JointPieceWinner:
    owner as address.private;
    amount as u64.private;
    time_claimer_address as address.private;
    state_updater_address as address.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;
    winner as address.private;
    ix as u32.private;

record AuditJointPieceWinner:
    owner as address.private;
    amount as u64.private;
    time_claimer_address as address.private;
    state_updater_address as address.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;
    winner as address.private;
    ix as u32.private;

record AuditTransferToWinner:
    owner as address.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;
    receiver as address.private;
    amount as u64.private;
    ix as u32.private;

record AuditPieceOwner:
    owner as address.private;
    piece_holder as address.private;
    amount as u64.private;
    ix as u32.private;

struct Message:
    field_1 as field;
    field_2 as field;
    field_3 as field;
    field_4 as field;
    field_5 as field;

record Answer:
    owner as address.private;
    challenger_address as address.private;
    opponent_address as address.private;
    game_multisig as address.private;
    amount as u64.private;
    nonce as field.private;
    answer as field.private;
    message_1 as field.private;
    message_2 as field.private;
    message_3 as field.private;
    message_4 as field.private;
    message_5 as field.private;

record AuditMintAnswer:
    owner as address.private;
    answer_owner as address.private;
    challenger_address as address.private;
    opponent_address as address.private;
    game_multisig as address.private;
    amount as u64.private;
    nonce as field.private;
    answer as field.private;
    message_1 as field.private;
    message_2 as field.private;
    message_3 as field.private;
    message_4 as field.private;
    message_5 as field.private;

record RevealAnswer:
    owner as address.private;
    challenger_address as address.private;
    opponent_address as address.private;
    game_multisig as address.private;
    amount as u64.private;
    nonce as field.private;
    answer as field.private;
    sig as signature.private;

record AuditRevealAnswer:
    owner as address.private;
    challenger_address as address.private;
    opponent_address as address.private;
    game_multisig as address.private;
    amount as u64.private;
    nonce as field.private;
    answer as field.private;
    sig as signature.private;

record Key:
    owner as address.private;
    seed as field.private;
    amount as u64.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;

record AuditKey:
    owner as address.private;
    seed as field.private;
    amount as u64.private;
    challenger as address.private;
    opponent as address.private;
    game_multisig as address.private;

function propose_game:
    input r0 as Piece.record;
    input r1 as u64.private;
    input r2 as address.private;
    input r3 as address.private;
    input r4 as address.private;
    input r5 as address.private;
    input r6 as field.private;
    input r7 as field.private;
    input r8 as field.private;
    input r9 as field.private;
    input r10 as field.private;
    input r11 as signature.private;
    input r12 as field.private;
    input r13 as field.private;
    input r14 as field.private;
    assert.eq self.caller self.signer ;
    assert.neq r5 r4 ;
    assert.neq r3 r4 ;
    is.eq r13 0field into r15;
    is.eq r13 1field into r16;
    or r15 r16 into r17;
    assert.eq r17 true ;
    cast r12 into r18 as scalar;
    commit.bhp256 r13 r18 into r19 as field;
    gt r1 0u64 into r20;
    assert.eq r20 true ;
    gte r0.amount r1 into r21;
    assert.eq r21 true ;
    assert.eq r0.owner self.signer ;
    cast r5 r1 r2 r6 r7 r8 r9 r10 r3 r4 6u32 into r22 as PieceClaim.record;
    cast r2 r11 r1 r5 r3 r4 7u32 into r23 as ClaimSignature.record;
    cast r5 r1 r3 r4 3u32 into r24 as PieceStake.record;
    sub r0.amount r1 into r25;
    cast r2 r25 0u32 into r26 as Piece.record;
    cast aleo16hf8hfpwasnn9cf7k2c0dllc56nn7qt547qxgvgwu6pznw4trvqsx68kls r0.owner r1 r3 r4 r5 4u32 into r27 as AuditStakeIn.record;
    cast r4 r14 r1 r3 r4 r5 into r28 as Key.record;
    cast aleo16hf8hfpwasnn9cf7k2c0dllc56nn7qt547qxgvgwu6pznw4trvqsx68kls r14 r1 r3 r4 r5 into r29 as AuditKey.record;
    cast r6 r7 r8 r9 r10 into r30 as Message;
    sign.verify r11 r3 r30 into r31;
    assert.eq true r31 ;
    cast r3 r3 r4 r5 r1 r12 r13 r6 r7 r8 r9 r10 into r32 as Answer.record;
    cast aleo16hf8hfpwasnn9cf7k2c0dllc56nn7qt547qxgvgwu6pznw4trvqsx68kls r3 r3 r4 r5 r1 r12 r13 r6 r7 r8 r9 r10 into r33 as AuditMintAnswer.record;
    add r1 r1 into r34;
    cast r4 r5 1field true r34 r3 r4 into r35 as GameReqNotification.record;
    add r1 r1 into r36;
    cast r3 r5 1field false r36 r3 r4 into r37 as WaitingAcceptanceNotification.record;
    add r1 r1 into r38;
    cast r5 r19 123field r38 r3 r4 r5 1field into r39 as Game.record;
    output r22 as PieceClaim.record;
    output r24 as PieceStake.record;
    output r23 as ClaimSignature.record;
    output r26 as Piece.record;
    output r27 as AuditStakeIn.record;
    output r32 as Answer.record;
    output r33 as AuditMintAnswer.record;
    output r28 as Key.record;
    output r29 as AuditKey.record;
    output r39 as Game.record;
    output r35 as GameReqNotification.record;
    output r37 as WaitingAcceptanceNotification.record;

function submit_wager:
    input r0 as Piece.record;
    input r1 as Key.record;
    input r2 as GameReqNotification.record;
    input r3 as field.private;
    input r4 as field.private;
    input r5 as field.private;
    input r6 as field.private;
    input r7 as field.private;
    input r8 as signature.private;
    assert.eq self.caller self.signer ;
    gt r0.amount 0u64 into r9;
    assert.eq r9 true ;
    div r2.total_pot 2u64 into r10;
    gte r0.amount r10 into r11;
    assert.eq r11 true ;
    div r2.total_pot 2u64 into r12;
    cast r2.game_multisig r12 self.signer r3 r4 r5 r6 r7 r2.challenger_address r2.opponent_address 6u32 into r13 as PieceClaim.record;
    cast self.signer r8 r12 r2.game_multisig r2.challenger_address r2.opponent_address 7u32 into r14 as ClaimSignature.record;
    cast r2.game_multisig r12 r2.challenger_address r2.opponent_address 3u32 into r15 as PieceStake.record;
    sub r0.amount r12 into r16;
    cast self.signer r16 0u32 into r17 as Piece.record;
    cast aleo16hf8hfpwasnn9cf7k2c0dllc56nn7qt547qxgvgwu6pznw4trvqsx68kls r0.owner r12 r2.challenger_address r2.opponent_address r2.game_multisig 4u32 into r18 as AuditStakeIn.record;
    cast r2.challenger_address r2.game_multisig 2field false r2.total_pot r2.challenger_address r2.opponent_address into r19 as ChallengerWagerNotification.record;
    cast r2.opponent_address r2.game_multisig 2field true r2.total_pot r2.challenger_address r2.opponent_address into r20 as OpponentWagerNotification.record;
    output r13 as PieceClaim.record;
    output r15 as PieceStake.record;
    output r14 as ClaimSignature.record;
    output r17 as Piece.record;
    output r18 as AuditStakeIn.record;
    output r19 as ChallengerWagerNotification.record;
    output r20 as OpponentWagerNotification.record;

function accept_game:
    input r0 as Game.record;
    input r1 as field.private;
    input r2 as PieceStake.record;
    input r3 as PieceClaim.record;
    input r4 as PieceStake.record;
    input r5 as PieceClaim.record;
    input r6 as u32.private;
    assert.eq r0.owner self.signer ;
    assert.eq self.caller self.signer ;
    is.eq r1 0field into r7;
    is.eq r1 1field into r8;
    or r7 r8 into r9;
    assert.eq r9 true ;
    assert.eq r3.owner r2.owner ;
    assert.eq r4.owner r2.owner ;
    assert.eq r5.owner r2.owner ;
    assert.eq r3.amount r2.amount ;
    assert.eq r4.amount r2.amount ;
    assert.eq r5.amount r2.amount ;
    assert.eq r3.challenger r2.challenger ;
    assert.eq r4.challenger r2.challenger ;
    assert.eq r5.challenger r2.challenger ;
    assert.eq r3.opponent r2.opponent ;
    assert.eq r4.opponent r2.opponent ;
    assert.eq r5.opponent r2.opponent ;
    assert.eq r3.claimer r2.challenger ;
    assert.eq r5.claimer r4.opponent ;
    cast r2.owner r0.total_pot r2.opponent r2.challenger r6 9u32 into r10 as PieceJointStake.record;
    cast r2.owner r0.total_pot r2.opponent r2.challenger r5.message_1 r5.message_2 r5.message_3 r5.message_4 r5.message_5 r2.owner r2.challenger r2.opponent r6 8u32 into r11 as JointPieceTimeClaim.record;
    cast r2.challenger r0.total_pot r2.opponent r2.challenger r3.message_1 r3.message_2 r3.message_3 r3.message_4 r3.message_5 r2.challenger r2.opponent r2.owner 10u32 into r12 as JointPieceState.record;
    cast r2.opponent r0.total_pot r2.opponent r2.challenger r6 r2.challenger r2.opponent r2.owner 11u32 into r13 as AuditJointStake.record;
    cast r0.opponent_address r0.owner 3field false r0.total_pot r0.challenger_address r0.opponent_address into r14 as WaitingRevealNotification.record;
    cast r0.challenger_address r0.owner 3field true r0.total_pot r0.challenger_address r0.opponent_address r1 into r15 as RevealAnswerNotification.record;
    cast r0.owner r0.challenger_commit r1 r0.total_pot r0.challenger_address r0.opponent_address r0.game_multisig 3field into r16 as Game.record;
    async accept_game r6 into r17;
    output r10 as PieceJointStake.record;
    output r11 as JointPieceTimeClaim.record;
    output r12 as JointPieceState.record;
    output r13 as AuditJointStake.record;
    output r14 as WaitingRevealNotification.record;
    output r15 as RevealAnswerNotification.record;
    output r16 as Game.record;
    output r17 as treasure_hunt_v001.aleo/accept_game.future;

finalize accept_game:
    input r0 as u32.public;
    sub block.height 100u32 into r1;
    gte r0 r1 into r2;
    assert.eq r2 true ;
    add block.height 100u32 into r3;
    lte r0 r3 into r4;
    assert.eq r4 true ;

function reveal_answer_game:
    input r0 as RevealAnswerNotification.record;
    input r1 as Answer.record;
    input r2 as JointPieceState.record;
    input r3 as ClaimSignature.record;
    assert.eq r2.state_updater_address self.signer ;
    assert.eq self.caller self.signer ;
    is.eq r0.opponent_answer r1.answer into r4;
    ternary r4 r1.opponent_address r1.challenger_address into r5;
    assert.eq r1.owner r1.challenger_address ;
    cast r1.message_1 r1.message_2 r1.message_3 r1.message_4 r1.message_5 into r6 as Message;
    sign.verify r3.sig r1.challenger_address r6 into r7;
    assert.eq true r7 ;
    cast r1.game_multisig r1.challenger_address r1.opponent_address r1.game_multisig r1.amount r1.nonce r1.answer r3.sig into r8 as RevealAnswer.record;
    cast aleo16hf8hfpwasnn9cf7k2c0dllc56nn7qt547qxgvgwu6pznw4trvqsx68kls r1.challenger_address r1.opponent_address r1.game_multisig r1.amount r1.nonce r1.answer r3.sig into r9 as AuditRevealAnswer.record;
    assert.eq r2.owner r3.owner ;
    assert.eq r2.state_updater_address r3.owner ;
    assert.eq r2.state_updater_address r3.challenger ;
    add r3.amount r3.amount into r10;
    assert.eq r2.amount r10 ;
    assert.eq r2.opponent r3.opponent ;
    assert.eq r2.game_multisig r2.game_multisig ;
    cast r2.message_1 r2.message_2 r2.message_3 r2.message_4 r2.message_5 into r11 as Message;
    sign.verify r3.sig r2.state_updater_address r11 into r12;
    assert.eq true r12 ;
    is.eq r5 r2.challenger into r13;
    not r13 into r14;
    is.eq r5 r2.challenger into r15;
    or r14 r15 into r16;
    assert.eq r16 true ;
    not r13 into r17;
    not r17 into r18;
    is.eq r5 r2.opponent into r19;
    or r18 r19 into r20;
    assert.eq r20 true ;
    cast r2.game_multisig r2.amount r2.time_claimer_address r2.state_updater_address r2.challenger r2.opponent r2.game_multisig r5 12u32 into r21 as JointPieceWinner.record;
    cast r2.game_multisig r2.amount r2.time_claimer_address r2.state_updater_address r2.challenger r2.opponent r2.game_multisig r5 13u32 into r22 as AuditJointPieceWinner.record;
    cast r1.opponent_address r1.game_multisig 4field true r2.amount r1.challenger_address r1.opponent_address into r23 as GameFinishReqNotification.record;
    cast r1.challenger_address r1.game_multisig 4field true r2.amount r1.challenger_address r1.opponent_address into r24 as GameFinishReqNotification.record;
    output r8 as RevealAnswer.record;
    output r9 as AuditRevealAnswer.record;
    output r21 as JointPieceWinner.record;
    output r22 as AuditJointPieceWinner.record;
    output r23 as GameFinishReqNotification.record;
    output r24 as GameFinishReqNotification.record;

function finish_game:
    input r0 as Game.record;
    input r1 as JointPieceWinner.record;
    input r2 as PieceJointStake.record;
    input r3 as JointPieceTimeClaim.record;
    assert.eq r0.owner self.signer ;
    assert.eq self.caller self.signer ;
    is.eq r1.winner r0.challenger_address into r4;
    ternary r4 r0.opponent_address r0.challenger_address into r5;
    assert.eq r2.owner r1.owner ;
    assert.eq r3.owner r1.owner ;
    assert.eq r2.amount r1.amount ;
    assert.eq r3.amount r1.amount ;
    assert.eq r2.state_updater_address r1.challenger ;
    assert.eq r3.challenger r1.challenger ;
    assert.eq r2.time_claimer_address r1.opponent ;
    assert.eq r3.opponent r1.opponent ;
    is.eq r1.winner r2.time_claimer_address into r6;
    not r6 into r7;
    is.eq r1.winner r2.time_claimer_address into r8;
    or r7 r8 into r9;
    assert.eq r9 true ;
    not r6 into r10;
    not r10 into r11;
    is.eq r1.winner r2.state_updater_address into r12;
    or r11 r12 into r13;
    assert.eq r13 true ;
    cast r1.winner r1.amount 0u32 into r14 as Piece.record;
    cast aleo16hf8hfpwasnn9cf7k2c0dllc56nn7qt547qxgvgwu6pznw4trvqsx68kls r1.challenger r1.opponent r1.owner r1.winner r1.amount 14u32 into r15 as AuditTransferToWinner.record;
    cast aleo16hf8hfpwasnn9cf7k2c0dllc56nn7qt547qxgvgwu6pznw4trvqsx68kls r1.winner r1.amount 15u32 into r16 as AuditPieceOwner.record;
    cast r0.owner r0.challenger_commit r0.opponent_answer r0.total_pot r0.challenger_address r0.opponent_address r0.game_multisig 3field into r17 as Game.record;
    cast r0.challenger_address r0.game_multisig 5field false r0.total_pot r0.challenger_address r0.opponent_address r1.winner r5 into r18 as GameFinishedNotification.record;
    cast r0.opponent_address r0.game_multisig 5field false r0.total_pot r0.challenger_address r0.opponent_address r1.winner r5 into r19 as GameFinishedNotification.record;
    output r14 as Piece.record;
    output r15 as AuditTransferToWinner.record;
    output r16 as AuditPieceOwner.record;
    output r17 as Game.record;
    output r18 as GameFinishedNotification.record;
    output r19 as GameFinishedNotification.record;

function finish_game_by_timeout:
    input r0 as Game.record;
    input r1 as PieceJointStake.record;
    input r2 as JointPieceTimeClaim.record;
    input r3 as signature.private;
    assert.eq r0.owner self.signer ;
    assert.eq self.caller self.signer ;
    cast r0.owner r0.challenger_commit r0.opponent_answer r0.total_pot r0.challenger_address r0.opponent_address r0.game_multisig 3field into r4 as Game.record;
    cast r0.challenger_address r0.game_multisig 6field false r0.total_pot r0.challenger_address r0.opponent_address r0.opponent_address r0.challenger_address into r5 as GameFinishedNotification.record;
    cast r0.opponent_address r0.game_multisig 6field false r0.total_pot r0.challenger_address r0.opponent_address r0.opponent_address r0.challenger_address into r6 as GameFinishedNotification.record;
    assert.eq r1.owner r2.owner ;
    assert.eq r1.amount r2.amount ;
    assert.eq r1.state_updater_address r2.challenger ;
    assert.eq r1.time_claimer_address r2.opponent ;
    cast r2.message_1 r2.message_2 r2.message_3 r2.message_4 r2.message_5 into r7 as Message;
    sign.verify r3 r2.time_claimer_address r7 into r8;
    assert.eq true r8 ;
    cast r2.opponent r2.amount 0u32 into r9 as Piece.record;
    cast aleo16hf8hfpwasnn9cf7k2c0dllc56nn7qt547qxgvgwu6pznw4trvqsx68kls r2.challenger r2.opponent r2.owner r2.opponent r2.amount 14u32 into r10 as AuditTransferToWinner.record;
    async finish_game_by_timeout r2.block_ht into r11;
    output r9 as Piece.record;
    output r10 as AuditTransferToWinner.record;
    output r4 as Game.record;
    output r5 as GameFinishedNotification.record;
    output r6 as GameFinishedNotification.record;
    output r11 as treasure_hunt_v001.aleo/finish_game_by_timeout.future;

finalize finish_game_by_timeout:
    input r0 as u32.public;
    add r0 1000u32 into r1;
    gt block.height r1 into r2;
    assert.eq r2 true ;
