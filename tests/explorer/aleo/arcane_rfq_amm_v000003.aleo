program arcane_rfq_amm_v000003.aleo;

record Token:
    owner as address.private;
    amount as u128.private;
    token_id as u64.private;

struct TokenInfo:
    token_id as u64;
    max_supply as u128;
    decimals as u8;

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

struct ExtraAmountKey:
    voucher as field;
    token_id as u64;

struct ExtraAmount:
    token_id as u64;
    token_amount as u128;

record ExtraAmountVoucher:
    owner as address.private;
    token_id as u64.private;
    voucher as field.private;

struct Deposit:
    maker_address as address;
    token_id as u64;

struct Quote:
    amount_in as u128;
    amount_out as u128;
    token_in as u64;
    token_out as u64;
    maker_address as address;
    nonce as field;
    valid_until as u32;

struct Signature:
    challenge as scalar;
    response as scalar;
    pk_sig as group;
    pr_sig as group;
    sk_prf as scalar;

mapping registered_tokens:
    key as u64.public;
    value as TokenInfo.public;

mapping amm_pools:
    key as field.public;
    value as PoolInfo.public;

mapping amm_deposits:
    key as field.public;
    value as u128.public;

mapping amm_extras:
    key as field.public;
    value as ExtraAmount.public;

mapping maker_balances:
    key as field.public;
    value as u128.public;

mapping executed_quotes:
    key as field.public;
    value as u32.public;

function create_token:
    input r0 as u64.private;
    input r1 as u8.private;
    input r2 as u128.private;
    cast r0 r2 r1 into r3 as TokenInfo;
    async create_token r3 into r4;
    output r4 as arcane_rfq_amm_v000003.aleo/create_token.future;

finalize create_token:
    input r0 as TokenInfo.public;
    contains registered_tokens[r0.token_id] into r1;
    not r1 into r2;
    assert.eq r2 true ;
    set r0 into registered_tokens[r0.token_id];

function mint_private:
    input r0 as address.private;
    input r1 as u64.private;
    input r2 as u128.private;
    pow 10u128 6u8 into r3;
    mul 1000u128 r3 into r4;
    lte r2 r4 into r5;
    assert.eq r5 true ;
    cast r0 r2 r1 into r6 as Token.record;
    async mint_private r1 into r7;
    output r6 as Token.record;
    output r7 as arcane_rfq_amm_v000003.aleo/mint_private.future;

finalize mint_private:
    input r0 as u64.public;
    get registered_tokens[r0] into r1;

function create_pool:
    input r0 as address.private;
    input r1 as Token.record;
    input r2 as u128.private;
    input r3 as Token.record;
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
    sub r1.amount r2 into r14;
    cast r0 r14 r1.token_id into r15 as Token.record;
    sub r3.amount r4 into r16;
    cast r0 r16 r3.token_id into r17 as Token.record;
    gt r1.token_id r3.token_id into r18;
    ternary r18 r3.owner r1.owner into r19;
    ternary r18 r3.amount r1.amount into r20;
    ternary r18 r3.token_id r1.token_id into r21;
    cast r19 r20 r21 into r22 as Token.record;
    lt r1.token_id r3.token_id into r23;
    ternary r23 r3.owner r1.owner into r24;
    ternary r23 r3.amount r1.amount into r25;
    ternary r23 r3.token_id r1.token_id into r26;
    cast r24 r25 r26 into r27 as Token.record;
    gt r1.token_id r3.token_id into r28;
    ternary r28 r4 r2 into r29;
    lt r1.token_id r3.token_id into r30;
    ternary r30 r4 r2 into r31;
    gt r22.token_id r27.token_id into r32;
    ternary r32 r27.token_id r22.token_id into r33;
    lte r22.token_id r27.token_id into r34;
    ternary r34 r27.token_id r22.token_id into r35;
    cast r33 r35 into r36 as PoolKey;
    hash.bhp256 r36 into r37 as field;
    cast r0 r37 into r38 as PoolAdmin.record;
    async create_pool r37 r22.token_id r29 r27.token_id r31 r5 into r39;
    output r38 as PoolAdmin.record;
    output r15 as Token.record;
    output r17 as Token.record;
    output r39 as arcane_rfq_amm_v000003.aleo/create_pool.future;

