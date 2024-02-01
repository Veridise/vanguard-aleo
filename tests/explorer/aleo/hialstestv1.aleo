program hialstestv1.aleo;

record PrivateToken:
    owner as address.private;
    token as field.private;
    amount as u128.private;

struct TokenInfo:
    name as field;
    symbol as field;
    decimals as u8;
    total_supply as u128;
    admin as address;
    mintable as boolean;
    burnable as boolean;

struct GlobalState:
    admin as address;

struct Pair:
    reserve_a as u128;
    reserve_b as u128;

struct BalanceKeyData:
    token as field;
    user as address;

struct AllowanceKeyData:
    token as field;
    payer as address;
    spender as address;

struct PairKeyData:
    token_a as field;
    token_b as field;

struct TokenIdData:
    base as address;
    creator as address;
    salt as u128;

mapping balances:
    key as field.public;
    value as u128.public;

mapping allowance:
    key as field.public;
    value as u128.public;

mapping tokens:
    key as field.public;
    value as TokenInfo.public;

mapping global_state:
    key as boolean.public;
    value as GlobalState.public;

mapping pairs:
    key as field.public;
    value as Pair.public;

function create_token:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u8.public;
    input r3 as u128.public;
    input r4 as address.public;
    input r5 as boolean.public;
    input r6 as boolean.public;
    input r7 as u128.public;
    gt r0 0field into r8;
    assert.eq r8 true ;
    async create_token r0 r1 r2 r3 r4 r5 r6 self.caller r7 into r9;
    output r9 as hialstestv1.aleo/create_token.future;

finalize create_token:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u8.public;
    input r3 as u128.public;
    input r4 as address.public;
    input r5 as boolean.public;
    input r6 as boolean.public;
    input r7 as address.public;
    input r8 as u128.public;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r7 r8 into r9 as TokenIdData;
    hash.bhp256 r9 into r10 as field;
    contains tokens[r10] into r11;
    not r11 into r12;
    assert.eq r12 true ;
    cast r0 r1 r2 r3 r4 r5 r6 into r13 as TokenInfo;
    set r13 into tokens[r10];
    cast r10 r7 into r14 as BalanceKeyData;
    hash.bhp256 r14 into r15 as field;
    set r13.total_supply into balances[r15];

function transfer_public:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as u128.public;
    async transfer_public r0 self.caller r1 r2 into r3;
    output r3 as hialstestv1.aleo/transfer_public.future;

finalize transfer_public:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as address.public;
    input r3 as u128.public;
    contains tokens[r0] into r4;
    assert.eq r4 true ;
    cast r0 r1 into r5 as BalanceKeyData;
    hash.bhp256 r5 into r6 as field;
    get balances[r6] into r7;
    sub r7 r3 into r8;
    set r8 into balances[r6];
    cast r0 r2 into r9 as BalanceKeyData;
    hash.bhp256 r9 into r10 as field;
    get.or_use balances[r10] 0u128 into r11;
    add r11 r3 into r12;
    set r12 into balances[r10];

function approve:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as u128.public;
    async approve r0 self.caller r1 r2 into r3;
    output r3 as hialstestv1.aleo/approve.future;

finalize approve:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as address.public;
    input r3 as u128.public;
    contains tokens[r0] into r4;
    assert.eq r4 true ;
    cast r0 r1 r2 into r5 as AllowanceKeyData;
    hash.bhp256 r5 into r6 as field;
    set r3 into allowance[r6];

function transfer_from:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as address.public;
    input r3 as u128.public;
    async transfer_from self.caller r0 r1 r2 r3 into r4;
    output r4 as hialstestv1.aleo/transfer_from.future;

finalize transfer_from:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as address.public;
    input r3 as address.public;
    input r4 as u128.public;
    contains tokens[r1] into r5;
    assert.eq r5 true ;
    cast r1 r2 r0 into r6 as AllowanceKeyData;
    hash.bhp256 r6 into r7 as field;
    get allowance[r7] into r8;
    sub r8 r4 into r9;
    set r9 into allowance[r7];
    cast r1 r2 into r10 as BalanceKeyData;
    hash.bhp256 r10 into r11 as field;
    get balances[r11] into r12;
    sub r12 r4 into r13;
    set r13 into balances[r11];
    cast r1 r3 into r14 as BalanceKeyData;
    hash.bhp256 r14 into r15 as field;
    get.or_use balances[r15] 0u128 into r16;
    add r16 r4 into r17;
    set r17 into balances[r15];

function transfer_private:
    input r0 as PrivateToken.record;
    input r1 as address.private;
    input r2 as u128.private;
    cast r1 r0.token r2 into r3 as PrivateToken.record;
    sub r0.amount r2 into r4;
    cast r0.owner r0.token r4 into r5 as PrivateToken.record;
    output r3 as PrivateToken.record;
    output r5 as PrivateToken.record;

function transfer_public_to_private:
    input r0 as field.public;
    input r1 as address.private;
    input r2 as u128.public;
    cast r1 r0 r2 into r3 as PrivateToken.record;
    async transfer_public_to_private r0 self.caller r2 into r4;
    output r3 as PrivateToken.record;
    output r4 as hialstestv1.aleo/transfer_public_to_private.future;

finalize transfer_public_to_private:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as u128.public;
    contains tokens[r0] into r3;
    assert.eq r3 true ;
    cast r0 r1 into r4 as BalanceKeyData;
    hash.bhp256 r4 into r5 as field;
    get balances[r5] into r6;
    sub r6 r2 into r7;
    set r7 into balances[r5];

function transfer_private_to_public:
    input r0 as PrivateToken.record;
    input r1 as address.public;
    input r2 as u128.public;
    sub r0.amount r2 into r3;
    cast r0.owner r0.token r3 into r4 as PrivateToken.record;
    async transfer_private_to_public r0.token r1 r2 into r5;
    output r4 as PrivateToken.record;
    output r5 as hialstestv1.aleo/transfer_private_to_public.future;

