import credits.aleo;

program aleo_store_nft.aleo;

struct TokenId:
    token_number as u128;
    collection_number as u128;

struct String64:
    part0 as u128;
    part1 as u128;
    part2 as u128;
    part3 as u128;

struct TokenData:
    metadata_uri as String64;
    transferable as boolean;

record Token:
    owner as address.private;
    id as TokenId.private;
    data as TokenData.private;

struct CollectionId:
    collection_number as u128;

struct CollectionData:
    updatable as boolean;

record Collection:
    owner as address.private;
    id as CollectionId.private;
    data as CollectionData.private;

struct CollectionPublicData:
    royalty_fees as u64;
    royalty_address as address;
    metadata_uri as String64;
    base_uri as String64;
    publicizable as boolean;

struct CollectionMintId:
    collection_number as u128;
    mint_number as u128;

struct MintData:
    whitelist as boolean;
    price as u64;
    treasury as address;
    start as u32;
    end as u32;
    random as boolean;

struct AddressCollectionMintId:
    addr as address;
    collection_number as u128;
    mint_number as u128;

struct TokenMintId:
    collection_number as u128;
    token_number as u128;
    mint_number as u128;

struct IndexCollectionMintId:
    index as u128;
    collection_number as u128;
    mint_number as u128;

struct Listing:
    seller as address;
    price as u64;

record CollectionOwnerProof:
    owner as address.private;
    prover as address.private;
    id as CollectionId.private;
    is_owner as boolean.private;
    height as u32.private;

record CollectionHolderProof:
    owner as address.private;
    prover as address.private;
    id as CollectionId.private;
    is_holder as boolean.private;
    height as u32.private;

record TokenOwnerProof:
    owner as address.private;
    prover as address.private;
    id as TokenId.private;
    is_owner as boolean.private;
    height as u32.private;

mapping collectionPublicData:
    key as CollectionId.public;
    value as CollectionPublicData.public;

mapping tokenExists:
    key as TokenId.public;
    value as boolean.public;

mapping publicTokenData:
    key as TokenId.public;
    value as TokenData.public;

mapping publicTokenOwners:
    key as TokenId.public;
    value as address.public;

mapping mintWhitelists:
    key as AddressCollectionMintId.public;
    value as u64.public;

mapping collectionMintData:
    key as CollectionMintId.public;
    value as MintData.public;

mapping tokenMintData:
    key as TokenMintId.public;
    value as TokenData.public;

mapping mintTokenNumbers:
    key as IndexCollectionMintId.public;
    value as u128.public;

mapping mintLengths:
    key as CollectionMintId.public;
    value as u128.public;

mapping listings:
    key as TokenId.public;
    value as Listing.public;

function create_collection:
    input r0 as u128.private;
    input r1 as CollectionData.private;
    input r2 as CollectionPublicData.public;
    assert.neq r0 0u128 ;
    cast r0 into r3 as CollectionId;
    cast self.caller r3 r1 into r4 as Collection.record;
    async create_collection r3 r2 into r5;
    output r4 as Collection.record;
    output r5 as aleo_store_nft.aleo/create_collection.future;

finalize create_collection:
    input r0 as CollectionId.public;
    input r1 as CollectionPublicData.public;
    contains collectionPublicData[r0] into r2;
    not r2 into r3;
    assert.eq r3 true ;
    set r1 into collectionPublicData[r0];

function update_collection_public_data:
    input r0 as Collection.record;
    input r1 as CollectionPublicData.public;
    cast r0.owner r0.id r0.data into r2 as Collection.record;
    async update_collection_public_data r0.id r1 into r3;
    output r2 as Collection.record;
    output r3 as aleo_store_nft.aleo/update_collection_public_data.future;

finalize update_collection_public_data:
    input r0 as CollectionId.public;
    input r1 as CollectionPublicData.public;
    get collectionPublicData[r0] into r2;
    assert.eq r2.publicizable r1.publicizable ;
    set r1 into collectionPublicData[r0];

function transfer_collection:
    input r0 as Collection.record;
    input r1 as address.private;
    cast r1 r0.id r0.data into r2 as Collection.record;
    output r2 as Collection.record;