finalize create_pool:
    input r0 as field.public;
    input r1 as u64.public;
    input r2 as u128.public;
    input r3 as u64.public;
    input r4 as u128.public;
    input r5 as u128.public;
    contains amm_pools[r0] into r6;
    not r6 into r7;
    assert.eq r7 true ;
    mul r2 r4 into r8;
    cast r0 r1 r3 r2 r4 r8 r5 into r9 as PoolInfo;
    set r9 into amm_pools[r0];

function transfer_pool_ownership:
    input r0 as PoolAdmin.record;
    input r1 as address.private;
    is.eq r0.owner self.caller into r2;
    assert.eq r2 true ;
    cast r1 r0.pool_key into r3 as PoolAdmin.record;
    output r3 as PoolAdmin.record;

function add_amm_liquidity:
    input r0 as address.private;
    input r1 as Token.record;
    input r2 as u128.private;
    input r3 as u128.private;
    input r4 as Token.record;
    input r5 as u128.private;
    input r6 as u128.private;
    input r7 as field.private;
    sub r1.amount r2 into r8;
    sub r4.amount r5 into r9;
    cast r1.owner r8 r1.token_id into r10 as Token.record;
    cast r4.owner r9 r4.token_id into r11 as Token.record;
    cast r0 r1.token_id r4.token_id r7 into r12 as LpTokenReceipt.record;
    async add_amm_liquidity r7 r1.token_id r2 r3 r4.token_id r5 r6 into r13;
    output r10 as Token.record;
    output r11 as Token.record;
    output r12 as LpTokenReceipt.record;
    output r13 as arcane_rfq_amm_v000003.aleo/add_amm_liquidity.future;

finalize add_amm_liquidity:
    input r0 as field.public;
    input r1 as u64.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as u64.public;
    input r5 as u128.public;
    input r6 as u128.public;
    gt r1 r4 into r7;
    ternary r7 r4 r1 into r8;
    lte r1 r4 into r9;
    ternary r9 r4 r1 into r10;
    cast r8 r10 into r11 as PoolKey;
    hash.bhp256 r11 into r12 as field;
    get amm_pools[r12] into r13;
    mul r2 r13.lp_total_supply into r14;
    div r14 r13.reserve1 into r15;
    mul r5 r13.lp_total_supply into r16;
    div r16 r13.reserve2 into r17;
    lt r15 r17 into r18;
    ternary r18 r15 r17 into r19;
    add r13.reserve1 r2 into r20;
    add r13.reserve2 r5 into r21;
    add r13.lp_total_supply r19 into r22;
    cast r13.id r13.token1_id r13.token2_id r20 r21 r22 r13.swap_fee into r23 as PoolInfo;
    set r23 into amm_pools[r12];
    contains amm_deposits[r0] into r24;
    not r24 into r25;
    assert.eq r25 true ;
    set r19 into amm_deposits[r0];

function remove_amm_liquidity:
    input r0 as address.private;
    input r1 as LpTokenReceipt.record;
    input r2 as u128.private;
    input r3 as u128.private;
    input r4 as field.private;
    input r5 as field.private;
    is.neq r4 r5 into r6;
    assert.eq r6 true ;
    cast r0 r2 r1.token1_id into r7 as Token.record;
    cast r0 r3 r1.token2_id into r8 as Token.record;
    cast r0 r1.token1_id r4 into r9 as ExtraAmountVoucher.record;
    cast r0 r1.token2_id r5 into r10 as ExtraAmountVoucher.record;
    async remove_amm_liquidity r1.deposit_id r1.token1_id r1.token2_id r2 r3 r4 r5 into r11;
    output r7 as Token.record;
    output r8 as Token.record;
    output r9 as ExtraAmountVoucher.record;
    output r10 as ExtraAmountVoucher.record;
    output r11 as arcane_rfq_amm_v000003.aleo/remove_amm_liquidity.future;

