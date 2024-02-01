program aleo_monopoly_workshop6.aleo;

record Buildings:
    owner as address.private;
    amount as u64.private;
    buildings as u64.private;

struct TokenInfo:
    name as field;
    symbol as field;
    decimals as u8;
    circulating_supply as u64;
    total_supply as u64;
    testers as u64;
    admin as address;

struct TestToken:
    name as field;
    symbol as field;
    decimals as u8;
    circulating_supply as u64;
    total_supply as u64;
    admin as address;

struct BuildingInfo:
    building_id as field;
    max_building as u128;
    receiver as address;

record Reward:
    owner as address.private;
    amount as u64.private;

struct GlobalState:
    next_token_id as field;
    admin as address;

struct BiddingInfo:
    building_id as field;
    bidder as address;
    amount as u64;

struct Tournament:
    tournament_id as field;
    target_amount as u64;
    criteria_amount as u64;
    winners as u64;
    winners_active as boolean;
    active as boolean;
    admin as address;

mapping account:
    key as address.public;
    value as u64.public;

mapping get_reward:
    key as address.public;
    value as u64.public;

mapping tokens:
    key as u64.public;
    value as TokenInfo.public;

mapping test_token:
    key as u64.public;
    value as TestToken.public;

mapping unique_building:
    key as address.public;
    value as BuildingInfo.public;

mapping stake_utility:
    key as address.public;
    value as u64.public;

mapping global_state:
    key as boolean.public;
    value as GlobalState.public;

mapping global_tournament_state:
    key as field.public;
    value as Tournament.public;

mapping special_building:
    key as field.public;
    value as BiddingInfo.public;

function init:
    input r0 as boolean.private;
    async init self.caller into r1;
    output r1 as aleo_monopoly_workshop6.aleo/init.future;

finalize init:
    input r0 as address.public;
    cast 0field aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r1 as GlobalState;
    get.or_use global_state[true] r1 into r2;
    assert.eq r2.next_token_id 0field ;
    assert.eq r0 r2.admin ;
    cast 1field r2.admin into r3 as GlobalState;
    set r3 into global_state[true];
    get.or_use account[r0] 0u64 into r4;
    is.eq r4 0u64 into r5;
    assert.eq r5 true ;
    add r4 60000000u64 into r6;
    set r6 into account[r0];
    add 0u64 60000000u64 into r7;
    cast 4577111110111112111108121field 4577111110111112111108121field 6u8 r7 15000000000000u64 r2.admin into r8 as TestToken;
    set r8 into test_token[15000000000000u64];

function change_admin:
    input r0 as address.private;
    async change_admin self.caller r0 into r1;
    output r1 as aleo_monopoly_workshop6.aleo/change_admin.future;

finalize change_admin:
    input r0 as address.public;
    input r1 as address.public;
    get global_state[true] into r2;
    assert.eq r0 r2.admin ;
    cast r2.next_token_id r1 into r3 as GlobalState;
    set r3 into global_state[true];

function issue:
    input r0 as address.private;
    input r1 as u64.private;
    async issue r0 r1 into r2;
    output r0 as address.private;
    output r1 as u64.private;
    output r2 as aleo_monopoly_workshop6.aleo/issue.future;

finalize issue:
    input r0 as address.public;
    input r1 as u64.public;
    cast 0field aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r2 as GlobalState;
    get.or_use global_state[true] r2 into r3;
    is.eq r3.next_token_id 1field into r4;
    assert.eq r4 true ;
    cast 4577111110111112111108121field 4577111110111112111108121field 6u8 0u64 15000000000000u64 r3.admin into r5 as TestToken;
    get.or_use test_token[15000000000000u64] r5 into r6;
    get.or_use account[r0] 0u64 into r7;
    add r6.circulating_supply r1 into r8;
    lte r8 r6.total_supply into r9;
    assert.eq r9 true ;
    is.eq r1 10000u64 into r10;
    assert.eq r10 true ;
    cast r6.name r6.symbol r6.decimals r8 r6.total_supply r3.admin into r11 as TestToken;
    set r11 into test_token[15000000000000u64];
    is.eq r7 0u64 into r12;
    assert.eq r12 true ;
    add r7 r1 into r13;
    set r13 into account[r0];