function freeze_collection_updates:
    input r0 as Collection.record;
    cast false into r1 as CollectionData;
    cast r0.owner r0.id r1 into r2 as Collection.record;
    async freeze_collection_updates r0.id into r3;
    output r2 as Collection.record;
    output r3 as aleo_store_nft.aleo/freeze_collection_updates.future;

finalize freeze_collection_updates:
    input r0 as CollectionId.public;
    assert.eq true true ;

function mint_private:
    input r0 as Collection.record;
    input r1 as u128.public;
    input r2 as address.private;
    input r3 as TokenData.private;
    cast r0.owner r0.id r0.data into r4 as Collection.record;
    cast r1 r0.id.collection_number into r5 as TokenId;
    cast r2 r5 r3 into r6 as Token.record;
    async mint_private r5 into r7;
    output r6 as Token.record;
    output r4 as Collection.record;
    output r7 as aleo_store_nft.aleo/mint_private.future;

finalize mint_private:
    input r0 as TokenId.public;
    contains tokenExists[r0] into r1;
    not r1 into r2;
    assert.eq r2 true ;
    set true into tokenExists[r0];

function burn_private:
    input r0 as Collection.record;
    input r1 as Token.record;
    assert.eq r1.id.collection_number r0.id.collection_number ;
    assert.eq r0.data.updatable true ;
    cast r0.data.updatable into r2 as CollectionData;
    cast r0.owner r0.id r2 into r3 as Collection.record;
    async burn_private r1.id into r4;
    output r3 as Collection.record;
    output r4 as aleo_store_nft.aleo/burn_private.future;

finalize burn_private:
    input r0 as TokenId.public;
    remove tokenExists[r0];

function burn_public:
    input r0 as Collection.record;
    input r1 as TokenId.public;
    assert.eq r1.collection_number r0.id.collection_number ;
    assert.eq r0.data.updatable true ;
    cast r0.owner r0.id r0.data into r2 as Collection.record;
    async burn_public r0.id r1 into r3;
    output r2 as Collection.record;
    output r3 as aleo_store_nft.aleo/burn_public.future;

finalize burn_public:
    input r0 as CollectionId.public;
    input r1 as TokenId.public;
    contains listings[r1] into r2;
    contains publicTokenData[r1] into r3;
    assert.eq r3 true ;
    remove tokenExists[r1];
    remove publicTokenData[r1];
    remove listings[r1];
    remove publicTokenOwners[r1];

function transfer_token_private:
    input r0 as Token.record;
    input r1 as address.private;
    assert.eq r0.data.transferable true ;
    cast r1 r0.id r0.data into r2 as Token.record;
    output r2 as Token.record;

function transfer_token_public:
    input r0 as TokenId.public;
    input r1 as address.public;
    async transfer_token_public r0 r1 self.caller into r2;
    output r2 as aleo_store_nft.aleo/transfer_token_public.future;

finalize transfer_token_public:
    input r0 as TokenId.public;
    input r1 as address.public;
    input r2 as address.public;
    get publicTokenOwners[r0] into r3;
    get publicTokenData[r0] into r4;
    assert.eq r3 r2 ;
    assert.eq r4.transferable true ;
    set r1 into publicTokenOwners[r0];

function transfer_t_private_to_public:
    input r0 as Token.record;
    input r1 as address.public;
    is.eq self.caller r1 into r2;
    or r0.data.transferable r2 into r3;
    assert.eq r3 true ;
    async transfer_t_private_to_public r0.data r0.id r1 into r4;
    output r4 as aleo_store_nft.aleo/transfer_t_private_to_public.future;

finalize transfer_t_private_to_public:
    input r0 as TokenData.public;
    input r1 as TokenId.public;
    input r2 as address.public;
    cast r1.collection_number into r3 as CollectionId;
    get collectionPublicData[r3] into r4;
    assert.eq r4.publicizable true ;
    set r0 into publicTokenData[r1];
    set r2 into publicTokenOwners[r1];