finalize transfer_private_to_public:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as u128.public;
    contains tokens[r0] into r3;
    assert.eq r3 true ;
    cast r0 r1 into r4 as BalanceKeyData;
    hash.bhp256 r4 into r5 as field;
    get.or_use balances[r5] 0u128 into r6;
    add r6 r2 into r7;
    set r7 into balances[r5];

function join:
    input r0 as PrivateToken.record;
    input r1 as PrivateToken.record;
    assert.eq r0.token r1.token ;
    add r0.amount r1.amount into r2;
    cast r0.owner r0.token r2 into r3 as PrivateToken.record;
    output r3 as PrivateToken.record;

function change_token_admin:
    input r0 as field.public;
    input r1 as address.public;
    async change_token_admin self.caller r0 r1 into r2;
    output r2 as hialstestv1.aleo/change_token_admin.future;

finalize change_token_admin:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as address.public;
    get tokens[r1] into r3;
    assert.eq r0 r3.admin ;
    cast r3.name r3.symbol r3.decimals r3.total_supply r2 r3.mintable r3.burnable into r4 as TokenInfo;
    set r4 into tokens[r1];

function renounce_mintable:
    input r0 as field.public;
    async renounce_mintable self.caller r0 into r1;
    output r1 as hialstestv1.aleo/renounce_mintable.future;

finalize renounce_mintable:
    input r0 as address.public;
    input r1 as field.public;
    get tokens[r1] into r2;
    assert.eq r0 r2.admin ;
    assert.eq r2.mintable true ;
    cast r2.name r2.symbol r2.decimals r2.total_supply r2.admin false r2.burnable into r3 as TokenInfo;
    set r3 into tokens[r1];

function renounce_burnable:
    input r0 as field.public;
    async renounce_burnable self.caller r0 into r1;
    output r1 as hialstestv1.aleo/renounce_burnable.future;

finalize renounce_burnable:
    input r0 as address.public;
    input r1 as field.public;
    get tokens[r1] into r2;
    assert.eq r0 r2.admin ;
    assert.eq r2.burnable true ;
    cast r2.name r2.symbol r2.decimals r2.total_supply r2.admin r2.mintable false into r3 as TokenInfo;
    set r3 into tokens[r1];

function mint_public:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as u128.public;
    async mint_public self.caller r0 r1 r2 into r3;
    output r3 as hialstestv1.aleo/mint_public.future;

finalize mint_public:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as address.public;
    input r3 as u128.public;
    get tokens[r1] into r4;
    assert.eq r0 r4.admin ;
    assert.eq r4.mintable true ;
    add r4.total_supply r3 into r5;
    cast r4.name r4.symbol r4.decimals r5 r4.admin r4.mintable r4.burnable into r6 as TokenInfo;
    set r6 into tokens[r1];
    cast r1 r2 into r7 as BalanceKeyData;
    hash.bhp256 r7 into r8 as field;
    get.or_use balances[r8] 0u128 into r9;
    add r9 r3 into r10;
    set r10 into balances[r8];

function mint_private:
    input r0 as field.public;
    input r1 as address.private;
    input r2 as u128.public;
    cast r1 r0 r2 into r3 as PrivateToken.record;
    async mint_private self.caller r0 r2 into r4;
    output r3 as PrivateToken.record;
    output r4 as hialstestv1.aleo/mint_private.future;

finalize mint_private:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as u128.public;
    get tokens[r1] into r3;
    assert.eq r0 r3.admin ;
    assert.eq r3.mintable true ;
    add r3.total_supply r2 into r4;
    cast r3.name r3.symbol r3.decimals r4 r3.admin r3.mintable r3.burnable into r5 as TokenInfo;
    set r5 into tokens[r1];

function burn:
    input r0 as field.public;
    input r1 as u128.public;
    async burn self.caller r0 r1 into r2;
    output r2 as hialstestv1.aleo/burn.future;

finalize burn:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as u128.public;
    get tokens[r1] into r3;
    assert.eq r3.burnable true ;
    sub r3.total_supply r2 into r4;
    cast r3.name r3.symbol r3.decimals r4 r3.admin r3.mintable r3.burnable into r5 as TokenInfo;
    set r5 into tokens[r1];
    cast r1 r0 into r6 as BalanceKeyData;
    hash.bhp256 r6 into r7 as field;
    get balances[r7] into r8;
    sub r8 r2 into r9;
    set r9 into balances[r7];

function burn_from:
    input r0 as field.public;
    input r1 as address.public;
    input r2 as u128.public;
    async burn_from self.caller r0 r1 r2 into r3;
    output r3 as hialstestv1.aleo/burn_from.future;

finalize burn_from:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as address.public;
    input r3 as u128.public;
    get tokens[r1] into r4;
    assert.eq r4.burnable true ;
    cast r1 r2 r0 into r5 as AllowanceKeyData;
    hash.bhp256 r5 into r6 as field;
    get allowance[r6] into r7;
    sub r7 r3 into r8;
    set r8 into allowance[r6];
    sub r4.total_supply r3 into r9;
    cast r4.name r4.symbol r4.decimals r9 r4.admin r4.mintable r4.burnable into r10 as TokenInfo;
    set r10 into tokens[r1];
    cast r1 r2 into r11 as BalanceKeyData;
    hash.bhp256 r11 into r12 as field;
    get balances[r12] into r13;
    sub r13 r3 into r14;
    set r14 into balances[r12];

function init:
    input r0 as address.private;
    assert.eq self.caller aleo1uldp2afc9gnfsxd0r2svaecax8quutny5j6ns2qa80yp5uhsac9q35h7h6 ;
    async init r0 into r1;
    output r1 as hialstestv1.aleo/init.future;

finalize init:
    input r0 as address.public;
    contains global_state[true] into r1;
    not r1 into r2;
    assert.eq r2 true ;
    cast r0 into r3 as GlobalState;
    set r3 into global_state[true];