function monopoly_buy:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    sub r1 1500u64 into r3;
    cast r0 r3 r2 into r4 as Buildings.record;
    async monopoly_buy r0 1500u64 1u128 into r5;
    output r4 as Buildings.record;
    output 1500u64 as u64.private;
    output r5 as aleo_monopoly_workshop6.aleo/monopoly_buy.future;

finalize monopoly_buy:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    get.or_use account[r0] 0u64 into r3;
    gt r3 0u64 into r4;
    assert.eq r4 true ;
    get.or_use account[r0] 0u64 into r5;
    sub r5 r1 into r6;
    set r6 into account[r0];
    rand.chacha into r7 as field;
    cast r7 0u128 r0 into r8 as BuildingInfo;
    get.or_use unique_building[r0] r8 into r9;
    is.eq r9.receiver r0 into r10;
    assert.eq r10 true ;
    is.eq r9.max_building 0u128 into r11;
    assert.eq r11 true ;
    add r9.max_building r2 into r12;
    cast r9.building_id r12 r9.receiver into r13 as BuildingInfo;
    set r13 into unique_building[r0];

function monopoly_rent:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    cast r0 r1 r2 into r3 as Buildings.record;
    async monopoly_rent r0 150u64 1u128 into r4;
    output r3 as Buildings.record;
    output 150u64 as u64.private;
    output r4 as aleo_monopoly_workshop6.aleo/monopoly_rent.future;

finalize monopoly_rent:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r0] r3 into r4;
    is.eq r4.receiver r0 into r5;
    assert.eq r5 true ;
    is.eq r4.max_building 1u128 into r6;
    assert.eq r6 true ;
    get.or_use account[r0] 0u64 into r7;
    gt r7 0u64 into r8;
    assert.eq r8 true ;
    get.or_use account[r0] 0u64 into r9;
    rand.chacha into r10 as u64;
    gt 9223372036854775808u64 r10 into r11;
    add r9 150u64 into r12;
    sub r9 150u64 into r13;
    ternary r11 r12 r13 into r14;
    set r14 into account[r0];
    get.or_use stake_utility[r0] 0u64 into r15;
    gte r15 3000u64 into r16;
    add r15 100u64 into r17;
    add r15 0u64 into r18;
    ternary r16 r17 r18 into r19;
    set r19 into stake_utility[r0];

function monopoly_sale:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    input r3 as u64.private;
    input r4 as address.private;
    gte r3 8000u64 into r5;
    not r5 into r6;
    or r6 true into r7;
    assert.eq r7 true ;
    not r5 into r8;
    not r8 into r9;
    or r9 false into r10;
    assert.eq r10 true ;
    add r1 r3 into r11;
    sub r2 1u64 into r12;
    cast r0 r11 r12 into r13 as Buildings.record;
    async monopoly_sale r0 r4 r3 1u128 into r14;
    output r13 as Buildings.record;
    output r4 as address.private;
    output r3 as u64.private;
    output r14 as aleo_monopoly_workshop6.aleo/monopoly_sale.future;

