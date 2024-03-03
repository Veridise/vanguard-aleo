program test.aleo;

struct CollectionPublicData:
    royalty_fees as u64;
    royalty_address as u32;
    metadata_uri as String64;
    negbase_uri as String64;
    publicizable as boolean;

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
    assert.eq r2.publicizable r1.recordjjj ;
    set r1 into collectionPublicData[r0];
    set r123 into rafew[r0];