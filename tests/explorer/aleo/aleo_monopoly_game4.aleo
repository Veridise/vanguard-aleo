program aleo_monopoly_game4.aleo;

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
    block_height as u32;

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
    key as u128.public;
    value as BuildingInfo.public;

mapping stake_utility:
    key as address.public;
    value as u64.public;

mapping global_state:
    key as boolean.public;
    value as GlobalState.public;

mapping special_building:
    key as u64.public;
    value as BiddingInfo.public;

function init:
    input r0 as boolean.public;
    async init self.caller into r1;
    output r1 as aleo_monopoly_game4.aleo/init.future;

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
    add r4 100000u64 into r6;
    set r6 into account[r0];
    add 0u64 100000u64 into r7;
    cast 4577111110111112111108121field 4577111110111112111108121field 6u8 r7 15000000000u64 r2.admin into r8 as TestToken;
    set r8 into test_token[15000000000u64];

function change_admin:
    input r0 as address.public;
    async change_admin self.caller r0 into r1;
    output r1 as aleo_monopoly_game4.aleo/change_admin.future;

finalize change_admin:
    input r0 as address.public;
    input r1 as address.public;
    get global_state[true] into r2;
    assert.eq r0 r2.admin ;
    cast r2.next_token_id r1 into r3 as GlobalState;
    set r3 into global_state[true];

function issue:
    input r0 as address.public;
    input r1 as u64.public;
    async issue r0 r1 into r2;
    output r0 as address.private;
    output r1 as u64.private;
    output r2 as aleo_monopoly_game4.aleo/issue.future;

finalize issue:
    input r0 as address.public;
    input r1 as u64.public;
    cast 0field aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r2 as GlobalState;
    get.or_use global_state[true] r2 into r3;
    is.eq r3.next_token_id 1field into r4;
    assert.eq r4 true ;
    cast 4577111110111112111108121field 4577111110111112111108121field 6u8 r1 15000000000000u64 r3.admin into r5 as TestToken;
    get.or_use test_token[15000000000000u64] r5 into r6;
    is.eq r1 10000u64 into r7;
    assert.eq r7 true ;
    get.or_use account[r0] 0u64 into r8;
    add r6.circulating_supply r1 into r9;
    lte r9 r6.total_supply into r10;
    assert.eq r10 true ;
    cast r6.name r6.symbol r6.decimals r9 r6.total_supply r3.admin into r11 as TestToken;
    set r11 into test_token[15000000000000u64];
    is.eq r8 0u64 into r12;
    assert.eq r12 true ;
    add r8 r1 into r13;
    set r13 into account[r0];

function monopoly_buy:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u64.public;
    sub r1 1500u64 into r3;
    cast r0 r3 r2 into r4 as Buildings.record;
    async monopoly_buy r0 1500u64 1u128 into r5;
    output r4 as Buildings.record;
    output 1500u64 as u64.private;
    output r5 as aleo_monopoly_game4.aleo/monopoly_buy.future;

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
    get.or_use unique_building[r2] r8 into r9;
    lt r9.max_building 1u128 into r10;
    assert.eq r10 true ;
    add r9.max_building r2 into r11;
    cast r9.building_id r11 r9.receiver into r12 as BuildingInfo;
    set r12 into unique_building[r2];

function monopoly_rent:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u64.public;
    cast r0 r1 r2 into r3 as Buildings.record;
    async monopoly_rent r0 150u64 1u128 into r4;
    output r3 as Buildings.record;
    output 150u64 as u64.private;
    output r4 as aleo_monopoly_game4.aleo/monopoly_rent.future;

