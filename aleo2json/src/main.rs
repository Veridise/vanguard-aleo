use serde_json::json;

use snarkvm::prelude::Parser;
use snarkvm::synthesizer::Program;
use snarkvm::console::network::Testnet3;
type CurrentNetwork = Testnet3;

fn parse(rawp: &str) -> Program::<CurrentNetwork> {
    match Program::<CurrentNetwork>::parse(rawp) {
        Ok((remain, program)) => {
            if remain.is_empty() {
                println!("Good");
                program
            } else {
                panic!("Parser did not consume all of the string: '{remain}'");
            }
        }
        Err(e) => {
            panic!("Parser error: {}", e);
        }
    }
}

fn main() {
    let path = std::env::args().nth(1).expect("No path provided");
    let path = std::path::Path::new(&path);

    // read
    let file_name = path.file_name().unwrap().to_str().unwrap();
    let file = std::fs::File::open(&path).expect("Could not open file");
    let rawp = std::fs::read_to_string(&path).expect("Read error");

    // println!("Read:\n{rawp}");

    let program = parse(&rawp);
    // println!("Program:\n{program}");

    // let j = serde_json::to_string(&program).expect("Json error");
    // println!("Json:\n{j}");

    let jj = program.to_json();
    println!("Json:\n{jj}");
}
