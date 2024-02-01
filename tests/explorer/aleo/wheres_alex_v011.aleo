import puzzle_pieces_v011.aleo;
import multiparty_pvp_utils_v011.aleo;

program wheres_alex_v011.aleo;

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

function propose_game:
    input r0 as puzzle_pieces_v011.aleo/Piece.record;
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
    assert.neq r5 r4 ;
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
    call puzzle_pieces_v011.aleo/stake_transfer_in r0 r2 r3 r4 r5 r1 r6 r7 r8 r9 r10 r11 into r22 r23 r24 r25 r26;
    call multiparty_pvp_utils_v011.aleo/mint_multisig_key r14 r1 r3 r4 r5 into r27 r28;
    add r1 r1 into r29;
    cast r4 r5 1field true r29 r3 r4 into r30 as GameReqNotification.record;
    add r1 r1 into r31;
    cast r3 r5 1field false r31 r3 r4 into r32 as WaitingAcceptanceNotification.record;
    add r1 r1 into r33;
    cast r5 r19 r13 r33 r3 r4 r5 1field into r34 as Game.record;
    call multiparty_pvp_utils_v011.aleo/mint_answer r3 r4 r5 r1 r12 r13 r6 r7 r8 r9 r10 r11 into r35 r36;
    output r22 as puzzle_pieces_v011.aleo/PieceClaim.record;
    output r23 as puzzle_pieces_v011.aleo/PieceStake.record;
    output r24 as puzzle_pieces_v011.aleo/ClaimSignature.record;
    output r25 as puzzle_pieces_v011.aleo/Piece.record;
    output r26 as puzzle_pieces_v011.aleo/AuditStakeIn.record;
    output r35 as multiparty_pvp_utils_v011.aleo/Answer.record;
    output r36 as multiparty_pvp_utils_v011.aleo/AuditMintAnswer.record;
    output r27 as multiparty_pvp_utils_v011.aleo/Key.record;
    output r28 as multiparty_pvp_utils_v011.aleo/AuditKey.record;
    output r34 as Game.record;
    output r30 as GameReqNotification.record;
    output r32 as WaitingAcceptanceNotification.record;

function challenger_renege_stake:
    input r0 as WaitingAcceptanceNotification.record;
    input r1 as puzzle_pieces_v011.aleo/PieceStake.record;
    input r2 as puzzle_pieces_v011.aleo/PieceClaim.record;
    input r3 as signature.private;
    call puzzle_pieces_v011.aleo/stake_transfer_out r1 r2 r3 into r4 r5;
    cast r0.challenger_address r0.game_multisig 0field false r0.total_pot r0.challenger_address r0.opponent_address r0.challenger_address into r6 as StakeRenegedNotification.record;
    cast r0.opponent_address r0.game_multisig 0field false r0.total_pot r0.challenger_address r0.opponent_address r0.challenger_address into r7 as StakeRenegedNotification.record;
    output r4 as puzzle_pieces_v011.aleo/Piece.record;
    output r5 as puzzle_pieces_v011.aleo/AuditStakeOut.record;
    output r6 as StakeRenegedNotification.record;
    output r7 as StakeRenegedNotification.record;

function submit_wager:
    input r0 as puzzle_pieces_v011.aleo/Piece.record;
    input r1 as multiparty_pvp_utils_v011.aleo/Key.record;
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
    call puzzle_pieces_v011.aleo/stake_transfer_in r0 r2.opponent_address r2.challenger_address r2.opponent_address r2.game_multisig r12 r3 r4 r5 r6 r7 r8 into r13 r14 r15 r16 r17;
    cast r2.challenger_address r2.game_multisig 2field false r2.total_pot r2.challenger_address r2.opponent_address into r18 as ChallengerWagerNotification.record;
    cast r2.opponent_address r2.game_multisig 2field true r2.total_pot r2.challenger_address r2.opponent_address into r19 as OpponentWagerNotification.record;
    output r13 as puzzle_pieces_v011.aleo/PieceClaim.record;
    output r14 as puzzle_pieces_v011.aleo/PieceStake.record;
    output r15 as puzzle_pieces_v011.aleo/ClaimSignature.record;
    output r16 as puzzle_pieces_v011.aleo/Piece.record;
    output r17 as puzzle_pieces_v011.aleo/AuditStakeIn.record;
    output r18 as ChallengerWagerNotification.record;
    output r19 as OpponentWagerNotification.record;