finalize monopoly_rent:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r2] r3 into r4;
    is.eq r4.max_building 1u128 into r5;
    assert.eq r5 true ;
    get.or_use account[r0] 0u64 into r6;
    gt r6 0u64 into r7;
    assert.eq r7 true ;
    get.or_use account[r0] 0u64 into r8;
    rand.chacha into r9 as u8;
    is.eq r9 2u8 into r10;
    is.eq r9 3u8 into r11;
    or r10 r11 into r12;
    is.eq r9 5u8 into r13;
    or r12 r13 into r14;
    is.eq r9 7u8 into r15;
    or r14 r15 into r16;
    is.eq r9 11u8 into r17;
    or r16 r17 into r18;
    is.eq r9 13u8 into r19;
    or r18 r19 into r20;
    is.eq r9 17u8 into r21;
    or r20 r21 into r22;
    is.eq r9 19u8 into r23;
    or r22 r23 into r24;
    is.eq r9 23u8 into r25;
    or r24 r25 into r26;
    is.eq r9 29u8 into r27;
    or r26 r27 into r28;
    is.eq r9 31u8 into r29;
    or r28 r29 into r30;
    is.eq r9 37u8 into r31;
    or r30 r31 into r32;
    is.eq r9 41u8 into r33;
    or r32 r33 into r34;
    is.eq r9 43u8 into r35;
    or r34 r35 into r36;
    is.eq r9 47u8 into r37;
    or r36 r37 into r38;
    is.eq r9 53u8 into r39;
    or r38 r39 into r40;
    is.eq r9 59u8 into r41;
    or r40 r41 into r42;
    is.eq r9 61u8 into r43;
    or r42 r43 into r44;
    is.eq r9 67u8 into r45;
    or r44 r45 into r46;
    is.eq r9 71u8 into r47;
    or r46 r47 into r48;
    is.eq r9 73u8 into r49;
    or r48 r49 into r50;
    is.eq r9 79u8 into r51;
    or r50 r51 into r52;
    is.eq r9 83u8 into r53;
    or r52 r53 into r54;
    is.eq r9 89u8 into r55;
    or r54 r55 into r56;
    is.eq r9 97u8 into r57;
    or r56 r57 into r58;
    is.eq r9 101u8 into r59;
    or r58 r59 into r60;
    is.eq r9 103u8 into r61;
    or r60 r61 into r62;
    is.eq r9 107u8 into r63;
    or r62 r63 into r64;
    is.eq r9 109u8 into r65;
    or r64 r65 into r66;
    is.eq r9 113u8 into r67;
    or r66 r67 into r68;
    is.eq r9 127u8 into r69;
    or r68 r69 into r70;
    is.eq r9 131u8 into r71;
    or r70 r71 into r72;
    is.eq r9 137u8 into r73;
    or r72 r73 into r74;
    is.eq r9 139u8 into r75;
    or r74 r75 into r76;
    is.eq r9 149u8 into r77;
    or r76 r77 into r78;
    is.eq r9 151u8 into r79;
    or r78 r79 into r80;
    is.eq r9 157u8 into r81;
    or r80 r81 into r82;
    is.eq r9 163u8 into r83;
    or r82 r83 into r84;
    is.eq r9 167u8 into r85;
    or r84 r85 into r86;
    is.eq r9 173u8 into r87;
    or r86 r87 into r88;
    is.eq r9 179u8 into r89;
    or r88 r89 into r90;
    is.eq r9 181u8 into r91;
    or r90 r91 into r92;
    is.eq r9 191u8 into r93;
    or r92 r93 into r94;
    is.eq r9 193u8 into r95;
    or r94 r95 into r96;
    is.eq r9 197u8 into r97;
    or r96 r97 into r98;
    is.eq r9 199u8 into r99;
    or r98 r99 into r100;
    is.eq r9 211u8 into r101;
    or r100 r101 into r102;
    is.eq r9 223u8 into r103;
    or r102 r103 into r104;
    is.eq r9 227u8 into r105;
    or r104 r105 into r106;
    is.eq r9 229u8 into r107;
    or r106 r107 into r108;
    is.eq r9 233u8 into r109;
    or r108 r109 into r110;
    is.eq r9 239u8 into r111;
    or r110 r111 into r112;
    is.eq r9 241u8 into r113;
    or r112 r113 into r114;
    is.eq r9 251u8 into r115;
    or r114 r115 into r116;
    add r8 150u64 into r117;
    sub r8 150u64 into r118;
    ternary r116 r117 r118 into r119;
    set r119 into account[r0];
    get.or_use stake_utility[r0] 0u64 into r120;
    is.eq r120 3000u64 into r121;
    add r8 100u64 into r122;
    add r8 0u64 into r123;
    ternary r121 r122 r123 into r124;
    set r124 into account[r0];

function monopoly_sale:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u64.public;
    input r3 as u64.public;
    input r4 as address.public;
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
    output r14 as aleo_monopoly_game4.aleo/monopoly_sale.future;