function transfer_t_public_to_private:
    input r0 as TokenId.public;
    input r1 as TokenData.public;
    input r2 as address.public;
    is.eq self.caller r2 into r3;
    or r1.transferable r3 into r4;
    assert.eq r4 true ;
    cast r2 r0 r1 into r5 as Token.record;
    async transfer_t_public_to_private r0 r1 self.caller into r6;
    output r5 as Token.record;
    output r6 as aleo_store_nft.aleo/transfer_t_public_to_private.future;

finalize transfer_t_public_to_private:
    input r0 as TokenId.public;
    input r1 as TokenData.public;
    input r2 as address.public;
    get publicTokenData[r0] into r3;
    get publicTokenOwners[r0] into r4;
    assert.eq r4 r2 ;
    assert.eq r1 r3 ;
    remove publicTokenOwners[r0];
    remove publicTokenData[r0];

function update_token_data_private:
    input r0 as Collection.record;
    input r1 as Token.record;
    input r2 as TokenData.private;
    assert.eq r1.id.collection_number r0.id.collection_number ;
    assert.eq r0.data.updatable true ;
    cast r0.owner r0.id r0.data into r3 as Collection.record;
    cast r1.owner r1.id r2 into r4 as Token.record;
    output r4 as Token.record;
    output r3 as Collection.record;

function update_token_data_public:
    input r0 as Collection.record;
    input r1 as TokenId.public;
    input r2 as TokenData.public;
    assert.eq r1.collection_number r0.id.collection_number ;
    assert.eq r0.data.updatable true ;
    cast r0.owner r0.id r0.data into r3 as Collection.record;
    async update_token_data_public r1 r2 into r4;
    output r3 as Collection.record;
    output r4 as aleo_store_nft.aleo/update_token_data_public.future;

finalize update_token_data_public:
    input r0 as TokenId.public;
    input r1 as TokenData.public;
    set r1 into publicTokenData[r0];

function set_collection_mint:
    input r0 as Collection.record;
    input r1 as u128.public;
    input r2 as MintData.public;
    cast r0.owner r0.id r0.data into r3 as Collection.record;
    cast r0.id.collection_number r1 into r4 as CollectionMintId;
    async set_collection_mint r4 r2 into r5;
    output r3 as Collection.record;
    output r5 as aleo_store_nft.aleo/set_collection_mint.future;

finalize set_collection_mint:
    input r0 as CollectionMintId.public;
    input r1 as MintData.public;
    cast r0.collection_number into r2 as CollectionId;
    get collectionPublicData[r2] into r3;
    assert.eq r3.publicizable true ;
    set r1 into collectionMintData[r0];

function create_token_mint:
    input r0 as Collection.record;
    input r1 as u128.public;
    input r2 as u128.public;
    input r3 as TokenData.public;
    cast r0.owner r0.id r0.data into r4 as Collection.record;
    cast r0.id.collection_number r2 into r5 as CollectionMintId;
    async create_token_mint r5 r1 r3 into r6;
    output r4 as Collection.record;
    output r6 as aleo_store_nft.aleo/create_token_mint.future;

finalize create_token_mint:
    input r0 as CollectionMintId.public;
    input r1 as u128.public;
    input r2 as TokenData.public;
    get.or_use mintLengths[r0] 0u128 into r3;
    cast r3 r0.collection_number r0.mint_number into r4 as IndexCollectionMintId;
    cast r0.collection_number r1 r0.mint_number into r5 as TokenMintId;
    add r3 1u128 into r6;
    set r6 into mintLengths[r0];
    set r1 into mintTokenNumbers[r4];
    set r2 into tokenMintData[r5];

function update_token_mint:
    input r0 as Collection.record;
    input r1 as u128.public;
    input r2 as u128.public;
    input r3 as u128.public;
    input r4 as TokenData.public;
    cast r0.owner r0.id r0.data into r5 as Collection.record;
    cast r0.id.collection_number r1 r2 into r6 as TokenMintId;
    async update_token_mint r6 r3 r4 into r7;
    output r5 as Collection.record;
    output r7 as aleo_store_nft.aleo/update_token_mint.future;

