# Sequence Profiler

---

This **Sequence Profiler** is a command-line utility designed for creating DNA sequence profiles from multiple sequence alignments (MSA). Given a set of aligned DNA sequences (gapped or ungapped), it computes a consensus sequence using **IUPAC ambiguity codes**, representing nucleotide variability at each position.

---

## Installation

To set up the Sequence Profiler, follow these steps:

1. **Clone the Repository**:  
   Download the source code from [GitHub](https://github.com/DemiOever/Sequence_profiler).

2. **Java Requirement**:  
   Ensure you have Java installed (Java 21).

3. **Build the Executable JAR**:  
   Navigate to the `sequenceprofiler` directory in your terminal and execute:
   ```bash
   ./gradlew build
    ```
   
## Usage

The **SequenceProfiler** reads an input FASTA file and generates a profile using IUPAC ambiguity codes. The basic syntax is:

```bash
java -jar SequenceProfiler.jar -i <input-file> [-op <output-profile>] [-o <output-file>] [-v]
```

## Command Options

| Option                  | Description                                         |
|-------------------------|-----------------------------------------------------|
| **-i, --input-file**    | Input FASTA file with aligned sequences (required). |
| **-op, --output-profile** | File path to save the IUPAC profile (optional)      |
| **-o, --output_file**   | File path to save full results (optional)           |
| **-v**                  | Verbose logging                                     |
| **-h, --help**                    | Help                            |

## Example usage

```bash
java -jar build/libs/Sequence_profiler-1.0-SNAPSHOT.jar -i "60_amniota_vertebrates_Mercator_Pecan.fa" -op profile.txt
```
You can replace the input, output profile, etc. with your own files and file paths.

## IUPAC ambiguity codes

Where each letter represents:

- A, C, G, T  -> single nucleotide
- R           -> A or G
- Y           -> C or T
- S           -> G or C
- W           -> A or T
- K           -> G or T
- M           -> A or C
- B           -> C, G, or T
- D           -> A, G, or T
- H           -> A, C, or T
- V           -> A, C, or G
- N           -> any nucleotide

## Contact

If you have questions or need any support, please contact me:

- **D. van 't Oever**: [d.van.t.oever@st.hanze.nl](mailto:d.van.t.oever@st.hanze.nl)