function change_admin:
    input r0 as address.public;
    async change_admin self.caller r0 into r1;
    output r1 as hialstestv1.aleo/change_admin.future;

finalize change_admin:
    input r0 as address.public;
    input r1 as address.public;
    get global_state[true] into r2;
    assert.eq r0 r2.admin ;
    cast r1 into r3 as GlobalState;
    set r3 into global_state[true];

function create_pair:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    lt r0 r1 into r5;
    assert.eq r5 true ;
    gt r2 0u128 into r6;
    assert.eq r6 true ;
    gt r3 0u128 into r7;
    assert.eq r7 true ;
    async create_pair self.caller r0 r1 r2 r3 r4 into r8;
    output r8 as hialstestv1.aleo/create_pair.future;

finalize create_pair:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as field.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as address.public;
    lt r1 r2 into r6;
    assert.eq r6 true ;
    cast r1 r2 into r7 as PairKeyData;
    hash.bhp256 r7 into r8 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r8 into r9 as TokenIdData;
    hash.bhp256 r9 into r10 as field;
    mul r3 r4 into r11;
    is.eq r11 0u128 into r12;
    shr r11 64u32 into r13;
    gt r13 0u128 into r14;
    shr r11 64u32 into r15;
    add 0u32 64u32 into r16;
    ternary r14 r15 r11 into r17;
    ternary r14 r16 0u32 into r18;
    shr r17 32u32 into r19;
    gt r19 0u128 into r20;
    shr r17 32u32 into r21;
    add r18 32u32 into r22;
    ternary r20 r21 r17 into r23;
    ternary r20 r22 r18 into r24;
    shr r23 16u32 into r25;
    gt r25 0u128 into r26;
    shr r23 16u32 into r27;
    add r24 16u32 into r28;
    ternary r26 r27 r23 into r29;
    ternary r26 r28 r24 into r30;
    shr r29 8u32 into r31;
    gt r31 0u128 into r32;
    shr r29 8u32 into r33;
    add r30 8u32 into r34;
    ternary r32 r33 r29 into r35;
    ternary r32 r34 r30 into r36;
    shr r35 4u32 into r37;
    gt r37 0u128 into r38;
    shr r35 4u32 into r39;
    add r36 4u32 into r40;
    ternary r38 r39 r35 into r41;
    ternary r38 r40 r36 into r42;
    shr r41 2u32 into r43;
    gt r43 0u128 into r44;
    shr r41 2u32 into r45;
    add r42 2u32 into r46;
    ternary r44 r45 r41 into r47;
    ternary r44 r46 r42 into r48;
    shr r47 1u32 into r49;
    gt r49 0u128 into r50;
    add r48 1u32 into r51;
    ternary r50 r51 r48 into r52;
    div r52 2u32 into r53;
    shl 1u128 r53 into r54;
    div r11 r54 into r55;
    add r54 r55 into r56;
    shr r56 1u32 into r57;
    div r11 r57 into r58;
    add r57 r58 into r59;
    shr r59 1u32 into r60;
    div r11 r60 into r61;
    add r60 r61 into r62;
    shr r62 1u32 into r63;
    div r11 r63 into r64;
    add r63 r64 into r65;
    shr r65 1u32 into r66;
    div r11 r66 into r67;
    add r66 r67 into r68;
    shr r68 1u32 into r69;
    div r11 r69 into r70;
    add r69 r70 into r71;
    shr r71 1u32 into r72;
    div r11 r72 into r73;
    add r72 r73 into r74;
    shr r74 1u32 into r75;
    div r11 r75 into r76;
    lt r75 r76 into r77;
    ternary r77 r75 r76 into r78;
    ternary r12 0u128 r78 into r79;
    gt r79 0u128 into r80;
    assert.eq r80 true ;
    cast 5183377571718029925300968712562field 4281168field 6u8 0u128 aleo1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq3ljyzc false false into r81 as TokenInfo;
    get.or_use tokens[r10] r81 into r82;
    assert.eq r82.total_supply 0u128 ;
    cast 0u128 0u128 into r83 as Pair;
    get.or_use pairs[r10] r83 into r84;
    cast r1 r0 into r85 as BalanceKeyData;
    hash.bhp256 r85 into r86 as field;
    get balances[r86] into r87;
    sub r87 r3 into r88;
    set r88 into balances[r86];
    cast r2 r0 into r89 as BalanceKeyData;
    hash.bhp256 r89 into r90 as field;
    get balances[r90] into r91;
    sub r91 r4 into r92;
    set r92 into balances[r90];
    cast r10 r5 into r93 as BalanceKeyData;
    hash.bhp256 r93 into r94 as field;
    get.or_use balances[r94] 0u128 into r95;
    add r95 r79 into r96;
    set r96 into balances[r94];
    add r82.total_supply r79 into r97;
    cast r82.name r82.symbol r82.decimals r97 r82.admin r82.mintable r82.burnable into r98 as TokenInfo;
    set r98 into tokens[r10];
    add r84.reserve_a r3 into r99;
    add r84.reserve_b r4 into r100;
    cast r99 r100 into r101 as Pair;
    set r101 into pairs[r10];

function create_pair_privately:
    input r0 as PrivateToken.record;
    input r1 as PrivateToken.record;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.private;
    input r5 as u128.public;
    lt r0.token r1.token into r6;
    assert.eq r6 true ;
    gt r2 0u128 into r7;
    assert.eq r7 true ;
    gt r3 0u128 into r8;
    assert.eq r8 true ;
    gt r5 0u128 into r9;
    assert.eq r9 true ;
    sub r0.amount r2 into r10;
    cast r0.owner r0.token r10 into r11 as PrivateToken.record;
    sub r1.amount r3 into r12;
    cast r1.owner r1.token r12 into r13 as PrivateToken.record;
    lt r0.token r1.token into r14;
    assert.eq r14 true ;
    cast r0.token r1.token into r15 as PairKeyData;
    hash.bhp256 r15 into r16 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r16 into r17 as TokenIdData;
    hash.bhp256 r17 into r18 as field;
    cast r4 r18 r5 into r19 as PrivateToken.record;
    async create_pair_privately r0.token r1.token r2 r3 r18 r5 into r20;
    output r19 as PrivateToken.record;
    output r11 as PrivateToken.record;
    output r13 as PrivateToken.record;
    output r20 as hialstestv1.aleo/create_pair_privately.future;