function accept_game:
    input r0 as Game.record;
    input r1 as field.private;
    input r2 as puzzle_pieces_v011.aleo/PieceStake.record;
    input r3 as puzzle_pieces_v011.aleo/PieceClaim.record;
    input r4 as puzzle_pieces_v011.aleo/PieceStake.record;
    input r5 as puzzle_pieces_v011.aleo/PieceClaim.record;
    input r6 as u32.private;
    call puzzle_pieces_v011.aleo/transfer_stakes_to_joint r2 r3 r4 r5 r6 into r7 r8 r9 r10;
    cast r0.opponent_address r0.owner 3field false r0.total_pot r0.challenger_address r0.opponent_address into r11 as WaitingRevealNotification.record;
    cast r0.challenger_address r0.owner 3field true r0.total_pot r0.challenger_address r0.opponent_address r1 into r12 as RevealAnswerNotification.record;
    cast r0.owner r0.challenger_commit r0.opponent_answer r0.total_pot r0.challenger_address r0.opponent_address r0.game_multisig 2field into r13 as Game.record;
    async accept_game r6 into r14;
    output r7 as puzzle_pieces_v011.aleo/PieceJointStake.record;
    output r8 as puzzle_pieces_v011.aleo/JointPieceTimeClaim.record;
    output r9 as puzzle_pieces_v011.aleo/JointPieceState.record;
    output r10 as puzzle_pieces_v011.aleo/AuditJointStake.record;
    output r11 as WaitingRevealNotification.record;
    output r12 as RevealAnswerNotification.record;
    output r13 as Game.record;
    output r14 as wheres_alex_v011.aleo/accept_game.future;

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
    input r1 as multiparty_pvp_utils_v011.aleo/Answer.record;
    input r2 as puzzle_pieces_v011.aleo/JointPieceState.record;
    input r3 as puzzle_pieces_v011.aleo/ClaimSignature.record;
    assert.eq r2.state_updater_address self.signer ;
    is.eq r0.opponent_answer r1.answer into r4;
    ternary r4 r1.opponent_address r1.challenger_address into r5;
    call multiparty_pvp_utils_v011.aleo/reveal_answer r1 r3.sig into r6 r7;
    call puzzle_pieces_v011.aleo/joint_stake_state_update r2 r3 r5 into r8 r9;
    cast r1.opponent_address r1.game_address 4field true r2.amount r1.challenger_address r1.opponent_address into r10 as GameFinishReqNotification.record;
    cast r1.challenger_address r1.game_address 4field true r2.amount r1.challenger_address r1.opponent_address into r11 as GameFinishReqNotification.record;
    output r6 as multiparty_pvp_utils_v011.aleo/RevealAnswer.record;
    output r7 as multiparty_pvp_utils_v011.aleo/AuditRevealAnswer.record;
    output r8 as puzzle_pieces_v011.aleo/JointPieceWinner.record;
    output r9 as puzzle_pieces_v011.aleo/AuditJointPieceWinner.record;
    output r10 as GameFinishReqNotification.record;
    output r11 as GameFinishReqNotification.record;

function finish_game:
    input r0 as Game.record;
    input r1 as puzzle_pieces_v011.aleo/JointPieceWinner.record;
    input r2 as puzzle_pieces_v011.aleo/PieceJointStake.record;
    input r3 as puzzle_pieces_v011.aleo/JointPieceTimeClaim.record;
    is.eq r1.winner r0.challenger_address into r4;
    ternary r4 r0.opponent_address r0.challenger_address into r5;
    call puzzle_pieces_v011.aleo/joint_stake_transfer_to_winner r1 r2 r3 into r6 r7 r8;
    cast r0.owner r0.challenger_commit r0.opponent_answer r0.total_pot r0.challenger_address r0.opponent_address r0.game_multisig 3field into r9 as Game.record;
    cast r0.challenger_address r0.game_multisig 5field false r0.total_pot r0.challenger_address r0.opponent_address r1.winner r5 into r10 as GameFinishedNotification.record;
    cast r0.opponent_address r0.game_multisig 5field false r0.total_pot r0.challenger_address r0.opponent_address r1.winner r5 into r11 as GameFinishedNotification.record;
    output r6 as puzzle_pieces_v011.aleo/Piece.record;
    output r7 as puzzle_pieces_v011.aleo/AuditTransferToWinner.record;
    output r8 as puzzle_pieces_v011.aleo/AuditPieceOwner.record;
    output r9 as Game.record;
    output r10 as GameFinishedNotification.record;
    output r11 as GameFinishedNotification.record;

function finish_game_by_timeout:
    input r0 as Game.record;
    input r1 as puzzle_pieces_v011.aleo/PieceJointStake.record;
    input r2 as puzzle_pieces_v011.aleo/JointPieceTimeClaim.record;
    input r3 as signature.private;
    cast r0.owner r0.challenger_commit r0.opponent_answer r0.total_pot r0.challenger_address r0.opponent_address r0.game_multisig 3field into r4 as Game.record;
    cast r0.challenger_address r0.game_multisig 6field false r0.total_pot r0.challenger_address r0.opponent_address r0.opponent_address r0.challenger_address into r5 as GameFinishedNotification.record;
    cast r0.opponent_address r0.game_multisig 6field false r0.total_pot r0.challenger_address r0.opponent_address r0.opponent_address r0.challenger_address into r6 as GameFinishedNotification.record;
    call puzzle_pieces_v011.aleo/joint_timeout_to_opponent r1 r2 r3 into r7 r8;
    async finish_game_by_timeout r2.block_ht into r9;
    output r7 as puzzle_pieces_v011.aleo/Piece.record;
    output r8 as puzzle_pieces_v011.aleo/AuditTransferToWinner.record;
    output r4 as Game.record;
    output r5 as GameFinishedNotification.record;
    output r6 as GameFinishedNotification.record;
    output r9 as wheres_alex_v011.aleo/finish_game_by_timeout.future;

finalize finish_game_by_timeout:
    input r0 as u32.public;
    add r0 1000u32 into r1;
    gt block.height r1 into r2;
    assert.eq r2 true ;
