# K-Compiler

A compiler for an artificial language that performs scanning, parsing, semantic analysis, and generates x86 assembly code from `.k` source files.

## Table of Contents
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Building](#building)
- [Usage](#usage)
- [Grammar](#grammar)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Project Structure

```
.
├── src/                   # Java source files
│   ├── Compiler.java      # Entry point; orchestrates compilation stages
│   ├── Lexer.java         # Tokenizes input source
│   ├── Parser.java        # Parses tokens into AST
│   ├── Program.java       # AST root and code generation entry
│   ├── Procedure.java     # Base class for procedures (extern/internal)
│   ├── Utility.java       # Error reporting and debugging support
│   ├── Declaration.java   # Base class for declarations
│   ├── VariableDeclaration.java
│   ├── Token.java
│   ├── Type.java
│   └── ...                # Additional source files
├── grammar.txt            # BNF grammar of the `.k` language
├── compile.sh             # Build script: compiles all source files
├── tests/                 # Test suite
│   ├── test.k
│   ├── memoize.k
│   └── debug.k
└── README.md              # This file
```

## Prerequisites

- Java SE Development Kit (JDK) 8 or later
- Unix-like shell (bash, zsh) for `compile.sh`

## Building

Run the provided build script:

```
chmod +x compile.sh
./compile.sh
```

This will compile all Java source files under `src/` into the appropriate output directory.

## Usage

To compile a `.k` file into an assembly file:

```
java -cp src Compiler path/to/source.k
```

This will produce `path/to/source.asm` alongside your source file.

## Grammar

See [grammar.txt](grammar.txt) for the full BNF grammar specification of the `.k` language.

## Examples

Compile and run the `test.k` example:

```
./compile.sh
java -cp src Compiler tests/test.k
# Inspect the generated tests/test.asm
```