finalize create_pair_privately:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as field.public;
    input r5 as u128.public;
    mul r2 r3 into r6;
    is.eq r6 0u128 into r7;
    shr r6 64u32 into r8;
    gt r8 0u128 into r9;
    shr r6 64u32 into r10;
    add 0u32 64u32 into r11;
    ternary r9 r10 r6 into r12;
    ternary r9 r11 0u32 into r13;
    shr r12 32u32 into r14;
    gt r14 0u128 into r15;
    shr r12 32u32 into r16;
    add r13 32u32 into r17;
    ternary r15 r16 r12 into r18;
    ternary r15 r17 r13 into r19;
    shr r18 16u32 into r20;
    gt r20 0u128 into r21;
    shr r18 16u32 into r22;
    add r19 16u32 into r23;
    ternary r21 r22 r18 into r24;
    ternary r21 r23 r19 into r25;
    shr r24 8u32 into r26;
    gt r26 0u128 into r27;
    shr r24 8u32 into r28;
    add r25 8u32 into r29;
    ternary r27 r28 r24 into r30;
    ternary r27 r29 r25 into r31;
    shr r30 4u32 into r32;
    gt r32 0u128 into r33;
    shr r30 4u32 into r34;
    add r31 4u32 into r35;
    ternary r33 r34 r30 into r36;
    ternary r33 r35 r31 into r37;
    shr r36 2u32 into r38;
    gt r38 0u128 into r39;
    shr r36 2u32 into r40;
    add r37 2u32 into r41;
    ternary r39 r40 r36 into r42;
    ternary r39 r41 r37 into r43;
    shr r42 1u32 into r44;
    gt r44 0u128 into r45;
    add r43 1u32 into r46;
    ternary r45 r46 r43 into r47;
    div r47 2u32 into r48;
    shl 1u128 r48 into r49;
    div r6 r49 into r50;
    add r49 r50 into r51;
    shr r51 1u32 into r52;
    div r6 r52 into r53;
    add r52 r53 into r54;
    shr r54 1u32 into r55;
    div r6 r55 into r56;
    add r55 r56 into r57;
    shr r57 1u32 into r58;
    div r6 r58 into r59;
    add r58 r59 into r60;
    shr r60 1u32 into r61;
    div r6 r61 into r62;
    add r61 r62 into r63;
    shr r63 1u32 into r64;
    div r6 r64 into r65;
    add r64 r65 into r66;
    shr r66 1u32 into r67;
    div r6 r67 into r68;
    add r67 r68 into r69;
    shr r69 1u32 into r70;
    div r6 r70 into r71;
    lt r70 r71 into r72;
    ternary r72 r70 r71 into r73;
    ternary r7 0u128 r73 into r74;
    is.eq r5 r74 into r75;
    assert.eq r75 true ;
    cast 5183377571718029925300968712562field 4281168field 6u8 0u128 aleo1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq3ljyzc false false into r76 as TokenInfo;
    get.or_use tokens[r4] r76 into r77;
    assert.eq r77.total_supply 0u128 ;
    cast 0u128 0u128 into r78 as Pair;
    get.or_use pairs[r4] r78 into r79;
    add r77.total_supply r74 into r80;
    cast r77.name r77.symbol r77.decimals r80 r77.admin r77.mintable r77.burnable into r81 as TokenInfo;
    set r81 into tokens[r4];
    add r79.reserve_a r2 into r82;
    add r79.reserve_b r3 into r83;
    cast r82 r83 into r84 as Pair;
    set r84 into pairs[r4];

function add_liquidity:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as u128.public;
    input r6 as address.public;
    lt r0 r1 into r7;
    assert.eq r7 true ;
    gt r2 0u128 into r8;
    gte r2 r4 into r9;
    and r8 r9 into r10;
    assert.eq r10 true ;
    gt r3 0u128 into r11;
    gte r3 r5 into r12;
    and r11 r12 into r13;
    assert.eq r13 true ;
    async add_liquidity self.caller r0 r1 r2 r3 r4 r5 r6 into r14;
    output r14 as hialstestv1.aleo/add_liquidity.future;

finalize add_liquidity:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as field.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as u128.public;
    input r6 as u128.public;
    input r7 as address.public;
    lt r1 r2 into r8;
    assert.eq r8 true ;
    cast r1 r2 into r9 as PairKeyData;
    hash.bhp256 r9 into r10 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r10 into r11 as TokenIdData;
    hash.bhp256 r11 into r12 as field;
    get pairs[r12] into r13;
    get tokens[r12] into r14;
    mul r3 r14.total_supply into r15;
    div r15 r13.reserve_a into r16;
    mul r4 r14.total_supply into r17;
    div r17 r13.reserve_b into r18;
    lte r16 r18 into r19;
    ternary r19 r16 r18 into r20;
    lte r16 r20 into r21;
    mul r20 r13.reserve_a into r22;
    add r22 r14.total_supply into r23;
    sub r23 1u128 into r24;
    div r24 r14.total_supply into r25;
    ternary r21 r3 r25 into r26;
    lte r18 r20 into r27;
    mul r20 r13.reserve_b into r28;
    add r28 r14.total_supply into r29;
    sub r29 1u128 into r30;
    div r30 r14.total_supply into r31;
    ternary r27 r4 r31 into r32;
    gt r20 0u128 into r33;
    assert.eq r33 true ;
    gte r26 r5 into r34;
    assert.eq r34 true ;
    gte r32 r6 into r35;
    assert.eq r35 true ;
    cast r1 r0 into r36 as BalanceKeyData;
    hash.bhp256 r36 into r37 as field;
    get balances[r37] into r38;
    sub r38 r26 into r39;
    set r39 into balances[r37];
    cast r2 r0 into r40 as BalanceKeyData;
    hash.bhp256 r40 into r41 as field;
    get balances[r41] into r42;
    sub r42 r32 into r43;
    set r43 into balances[r41];
    cast r12 r7 into r44 as BalanceKeyData;
    hash.bhp256 r44 into r45 as field;
    get.or_use balances[r45] 0u128 into r46;
    add r46 r20 into r47;
    set r47 into balances[r45];
    add r14.total_supply r20 into r48;
    cast r14.name r14.symbol r14.decimals r48 r14.admin r14.mintable r14.burnable into r49 as TokenInfo;
    set r49 into tokens[r12];
    add r13.reserve_a r26 into r50;
    add r13.reserve_b r32 into r51;
    cast r50 r51 into r52 as Pair;
    set r52 into pairs[r12];

