import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SequenceReader {
    private static final Set<Character> VALID_CHARS = Set.of(
            'A','C','G','T',
            'R','Y','S','W','K','M',
            'B','D','H','V',
            'N',
            '-', '.'
    );

    /**
     * Reads DNA sequences from a FASTA file.
     * @param filePath path to FASTA file
     * @return List of sequences (strings without headers)
     * @throws IOException in case of reading errors and/or invalid characters
     */
    public List<String> readSequences(Path filePath) throws IOException {
        List<String> sequences = new ArrayList<>();
        StringBuilder currentSeq = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim().toUpperCase();

                if (line.isEmpty()) {
                    // Ensures that empty lines are skipped
                    continue;
                }
                if (line.startsWith(">")) {
                    // Header starts with >, saves sequence if it encounters a header
                    if (currentSeq.length() > 0) {
                        sequences.add(currentSeq.toString());
                        currentSeq.setLength(0);
                    }
                    // Skips line with header
                    continue;
                }

                // Validate
                for (char c : line.toCharArray()) {
                    if (!VALID_CHARS.contains(c)) {
                        throw new IOException("Invalid character '" + c + "' in the given sequence.");
                    }
                }

                // Add sequence to current process
                currentSeq.append(line);
            }

            // Saves last sequence
            if (currentSeq.length() > 0) {
                sequences.add(currentSeq.toString());
            }
        }

        if (sequences.isEmpty()) {
            throw new IOException("Didn't found a sequence in the input file " + filePath);
        }

        return sequences;
    }
}
