
program quest_mint_v1.aleo;

struct BaseURI:
    data0 as u128;
    data1 as u128;
    data2 as u128;
    data3 as u128;

struct TokenId:
    data1 as u128;

struct SymbolBits:
    data as u128;

record NFT:
    owner as address.private;
    data as TokenId.private;
    edition as scalar.private;

mapping general_settings:
    key as u8.public;
    value as u128.public;

mapping toggle_settings:
    key as u8.public;
    value as u32.public;

mapping minted_nfts:
    key as u128.public;
    value as boolean.public;

mapping nft_owners:
    key as field.public;
    value as address.public;

function initialize_collection:
    input r0 as u128.public;
    input r1 as u128.public;
    input r2 as BaseURI.public;
    assert.eq self.caller aleo1pv0g5swuw3akqegrktvf3aqngzpd4e5w5vlleh5zjd0gf9yxgcfqurnfu0;
    async initialize_collection r0 r1 r2 into r3;
    output r3 as quest_mint_v1.aleo/initialize_collection.future;
finalize initialize_collection:
    input r0 as u128.public;
    input r1 as u128.public;
    input r2 as BaseURI.public;
    get.or_use toggle_settings[0u8] 0u32 into r3;
    and r3 1u32 into r4;
    assert.eq r4 0u32;
    set 0u128 into general_settings[0u8];
    set r0 into general_settings[1u8];
    set r1 into general_settings[2u8];
    set r2.data0 into general_settings[3u8];
    set r2.data1 into general_settings[4u8];
    set r2.data2 into general_settings[5u8];
    set r2.data3 into general_settings[6u8];
    set 5u32 into toggle_settings[0u8];
    set 0u32 into toggle_settings[1u8];

function update_toggle_settings:
    input r0 as u32.public;
    assert.eq self.caller aleo1pv0g5swuw3akqegrktvf3aqngzpd4e5w5vlleh5zjd0gf9yxgcfqurnfu0;
    async update_toggle_settings r0 into r1;
    output r1 as quest_mint_v1.aleo/update_toggle_settings.future;
finalize update_toggle_settings:
    input r0 as u32.public;
    get toggle_settings[0u8] into r1;
    and r1 9u32 into r2;
    assert.eq r2 1u32;
    and r0 1u32 into r3;
    assert.eq r3 1u32;
    set r0 into toggle_settings[0u8];

function set_mint_block:
    input r0 as u32.public;
    assert.eq self.caller aleo1pv0g5swuw3akqegrktvf3aqngzpd4e5w5vlleh5zjd0gf9yxgcfqurnfu0;
    async set_mint_block r0 into r1;
    output r1 as quest_mint_v1.aleo/set_mint_block.future;
finalize set_mint_block:
    input r0 as u32.public;
    get toggle_settings[0u8] into r1;
    and r1 9u32 into r2;
    assert.eq r2 1u32;
    set r0 into toggle_settings[1u8];

function update_symbol:
    input r0 as u128.public;
    assert.eq self.caller aleo1pv0g5swuw3akqegrktvf3aqngzpd4e5w5vlleh5zjd0gf9yxgcfqurnfu0;
    async update_symbol r0 into r1;
    output r1 as quest_mint_v1.aleo/update_symbol.future;
finalize update_symbol:
    input r0 as u128.public;
    get toggle_settings[0u8] into r1;
    and r1 9u32 into r2;
    assert.eq r2 1u32;
    set r0 into general_settings[2u8];

function update_base_uri:
    input r0 as BaseURI.public;
    assert.eq self.caller aleo1pv0g5swuw3akqegrktvf3aqngzpd4e5w5vlleh5zjd0gf9yxgcfqurnfu0;
    async update_base_uri r0 into r1;
    output r1 as quest_mint_v1.aleo/update_base_uri.future;
finalize update_base_uri:
    input r0 as BaseURI.public;
    get toggle_settings[0u8] into r1;
    and r1 9u32 into r2;
    assert.eq r2 1u32;
    set r0.data0 into general_settings[3u8];
    set r0.data1 into general_settings[4u8];
    set r0.data2 into general_settings[5u8];
    set r0.data3 into general_settings[6u8];

function mint:
    input r0 as u128.private;
    and r0 320265757102059730318470217724476784640u128 into r1;
    assert.eq r1 64053151420411946063694043544895356928u128;
    cast r0 into r2 as TokenId;
    cast self.caller r2 0scalar into r3 as NFT.record;
    async mint r0 into r4;
    output r3 as NFT.record;
    output r4 as quest_mint_v1.aleo/mint.future;
finalize mint:
    input r0 as u128.public;
    get toggle_settings[1u8] into r1;
    lte r1 block.height into r2;
    assert.eq r2 true;
    get toggle_settings[0u8] into r3;
    and r3 11u32 into r4;
    assert.eq r4 3u32;
    get.or_use minted_nfts[r0] false into r5;
    assert.eq r5 false;
    set true into minted_nfts[r0];

function authorize:
    input r0 as NFT.record;
    input r1 as u64.public;
    async authorize  into r2;
    output r2 as quest_mint_v1.aleo/authorize.future;
finalize authorize:
    assert.eq 0u8 1u8;

function transfer_private:
    input r0 as NFT.record;
    input r1 as address.private;
    cast r1 r0.data r0.edition into r2 as NFT.record;
    output r2 as NFT.record;

function transfer_public:
    input r0 as address.private;
    input r1 as TokenId.private;
    input r2 as scalar.private;
    hash.bhp256 r1 into r3 as field;
    commit.bhp256 r3 r2 into r4 as field;
    async transfer_public r0 r4 self.caller into r5;
    output r5 as quest_mint_v1.aleo/transfer_public.future;
finalize transfer_public:
    input r0 as address.public;
    input r1 as field.public;
    input r2 as address.public;
    get nft_owners[r1] into r3;
    assert.eq r2 r3;
    set r0 into nft_owners[r1];

function convert_private_to_public:
    input r0 as NFT.record;
    hash.bhp256 r0.data into r1 as field;
    commit.bhp256 r1 r0.edition into r2 as field;
    async convert_private_to_public r0.owner r2 into r3;
    output r3 as quest_mint_v1.aleo/convert_private_to_public.future;
finalize convert_private_to_public:
    input r0 as address.public;
    input r1 as field.public;
    set r0 into nft_owners[r1];

function convert_public_to_private:
    input r0 as address.private;
    input r1 as TokenId.private;
    input r2 as scalar.private;
    assert.eq r0 self.caller;
    hash.bhp256 r1 into r3 as field;
    commit.bhp256 r3 r2 into r4 as field;
    cast r0 r1 r2 into r5 as NFT.record;
    async convert_public_to_private r0 r4 into r6;
    output r5 as NFT.record;
    output r6 as quest_mint_v1.aleo/convert_public_to_private.future;
finalize convert_public_to_private:
    input r0 as address.public;
    input r1 as field.public;
    get nft_owners[r1] into r2;
    assert.eq r0 r2;
    remove nft_owners[r1];