function add_liquidity_privately:
    input r0 as PrivateToken.record;
    input r1 as PrivateToken.record;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as u128.public;
    input r6 as u128.public;
    input r7 as address.private;
    input r8 as address.public;
    lt r0.token r1.token into r9;
    assert.eq r9 true ;
    gt r2 0u128 into r10;
    gte r2 r4 into r11;
    and r10 r11 into r12;
    assert.eq r12 true ;
    gt r3 0u128 into r13;
    gte r3 r5 into r14;
    and r13 r14 into r15;
    assert.eq r15 true ;
    gt r6 0u128 into r16;
    assert.eq r16 true ;
    sub r0.amount r2 into r17;
    cast r0.owner r0.token r17 into r18 as PrivateToken.record;
    sub r1.amount r3 into r19;
    cast r1.owner r1.token r19 into r20 as PrivateToken.record;
    lt r0.token r1.token into r21;
    assert.eq r21 true ;
    cast r0.token r1.token into r22 as PairKeyData;
    hash.bhp256 r22 into r23 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r23 into r24 as TokenIdData;
    hash.bhp256 r24 into r25 as field;
    cast r7 r25 r6 into r26 as PrivateToken.record;
    async add_liquidity_privately r0.token r1.token r25 r2 r3 r4 r5 r6 r8 into r27;
    output r26 as PrivateToken.record;
    output r18 as PrivateToken.record;
    output r20 as PrivateToken.record;
    output r27 as hialstestv1.aleo/add_liquidity_privately.future;

finalize add_liquidity_privately:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as field.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as u128.public;
    input r6 as u128.public;
    input r7 as u128.public;
    input r8 as address.public;
    get pairs[r2] into r9;
    get tokens[r2] into r10;
    mul r3 r10.total_supply into r11;
    div r11 r9.reserve_a into r12;
    mul r4 r10.total_supply into r13;
    div r13 r9.reserve_b into r14;
    lte r12 r14 into r15;
    ternary r15 r12 r14 into r16;
    lte r12 r16 into r17;
    mul r16 r9.reserve_a into r18;
    add r18 r10.total_supply into r19;
    sub r19 1u128 into r20;
    div r20 r10.total_supply into r21;
    ternary r17 r3 r21 into r22;
    lte r14 r16 into r23;
    mul r16 r9.reserve_b into r24;
    add r24 r10.total_supply into r25;
    sub r25 1u128 into r26;
    div r26 r10.total_supply into r27;
    ternary r23 r4 r27 into r28;
    gte r16 r7 into r29;
    assert.eq r29 true ;
    gte r3 r22 into r30;
    gte r22 r5 into r31;
    and r30 r31 into r32;
    assert.eq r32 true ;
    gte r4 r28 into r33;
    gte r28 r6 into r34;
    and r33 r34 into r35;
    assert.eq r35 true ;
    cast r0 r8 into r36 as BalanceKeyData;
    hash.bhp256 r36 into r37 as field;
    get.or_use balances[r37] 0u128 into r38;
    add r38 r3 into r39;
    sub r39 r22 into r40;
    set r40 into balances[r37];
    cast r1 r8 into r41 as BalanceKeyData;
    hash.bhp256 r41 into r42 as field;
    get.or_use balances[r42] 0u128 into r43;
    add r43 r4 into r44;
    sub r44 r28 into r45;
    set r45 into balances[r42];
    cast r2 r8 into r46 as BalanceKeyData;
    hash.bhp256 r46 into r47 as field;
    get.or_use balances[r47] 0u128 into r48;
    add r48 r16 into r49;
    sub r49 r7 into r50;
    set r50 into balances[r47];
    add r10.total_supply r16 into r51;
    cast r10.name r10.symbol r10.decimals r51 r10.admin r10.mintable r10.burnable into r52 as TokenInfo;
    set r52 into tokens[r2];
    add r9.reserve_a r22 into r53;
    add r9.reserve_b r28 into r54;
    cast r53 r54 into r55 as Pair;
    set r55 into pairs[r2];

function remove_liquidity:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as address.public;
    lt r0 r1 into r6;
    assert.eq r6 true ;
    gt r2 0u128 into r7;
    assert.eq r7 true ;
    async remove_liquidity self.caller r0 r1 r2 r3 r4 r5 into r8;
    output r8 as hialstestv1.aleo/remove_liquidity.future;

