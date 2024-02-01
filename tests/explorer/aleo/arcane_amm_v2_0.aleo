import credits.aleo;
import arcanetoken.aleo;

program arcane_amm_v2_0.aleo;

struct PoolKey:
    token1 as u64;
    token2 as u64;

record PoolAdmin:
    owner as address.private;
    pool_key as field.private;

struct PoolInfo:
    id as field;
    token1_id as u64;
    token2_id as u64;
    reserve1 as u128;
    reserve2 as u128;
    lp_total_supply as u128;
    swap_fee as u128;

struct DepositKey:
    holder as address;
    pool_key as field;
    deposit_id as field;

record LpTokenReceipt:
    owner as address.private;
    token1_id as u64.private;
    token2_id as u64.private;
    deposit_id as field.private;

struct ExtraAmount:
    token_id as u64;
    token_amount as u128;

record ExtraAmountVoucher:
    owner as address.private;
    token_id as u64.private;
    voucher as field.private;

mapping amm_pools:
    key as field.public;
    value as PoolInfo.public;

mapping amm_deposits:
    key as field.public;
    value as u128.public;

mapping amm_extras:
    key as field.public;
    value as ExtraAmount.public;

function create_pool:
    input r0 as address.private;
    input r1 as arcanetoken.aleo/ArcaneToken.record;
    input r2 as u128.private;
    input r3 as arcanetoken.aleo/ArcaneToken.record;
    input r4 as u128.private;
    input r5 as u128.private;
    gt r2 0u128 into r6;
    gt r4 0u128 into r7;
    and r6 r7 into r8;
    assert.eq r8 true ;
    lte r5 10000u128 into r9;
    assert.eq r9 true ;
    is.neq r1.token_id r3.token_id into r10;
    assert.eq r10 true ;
    gte r1.amount r2 into r11;
    gte r3.amount r4 into r12;
    and r11 r12 into r13;
    assert.eq r13 true ;
    lt r1.token_id r3.token_id into r14;
    assert.eq r14 true ;
    call arcanetoken.aleo/transfer_private_to_public_arc r1 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r2 into r15 r16;
    call arcanetoken.aleo/transfer_private_to_public_arc r3 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r4 into r17 r18;
    gt r1.token_id r3.token_id into r19;
    ternary r19 r3.token_id r1.token_id into r20;
    lte r1.token_id r3.token_id into r21;
    ternary r21 r3.token_id r1.token_id into r22;
    cast r20 r22 into r23 as PoolKey;
    hash.bhp256 r23 into r24 as field;
    cast r0 r24 into r25 as PoolAdmin.record;
    async create_pool r16 r18 r24 r1.token_id r2 r3.token_id r4 r5 into r26;
    output r25 as PoolAdmin.record;
    output r15 as arcanetoken.aleo/ArcaneToken.record;
    output r17 as arcanetoken.aleo/ArcaneToken.record;
    output r26 as arcane_amm_v2_0.aleo/create_pool.future;

finalize create_pool:
    input r0 as arcanetoken.aleo/transfer_private_to_public_arc.future;
    input r1 as arcanetoken.aleo/transfer_private_to_public_arc.future;
    input r2 as field.public;
    input r3 as u64.public;
    input r4 as u128.public;
    input r5 as u64.public;
    input r6 as u128.public;
    input r7 as u128.public;
    await r0;
    await r1;
    contains amm_pools[r2] into r8;
    not r8 into r9;
    assert.eq r9 true ;
    mul r4 r6 into r10;
    cast r2 r3 r5 r4 r6 r10 r7 into r11 as PoolInfo;
    set r11 into amm_pools[r2];

function transfer_pool_ownership:
    input r0 as PoolAdmin.record;
    input r1 as address.private;
    is.eq r0.owner self.caller into r2;
    assert.eq r2 true ;
    cast r1 r0.pool_key into r3 as PoolAdmin.record;
    output r3 as PoolAdmin.record;