finalize remove_amm_liquidity:
    input r0 as field.public;
    input r1 as u64.public;
    input r2 as u64.public;
    input r3 as u128.public;
    input r4 as u128.public;
    input r5 as field.public;
    input r6 as field.public;
    gt r1 r2 into r7;
    ternary r7 r2 r1 into r8;
    lte r1 r2 into r9;
    ternary r9 r2 r1 into r10;
    cast r8 r10 into r11 as PoolKey;
    hash.bhp256 r11 into r12 as field;
    get amm_pools[r12] into r13;
    get amm_deposits[r0] into r14;
    mul r14 r13.reserve1 into r15;
    div r15 r13.lp_total_supply into r16;
    mul r14 r13.reserve2 into r17;
    div r17 r13.lp_total_supply into r18;
    sub r16 r3 into r19;
    sub r18 r4 into r20;
    contains amm_extras[r5] into r21;
    not r21 into r22;
    assert.eq r22 true ;
    cast r1 r19 into r23 as ExtraAmount;
    set r23 into amm_extras[r5];
    contains amm_extras[r6] into r24;
    not r24 into r25;
    assert.eq r25 true ;
    cast r2 r20 into r26 as ExtraAmount;
    set r26 into amm_extras[r6];
    sub r13.reserve1 r16 into r27;
    sub r13.reserve2 r18 into r28;
    sub r13.lp_total_supply r14 into r29;
    cast r13.id r13.token1_id r13.token2_id r27 r28 r29 r13.swap_fee into r30 as PoolInfo;
    set r30 into amm_pools[r12];
    remove amm_deposits[r0];

function swap_amm:
    input r0 as address.private;
    input r1 as Token.record;
    input r2 as u128.private;
    input r3 as u64.private;
    input r4 as u128.private;
    input r5 as field.private;
    gt r4 0u128 into r6;
    assert.eq r6 true ;
    sub r1.amount r2 into r7;
    cast r1.owner r7 r1.token_id into r8 as Token.record;
    cast r0 r4 r3 into r9 as Token.record;
    cast r0 r3 r5 into r10 as ExtraAmountVoucher.record;
    async swap_amm r1.token_id r2 r3 r4 r5 into r11;
    output r8 as Token.record;
    output r9 as Token.record;
    output r10 as ExtraAmountVoucher.record;
    output r11 as arcane_rfq_amm_v000003.aleo/swap_amm.future;

finalize swap_amm:
    input r0 as u64.public;
    input r1 as u128.public;
    input r2 as u64.public;
    input r3 as u128.public;
    input r4 as field.public;
    gt r0 r2 into r5;
    ternary r5 r2 r0 into r6;
    lte r0 r2 into r7;
    ternary r7 r2 r0 into r8;
    cast r6 r8 into r9 as PoolKey;
    hash.bhp256 r9 into r10 as field;
    get amm_pools[r10] into r11;
    is.eq r11.token1_id r0 into r12;
    ternary r12 r11.reserve1 r11.reserve2 into r13;
    is.eq r11.token2_id r0 into r14;
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
    is.eq r11.token1_id r0 into r27;
    ternary r27 r25 r26 into r28;
    is.eq r11.token2_id r0 into r29;
    ternary r29 r25 r26 into r30;
    cast r11.id r11.token1_id r11.token2_id r28 r30 r11.lp_total_supply r11.swap_fee into r31 as PoolInfo;
    set r31 into amm_pools[r10];

function redeem_voucher:
    input r0 as ExtraAmountVoucher.record;
    input r1 as u128.private;
    cast r0.owner r1 r0.token_id into r2 as Token.record;
    async redeem_voucher r0.token_id r0.voucher r1 into r3;
    output r2 as Token.record;
    output r3 as arcane_rfq_amm_v000003.aleo/redeem_voucher.future;

