use serde_json::json;
use std::collections::HashMap;

use snarkvm_console_network::Testnet3;
use snarkvm_console_network::*;
use snarkvm_synthesizer::{Program, Closure, Function};
use snarkvm_synthesizer::program::Import;
use snarkvm_synthesizer::prelude::Mapping;
use snarkvm_console_program::{ProgramID, StructType, RecordType};

use snarkvm_synthesizer::program::MapKey;

type CurrentNetwork = Testnet3;

trait JsonBody {
    fn to_json(&self) -> serde_json::Value;
}

impl JsonBody for Program::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {

        // collect id
        let j_id = self.id().to_json();

        // collect imports
        // ref: https://github.com/AleoHQ/snarkVM/blob/testnet3/synthesizer/program/src/parse.rs#L139C38-L139C38
        // HASHMAP VERSION
        // let mut j_imports: HashMap<String, serde_json::Value> = HashMap::new();
        // if !self.imports().is_empty() {
        //     for (key, val) in &*self.imports() {
        //         j_imports.insert(key.to_str_index(), val.to_json());
        //     }
        // }
        // VEC VERSION
        let mut j_imports: Vec<serde_json::Value> = Vec::new();
        if !self.imports().is_empty() {
            for val in self.imports().values() {
                j_imports.push(val.to_json());
            }
        }

        // collect mappings
        let mut j_mappings: Vec<serde_json::Value> = Vec::new();
        if !self.mappings().is_empty() {
            for val in self.mappings().values() {
                j_mappings.push(val.to_json());
            }
        }

        // collect structs
        let mut j_structs: Vec<serde_json::Value> = Vec::new();
        if !self.structs().is_empty() {
            for val in self.structs().values() {
                j_structs.push(val.to_json());
            }
        }

        // collect records
        let mut j_records: Vec<serde_json::Value> = Vec::new();
        if !self.records().is_empty() {
            for val in self.records().values() {
                j_records.push(val.to_json());
            }
        }

        // collect closures
        let mut j_closures: Vec<serde_json::Value> = Vec::new();
        if !self.closures().is_empty() {
            for val in self.closures().values() {
                j_closures.push(val.to_json());
            }
        }

        // collect functions
        let mut j_functions: Vec<serde_json::Value> = Vec::new();
        if !self.functions().is_empty() {
            for val in self.functions().values() {
                j_functions.push(val.to_json());
            }
        }

        json!({
            "type": "Program",
            "id": j_id,
            "imports": j_imports,
            // "identifiers": 0,
            "mappings": j_mappings,
            "structs": j_structs,
            "records": j_records,
            "closures": j_closures,
            "functions": j_functions,
        })
    }
}

impl JsonBody for ProgramID::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {
        json!(self.name())
    }
}

impl JsonBody for Import::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {
        json!({
            "type": "Import",
            "program_id": self.program_id().to_json(),
        })
    }
}

impl JsonBody for Mapping::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {
        json!({
            "type": "Mapping",
            "name": format!("{}", self.name()), // Identifier
            "key": self.key().to_json(),
            "value": "TBD",
        })
    }
}

impl JsonBody for StructType::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {
        json!({
            "type": "StructType",
            "TBD": "TBD",
        })
    }
}

impl JsonBody for RecordType::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {
        json!({
            "type": "RecordType",
            "TBD": "TBD",
        })
    }
}

impl JsonBody for Closure::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {
        json!({
            "type": "Closure",
            "TBD": "TBD,"
        })
    }
}

impl JsonBody for Function::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {
        json!({
            "type": "Function",
            "TBF": "TBD"
        })
    }
}

impl JsonBody for MapKey::<CurrentNetwork> {
    fn to_json(&self) -> serde_json::Value {
        json!({
            "type": "MapKey",
            "plaintext_type": format!("{}", self.plaintext_type()), // PlaintextType
        })
    }
}

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