function add_amm_liquidity:
    input r0 as address.private;
    input r1 as arcanetoken.aleo/ArcaneToken.record;
    input r2 as u128.private;
    input r3 as u128.private;
    input r4 as arcanetoken.aleo/ArcaneToken.record;
    input r5 as u128.private;
    input r6 as u128.private;
    input r7 as field.private;
    call arcanetoken.aleo/transfer_private_to_public_arc r1 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r2 into r8 r9;
    call arcanetoken.aleo/transfer_private_to_public_arc r4 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r5 into r10 r11;
    cast r0 r1.token_id r4.token_id r7 into r12 as LpTokenReceipt.record;
    async add_amm_liquidity r9 r11 r7 r1.token_id r2 r3 r4.token_id r5 r6 into r13;
    output r8 as arcanetoken.aleo/ArcaneToken.record;
    output r10 as arcanetoken.aleo/ArcaneToken.record;
    output r12 as LpTokenReceipt.record;
    output r13 as arcane_amm_v2_0.aleo/add_amm_liquidity.future;

finalize add_amm_liquidity:
    input r0 as arcanetoken.aleo/transfer_private_to_public_arc.future;
    input r1 as arcanetoken.aleo/transfer_private_to_public_arc.future;
    input r2 as field.public;
    input r3 as u64.public;
    input r4 as u128.public;
    input r5 as u128.public;
    input r6 as u64.public;
    input r7 as u128.public;
    input r8 as u128.public;
    await r0;
    await r1;
    gt r3 r6 into r9;
    ternary r9 r6 r3 into r10;
    lte r3 r6 into r11;
    ternary r11 r6 r3 into r12;
    cast r10 r12 into r13 as PoolKey;
    hash.bhp256 r13 into r14 as field;
    get amm_pools[r14] into r15;
    mul r4 r15.lp_total_supply into r16;
    div r16 r15.reserve1 into r17;
    mul r7 r15.lp_total_supply into r18;
    div r18 r15.reserve2 into r19;
    lt r17 r19 into r20;
    ternary r20 r17 r19 into r21;
    add r15.reserve1 r4 into r22;
    add r15.reserve2 r7 into r23;
    add r15.lp_total_supply r21 into r24;
    cast r15.id r15.token1_id r15.token2_id r22 r23 r24 r15.swap_fee into r25 as PoolInfo;
    set r25 into amm_pools[r14];
    contains amm_deposits[r2] into r26;
    not r26 into r27;
    assert.eq r27 true ;
    set r21 into amm_deposits[r2];

function remove_amm_liquidity:
    input r0 as address.private;
    input r1 as LpTokenReceipt.record;
    input r2 as u128.private;
    input r3 as u128.private;
    input r4 as field.private;
    input r5 as field.private;
    is.neq r4 r5 into r6;
    assert.eq r6 true ;
    call arcanetoken.aleo/transfer_public_to_private_arc r1.token1_id r0 r2 into r7 r8;
    call arcanetoken.aleo/transfer_public_to_private_arc r1.token2_id r0 r3 into r9 r10;
    cast r0 r1.token1_id r4 into r11 as ExtraAmountVoucher.record;
    cast r0 r1.token2_id r5 into r12 as ExtraAmountVoucher.record;
    async remove_amm_liquidity r8 r10 r1.deposit_id r1.token1_id r1.token2_id r2 r3 r4 r5 into r13;
    output r7 as arcanetoken.aleo/ArcaneToken.record;
    output r9 as arcanetoken.aleo/ArcaneToken.record;
    output r11 as ExtraAmountVoucher.record;
    output r12 as ExtraAmountVoucher.record;
    output r13 as arcane_amm_v2_0.aleo/remove_amm_liquidity.future;