finalize redeem_voucher:
    input r0 as u64.public;
    input r1 as field.public;
    input r2 as u128.public;
    cast r1 r0 into r3 as ExtraAmountKey;
    hash.bhp256 r3 into r4 as field;
    get amm_extras[r4] into r5;
    is.eq r5.token_id r0 into r6;
    is.eq r5.token_amount r2 into r7;
    and r6 r7 into r8;
    assert.eq r8 true ;
    remove amm_extras[r4];

closure get_deposit_id:
    input r0 as address;
    input r1 as u64;
    cast r0 r1 into r2 as Deposit;
    hash.psd8 r2 into r3 as field;
    output r3 as field;

function add_rfq_liquidity:
    input r0 as Token.record;
    input r1 as address.private;
    input r2 as u128.private;
    call get_deposit_id r1 r0.token_id into r3;
    sub r0.amount r2 into r4;
    cast r0.owner r4 r0.token_id into r5 as Token.record;
    async add_rfq_liquidity r3 r2 into r6;
    output r5 as Token.record;
    output r6 as arcane_rfq_amm_v000003.aleo/add_rfq_liquidity.future;

finalize add_rfq_liquidity:
    input r0 as field.public;
    input r1 as u128.public;
    get.or_use maker_balances[r0] 0u128 into r2;
    add r2 r1 into r3;
    set r3 into maker_balances[r0];

function remove_rfq_liquidity:
    input r0 as u64.private;
    input r1 as u128.private;
    call get_deposit_id self.caller r0 into r2;
    cast self.caller r1 r0 into r3 as Token.record;
    async remove_rfq_liquidity r2 r1 into r4;
    output r3 as Token.record;
    output r4 as arcane_rfq_amm_v000003.aleo/remove_rfq_liquidity.future;

finalize remove_rfq_liquidity:
    input r0 as field.public;
    input r1 as u128.public;
    get maker_balances[r0] into r2;
    gte r2 r1 into r3;
    assert.eq r3 true ;
    sub r2 r1 into r4;
    set r4 into maker_balances[r0];

function init_demo_market_maker:
    input r0 as field.private;
    call get_deposit_id aleo1r3qlsxnuux6rkrhk24rktdtzu7kjr3c2fw5fvtp6a9dwghe0xgzs9c2nhu 1u64 into r1;
    call get_deposit_id aleo1r3qlsxnuux6rkrhk24rktdtzu7kjr3c2fw5fvtp6a9dwghe0xgzs9c2nhu 2u64 into r2;
    call get_deposit_id aleo1r3qlsxnuux6rkrhk24rktdtzu7kjr3c2fw5fvtp6a9dwghe0xgzs9c2nhu 3u64 into r3;
    call get_deposit_id aleo1r3qlsxnuux6rkrhk24rktdtzu7kjr3c2fw5fvtp6a9dwghe0xgzs9c2nhu 4u64 into r4;
    add r0 1field into r5;
    async init_demo_market_maker r1 r2 r3 r4 into r6;
    output r5 as field.private;
    output r6 as arcane_rfq_amm_v000003.aleo/init_demo_market_maker.future;

finalize init_demo_market_maker:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as field.public;
    input r3 as field.public;
    pow 10u128 6u8 into r4;
    mul 1000000u128 r4 into r5;
    set r5 into maker_balances[r0];
    pow 10u128 6u8 into r6;
    mul 1000000u128 r6 into r7;
    set r7 into maker_balances[r1];
    pow 10u128 6u8 into r8;
    mul 1000000u128 r8 into r9;
    set r9 into maker_balances[r2];
    pow 10u128 6u8 into r10;
    mul 1000000u128 r10 into r11;
    set r11 into maker_balances[r3];