finalize monopoly_sale:
    input r0 as address.public;
    input r1 as address.public;
    input r2 as u64.public;
    input r3 as u128.public;
    cast 123field 0u128 r0 into r4 as BuildingInfo;
    get.or_use unique_building[r3] r4 into r5;
    gt r5.max_building 0u128 into r6;
    assert.eq r6 true ;
    get.or_use account[r0] 0u64 into r7;
    gt r7 0u64 into r8;
    assert.eq r8 true ;
    get.or_use account[r1] 0u64 into r9;
    gte r9 8000u64 into r10;
    assert.eq r10 true ;
    get.or_use account[r1] 0u64 into r11;
    sub r11 r2 into r12;
    set r12 into account[r1];
    get.or_use account[r0] 0u64 into r13;
    add r13 r2 into r14;
    set r14 into account[r0];
    sub r5.max_building r3 into r15;
    lte r15 r5.max_building into r16;
    assert.eq r16 true ;
    cast r5.building_id r15 r0 into r17 as BuildingInfo;
    set r17 into unique_building[r15];
    add r5.max_building r3 into r18;
    gte r18 r5.max_building into r19;
    assert.eq r19 true ;
    cast r5.building_id r18 r1 into r20 as BuildingInfo;
    set r20 into unique_building[r18];
    remove unique_building[r15];

function mystery_card:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u64.public;
    cast r0 r1 r2 into r3 as Buildings.record;
    async mystery_card r0 1500u64 1u128 into r4;
    output r3 as Buildings.record;
    output 1500u64 as u64.private;
    output r4 as aleo_monopoly_game4.aleo/mystery_card.future;

finalize mystery_card:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r2] r3 into r4;
    gt r4.max_building 0u128 into r5;
    assert.eq r5 true ;
    get.or_use account[r0] 0u64 into r6;
    gt r6 0u64 into r7;
    assert.eq r7 true ;
    get.or_use account[r0] 0u64 into r8;
    rand.chacha into r9 as u8;
    is.eq r9 9u8 into r10;
    is.eq r9 18u8 into r11;
    or r10 r11 into r12;
    is.eq r9 27u8 into r13;
    or r12 r13 into r14;
    is.eq r9 36u8 into r15;
    or r14 r15 into r16;
    is.eq r9 45u8 into r17;
    or r16 r17 into r18;
    is.eq r9 54u8 into r19;
    or r18 r19 into r20;
    is.eq r9 63u8 into r21;
    or r20 r21 into r22;
    is.eq r9 72u8 into r23;
    or r22 r23 into r24;
    is.eq r9 81u8 into r25;
    or r24 r25 into r26;
    is.eq r9 90u8 into r27;
    or r26 r27 into r28;
    is.eq r9 99u8 into r29;
    or r28 r29 into r30;
    is.eq r9 108u8 into r31;
    or r30 r31 into r32;
    is.eq r9 117u8 into r33;
    or r32 r33 into r34;
    is.eq r9 126u8 into r35;
    or r34 r35 into r36;
    is.eq r9 135u8 into r37;
    or r36 r37 into r38;
    is.eq r9 144u8 into r39;
    or r38 r39 into r40;
    is.eq r9 153u8 into r41;
    or r40 r41 into r42;
    is.eq r9 162u8 into r43;
    or r42 r43 into r44;
    is.eq r9 171u8 into r45;
    or r44 r45 into r46;
    is.eq r9 180u8 into r47;
    or r46 r47 into r48;
    is.eq r9 189u8 into r49;
    or r48 r49 into r50;
    is.eq r9 192u8 into r51;
    or r50 r51 into r52;
    is.eq r9 201u8 into r53;
    or r52 r53 into r54;
    is.eq r9 210u8 into r55;
    or r54 r55 into r56;
    is.eq r9 219u8 into r57;
    or r56 r57 into r58;
    is.eq r9 228u8 into r59;
    or r58 r59 into r60;
    is.eq r9 237u8 into r61;
    or r60 r61 into r62;
    is.eq r9 246u8 into r63;
    or r62 r63 into r64;
    is.eq r9 255u8 into r65;
    or r64 r65 into r66;
    add r8 1500u64 into r67;
    sub r8 1500u64 into r68;
    ternary r66 r67 r68 into r69;
    set r69 into account[r0];

function staking_utility:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u64.public;
    cast r0 r1 r2 into r3 as Buildings.record;
    async staking_utility r0 3000u64 1u128 into r4;
    output r3 as Buildings.record;
    output 3000u64 as u64.private;
    output r4 as aleo_monopoly_game4.aleo/staking_utility.future;

finalize staking_utility:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r2] r3 into r4;
    gt r4.max_building 0u128 into r5;
    assert.eq r5 true ;
    get.or_use account[r0] 0u64 into r6;
    gte r6 3000u64 into r7;
    assert.eq r7 true ;
    get.or_use account[r0] 0u64 into r8;
    sub r8 r1 into r9;
    set r9 into account[r0];
    get.or_use stake_utility[r0] 0u64 into r10;
    is.eq r10 0u64 into r11;
    assert.eq r11 true ;
    add r10 r1 into r12;
    set r12 into stake_utility[r0];