finalize remove_amm_liquidity:
    input r0 as arcanetoken.aleo/transfer_public_to_private_arc.future;
    input r1 as arcanetoken.aleo/transfer_public_to_private_arc.future;
    input r2 as field.public;
    input r3 as u64.public;
    input r4 as u64.public;
    input r5 as u128.public;
    input r6 as u128.public;
    input r7 as field.public;
    input r8 as field.public;
    await r0;
    await r1;
    gt r3 r4 into r9;
    ternary r9 r4 r3 into r10;
    lte r3 r4 into r11;
    ternary r11 r4 r3 into r12;
    cast r10 r12 into r13 as PoolKey;
    hash.bhp256 r13 into r14 as field;
    get amm_pools[r14] into r15;
    get amm_deposits[r2] into r16;
    mul r16 r15.reserve1 into r17;
    div r17 r15.lp_total_supply into r18;
    mul r16 r15.reserve2 into r19;
    div r19 r15.lp_total_supply into r20;
    sub r18 r5 into r21;
    sub r20 r6 into r22;
    contains amm_extras[r7] into r23;
    not r23 into r24;
    assert.eq r24 true ;
    cast r3 r21 into r25 as ExtraAmount;
    set r25 into amm_extras[r7];
    contains amm_extras[r8] into r26;
    not r26 into r27;
    assert.eq r27 true ;
    cast r4 r22 into r28 as ExtraAmount;
    set r28 into amm_extras[r8];
    sub r15.reserve1 r18 into r29;
    sub r15.reserve2 r20 into r30;
    sub r15.lp_total_supply r16 into r31;
    cast r15.id r15.token1_id r15.token2_id r29 r30 r31 r15.swap_fee into r32 as PoolInfo;
    set r32 into amm_pools[r14];
    remove amm_deposits[r2];

function swap_amm:
    input r0 as address.private;
    input r1 as arcanetoken.aleo/ArcaneToken.record;
    input r2 as u128.private;
    input r3 as u64.private;
    input r4 as u128.private;
    input r5 as field.private;
    gt r4 0u128 into r6;
    assert.eq r6 true ;
    call arcanetoken.aleo/transfer_private_to_public_arc r1 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r2 into r7 r8;
    call arcanetoken.aleo/transfer_public_to_private_arc r3 r0 r4 into r9 r10;
    cast r0 r3 r5 into r11 as ExtraAmountVoucher.record;
    async swap_amm r8 r10 r1.token_id r2 r3 r4 r5 into r12;
    output r7 as arcanetoken.aleo/ArcaneToken.record;
    output r9 as arcanetoken.aleo/ArcaneToken.record;
    output r11 as ExtraAmountVoucher.record;
    output r12 as arcane_amm_v2_0.aleo/swap_amm.future;

finalize swap_amm:
    input r0 as arcanetoken.aleo/transfer_private_to_public_arc.future;
    input r1 as arcanetoken.aleo/transfer_public_to_private_arc.future;
    input r2 as u64.public;
    input r3 as u128.public;
    input r4 as u64.public;
    input r5 as u128.public;
    input r6 as field.public;
    await r0;
    await r1;
    gt r2 r4 into r7;
    ternary r7 r4 r2 into r8;
    lte r2 r4 into r9;
    ternary r9 r4 r2 into r10;
    cast r8 r10 into r11 as PoolKey;
    hash.bhp256 r11 into r12 as field;
    get amm_pools[r12] into r13;
    is.eq r13.token1_id r2 into r14;
    ternary r14 r13.reserve1 r13.reserve2 into r15;
    is.eq r13.token2_id r2 into r16;
    ternary r16 r13.reserve1 r13.reserve2 into r17;
    sub 10000u128 r13.swap_fee into r18;
    mul r3 r18 into r19;
    mul r19 r17 into r20;
    mul r15 10000u128 into r21;
    add r21 r19 into r22;
    div r20 r22 into r23;
    gte r23 r5 into r24;
    assert.eq r24 true ;
    sub r23 r5 into r25;
    cast r4 r25 into r26 as ExtraAmount;
    set r26 into amm_extras[r6];
    add r15 r3 into r27;
    sub r17 r23 into r28;
    is.eq r13.token1_id r2 into r29;
    ternary r29 r27 r28 into r30;
    is.eq r13.token2_id r2 into r31;
    ternary r31 r27 r28 into r32;
    cast r13.id r13.token1_id r13.token2_id r30 r32 r13.lp_total_supply r13.swap_fee into r33 as PoolInfo;
    set r33 into amm_pools[r12];

