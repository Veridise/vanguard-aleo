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
use console::{account::*, network::Testnet3};
use snarkvm_utilities::Uniform;

use rand::RngCore;

const ITERATIONS: u64 = 100;

#[test]
fn test_coinbase_puzzle() {
    let mut rng = TestRng::default();

    let max_degree = 1 << 15;
    let max_config = PuzzleConfig { degree: max_degree };
    let srs = CoinbasePuzzle::<Testnet3>::setup(max_config).unwrap();

    for log_degree in 5..10 {
        let degree = (1 << log_degree) - 1;
        let config = PuzzleConfig { degree };
        let puzzle = CoinbasePuzzle::<Testnet3>::trim(&srs, config).unwrap();
        let epoch_challenge = EpochChallenge::new(rng.next_u32(), Default::default(), degree).unwrap();

        for batch_size in 1..10 {
            let solutions = (0..batch_size)
                .map(|_| {
                    let private_key = PrivateKey::<Testnet3>::new(&mut rng).unwrap();
                    let address = Address::try_from(private_key).unwrap();
                    let nonce = u64::rand(&mut rng);
                    puzzle.prove(&epoch_challenge, address, nonce, None).unwrap()
                })
                .collect::<Vec<_>>();
            let full_solution = CoinbaseSolution::new(solutions).unwrap();
            assert!(puzzle.check_solutions(&full_solution, &epoch_challenge, 0u64).is_ok());

            let bad_epoch_challenge = EpochChallenge::new(rng.next_u32(), Default::default(), degree).unwrap();
            assert!(puzzle.check_solutions(&full_solution, &bad_epoch_challenge, 0u64).is_err());
        }
    }
}

#[test]
fn test_prover_solution_minimum_target() {
    let mut rng = TestRng::default();

    let max_degree = 1 << 15;
    let max_config = PuzzleConfig { degree: max_degree };
    let srs = CoinbasePuzzle::<Testnet3>::setup(max_config).unwrap();

    for log_degree in 5..10 {
        let degree = (1 << log_degree) - 1;
        let config = PuzzleConfig { degree };
        let puzzle = CoinbasePuzzle::<Testnet3>::trim(&srs, config).unwrap();
        let epoch_challenge = EpochChallenge::new(rng.next_u32(), Default::default(), degree).unwrap();

        for _ in 0..ITERATIONS {
            let private_key = PrivateKey::<Testnet3>::new(&mut rng).unwrap();
            let address = Address::try_from(private_key).unwrap();
            let nonce = u64::rand(&mut rng);

            let solution = puzzle.prove(&epoch_challenge, address, nonce, None).unwrap();
            let proof_target = solution.to_target().unwrap();

            // Assert that the operation will pass if the minimum target is low enough.
            assert!(puzzle.prove(&epoch_challenge, address, nonce, Some(proof_target.saturating_sub(1))).is_ok());

            // Assert that the operation will fail if the minimum target is too high.
            assert!(puzzle.prove(&epoch_challenge, address, nonce, Some(proof_target.saturating_add(1))).is_err());
        }
    }
}

#[test]
fn test_edge_case_for_degree() {
    let mut rng = rand::thread_rng();

    // Generate srs.
    let max_degree = 1 << 15;
    let max_config = PuzzleConfig { degree: max_degree };
    let srs = CoinbasePuzzle::<Testnet3>::setup(max_config).unwrap();

    // Generate PK and VK.
    let degree = (1 << 13) - 1;
    let puzzle = CoinbasePuzzle::<Testnet3>::trim(&srs, PuzzleConfig { degree }).unwrap();

    // Generate proof inputs
    let private_key = PrivateKey::<Testnet3>::new(&mut rng).unwrap();
    let address = Address::try_from(private_key).unwrap();
    let epoch_challenge = EpochChallenge::new(rng.gen(), Default::default(), degree).unwrap();

    // Generate a prover solution.
    let prover_solution = puzzle.prove(&epoch_challenge, address, rng.gen(), None).unwrap();
    let coinbase_solution = CoinbaseSolution::new(vec![prover_solution]).unwrap();
    assert!(puzzle.check_solutions(&coinbase_solution, &epoch_challenge, 0u64).is_ok());
}

/// Use `cargo test profiler --features timer` to run this test.
#[ignore]
#[test]
fn test_profiler() -> Result<()> {
    fn sample_address_and_nonce(rng: &mut (impl CryptoRng + RngCore)) -> (Address<Testnet3>, u64) {
        let private_key = PrivateKey::new(rng).unwrap();
        let address = Address::try_from(private_key).unwrap();
        let nonce = rng.next_u64();
        (address, nonce)
    }

    let mut rng = rand::thread_rng();

    // Generate srs.
    let max_degree = 1 << 15;
    let max_config = PuzzleConfig { degree: max_degree };
    let universal_srs = CoinbasePuzzle::<Testnet3>::setup(max_config).unwrap();

    // Generate PK and VK.
    let degree = (1 << 13) - 1;
    let config = PuzzleConfig { degree };
    let puzzle = CoinbasePuzzle::trim(&universal_srs, config).unwrap();

    // Generate proof inputs
    let epoch_challenge = EpochChallenge::new(rng.next_u32(), Default::default(), degree).unwrap();

    for batch_size in [10, 100, <Testnet3 as Network>::MAX_SOLUTIONS] {
        // Generate the solutions.
        let solutions = (0..batch_size)
            .map(|_| {
                let (address, nonce) = sample_address_and_nonce(&mut rng);
                puzzle.prove(&epoch_challenge, address, nonce, None).unwrap()
            })
            .collect::<Vec<_>>();
        // Construct the solutions.
        let solutions = CoinbaseSolution::new(solutions).unwrap();
        // Verify the solutions.
        puzzle.check_solutions(&solutions, &epoch_challenge, 0u64).unwrap();
    }

    bail!("\n\nRemember to #[ignore] this test!\n\n")
}