function unstaking_utility:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u64.public;
    cast r0 r1 r2 into r3 as Buildings.record;
    async unstaking_utility r0 3000u64 1u128 into r4;
    output r3 as Buildings.record;
    output 3000u64 as u64.private;
    output r4 as aleo_monopoly_game4.aleo/unstaking_utility.future;

finalize unstaking_utility:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r2] r3 into r4;
    gt r4.max_building 0u128 into r5;
    assert.eq r5 true ;
    get.or_use account[r0] 0u64 into r6;
    gte r6 0u64 into r7;
    assert.eq r7 true ;
    get.or_use stake_utility[r0] 0u64 into r8;
    is.eq r8 3000u64 into r9;
    assert.eq r9 true ;
    sub r8 r1 into r10;
    set r10 into stake_utility[r0];
    get.or_use account[r0] 0u64 into r11;
    add r11 r1 into r12;
    set r12 into account[r0];

function bidding_info:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u64.public;
    cast 123field r0 r1 0u32 into r3 as BiddingInfo;
    async bidding_info r0 r1 1u128 into r4;
    output r3 as BiddingInfo.private;
    output r1 as u64.private;
    output r4 as aleo_monopoly_game4.aleo/bidding_info.future;

finalize bidding_info:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r2] r3 into r4;
    gt r4.max_building 0u128 into r5;
    assert.eq r5 true ;
    get.or_use account[r0] 0u64 into r6;
    gte r6 20000u64 into r7;
    assert.eq r7 true ;
    get.or_use account[r0] 0u64 into r8;
    sub r8 r1 into r9;
    set r9 into account[r0];
    rand.chacha into r10 as field;
    cast r10 r0 0u64 0u32 into r11 as BiddingInfo;
    get.or_use special_building[r1] r11 into r12;
    gt r1 r12.amount into r13;
    assert.eq r13 true ;
    cast r12.building_id r0 r1 r12.block_height into r14 as BiddingInfo;
    set r14 into special_building[r1];

function claim_bidding_reward:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u64.public;
    cast 123field r0 r1 0u32 into r3 as BiddingInfo;
    async claim_bidding_reward r0 r1 1u128 into r4;
    output r3 as BiddingInfo.private;
    output r1 as u64.private;
    output r4 as aleo_monopoly_game4.aleo/claim_bidding_reward.future;

finalize claim_bidding_reward:
    input r0 as address.public;
    input r1 as u64.public;
    input r2 as u128.public;
    cast 123field 0u128 r0 into r3 as BuildingInfo;
    get.or_use unique_building[r2] r3 into r4;
    gt r4.max_building 0u128 into r5;
    assert.eq r5 true ;
    rand.chacha into r6 as field;
    cast r6 r0 0u64 86400u32 into r7 as BiddingInfo;
    get.or_use special_building[r1] r7 into r8;
    assert.eq r8.bidder r0 ;
    get.or_use account[r0] 0u64 into r9;
    add r9 300u64 into r10;
    set r10 into account[r0];

function mint_reward:
    input r0 as address.public;
    input r1 as u64.public;
    cast r0 r1 into r2 as Reward.record;
    async mint_reward self.caller r1 into r3;
    output r2 as Reward.record;
    output r3 as aleo_monopoly_game4.aleo/mint_reward.future;

finalize mint_reward:
    input r0 as address.public;
    input r1 as u64.public;
    cast 4577111110111112111108121field 4577111110111112111108121field 6u8 0u64 1500000000u64 aleo1az8p9vlllyqwtj0c2g9svkd0e5v0p3zzdflwwrpa7kpe8xrfxgfqqpru7m into r2 as TokenInfo;
    get.or_use tokens[1500000000u64] r2 into r3;
    add r3.circulating_supply r1 into r4;
    lte r4 r3.total_supply into r5;
    assert.eq r5 true ;
    cast r3.name r3.symbol r3.decimals r4 r3.total_supply r3.admin into r6 as TokenInfo;
    set r6 into tokens[1500000000u64];
    get.or_use account[r0] 0u64 into r7;
    gte r7 12000u64 into r8;
    assert.eq r8 true ;
    get.or_use get_reward[r0] 0u64 into r9;
    assert.eq r9 0u64 ;
    get.or_use get_reward[r0] 0u64 into r10;
    add r10 r1 into r11;
    set r11 into get_reward[r0];