finalize update_token_mint:
    input r0 as TokenMintId.public;
    input r1 as u128.public;
    input r2 as TokenData.public;
    cast r1 r0.collection_number r0.mint_number into r3 as IndexCollectionMintId;
    get mintTokenNumbers[r3] into r4;
    assert.eq r4 r0.token_number ;
    set r2 into tokenMintData[r0];

function remove_token_mint:
    input r0 as Collection.record;
    input r1 as u128.public;
    input r2 as u128.public;
    input r3 as u128.public;
    cast r3 r0.id.collection_number r2 into r4 as IndexCollectionMintId;
    cast r0.owner r0.id r0.data into r5 as Collection.record;
    async remove_token_mint r4 r1 into r6;
    output r5 as Collection.record;
    output r6 as aleo_store_nft.aleo/remove_token_mint.future;

finalize remove_token_mint:
    input r0 as IndexCollectionMintId.public;
    input r1 as u128.public;
    get mintTokenNumbers[r0] into r2;
    assert.eq r2 r1 ;
    cast r0.collection_number r0.mint_number into r3 as CollectionMintId;
    get mintLengths[r3] into r4;
    sub r4 1u128 into r5;
    set r5 into mintLengths[r3];
    cast r5 r0.collection_number r0.mint_number into r6 as IndexCollectionMintId;
    get mintTokenNumbers[r6] into r7;
    set r7 into mintTokenNumbers[r0];
    remove mintTokenNumbers[r6];
    cast r0.collection_number r1 r0.mint_number into r8 as TokenMintId;
    remove tokenMintData[r8];

function update_whitelist:
    input r0 as Collection.record;
    input r1 as u128.public;
    input r2 as address.public;
    input r3 as u64.public;
    cast r0.owner r0.id r0.data into r4 as Collection.record;
    cast r2 r0.id.collection_number r1 into r5 as AddressCollectionMintId;
    async update_whitelist r5 r3 into r6;
    output r4 as Collection.record;
    output r6 as aleo_store_nft.aleo/update_whitelist.future;

finalize update_whitelist:
    input r0 as AddressCollectionMintId.public;
    input r1 as u64.public;
    set r1 into mintWhitelists[r0];

function mint_public:
    input r0 as IndexCollectionMintId.public;
    input r1 as u128.public;
    input r2 as credits.aleo/credits.record;
    input r3 as address.public;
    input r4 as u64.public;
    call credits.aleo/transfer_private r2 r3 r4 into r5 r6;
    async mint_public r0 r1 r3 r4 self.caller into r7;
    output r6 as credits.aleo/credits.record;
    output r5 as credits.aleo/credits.record;
    output r7 as aleo_store_nft.aleo/mint_public.future;

finalize mint_public:
    input r0 as IndexCollectionMintId.public;
    input r1 as u128.public;
    input r2 as address.public;
    input r3 as u64.public;
    input r4 as address.public;
    cast r0.collection_number r0.mint_number into r5 as CollectionMintId;
    get collectionMintData[r5] into r6;
    get mintLengths[r5] into r7;
    rand.chacha into r8 as u128;
    rem r8 r7 into r9;
    ternary r6.random r9 r0.index into r10;
    cast r10 r5.collection_number r5.mint_number into r11 as IndexCollectionMintId;
    get mintTokenNumbers[r11] into r12;
    is.eq r12 r1 into r13;
    or r6.random r13 into r14;
    assert.eq r14 true ;
    cast r12 r5.collection_number into r15 as TokenId;
    contains tokenExists[r15] into r16;
    not r16 into r17;
    assert.eq r17 true ;
    cast r4 r5.collection_number r5.mint_number into r18 as AddressCollectionMintId;
    get.or_use mintWhitelists[r18] 0u64 into r19;
    ternary r6.whitelist r19 1u64 into r20;
    sub r20 1u64 into r21;
    set r21 into mintWhitelists[r18];
    is.eq r6.start 0u32 into r22;
    lte r6.start block.height into r23;
    or r22 r23 into r24;
    assert.eq r24 true ;
    is.eq r6.end 0u32 into r25;
    lt block.height r6.end into r26;
    or r25 r26 into r27;
    assert.eq r27 true ;
    assert.eq r3 r6.price ;
    assert.eq r2 r6.treasury ;
    sub r7 1u128 into r28;
    set r28 into mintLengths[r5];
    cast r28 r5.collection_number r5.mint_number into r29 as IndexCollectionMintId;
    get mintTokenNumbers[r29] into r30;
    set r30 into mintTokenNumbers[r29];
    remove mintTokenNumbers[r11];
    set true into tokenExists[r15];
    set r4 into publicTokenOwners[r15];
    cast r5.collection_number r12 r0.mint_number into r31 as TokenMintId;
    get tokenMintData[r31] into r32;
    set r32 into publicTokenData[r15];