function redeem_voucher:
    input r0 as ExtraAmountVoucher.record;
    input r1 as u128.private;
    call arcanetoken.aleo/transfer_public_to_private_arc r0.token_id r0.owner r1 into r2 r3;
    async redeem_voucher r3 r0.token_id r0.voucher r1 into r4;
    output r2 as arcanetoken.aleo/ArcaneToken.record;
    output r4 as arcane_amm_v2_0.aleo/redeem_voucher.future;

finalize redeem_voucher:
    input r0 as arcanetoken.aleo/transfer_public_to_private_arc.future;
    input r1 as u64.public;
    input r2 as field.public;
    input r3 as u128.public;
    await r0;
    get amm_extras[r2] into r4;
    is.eq r4.token_id r1 into r5;
    is.eq r4.token_amount r3 into r6;
    and r5 r6 into r7;
    assert.eq r7 true ;
    remove amm_extras[r2];

function create_pool_pric:
    input r0 as address.private;
    input r1 as credits.aleo/credits.record;
    input r2 as u64.private;
    input r3 as arcanetoken.aleo/ArcaneToken.record;
    input r4 as u128.private;
    input r5 as u128.private;
    gt r2 0u64 into r6;
    gt r4 0u128 into r7;
    and r6 r7 into r8;
    assert.eq r8 true ;
    lte r5 10000u128 into r9;
    assert.eq r9 true ;
    gte r1.microcredits r2 into r10;
    gte r3.amount r4 into r11;
    and r10 r11 into r12;
    assert.eq r12 true ;
    call credits.aleo/transfer_private_to_public r1 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r2 into r13 r14;
    call arcanetoken.aleo/transfer_private_to_public_arc r3 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r4 into r15 r16;
    gt 0u64 r3.token_id into r17;
    ternary r17 r3.token_id 0u64 into r18;
    lte 0u64 r3.token_id into r19;
    ternary r19 r3.token_id 0u64 into r20;
    cast r18 r20 into r21 as PoolKey;
    hash.bhp256 r21 into r22 as field;
    cast r0 r22 into r23 as PoolAdmin.record;
    cast r2 into r24 as u128;
    async create_pool_pric r14 r16 r22 0u64 r24 r3.token_id r4 r5 into r25;
    output r23 as PoolAdmin.record;
    output r13 as credits.aleo/credits.record;
    output r15 as arcanetoken.aleo/ArcaneToken.record;
    output r25 as arcane_amm_v2_0.aleo/create_pool_pric.future;

finalize create_pool_pric:
    input r0 as credits.aleo/transfer_private_to_public.future;
    input r1 as arcanetoken.aleo/transfer_private_to_public_arc.future;
    input r2 as field.public;
    input r3 as u64.public;
    input r4 as u128.public;
    input r5 as u64.public;
    input r6 as u128.public;
    input r7 as u128.public;
    await r0;
    await r1;
    contains amm_pools[r2] into r8;
    not r8 into r9;
    assert.eq r9 true ;
    mul r4 r6 into r10;
    cast r2 r3 r5 r4 r6 r10 r7 into r11 as PoolInfo;
    set r11 into amm_pools[r2];

function add_amm_liquidity_pric:
    input r0 as address.private;
    input r1 as credits.aleo/credits.record;
    input r2 as u64.private;
    input r3 as arcanetoken.aleo/ArcaneToken.record;
    input r4 as u128.private;
    input r5 as field.private;
    call credits.aleo/transfer_private_to_public r1 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r2 into r6 r7;
    call arcanetoken.aleo/transfer_private_to_public_arc r3 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r4 into r8 r9;
    cast r0 0u64 r3.token_id r5 into r10 as LpTokenReceipt.record;
    cast r2 into r11 as u128;
    async add_amm_liquidity_pric r7 r9 r5 r11 r3.token_id r4 into r12;
    output r6 as credits.aleo/credits.record;
    output r8 as arcanetoken.aleo/ArcaneToken.record;
    output r10 as LpTokenReceipt.record;
    output r12 as arcane_amm_v2_0.aleo/add_amm_liquidity_pric.future;

