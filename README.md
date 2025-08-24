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
