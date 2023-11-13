// Copyright (C) 2019-2023 Aleo Systems Inc.
// This file is part of the snarkVM library.

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at:
// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

use serde_json::json;

pub use cast::Cast;
pub use cast_lossy::CastLossy;

mod bytes;
mod cast;
mod cast_lossy;
mod equal;
mod from_bits;
mod parse;
mod sample;
mod serialize;
mod size_in_bits;
mod to_bits;
mod to_type;
mod variant;

use crate::LiteralType;
use snarkvm_console_account::{ComputeKey, PrivateKey, Signature};
use snarkvm_console_network::Network;
use snarkvm_console_types::{prelude::*, Boolean};

/// The literal enum represents all supported types in snarkVM.
#[derive(Clone)]
pub enum Literal<N: Network> {
    /// The Aleo address type.
    Address(Address<N>),
    /// The boolean type.
    Boolean(Boolean<N>),
    /// The field type.
    Field(Field<N>),
    /// The group type.
    Group(Group<N>),
    /// The 8-bit signed integer type.
    I8(I8<N>),
    /// The 16-bit signed integer type.
    I16(I16<N>),
    /// The 32-bit signed integer type.
    I32(I32<N>),
    /// The 64-bit signed integer type.
    I64(I64<N>),
    /// The 128-bit signed integer type.
    I128(I128<N>),
    /// The 8-bit unsigned integer type.
    U8(U8<N>),
    /// The 16-bit unsigned integer type.
    U16(U16<N>),
    /// The 32-bit unsigned integer type.
    U32(U32<N>),
    /// The 64-bit unsigned integer type.
    U64(U64<N>),
    /// The 128-bit unsigned integer type.
    U128(U128<N>),
    /// The scalar type.
    Scalar(Scalar<N>),
    /// The signature type.
    Signature(Box<Signature<N>>),
    /// The string type.
    String(StringType<N>),
}

/// ** Vanguard JSON serialization helper ** ///
impl<N: Network> Literal<N> {
    pub fn to_json(&self) -> serde_json::Value {
        let j_vtype = match self {
            Self::Address(literal) => "Address",
            Self::Boolean(literal) => "Boolean",
            Self::Field(literal) => "Field",
            Self::Group(literal) => "Group",
            Self::I8(literal) => "I8",
            Self::I16(literal) => "I16",
            Self::I32(literal) => "I32",
            Self::I64(literal) => "I64",
            Self::I128(literal) => "I128",
            Self::U8(literal) => "U8",
            Self::U16(literal) => "U16",
            Self::U32(literal) => "U32",
            Self::U64(literal) => "U64",
            Self::U128(literal) => "U128",
            Self::Scalar(literal) => "Scalar",
            Self::Signature(literal) => "Signature",
            Self::String(literal) => "String",
        };

        let j_value = match self {
            Self::Address(literal) => literal.to_json(),
            Self::Boolean(literal) => literal.to_json(),
            Self::Field(literal) => literal.to_json(),
            Self::Group(literal) => literal.to_json(),
            Self::I8(literal) => literal.to_json(),
            Self::I16(literal) => literal.to_json(),
            Self::I32(literal) => literal.to_json(),
            Self::I64(literal) => literal.to_json(),
            Self::I128(literal) => literal.to_json(),
            Self::U8(literal) => literal.to_json(),
            Self::U16(literal) => literal.to_json(),
            Self::U32(literal) => literal.to_json(),
            Self::U64(literal) => literal.to_json(),
            Self::U128(literal) => literal.to_json(),
            Self::Scalar(literal) => literal.to_json(),
            Self::Signature(literal) => literal.to_json(),
            Self::String(literal) => literal.to_json(),
        };

        json!({
            "type": "Literal",
            "vtype": j_vtype,
            "value": j_value,
        })
    }
}