finalize add_amm_liquidity_pric:
    input r0 as credits.aleo/transfer_private_to_public.future;
    input r1 as arcanetoken.aleo/transfer_private_to_public_arc.future;
    input r2 as field.public;
    input r3 as u128.public;
    input r4 as u64.public;
    input r5 as u128.public;
    await r0;
    await r1;
    gt 0u64 r4 into r6;
    ternary r6 r4 0u64 into r7;
    lte 0u64 r4 into r8;
    ternary r8 r4 0u64 into r9;
    cast r7 r9 into r10 as PoolKey;
    hash.bhp256 r10 into r11 as field;
    get amm_pools[r11] into r12;
    mul r3 r12.lp_total_supply into r13;
    div r13 r12.reserve1 into r14;
    mul r5 r12.lp_total_supply into r15;
    div r15 r12.reserve2 into r16;
    lt r14 r16 into r17;
    ternary r17 r14 r16 into r18;
    add r12.reserve1 r3 into r19;
    add r12.reserve2 r5 into r20;
    add r12.lp_total_supply r18 into r21;
    cast r12.id r12.token1_id r12.token2_id r19 r20 r21 r12.swap_fee into r22 as PoolInfo;
    set r22 into amm_pools[r11];
    contains amm_deposits[r2] into r23;
    not r23 into r24;
    assert.eq r24 true ;
    set r18 into amm_deposits[r2];

function remove_amm_liquidity_pric:
    input r0 as address.private;
    input r1 as LpTokenReceipt.record;
    input r2 as u64.private;
    input r3 as u128.private;
    input r4 as field.private;
    input r5 as field.private;
    is.neq r4 r5 into r6;
    assert.eq r6 true ;
    call credits.aleo/transfer_public_to_private r0 r2 into r7 r8;
    call arcanetoken.aleo/transfer_public_to_private_arc r1.token2_id r0 r3 into r9 r10;
    cast r0 r1.token1_id r4 into r11 as ExtraAmountVoucher.record;
    cast r0 r1.token2_id r5 into r12 as ExtraAmountVoucher.record;
    cast r2 into r13 as u128;
    async remove_amm_liquidity_pric r8 r10 r1.deposit_id r1.token1_id r1.token2_id r13 r3 r4 r5 into r14;
    output r7 as credits.aleo/credits.record;
    output r9 as arcanetoken.aleo/ArcaneToken.record;
    output r11 as ExtraAmountVoucher.record;
    output r12 as ExtraAmountVoucher.record;
    output r14 as arcane_amm_v2_0.aleo/remove_amm_liquidity_pric.future;

finalize remove_amm_liquidity_pric:
    input r0 as credits.aleo/transfer_public_to_private.future;
    input r1 as arcanetoken.aleo/transfer_public_to_private_arc.future;
    input r2 as field.public;
    input r3 as u64.public;
    input r4 as u64.public;
    input r5 as u128.public;
    input r6 as u128.public;
    input r7 as field.public;
    input r8 as field.public;
    await r0;
    await r1;
    gt r3 r4 into r9;
    ternary r9 r4 r3 into r10;
    lte r3 r4 into r11;
    ternary r11 r4 r3 into r12;
    cast r10 r12 into r13 as PoolKey;
    hash.bhp256 r13 into r14 as field;
    get amm_pools[r14] into r15;
    get amm_deposits[r2] into r16;
    mul r16 r15.reserve1 into r17;
    div r17 r15.lp_total_supply into r18;
    mul r16 r15.reserve2 into r19;
    div r19 r15.lp_total_supply into r20;
    sub r18 r5 into r21;
    sub r20 r6 into r22;
    contains amm_extras[r7] into r23;
    not r23 into r24;
    assert.eq r24 true ;
    cast r3 r21 into r25 as ExtraAmount;
    set r25 into amm_extras[r7];
    contains amm_extras[r8] into r26;
    not r26 into r27;
    assert.eq r27 true ;
    cast r4 r22 into r28 as ExtraAmount;
    set r28 into amm_extras[r8];
    sub r15.reserve1 r18 into r29;
    sub r15.reserve2 r20 into r30;
    sub r15.lp_total_supply r16 into r31;
    cast r15.id r15.token1_id r15.token2_id r29 r30 r31 r15.swap_fee into r32 as PoolInfo;
    set r32 into amm_pools[r14];
    remove amm_deposits[r2];