finalize remove_liquidity:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as field.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as u128.public;
    input r6 as address.public;
    lt r1 r2 into r7;
    assert.eq r7 true ;
    cast r1 r2 into r8 as PairKeyData;
    hash.bhp256 r8 into r9 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r9 into r10 as TokenIdData;
    hash.bhp256 r10 into r11 as field;
    get tokens[r11] into r12;
    get pairs[r11] into r13;
    mul r3 r13.reserve_a into r14;
    div r14 r12.total_supply into r15;
    mul r3 r13.reserve_b into r16;
    div r16 r12.total_supply into r17;
    gte r15 r4 into r18;
    gte r17 r5 into r19;
    and r18 r19 into r20;
    assert.eq r20 true ;
    gt r15 0u128 into r21;
    gt r17 0u128 into r22;
    or r21 r22 into r23;
    assert.eq r23 true ;
    cast r11 r0 into r24 as BalanceKeyData;
    hash.bhp256 r24 into r25 as field;
    get balances[r25] into r26;
    sub r26 r3 into r27;
    set r27 into balances[r25];
    sub r12.total_supply r3 into r28;
    cast r12.name r12.symbol r12.decimals r28 r12.admin r12.mintable r12.burnable into r29 as TokenInfo;
    set r29 into tokens[r11];
    sub r13.reserve_a r15 into r30;
    sub r13.reserve_b r17 into r31;
    cast r30 r31 into r32 as Pair;
    set r32 into pairs[r11];
    cast r1 r6 into r33 as BalanceKeyData;
    hash.bhp256 r33 into r34 as field;
    cast r2 r6 into r35 as BalanceKeyData;
    hash.bhp256 r35 into r36 as field;
    get.or_use balances[r34] 0u128 into r37;
    add r37 r15 into r38;
    set r38 into balances[r34];
    get.or_use balances[r36] 0u128 into r39;
    add r39 r17 into r40;
    set r40 into balances[r36];

function remove_liquidity_privately:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as PrivateToken.record;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as u128.public;
    input r6 as address.private;
    input r7 as address.public;
    lt r0 r1 into r8;
    assert.eq r8 true ;
    gt r3 0u128 into r9;
    assert.eq r9 true ;
    lt r0 r1 into r10;
    assert.eq r10 true ;
    cast r0 r1 into r11 as PairKeyData;
    hash.bhp256 r11 into r12 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r12 into r13 as TokenIdData;
    hash.bhp256 r13 into r14 as field;
    assert.eq r14 r2.token ;
    cast r6 r0 r4 into r15 as PrivateToken.record;
    cast r6 r1 r5 into r16 as PrivateToken.record;
    sub r2.amount r3 into r17;
    cast r2.owner r14 r17 into r18 as PrivateToken.record;
    async remove_liquidity_privately r0 r1 r14 r3 r4 r5 r7 into r19;
    output r15 as PrivateToken.record;
    output r16 as PrivateToken.record;
    output r18 as PrivateToken.record;
    output r19 as hialstestv1.aleo/remove_liquidity_privately.future;

finalize remove_liquidity_privately:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as field.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as u128.public;
    input r6 as address.public;
    get tokens[r2] into r7;
    get pairs[r2] into r8;
    mul r3 r8.reserve_a into r9;
    div r9 r7.total_supply into r10;
    mul r3 r8.reserve_b into r11;
    div r11 r7.total_supply into r12;
    gte r10 r4 into r13;
    gte r12 r5 into r14;
    and r13 r14 into r15;
    assert.eq r15 true ;
    gt r10 0u128 into r16;
    gt r12 0u128 into r17;
    or r16 r17 into r18;
    assert.eq r18 true ;
    sub r7.total_supply r3 into r19;
    cast r7.name r7.symbol r7.decimals r19 r7.admin r7.mintable r7.burnable into r20 as TokenInfo;
    set r20 into tokens[r2];
    sub r8.reserve_a r10 into r21;
    sub r8.reserve_b r12 into r22;
    cast r21 r22 into r23 as Pair;
    set r23 into pairs[r2];
    cast r0 r6 into r24 as BalanceKeyData;
    hash.bhp256 r24 into r25 as field;
    cast r1 r6 into r26 as BalanceKeyData;
    hash.bhp256 r26 into r27 as field;
    get.or_use balances[r25] 0u128 into r28;
    add r28 r10 into r29;
    sub r29 r4 into r30;
    set r30 into balances[r25];
    get.or_use balances[r27] 0u128 into r31;
    add r31 r12 into r32;
    sub r32 r5 into r33;
    set r33 into balances[r27];

function swap_exact_tokens_for_tokens:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    is.neq r0 r1 into r5;
    assert.eq r5 true ;
    gt r2 0u128 into r6;
    assert.eq r6 true ;
    async swap_exact_tokens_for_tokens self.caller r0 r1 r2 r3 r4 into r7;
    output r7 as hialstestv1.aleo/swap_exact_tokens_for_tokens.future;

finalize swap_exact_tokens_for_tokens:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as field.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as address.public;
    lt r1 r2 into r6;
    ternary r6 r1 r2 into r7;
    lt r1 r2 into r8;
    ternary r8 r2 r1 into r9;
    lt r7 r9 into r10;
    assert.eq r10 true ;
    cast r7 r9 into r11 as PairKeyData;
    hash.bhp256 r11 into r12 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r12 into r13 as TokenIdData;
    hash.bhp256 r13 into r14 as field;
    get pairs[r14] into r15;
    is.eq r7 r1 into r16;
    ternary r16 r15.reserve_a r15.reserve_b into r17;
    is.eq r7 r2 into r18;
    ternary r18 r15.reserve_a r15.reserve_b into r19;
    mul r3 997u128 into r20;
    mul r20 r19 into r21;
    mul r17 1000u128 into r22;
    add r22 r20 into r23;
    div r21 r23 into r24;
    gte r24 r4 into r25;
    assert.eq r25 true ;
    gt r24 0u128 into r26;
    assert.eq r26 true ;
    cast r1 r0 into r27 as BalanceKeyData;
    hash.bhp256 r27 into r28 as field;
    get balances[r28] into r29;
    sub r29 r3 into r30;
    set r30 into balances[r28];
    add r17 r3 into r31;
    sub r19 r24 into r32;
    is.eq r7 r1 into r33;
    ternary r33 r31 r32 into r34;
    is.eq r9 r1 into r35;
    ternary r35 r31 r32 into r36;
    cast r34 r36 into r37 as Pair;
    set r37 into pairs[r14];
    cast r2 r5 into r38 as BalanceKeyData;
    hash.bhp256 r38 into r39 as field;
    get.or_use balances[r39] 0u128 into r40;
    add r40 r24 into r41;
    set r41 into balances[r39];