finalize monopoly_sale:
    input r0 as address.public;
    input r1 as address.public;
    input r2 as u64.public;
    input r3 as u128.public;
    cast 123field 0u128 r0 into r4 as BuildingInfo;
    get.or_use unique_building[r0] r4 into r5;
    is.eq r5.receiver r0 into r6;
    assert.eq r6 true ;
    is.eq r5.max_building 1u128 into r7;
    assert.eq r7 true ;
    get.or_use account[r0] 0u64 into r8;
    gt r8 0u64 into r9;
    assert.eq r9 true ;
    get.or_use account[r1] 0u64 into r10;
    gte r10 8000u64 into r11;
    assert.eq r11 true ;
    assert.eq r1 aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m ;
    get.or_use stake_utility[r0] 0u64 into r12;
    is.eq r12 0u64 into r13;
    assert.eq r13 true ;
    get.or_use account[r1] 0u64 into r14;
    sub r14 r2 into r15;
    set r15 into account[r1];
    get.or_use account[r0] 0u64 into r16;
    add r16 r2 into r17;
    set r17 into account[r0];
    sub r5.max_building r3 into r18;
    lte r18 r5.max_building into r19;
    assert.eq r19 true ;
    cast r5.building_id r18 r0 into r20 as BuildingInfo;
    set r20 into unique_building[r0];
    add r5.max_building r3 into r21;
    gte r21 r5.max_building into r22;
    assert.eq r22 true ;
    cast r5.building_id r21 r1 into r23 as BuildingInfo;
    set r23 into unique_building[r1];
    remove unique_building[r0];

function mystery_card:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    cast r0 r1 r2 into r3 as Buildings.record;
    async mystery_card r0 1500u64 1u128 into r4;
    output r3 as Buildings.record;
    output 1500u64 as u64.private;
    output r4 as aleo_monopoly_workshop6.aleo/mystery_card.future;

finalize mystery_card:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r0] r3 into r4;
    is.eq r4.receiver r0 into r5;
    assert.eq r5 true ;
    is.eq r4.max_building 1u128 into r6;
    assert.eq r6 true ;
    get.or_use account[r0] 0u64 into r7;
    gt r7 0u64 into r8;
    assert.eq r8 true ;
    get.or_use account[r0] 0u64 into r9;
    rand.chacha into r10 as u64;
    gte r10 18446744073709551615u64 into r11;
    add r9 1500u64 into r12;
    sub r9 1500u64 into r13;
    ternary r11 r12 r13 into r14;
    set r14 into account[r0];

function staking_utility:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    cast r0 r1 r2 into r3 as Buildings.record;
    async staking_utility r0 3000u64 1u128 into r4;
    output r3 as Buildings.record;
    output 3000u64 as u64.private;
    output r4 as aleo_monopoly_workshop6.aleo/staking_utility.future;

finalize staking_utility:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r0] r3 into r4;
    is.eq r4.receiver r0 into r5;
    assert.eq r5 true ;
    is.eq r4.max_building 1u128 into r6;
    assert.eq r6 true ;
    get.or_use account[r0] 0u64 into r7;
    gte r7 3000u64 into r8;
    assert.eq r8 true ;
    get.or_use account[r0] 0u64 into r9;
    sub r9 r1 into r10;
    set r10 into account[r0];
    get.or_use stake_utility[r0] 0u64 into r11;
    is.eq r11 0u64 into r12;
    assert.eq r12 true ;
    add r11 r1 into r13;
    set r13 into stake_utility[r0];

function unstaking_utility:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    cast r0 r1 r2 into r3 as Buildings.record;
    async unstaking_utility r0 3000u64 1u128 into r4;
    output r3 as Buildings.record;
    output 3000u64 as u64.private;
    output r4 as aleo_monopoly_workshop6.aleo/unstaking_utility.future;

finalize unstaking_utility:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r0] r3 into r4;
    is.eq r4.receiver r0 into r5;
    assert.eq r5 true ;
    is.eq r4.max_building 1u128 into r6;
    assert.eq r6 true ;
    get.or_use account[r0] 0u64 into r7;
    gte r7 0u64 into r8;
    assert.eq r8 true ;
    get.or_use stake_utility[r0] 0u64 into r9;
    gte r9 3000u64 into r10;
    assert.eq r10 true ;
    sub r9 r1 into r11;
    set r11 into stake_utility[r0];
    get.or_use account[r0] 0u64 into r12;
    add r12 r1 into r13;
    set r13 into account[r0];

function bidding_info:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    cast 1151121019910597108field r0 r1 into r3 as BiddingInfo;
    async bidding_info r0 r1 1u128 into r4;
    output r3 as BiddingInfo.private;
    output r1 as u64.private;
    output r4 as aleo_monopoly_workshop6.aleo/bidding_info.future;