closure verify_signature:
    input r0 as Quote;
    input r1 as Signature;
    mul 522678458525321116977504528531602186870683848189190546523208313015552693483group r1.response into r2;
    mul r1.pk_sig r1.challenge into r3;
    add r2 r3 into r4;
    cast r0.maker_address into r5 as group;
    hash.psd8 r4 into r6 as scalar;
    hash.psd8 r1.pk_sig into r7 as scalar;
    hash.psd8 r1.pr_sig into r8 as scalar;
    hash.psd8 r5 into r9 as scalar;
    hash.psd8 r0 into r10 as scalar;
    add r6 r7 into r11;
    add r11 r8 into r12;
    add r12 r9 into r13;
    add r13 r10 into r14;
    add r1.pk_sig r1.pr_sig into r15;
    mul 522678458525321116977504528531602186870683848189190546523208313015552693483group r1.sk_prf into r16;
    add r15 r16 into r17;
    is.eq r17 r5 into r18;
    is.eq r1.challenge r14 into r19;
    and r18 r19 into r20;
    output r20 as boolean;

function quote_swap:
    input r0 as Token.record;
    input r1 as Quote.private;
    input r2 as Signature.private;
    call verify_signature r1 r2 into r3;
    assert.eq r3 true ;
    is.eq r0.token_id r1.token_in into r4;
    assert.eq r4 true ;
    gte r0.amount r1.amount_in into r5;
    assert.eq r5 true ;
    sub r0.amount r1.amount_in into r6;
    cast r0.owner r6 r0.token_id into r7 as Token.record;
    cast r0.owner r1.amount_out r1.token_out into r8 as Token.record;
    cast r1.maker_address r1.amount_in r1.token_in into r9 as Token.record;
    call get_deposit_id r1.maker_address r1.token_out into r10;
    hash.psd8 r1 into r11 as field;
    async quote_swap r10 r11 r1.amount_out r1.valid_until into r12;
    output r8 as Token.record;
    output r7 as Token.record;
    output r9 as Token.record;
    output r12 as arcane_rfq_amm_v000003.aleo/quote_swap.future;

finalize quote_swap:
    input r0 as field.public;
    input r1 as field.public;
    input r2 as u128.public;
    input r3 as u32.public;
    gt r3 block.height into r4;
    assert.eq r4 true ;
    contains executed_quotes[r1] into r5;
    not r5 into r6;
    assert.eq r6 true ;
    get maker_balances[r0] into r7;
    gte r7 r2 into r8;
    assert.eq r8 true ;
    sub r7 r2 into r9;
    set r9 into maker_balances[r0];
    set block.height into executed_quotes[r1];

function init_demo_tokens:
    input r0 as field.private;
    add r0 1field into r1;
    async init_demo_tokens r0 into r2;
    output r1 as field.private;
    output r2 as arcane_rfq_amm_v000003.aleo/init_demo_tokens.future;

finalize init_demo_tokens:
    input r0 as field.public;
    pow 10u128 6u8 into r1;
    mul 1000000000u128 r1 into r2;
    cast 1u64 r2 6u8 into r3 as TokenInfo;
    set r3 into registered_tokens[1u64];
    pow 10u128 6u8 into r4;
    mul 1000000000u128 r4 into r5;
    cast 2u64 r5 6u8 into r6 as TokenInfo;
    set r6 into registered_tokens[2u64];
    pow 10u128 6u8 into r7;
    mul 1000000000u128 r7 into r8;
    cast 3u64 r8 6u8 into r9 as TokenInfo;
    set r9 into registered_tokens[3u64];
    pow 10u128 6u8 into r10;
    mul 1000000000u128 r10 into r11;
    cast 4u64 r11 6u8 into r12 as TokenInfo;
    set r12 into registered_tokens[4u64];

function init_demo_pools:
    input r0 as field.private;
    async init_demo_pools into r1;
    output r1 as arcane_rfq_amm_v000003.aleo/init_demo_pools.future;

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