function swap_amm_puc_in:
    input r0 as address.private;
    input r1 as u128.private;
    input r2 as u64.private;
    input r3 as u128.private;
    input r4 as field.private;
    gt r3 0u128 into r5;
    assert.eq r5 true ;
    call arcanetoken.aleo/transfer_public_to_private_arc r2 r0 r3 into r6 r7;
    cast r0 r2 r4 into r8 as ExtraAmountVoucher.record;
    async swap_amm_puc_in r7 r1 r2 r3 r4 into r9;
    output r6 as arcanetoken.aleo/ArcaneToken.record;
    output r8 as ExtraAmountVoucher.record;
    output r9 as arcane_amm_v2_0.aleo/swap_amm_puc_in.future;

finalize swap_amm_puc_in:
    input r0 as arcanetoken.aleo/transfer_public_to_private_arc.future;
    input r1 as u128.public;
    input r2 as u64.public;
    input r3 as u128.public;
    input r4 as field.public;
    await r0;
    gt 0u64 r2 into r5;
    ternary r5 r2 0u64 into r6;
    lte 0u64 r2 into r7;
    ternary r7 r2 0u64 into r8;
    cast r6 r8 into r9 as PoolKey;
    hash.bhp256 r9 into r10 as field;
    get amm_pools[r10] into r11;
    is.eq r11.token1_id 0u64 into r12;
    ternary r12 r11.reserve1 r11.reserve2 into r13;
    is.eq r11.token2_id 0u64 into r14;
    ternary r14 r11.reserve1 r11.reserve2 into r15;
    sub 10000u128 r11.swap_fee into r16;
    mul r1 r16 into r17;
    mul r17 r15 into r18;
    mul r13 10000u128 into r19;
    add r19 r17 into r20;
    div r18 r20 into r21;
    gte r21 r3 into r22;
    assert.eq r22 true ;
    sub r21 r3 into r23;
    cast r2 r23 into r24 as ExtraAmount;
    set r24 into amm_extras[r4];
    add r13 r1 into r25;
    sub r15 r21 into r26;
    is.eq r11.token1_id 0u64 into r27;
    ternary r27 r25 r26 into r28;
    is.eq r11.token2_id 0u64 into r29;
    ternary r29 r25 r26 into r30;
    cast r11.id r11.token1_id r11.token2_id r28 r30 r11.lp_total_supply r11.swap_fee into r31 as PoolInfo;
    set r31 into amm_pools[r10];

function swap_amm_pric_in:
    input r0 as address.private;
    input r1 as credits.aleo/credits.record;
    input r2 as u64.private;
    input r3 as u64.private;
    input r4 as u128.private;
    input r5 as field.private;
    gt r4 0u128 into r6;
    assert.eq r6 true ;
    gt r2 0u64 into r7;
    assert.eq r7 true ;
    call credits.aleo/transfer_private_to_public r1 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r2 into r8 r9;
    call arcanetoken.aleo/transfer_public_to_private_arc r3 r0 r4 into r10 r11;
    cast r0 r3 r5 into r12 as ExtraAmountVoucher.record;
    cast r2 into r13 as u128;
    async swap_amm_pric_in r9 r11 r13 r3 r4 r5 into r14;
    output r8 as credits.aleo/credits.record;
    output r10 as arcanetoken.aleo/ArcaneToken.record;
    output r12 as ExtraAmountVoucher.record;
    output r14 as arcane_amm_v2_0.aleo/swap_amm_pric_in.future;

