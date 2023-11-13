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

use super::*;

impl<N: Network, Private: Visibility<Boolean = Boolean<N>>> Eq for Record<N, Private> {}

impl<N: Network, Private: Visibility<Boolean = Boolean<N>>> PartialEq for Record<N, Private> {
    /// Returns `true` if `self` and `other` are equal.
    fn eq(&self, other: &Self) -> bool {
        *self.is_equal(other)
    }
}

impl<N: Network, Private: Visibility<Boolean = Boolean<N>>> Equal<Self> for Record<N, Private> {
    type Output = Boolean<N>;

    /// Returns `true` if `self` and `other` are equal.
    ///
    /// Note: This method does **not** check the `nonce` equality.
    fn is_equal(&self, other: &Self) -> Self::Output {
        // Ensure the `data` lengths are equal.
        if self.data.len() != other.data.len() {
            return Boolean::new(false);
        }

        // Recursively check each entry for equality.
        let mut equal = Boolean::new(true);
        for ((name_a, entry_a), (name_b, entry_b)) in self.data.iter().zip_eq(other.data.iter()) {
            equal = equal & name_a.is_equal(name_b) & entry_a.is_equal(entry_b);
        }

        // Check the `owner`, `data`, and `nonce`.
        self.owner.is_equal(&other.owner) & equal & self.nonce.is_equal(&other.nonce)
    }

    /// Returns `true` if `self` and `other` are *not* equal.
    ///
    /// Note: This method does **not** check the `nonce` equality.
    fn is_not_equal(&self, other: &Self) -> Self::Output {
        // Check the `data` lengths.
        if self.data.len() != other.data.len() {
            return Boolean::new(true);
        }

        // Recursively check each entry for inequality.
        let mut not_equal = Boolean::new(false);
        for ((name_a, entry_a), (name_b, entry_b)) in self.data.iter().zip_eq(other.data.iter()) {
            not_equal = not_equal | name_a.is_not_equal(name_b) | entry_a.is_not_equal(entry_b);
        }

        // Check the `owner`, `data`, and `nonce`.
        self.owner.is_not_equal(&other.owner) | not_equal | self.nonce.is_not_equal(&other.nonce)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use snarkvm_console_network::Testnet3;

    type CurrentNetwork = Testnet3;

    fn sample_record() -> Record<CurrentNetwork, Plaintext<CurrentNetwork>> {
        Record::<CurrentNetwork, Plaintext<CurrentNetwork>>::from_str(
            r"{
    owner: aleo14tlamssdmg3d0p5zmljma573jghe2q9n6wz29qf36re2glcedcpqfg4add.private,
    a: true.private,
    b: 123456789field.public,
    c: 0group.private,
    d: {
        e: true.private,
        f: 123456789field.private,
        g: 0group.private
    },
    _nonce: 0group.public
}",
        )
        .unwrap()
    }

    fn sample_mismatched_record() -> Record<CurrentNetwork, Plaintext<CurrentNetwork>> {
        Record::<CurrentNetwork, Plaintext<CurrentNetwork>>::from_str(
            r"{
    owner: aleo14tlamssdmg3d0p5zmljma573jghe2q9n6wz29qf36re2glcedcpqfg4add.private,
    a: true.public,
    b: 123456789field.public,
    c: 0group.private,
    d: {
        e: true.private,
        f: 123456789field.private,
        g: 0group.private
    },
    _nonce: 0group.public
}",
        )
        .unwrap()
    }

    fn check_is_equal() {
        // Sample the record.
        let record = sample_record();
        let mismatched_record = sample_mismatched_record();

        let candidate = record.is_equal(&record);
        assert!(*candidate);

        let candidate = record.is_equal(&mismatched_record);
        assert!(!*candidate);
    }

    fn check_is_not_equal() {
        // Sample the record.
        let record = sample_record();
        let mismatched_record = sample_mismatched_record();

        let candidate = record.is_not_equal(&mismatched_record);
        assert!(*candidate);

        let candidate = record.is_not_equal(&record);
        assert!(!*candidate);
    }

    #[test]
    fn test_is_equal() {
        check_is_equal()
    }

    #[test]
    fn test_is_not_equal() {
        check_is_not_equal()
    }
}