finalize bidding_info:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r0] r3 into r4;
    is.eq r4.receiver r0 into r5;
    assert.eq r5 true ;
    is.eq r4.max_building 1u128 into r6;
    assert.eq r6 true ;
    get.or_use account[r0] 0u64 into r7;
    gte r7 15000u64 into r8;
    assert.eq r8 true ;
    get.or_use account[r0] 0u64 into r9;
    sub r9 r1 into r10;
    set r10 into account[r0];
    hash.keccak512 r0 into r11 as address;
    cast 1151121019910597108field r11 0u64 into r12 as BiddingInfo;
    get.or_use special_building[1151121019910597108field] r12 into r13;
    gt r1 r13.amount into r14;
    assert.eq r14 true ;
    assert.neq r11 r13.bidder ;
    get.or_use account[r13.bidder] 0u64 into r15;
    add r15 r13.amount into r16;
    set r16 into account[r13.bidder];
    cast r13.building_id r11 r1 into r17 as BiddingInfo;
    set r17 into special_building[1151121019910597108field];

function unbidding_info:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    cast 1151121019910597108field r0 r1 into r3 as BiddingInfo;
    async unbidding_info r0 r1 1u128 into r4;
    output r3 as BiddingInfo.private;
    output r1 as u64.private;
    output r4 as aleo_monopoly_workshop6.aleo/unbidding_info.future;

finalize unbidding_info:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r0] r3 into r4;
    is.eq r4.receiver r0 into r5;
    assert.eq r5 true ;
    is.eq r4.max_building 1u128 into r6;
    assert.eq r6 true ;
    hash.keccak512 r0 into r7 as address;
    cast 1151121019910597108field r7 0u64 into r8 as BiddingInfo;
    get.or_use special_building[1151121019910597108field] r8 into r9;
    assert.eq r9.bidder r7 ;
    get.or_use account[r0] 0u64 into r10;
    add r10 r9.amount into r11;
    set r11 into account[r0];
    remove special_building[1151121019910597108field];

function claim_bidding_reward:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u64.private;
    cast 1151121019910597108field r0 r1 into r3 as BiddingInfo;
    async claim_bidding_reward r0 r1 1u128 into r4;
    output r3 as BiddingInfo.private;
    output r1 as u64.private;
    output r4 as aleo_monopoly_workshop6.aleo/claim_bidding_reward.future;

finalize claim_bidding_reward:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r0] r3 into r4;
    is.eq r4.receiver r0 into r5;
    assert.eq r5 true ;
    is.eq r4.max_building 1u128 into r6;
    assert.eq r6 true ;
    hash.keccak512 r0 into r7 as address;
    cast 1151121019910597108field r7 0u64 into r8 as BiddingInfo;
    get.or_use special_building[1151121019910597108field] r8 into r9;
    assert.eq r9.bidder r7 ;
    get.or_use account[r0] 0u64 into r10;
    add r10 450u64 into r11;
    set r11 into account[r0];

function mint_reward:
    input r0 as address.private;
    input r1 as u64.private;
    cast r0 r1 into r2 as Reward.record;
    async mint_reward self.caller r1 into r3;
    output r2 as Reward.record;
    output r3 as aleo_monopoly_workshop6.aleo/mint_reward.future;

finalize mint_reward:
    input r0 as address.public;
    input r1 as u64.public;
    cast 4577111110111112111108121field 4577111110111112111108121field 6u8 0u64 15000000000000u64 0u64 aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r2 as TokenInfo;
    get.or_use tokens[15000000000000u64] r2 into r3;
    add r3.circulating_supply r1 into r4;
    lte r4 r3.total_supply into r5;
    assert.eq r5 true ;
    add r3.testers 1u64 into r6;
    cast r3.name r3.symbol r3.decimals r4 r3.total_supply r6 r3.admin into r7 as TokenInfo;
    set r7 into tokens[15000000000000u64];
    get.or_use account[r0] 0u64 into r8;
    gte r8 12000u64 into r9;
    assert.eq r9 true ;
    lte r3.testers 5000u64 into r10;
    assert.eq r10 true ;
    get.or_use get_reward[r0] 0u64 into r11;
    assert.eq r11 0u64 ;
    get.or_use get_reward[r0] 0u64 into r12;
    add r12 r1 into r13;
    set r13 into get_reward[r0];

