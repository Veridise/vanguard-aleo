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

use console::{network::prelude::*, program::PlaintextType};

/// An value statement is of the form `value as {plaintext_type}.public;`.
#[derive(Clone, PartialEq, Eq)]
pub struct MapValue<N: Network> {
    /// The value plaintext type.
    plaintext_type: PlaintextType<N>,
}

impl<N: Network> MapValue<N> {
    /// ** Vanguard JSON serialization helper ** ///
    pub fn to_json(&self) -> serde_json::Value {
        json!({
            "type": "MapValue",
            "plaintext_type": self.plaintext_type.to_json(),
            "visibility": "public", // CHECK: map value is always public
        })
    }

    /// Returns the value plaintext type.
    #[inline]
    pub const fn plaintext_type(&self) -> &PlaintextType<N> {
        &self.plaintext_type
    }
}

impl<N: Network> TypeName for MapValue<N> {
    /// Returns the type name as a string.
    #[inline]
    fn type_name() -> &'static str {
        "value"
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use console::network::Testnet3;

    type CurrentNetwork = Testnet3;

    #[test]
    fn test_value_type_name() {
        assert_eq!(MapValue::<CurrentNetwork>::type_name(), "value");
    }
}
