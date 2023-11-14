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

use crate::Access;
use snarkvm_console_network::prelude::*;

/// A register contains the location data to a value in memory.
#[derive(Clone, PartialEq, Eq, Hash)]
pub enum Register<N: Network> {
    /// A register contains its locator in memory.
    Locator(u64),
    /// A register access contains its locator and access(es) in memory.
    Access(u64, Vec<Access<N>>),
}

impl<N: Network> Register<N> {
    /// ** Vanguard JSON serialization helper ** ///
    pub fn to_json(&self) -> serde_json::Value {
        let j_vtype = match self {
            // Prints the register, i.e. r0
            Self::Locator(locator) => "Locator",
            // Prints the register access, i.e. r0.owner
            Self::Access(locator, accesses) => "Access",
        };

        let j_value = match self {
            // Prints the register, i.e. r0
            Self::Locator(locator) => json!(locator),
            // Prints the register access, i.e. r0.owner
            Self::Access(locator, accesses) => {
                let mut j_access = Vec::new();
                for val in accesses {
                    j_access.push(val.to_json());
                }
                json!(j_access)
            },
        };

        json!({
            "type": "Register",
            "vtype": j_vtype,
            "value": j_value,
        })
    }

    /// Returns the locator of the register.
    #[inline]
    pub const fn locator(&self) -> u64 {
        match self {
            Self::Locator(locator) => *locator,
            Self::Access(locator, _) => *locator,
        }
    }
}

impl<N: Network> Ord for Register<N> {
    /// Ordering is determined by the register locator (any accesses are ignored).
    fn cmp(&self, other: &Self) -> Ordering {
        self.locator().cmp(&other.locator())
    }
}

impl<N: Network> PartialOrd for Register<N> {
    /// Ordering is determined by the register locator (any accesses are ignored).
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::{Identifier, U32};
    use snarkvm_console_network::Testnet3;

    type CurrentNetwork = Testnet3;

    #[test]
    fn test_register_partial_ord() -> Result<()> {
        // Register::Locator
        assert_eq!(
            Some(Ordering::Equal),
            Register::<CurrentNetwork>::Locator(0).partial_cmp(&Register::<CurrentNetwork>::Locator(0))
        );
        assert_eq!(
            Some(Ordering::Less),
            Register::<CurrentNetwork>::Locator(0).partial_cmp(&Register::<CurrentNetwork>::Locator(1))
        );
        assert_eq!(
            Some(Ordering::Greater),
            Register::<CurrentNetwork>::Locator(1).partial_cmp(&Register::<CurrentNetwork>::Locator(0))
        );

        // Register::Access with Access::Member
        assert_eq!(
            Some(Ordering::Equal),
            Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)]).partial_cmp(
                &Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)])
            )
        );
        assert_eq!(
            Some(Ordering::Less),
            Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)]).partial_cmp(
                &Register::<CurrentNetwork>::Access(1, vec![Access::Member(Identifier::from_str("owner")?)])
            )
        );
        assert_eq!(
            Some(Ordering::Greater),
            Register::<CurrentNetwork>::Access(1, vec![Access::Member(Identifier::from_str("owner")?)]).partial_cmp(
                &Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)])
            )
        );

        // Register::Access with Access::Index
        assert_eq!(
            Some(Ordering::Equal),
            Register::<CurrentNetwork>::Access(0, vec![Access::Index(U32::new(0))]).partial_cmp(&Register::<
                CurrentNetwork,
            >::Access(
                0,
                vec![Access::Index(U32::new(0))]
            ))
        );
        assert_eq!(
            Some(Ordering::Less),
            Register::<CurrentNetwork>::Access(0, vec![Access::Index(U32::new(0))]).partial_cmp(&Register::<
                CurrentNetwork,
            >::Access(
                1,
                vec![Access::Index(U32::new(0))]
            ))
        );
        assert_eq!(
            Some(Ordering::Greater),
            Register::<CurrentNetwork>::Access(1, vec![Access::Index(U32::new(0))]).partial_cmp(&Register::<
                CurrentNetwork,
            >::Access(
                0,
                vec![Access::Index(U32::new(0))]
            ))
        );

        // Register::Access with a combination of Access::Member and Access::Index
        assert_eq!(
            Some(Ordering::Equal),
            Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ])
            .partial_cmp(&Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ]))
        );
        assert_eq!(
            Some(Ordering::Less),
            Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ])
            .partial_cmp(&Register::<CurrentNetwork>::Access(1, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ]))
        );
        assert_eq!(
            Some(Ordering::Greater),
            Register::<CurrentNetwork>::Access(1, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ])
            .partial_cmp(&Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ]))
        );

        Ok(())
    }

    #[test]
    fn test_register_eq() -> Result<()> {
        // Register::Locator
        assert_eq!(Register::<CurrentNetwork>::Locator(0), Register::<CurrentNetwork>::Locator(0));
        assert_ne!(Register::<CurrentNetwork>::Locator(0), Register::<CurrentNetwork>::Locator(1));
        assert_ne!(Register::<CurrentNetwork>::Locator(0), Register::<CurrentNetwork>::Locator(2));
        assert_ne!(Register::<CurrentNetwork>::Locator(0), Register::<CurrentNetwork>::Locator(3));
        assert_ne!(Register::<CurrentNetwork>::Locator(0), Register::<CurrentNetwork>::Locator(4));

        // Register::Access with Access::Member
        assert_eq!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)]),
            Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)]),
            Register::<CurrentNetwork>::Access(1, vec![Access::Member(Identifier::from_str("owner")?)])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)]),
            Register::<CurrentNetwork>::Access(2, vec![Access::Member(Identifier::from_str("owner")?)])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)]),
            Register::<CurrentNetwork>::Access(3, vec![Access::Member(Identifier::from_str("owner")?)])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Member(Identifier::from_str("owner")?)]),
            Register::<CurrentNetwork>::Access(4, vec![Access::Member(Identifier::from_str("owner")?)])
        );

        // Register::Access with Access::Index
        assert_eq!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Index(U32::new(0))]),
            Register::<CurrentNetwork>::Access(0, vec![Access::Index(U32::new(0))])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Index(U32::new(0))]),
            Register::<CurrentNetwork>::Access(1, vec![Access::Index(U32::new(0))])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Index(U32::new(0))]),
            Register::<CurrentNetwork>::Access(2, vec![Access::Index(U32::new(0))])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Index(U32::new(0))]),
            Register::<CurrentNetwork>::Access(3, vec![Access::Index(U32::new(0))])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![Access::Index(U32::new(0))]),
            Register::<CurrentNetwork>::Access(4, vec![Access::Index(U32::new(0))])
        );

        // Register::Access with a combination of Access::Member and Access::Index
        assert_eq!(
            Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ]),
            Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ]),
            Register::<CurrentNetwork>::Access(1, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ]),
            Register::<CurrentNetwork>::Access(2, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ]),
            Register::<CurrentNetwork>::Access(3, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ])
        );
        assert_ne!(
            Register::<CurrentNetwork>::Access(0, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ]),
            Register::<CurrentNetwork>::Access(4, vec![
                Access::Member(Identifier::from_str("owner")?),
                Access::Index(U32::new(0))
            ])
        );

        Ok(())
    }
}