finalize swap_amm_pric_in:
    input r0 as credits.aleo/transfer_private_to_public.future;
    input r1 as arcanetoken.aleo/transfer_public_to_private_arc.future;
    input r2 as u128.public;
    input r3 as u64.public;
    input r4 as u128.public;
    input r5 as field.public;
    await r0;
    await r1;
    gt 0u64 r3 into r6;
    ternary r6 r3 0u64 into r7;
    lte 0u64 r3 into r8;
    ternary r8 r3 0u64 into r9;
    cast r7 r9 into r10 as PoolKey;
    hash.bhp256 r10 into r11 as field;
    get amm_pools[r11] into r12;
    is.eq r12.token1_id 0u64 into r13;
    ternary r13 r12.reserve1 r12.reserve2 into r14;
    is.eq r12.token2_id 0u64 into r15;
    ternary r15 r12.reserve1 r12.reserve2 into r16;
    sub 10000u128 r12.swap_fee into r17;
    mul r2 r17 into r18;
    mul r18 r16 into r19;
    mul r14 10000u128 into r20;
    add r20 r18 into r21;
    div r19 r21 into r22;
    gte r22 r4 into r23;
    assert.eq r23 true ;
    sub r22 r4 into r24;
    cast r3 r24 into r25 as ExtraAmount;
    set r25 into amm_extras[r5];
    add r14 r2 into r26;
    sub r16 r22 into r27;
    is.eq r12.token1_id 0u64 into r28;
    ternary r28 r26 r27 into r29;
    is.eq r12.token2_id 0u64 into r30;
    ternary r30 r26 r27 into r31;
    cast r12.id r12.token1_id r12.token2_id r29 r31 r12.lp_total_supply r12.swap_fee into r32 as PoolInfo;
    set r32 into amm_pools[r11];

function swap_amm_pric_out:
    input r0 as address.private;
    input r1 as arcanetoken.aleo/ArcaneToken.record;
    input r2 as u128.private;
    input r3 as u64.private;
    input r4 as field.private;
    gt r3 0u64 into r5;
    assert.eq r5 true ;
    call arcanetoken.aleo/transfer_private_to_public_arc r1 aleo1hy8w46tflux7zwpeaw8ny7tq6wkzqux40z75a9ah3q9tqa4t758qltkqu7 r2 into r6 r7;
    call credits.aleo/transfer_public_to_private r0 r3 into r8 r9;
    cast r0 0u64 r4 into r10 as ExtraAmountVoucher.record;
    cast r3 into r11 as u128;
    async swap_amm_pric_out r7 r9 r1.token_id r2 r11 r4 into r12;
    output r6 as arcanetoken.aleo/ArcaneToken.record;
    output r8 as credits.aleo/credits.record;
    output r10 as ExtraAmountVoucher.record;
    output r12 as arcane_amm_v2_0.aleo/swap_amm_pric_out.future;

finalize swap_amm_pric_out:
    input r0 as arcanetoken.aleo/transfer_private_to_public_arc.future;
    input r1 as credits.aleo/transfer_public_to_private.future;
    input r2 as u64.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as field.public;
    await r0;
    await r1;
    gt r2 0u64 into r6;
    ternary r6 0u64 r2 into r7;
    lte r2 0u64 into r8;
    ternary r8 0u64 r2 into r9;
    cast r7 r9 into r10 as PoolKey;
    hash.bhp256 r10 into r11 as field;
    get amm_pools[r11] into r12;
    is.eq r12.token1_id r2 into r13;
    ternary r13 r12.reserve1 r12.reserve2 into r14;
    is.eq r12.token2_id r2 into r15;
    ternary r15 r12.reserve1 r12.reserve2 into r16;
    sub 10000u128 r12.swap_fee into r17;
    mul r3 r17 into r18;
    mul r18 r16 into r19;
    mul r14 10000u128 into r20;
    add r20 r18 into r21;
    div r19 r21 into r22;
    gte r22 r4 into r23;
    assert.eq r23 true ;
    sub r22 r4 into r24;
    cast 0u64 r24 into r25 as ExtraAmount;
    set r25 into amm_extras[r5];
    add r14 r3 into r26;
    sub r16 r22 into r27;
    is.eq r12.token1_id r2 into r28;
    ternary r28 r26 r27 into r29;
    is.eq r12.token2_id r2 into r30;
    ternary r30 r26 r27 into r31;
    cast r12.id r12.token1_id r12.token2_id r29 r31 r12.lp_total_supply r12.swap_fee into r32 as PoolInfo;
    set r32 into amm_pools[r11];