function swap_exact_private_for_public:
    input r0 as PrivateToken.record;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    is.neq r0.token r1 into r5;
    assert.eq r5 true ;
    gt r2 0u128 into r6;
    assert.eq r6 true ;
    sub r0.amount r2 into r7;
    cast r0.owner r0.token r7 into r8 as PrivateToken.record;
    async swap_exact_private_for_public r0.token r1 r2 r3 r4 into r9;
    output r8 as PrivateToken.record;
    output r9 as hialstestv1.aleo/swap_exact_private_for_public.future;

finalize swap_exact_private_for_public:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    lt r0 r1 into r5;
    ternary r5 r0 r1 into r6;
    lt r0 r1 into r7;
    ternary r7 r1 r0 into r8;
    lt r6 r8 into r9;
    assert.eq r9 true ;
    cast r6 r8 into r10 as PairKeyData;
    hash.bhp256 r10 into r11 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r11 into r12 as TokenIdData;
    hash.bhp256 r12 into r13 as field;
    get pairs[r13] into r14;
    is.eq r6 r0 into r15;
    ternary r15 r14.reserve_a r14.reserve_b into r16;
    is.eq r6 r1 into r17;
    ternary r17 r14.reserve_a r14.reserve_b into r18;
    mul r2 997u128 into r19;
    mul r19 r18 into r20;
    mul r16 1000u128 into r21;
    add r21 r19 into r22;
    div r20 r22 into r23;
    gte r23 r3 into r24;
    assert.eq r24 true ;
    gt r23 0u128 into r25;
    assert.eq r25 true ;
    add r16 r2 into r26;
    sub r18 r23 into r27;
    is.eq r6 r0 into r28;
    ternary r28 r26 r27 into r29;
    is.eq r8 r0 into r30;
    ternary r30 r26 r27 into r31;
    cast r29 r31 into r32 as Pair;
    set r32 into pairs[r13];
    cast r1 r4 into r33 as BalanceKeyData;
    hash.bhp256 r33 into r34 as field;
    get.or_use balances[r34] 0u128 into r35;
    add r35 r23 into r36;
    set r36 into balances[r34];

function swap_exact_private_for_private:
    input r0 as PrivateToken.record;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.private;
    input r5 as address.public;
    is.neq r0.token r1 into r6;
    assert.eq r6 true ;
    gt r2 0u128 into r7;
    assert.eq r7 true ;
    cast r4 r1 r3 into r8 as PrivateToken.record;
    sub r0.amount r2 into r9;
    cast r0.owner r0.token r9 into r10 as PrivateToken.record;
    async swap_exact_private_for_private r0.token r1 r2 r3 r5 into r11;
    output r8 as PrivateToken.record;
    output r10 as PrivateToken.record;
    output r11 as hialstestv1.aleo/swap_exact_private_for_private.future;

finalize swap_exact_private_for_private:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    lt r0 r1 into r5;
    ternary r5 r0 r1 into r6;
    lt r0 r1 into r7;
    ternary r7 r1 r0 into r8;
    lt r6 r8 into r9;
    assert.eq r9 true ;
    cast r6 r8 into r10 as PairKeyData;
    hash.bhp256 r10 into r11 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r11 into r12 as TokenIdData;
    hash.bhp256 r12 into r13 as field;
    get pairs[r13] into r14;
    is.eq r6 r0 into r15;
    ternary r15 r14.reserve_a r14.reserve_b into r16;
    is.eq r6 r1 into r17;
    ternary r17 r14.reserve_a r14.reserve_b into r18;
    mul r2 997u128 into r19;
    mul r19 r18 into r20;
    mul r16 1000u128 into r21;
    add r21 r19 into r22;
    div r20 r22 into r23;
    gte r23 r3 into r24;
    assert.eq r24 true ;
    gt r23 0u128 into r25;
    assert.eq r25 true ;
    add r16 r2 into r26;
    sub r18 r23 into r27;
    is.eq r6 r0 into r28;
    ternary r28 r26 r27 into r29;
    is.eq r8 r0 into r30;
    ternary r30 r26 r27 into r31;
    cast r29 r31 into r32 as Pair;
    set r32 into pairs[r13];
    cast r1 r4 into r33 as BalanceKeyData;
    hash.bhp256 r33 into r34 as field;
    sub r23 r3 into r35;
    get.or_use balances[r34] 0u128 into r36;
    add r36 r35 into r37;
    set r37 into balances[r34];

function swap_tokens_for_exact_tokens:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    is.neq r0 r1 into r5;
    assert.eq r5 true ;
    gt r3 0u128 into r6;
    assert.eq r6 true ;
    async swap_tokens_for_exact_tokens self.caller r0 r1 r2 r3 r4 into r7;
    output r7 as hialstestv1.aleo/swap_tokens_for_exact_tokens.future;

