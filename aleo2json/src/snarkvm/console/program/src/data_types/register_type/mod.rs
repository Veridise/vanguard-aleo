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

mod bytes;
mod parse;
mod serialize;

use crate::{FinalizeType, Identifier, Locator, PlaintextType, ValueType};
use snarkvm_console_network::prelude::*;

use enum_index::EnumIndex;

#[derive(Clone, PartialEq, Eq, Hash, EnumIndex)]
pub enum RegisterType<N: Network> {
    /// A plaintext type.
    Plaintext(PlaintextType<N>),
    /// A record name.
    Record(Identifier<N>),
    /// A record locator.
    ExternalRecord(Locator<N>),
    /// A future.
    Future(Locator<N>),
}

/// ** Vanguard JSON serialization helper ** ///
impl<N: Network> RegisterType<N> {
    pub fn to_json(&self) -> serde_json::Value {
        let j_vtype = match self {
            // Prints the plaintext type, i.e. signature
            Self::Plaintext(plaintext_type) => "Plaintext",
            // Prints the record name, i.e. token.record
            Self::Record(record_name) => "Record",
            // Prints the locator, i.e. token.aleo/token.record
            Self::ExternalRecord(locator) => "ExternalRecord",
            // Prints the future type, i.e. future
            Self::Future(locator) => "Future",
        };

        let j_value = match self {
            // Prints the plaintext type, i.e. signature
            Self::Plaintext(plaintext_type) => plaintext_type.to_json(),
            // Prints the record name, i.e. token.record
            Self::Record(record_name) => record_name.to_json(),
            // Prints the locator, i.e. token.aleo/token.record
            Self::ExternalRecord(locator) => locator.to_json(),
            // Prints the future type, i.e. future
            Self::Future(locator) => locator.to_json(),
        };

        json!({
            "type": "RegisterType",
            "vtype": j_vtype,
            "value": j_value,
        })
    }
}

impl<N: Network> From<ValueType<N>> for RegisterType<N> {
    /// Converts a value type to a register type.
    fn from(value: ValueType<N>) -> Self {
        match value {
            ValueType::Constant(plaintext_type)
            | ValueType::Public(plaintext_type)
            | ValueType::Private(plaintext_type) => Self::Plaintext(plaintext_type),
            ValueType::Record(record_name) => Self::Record(record_name),
            ValueType::ExternalRecord(locator) => Self::ExternalRecord(locator),
            ValueType::Future(locator) => Self::Future(locator),
        }
    }
}

impl<N: Network> From<FinalizeType<N>> for RegisterType<N> {
    /// Converts a finalize type to a register type.
    fn from(finalize: FinalizeType<N>) -> Self {
        match finalize {
            FinalizeType::Plaintext(plaintext_type) => Self::Plaintext(plaintext_type),
            FinalizeType::Future(locator) => Self::Future(locator),
        }
    }
}