function prove_collection_ownership:
    input r0 as Collection.record;
    input r1 as address.private;
    input r2 as u32.public;
    cast r1 self.caller r0.id true r2 into r3 as CollectionOwnerProof.record;
    cast r0.owner r0.id r0.data into r4 as Collection.record;
    async prove_collection_ownership r2 into r5;
    output r3 as CollectionOwnerProof.record;
    output r4 as Collection.record;
    output r5 as aleo_store_nft.aleo/prove_collection_ownership.future;

finalize prove_collection_ownership:
    input r0 as u32.public;
    sub block.height 50u32 into r1;
    gte r0 r1 into r2;
    assert.eq r2 true ;

function prove_token_ownership:
    input r0 as Token.record;
    input r1 as address.private;
    input r2 as u32.public;
    cast r1 self.caller r0.id true r2 into r3 as TokenOwnerProof.record;
    cast r0.owner r0.id r0.data into r4 as Token.record;
    async prove_token_ownership r2 into r5;
    output r3 as TokenOwnerProof.record;
    output r4 as Token.record;
    output r5 as aleo_store_nft.aleo/prove_token_ownership.future;

finalize prove_token_ownership:
    input r0 as u32.public;
    sub block.height 50u32 into r1;
    gte r0 r1 into r2;
    assert.eq r2 true ;

function prove_collection_holdership:
    input r0 as Token.record;
    input r1 as address.private;
    input r2 as u32.public;
    cast r0.id.collection_number into r3 as CollectionId;
    cast r1 self.caller r3 true r2 into r4 as CollectionHolderProof.record;
    cast r0.owner r0.id r0.data into r5 as Token.record;
    async prove_collection_holdership r2 into r6;
    output r4 as CollectionHolderProof.record;
    output r5 as Token.record;
    output r6 as aleo_store_nft.aleo/prove_collection_holdership.future;

finalize prove_collection_holdership:
    input r0 as u32.public;
    sub block.height 50u32 into r1;
    gte r0 r1 into r2;
    assert.eq r2 true ;

function mint_alias:
    input r0 as u128.public;
    input r1 as address.private;
    input r2 as String64.private;
    cast r0 0u128 into r3 as TokenId;
    cast r2 true into r4 as TokenData;
    cast r1 r3 r4 into r5 as Token.record;
    async mint_alias r3 into r6;
    output r5 as Token.record;
    output r6 as aleo_store_nft.aleo/mint_alias.future;

finalize mint_alias:
    input r0 as TokenId.public;
    contains tokenExists[r0] into r1;
    not r1 into r2;
    assert.eq r2 true ;
    set true into tokenExists[r0];

function update_alias_metadata_private:
    input r0 as Token.record;
    input r1 as String64.private;
    cast r1 true into r2 as TokenData;
    cast r0.owner r0.id r2 into r3 as Token.record;
    output r3 as Token.record;

function update_alias_metadata_public:
    input r0 as TokenId.public;
    input r1 as String64.public;
    async update_alias_metadata_public r0 r1 self.caller into r2;
    output r2 as aleo_store_nft.aleo/update_alias_metadata_public.future;

finalize update_alias_metadata_public:
    input r0 as TokenId.public;
    input r1 as String64.public;
    input r2 as address.public;
    get publicTokenOwners[r0] into r3;
    assert.eq r3 r2 ;
    cast r1 true into r4 as TokenData;
    set r4 into publicTokenData[r0];