function init_tournament:
    input r0 as field.private;
    input r1 as u64.private;
    input r2 as u64.private;
    input r3 as u64.private;
    input r4 as boolean.private;
    async init_tournament self.caller r0 r1 r2 r3 r4 into r5;
    output r5 as aleo_monopoly_workshop6.aleo/init_tournament.future;

finalize init_tournament:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as u64.public;
    input r3 as u64.public;
    input r4 as u64.public;
    input r5 as boolean.public;
    cast r1 0u64 0u64 0u64 false true aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r6 as Tournament;
    get.or_use global_tournament_state[123field] r6 into r7;
    assert.eq r0 r7.admin ;
    cast r1 r2 r3 r4 false true r7.admin into r8 as Tournament;
    set r8 into global_tournament_state[r1];

function tournament_game:
    input r0 as address.private;
    async tournament_game r0 into r1;
    output r1 as aleo_monopoly_workshop6.aleo/tournament_game.future;

finalize tournament_game:
    input r0 as address.public;
    cast 123field 0u64 0u64 0u64 false true aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r1 as Tournament;
    get.or_use global_tournament_state[123field] r1 into r2;
    assert.eq r2.active true ;
    get.or_use account[r0] 0u64 into r3;
    gte r3 r2.target_amount into r4;
    gte r3 r2.criteria_amount into r5;
    and r4 r5 into r6;
    assert.eq r6 true ;
    is.eq r2.winners_active false into r7;
    assert.eq r7 true ;
    sub r2.winners 1u64 into r8;
    gt r2.winners 0u64 into r9;
    assert.eq r9 true ;
    get.or_use get_reward[r0] 0u64 into r10;
    add r10 5000u64 into r11;
    set r11 into get_reward[r0];
    cast r2.tournament_id r2.target_amount r2.criteria_amount r8 true true aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r12 as Tournament;
    set r12 into global_tournament_state[r2.tournament_id];

function end_tournament:
    input r0 as field.private;
    input r1 as boolean.private;
    async end_tournament r0 self.caller into r2;
    output r2 as aleo_monopoly_workshop6.aleo/end_tournament.future;

finalize end_tournament:
    input r0 as field.public;
    input r1 as address.public;
    cast 123field 0u64 0u64 0u64 false true aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r2 as Tournament;
    get.or_use global_tournament_state[123field] r2 into r3;
    assert.eq r1 r3.admin ;
    assert.eq r0 r3.tournament_id ;
    assert.eq r3.winners 0u64 ;
    remove global_tournament_state[r3.tournament_id];

function send_token:
    input r0 as address.private;
    input r1 as address.private;
    input r2 as u64.private;
    async send_token self.caller r1 r2 into r3;
    output r2 as u64.private;
    output r3 as aleo_monopoly_workshop6.aleo/send_token.future;

finalize send_token:
    input r0 as address.public;
    input r1 as address.public;
    input r2 as u64.public;
    assert.eq r0 aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m ;
    get.or_use account[r0] 0u64 into r3;
    get.or_use account[r1] 0u64 into r4;
    gte r3 r2 into r5;
    assert.eq r5 true ;
    cast 123field 0u128 r1 into r6 as BuildingInfo;
    get.or_use unique_building[r1] r6 into r7;
    is.eq r7.max_building 1u128 into r8;
    assert.eq r8 true ;
    sub r3 r2 into r9;
    set r9 into account[r0];
    add r4 r2 into r10;
    set r10 into account[r1];

function hashed_address:
    input r0 as address.private;
    hash.keccak512 r0 into r1 as address;
    output r1 as address.private;