function redeem_voucher_pric:
    input r0 as ExtraAmountVoucher.record;
    input r1 as u64.private;
    is.eq r0.token_id 0u64 into r2;
    assert.eq r2 true ;
    call credits.aleo/transfer_public_to_private r0.owner r1 into r3 r4;
    cast r1 into r5 as u128;
    async redeem_voucher_pric r4 r0.voucher r5 into r6;
    output r3 as credits.aleo/credits.record;
    output r6 as arcane_amm_v2_0.aleo/redeem_voucher_pric.future;

finalize redeem_voucher_pric:
    input r0 as credits.aleo/transfer_public_to_private.future;
    input r1 as field.public;
    input r2 as u128.public;
    await r0;
    get amm_extras[r1] into r3;
    is.eq r3.token_id 0u64 into r4;
    is.eq r3.token_amount r2 into r5;
    and r4 r5 into r6;
    assert.eq r6 true ;
    remove amm_extras[r1];

function init_demo_pools:
    input r0 as field.private;
    async init_demo_pools into r1;
    output r1 as arcane_amm_v2_0.aleo/init_demo_pools.future;

finalize init_demo_pools:
    gt 1u64 2u64 into r0;
    ternary r0 2u64 1u64 into r1;
    lte 1u64 2u64 into r2;
    ternary r2 2u64 1u64 into r3;
    cast r1 r3 into r4 as PoolKey;
    hash.bhp256 r4 into r5 as field;
    mul 100000000000000u128 100000000000000u128 into r6;
    cast r5 1u64 2u64 100000000000000u128 100000000000000u128 r6 10u128 into r7 as PoolInfo;
    contains amm_pools[r5] into r8;
    not r8 into r9;
    assert.eq r9 true ;
    set r7 into amm_pools[r5];
    gt 1u64 3u64 into r10;
    ternary r10 3u64 1u64 into r11;
    lte 1u64 3u64 into r12;
    ternary r12 3u64 1u64 into r13;
    cast r11 r13 into r14 as PoolKey;
    hash.bhp256 r14 into r15 as field;
    mul 100000000000000u128 50000000000u128 into r16;
    cast r15 1u64 3u64 100000000000000u128 50000000000u128 r16 10u128 into r17 as PoolInfo;
    set r17 into amm_pools[r15];
    gt 1u64 4u64 into r18;
    ternary r18 4u64 1u64 into r19;
    lte 1u64 4u64 into r20;
    ternary r20 4u64 1u64 into r21;
    cast r19 r21 into r22 as PoolKey;
    hash.bhp256 r22 into r23 as field;
    mul 100000000000000u128 500000000000u128 into r24;
    cast r23 1u64 4u64 100000000000000u128 500000000000u128 r24 10u128 into r25 as PoolInfo;
    set r25 into amm_pools[r23];
    gt 2u64 3u64 into r26;
    ternary r26 3u64 2u64 into r27;
    lte 2u64 3u64 into r28;
    ternary r28 3u64 2u64 into r29;
    cast r27 r29 into r30 as PoolKey;
    hash.bhp256 r30 into r31 as field;
    mul 100000000000000u128 50000000000u128 into r32;
    cast r31 2u64 3u64 100000000000000u128 50000000000u128 r32 10u128 into r33 as PoolInfo;
    set r33 into amm_pools[r31];
    gt 2u64 4u64 into r34;
    ternary r34 4u64 2u64 into r35;
    lte 2u64 4u64 into r36;
    ternary r36 4u64 2u64 into r37;
    cast r35 r37 into r38 as PoolKey;
    hash.bhp256 r38 into r39 as field;
    mul 100000000000000u128 500000000000u128 into r40;
    cast r39 2u64 4u64 100000000000000u128 500000000000u128 r40 10u128 into r41 as PoolInfo;
    set r41 into amm_pools[r39];
    gt 3u64 4u64 into r42;
    ternary r42 4u64 3u64 into r43;
    lte 3u64 4u64 into r44;
    ternary r44 4u64 3u64 into r45;
    cast r43 r45 into r46 as PoolKey;
    hash.bhp256 r46 into r47 as field;
    mul 50000000000u128 500000000000u128 into r48;
    cast r47 3u64 4u64 50000000000u128 500000000000u128 r48 10u128 into r49 as PoolInfo;
    set r49 into amm_pools[r47];