function create_alias_collection:
    cast false into r0 as CollectionData;
    cast 0u128 into r1 as CollectionId;
    cast aleo1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq3ljyzc r1 r0 into r2 as Collection.record;
    async create_alias_collection into r3;
    output r2 as Collection.record;
    output r3 as aleo_store_nft.aleo/create_alias_collection.future;

finalize create_alias_collection:
    cast 0u128 into r0 as CollectionId;
    contains collectionPublicData[r0] into r1;
    not r1 into r2;
    assert.eq r2 true ;
    cast 0u128 into r3 as CollectionId;
    cast 0u128 0u128 0u128 0u128 into r4 as String64;
    cast 0u128 0u128 0u128 0u128 into r5 as String64;
    cast 0u64 aleo1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq3ljyzc r4 r5 true into r6 as CollectionPublicData;
    set r6 into collectionPublicData[r3];

function create_listing:
    input r0 as TokenId.public;
    input r1 as u64.public;
    async create_listing self.caller r0 r1 into r2;
    output r2 as aleo_store_nft.aleo/create_listing.future;

finalize create_listing:
    input r0 as address.public;
    input r1 as TokenId.public;
    input r2 as u64.public;
    get publicTokenOwners[r1] into r3;
    assert.eq r3 r0 ;
    get publicTokenData[r1] into r4;
    assert.eq r4.transferable true ;
    cast r0 r2 into r5 as Listing;
    set r5 into listings[r1];
    remove publicTokenOwners[r1];

function update_listing:
    input r0 as TokenId.public;
    input r1 as u64.public;
    async update_listing self.caller r0 r1 into r2;
    output r2 as aleo_store_nft.aleo/update_listing.future;

finalize update_listing:
    input r0 as address.public;
    input r1 as TokenId.public;
    input r2 as u64.public;
    get listings[r1] into r3;
    assert.eq r0 r3.seller ;
    cast r0 r2 into r4 as Listing;
    set r4 into listings[r1];

function cancel_listing:
    input r0 as TokenId.public;
    async cancel_listing self.caller r0 into r1;
    output r1 as aleo_store_nft.aleo/cancel_listing.future;

finalize cancel_listing:
    input r0 as address.public;
    input r1 as TokenId.public;
    get listings[r1] into r2;
    assert.eq r0 r2.seller ;
    set r0 into publicTokenOwners[r1];
    remove listings[r1];

function accept_listing:
    input r0 as Listing.public;
    input r1 as credits.aleo/credits.record;
    input r2 as u64.public;
    input r3 as address.public;
    input r4 as TokenId.public;
    input r5 as TokenData.public;
    cast self.caller r4 r5 into r6 as Token.record;
    mul r2 r0.price into r7;
    div r7 10000u64 into r8;
    mul 250u64 r0.price into r9;
    div r9 10000u64 into r10;
    sub r0.price r8 into r11;
    sub r11 r10 into r12;
    call credits.aleo/transfer_private r1 aleo1xg4897p9ea8cd4cqpm2fzq9nthjr8caa377u3a3jqv9ff9u4f5gq3kut0m r10 into r13 r14;
    call credits.aleo/transfer_private r14 r3 r8 into r15 r16;
    call credits.aleo/transfer_private r16 r0.seller r12 into r17 r18;
    async accept_listing r0 r4 r5 r2 r3 into r19;
    output r6 as Token.record;
    output r13 as credits.aleo/credits.record;
    output r15 as credits.aleo/credits.record;
    output r18 as credits.aleo/credits.record;
    output r17 as credits.aleo/credits.record;
    output r19 as aleo_store_nft.aleo/accept_listing.future;

finalize accept_listing:
    input r0 as Listing.public;
    input r1 as TokenId.public;
    input r2 as TokenData.public;
    input r3 as u64.public;
    input r4 as address.public;
    get listings[r1] into r5;
    assert.eq r0 r5 ;
    get publicTokenData[r1] into r6;
    assert.eq r2 r6 ;
    cast r1.collection_number into r7 as CollectionId;
    get collectionPublicData[r7] into r8;
    assert.eq r8.royalty_fees r3 ;
    assert.eq r8.royalty_address r4 ;
    remove listings[r1];
    remove publicTokenData[r1];