finalize swap_tokens_for_exact_tokens:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as field.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as address.public;
    lt r1 r2 into r6;
    ternary r6 r1 r2 into r7;
    lt r1 r2 into r8;
    ternary r8 r2 r1 into r9;
    lt r7 r9 into r10;
    assert.eq r10 true ;
    cast r7 r9 into r11 as PairKeyData;
    hash.bhp256 r11 into r12 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r12 into r13 as TokenIdData;
    hash.bhp256 r13 into r14 as field;
    get pairs[r14] into r15;
    is.eq r7 r1 into r16;
    ternary r16 r15.reserve_a r15.reserve_b into r17;
    is.eq r7 r2 into r18;
    ternary r18 r15.reserve_a r15.reserve_b into r19;
    mul r17 r4 into r20;
    mul r20 1000u128 into r21;
    sub r19 r4 into r22;
    mul r22 997u128 into r23;
    div r21 r23 into r24;
    add r24 1u128 into r25;
    lte r25 r3 into r26;
    assert.eq r26 true ;
    gt r25 0u128 into r27;
    assert.eq r27 true ;
    cast r1 r0 into r28 as BalanceKeyData;
    hash.bhp256 r28 into r29 as field;
    get balances[r29] into r30;
    sub r30 r25 into r31;
    set r31 into balances[r29];
    add r17 r25 into r32;
    sub r19 r4 into r33;
    is.eq r7 r1 into r34;
    ternary r34 r32 r33 into r35;
    is.eq r9 r1 into r36;
    ternary r36 r32 r33 into r37;
    cast r35 r37 into r38 as Pair;
    set r38 into pairs[r14];
    cast r2 r5 into r39 as BalanceKeyData;
    hash.bhp256 r39 into r40 as field;
    get.or_use balances[r40] 0u128 into r41;
    add r41 r4 into r42;
    set r42 into balances[r40];

function swap_private_for_exact_public:
    input r0 as PrivateToken.record;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    input r5 as address.public;
    is.neq r0.token r1 into r6;
    assert.eq r6 true ;
    gt r3 0u128 into r7;
    assert.eq r7 true ;
    sub r0.amount r2 into r8;
    cast r0.owner r0.token r8 into r9 as PrivateToken.record;
    async swap_private_for_exact_public r0.token r1 r2 r3 r4 r5 into r10;
    output r9 as PrivateToken.record;
    output r10 as hialstestv1.aleo/swap_private_for_exact_public.future;

finalize swap_private_for_exact_public:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    input r5 as address.public;
    lt r0 r1 into r6;
    ternary r6 r0 r1 into r7;
    lt r0 r1 into r8;
    ternary r8 r1 r0 into r9;
    lt r7 r9 into r10;
    assert.eq r10 true ;
    cast r7 r9 into r11 as PairKeyData;
    hash.bhp256 r11 into r12 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r12 into r13 as TokenIdData;
    hash.bhp256 r13 into r14 as field;
    get pairs[r14] into r15;
    is.eq r7 r0 into r16;
    ternary r16 r15.reserve_a r15.reserve_b into r17;
    is.eq r7 r1 into r18;
    ternary r18 r15.reserve_a r15.reserve_b into r19;
    mul r17 r3 into r20;
    mul r20 1000u128 into r21;
    sub r19 r3 into r22;
    mul r22 997u128 into r23;
    div r21 r23 into r24;
    add r24 1u128 into r25;
    lte r25 r2 into r26;
    assert.eq r26 true ;
    gt r25 0u128 into r27;
    assert.eq r27 true ;
    cast r0 r5 into r28 as BalanceKeyData;
    hash.bhp256 r28 into r29 as field;
    sub r2 r25 into r30;
    get.or_use balances[r29] 0u128 into r31;
    add r31 r30 into r32;
    set r32 into balances[r29];
    add r17 r25 into r33;
    sub r19 r3 into r34;
    is.eq r7 r0 into r35;
    ternary r35 r33 r34 into r36;
    is.eq r9 r0 into r37;
    ternary r37 r33 r34 into r38;
    cast r36 r38 into r39 as Pair;
    set r39 into pairs[r14];
    cast r1 r4 into r40 as BalanceKeyData;
    hash.bhp256 r40 into r41 as field;
    get.or_use balances[r41] 0u128 into r42;
    add r42 r3 into r43;
    set r43 into balances[r41];

function swap_private_for_exact_private:
    input r0 as PrivateToken.record;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.private;
    input r5 as address.public;
    is.neq r0.token r1 into r6;
    assert.eq r6 true ;
    gt r3 0u128 into r7;
    assert.eq r7 true ;
    cast r4 r1 r3 into r8 as PrivateToken.record;
    sub r0.amount r2 into r9;
    cast r0.owner r0.token r9 into r10 as PrivateToken.record;
    async swap_private_for_exact_private r0.token r1 r2 r3 r5 into r11;
    output r8 as PrivateToken.record;
    output r10 as PrivateToken.record;
    output r11 as hialstestv1.aleo/swap_private_for_exact_private.future;

finalize swap_private_for_exact_private:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as address.public;
    lt r0 r1 into r5;
    ternary r5 r0 r1 into r6;
    lt r0 r1 into r7;
    ternary r7 r1 r0 into r8;
    lt r6 r8 into r9;
    assert.eq r9 true ;
    cast r6 r8 into r10 as PairKeyData;
    hash.bhp256 r10 into r11 as u128;
    cast aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp aleo1hrmzd3fzwzvpt7xqk7m3j39r0sfm03h56ravct2y89zad0ranvgsvuy2dp r11 into r12 as TokenIdData;
    hash.bhp256 r12 into r13 as field;
    get pairs[r13] into r14;
    is.eq r6 r0 into r15;
    ternary r15 r14.reserve_a r14.reserve_b into r16;
    is.eq r6 r1 into r17;
    ternary r17 r14.reserve_a r14.reserve_b into r18;
    mul r16 r3 into r19;
    mul r19 1000u128 into r20;
    sub r18 r3 into r21;
    mul r21 997u128 into r22;
    div r20 r22 into r23;
    add r23 1u128 into r24;
    lte r24 r2 into r25;
    assert.eq r25 true ;
    gt r24 0u128 into r26;
    assert.eq r26 true ;
    cast r0 r4 into r27 as BalanceKeyData;
    hash.bhp256 r27 into r28 as field;
    sub r2 r24 into r29;
    get.or_use balances[r28] 0u128 into r30;
    add r30 r29 into r31;
    set r31 into balances[r28];
    add r16 r24 into r32;
    sub r18 r3 into r33;
    is.eq r6 r0 into r34;
    ternary r34 r32 r33 into r35;
    is.eq r8 r0 into r36;
    ternary r36 r32 r33 into r37;
    cast r35 r37 into r38 as Pair;
    set r38 into pairs[r13];
