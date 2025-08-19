import java.nio.file.*;
import java.util.*;

public class SequenceProcessor {

    private final SequenceReader reader = new SequenceReader();

    public void process(Path fastaFile) {
        try {
            List<String> sequences = reader.readSequences(fastaFile);

            // Number of sequences
            System.out.println("Number of sequences: " + sequences.size());

            // Length of the first sequence
            int length = sequences.get(0).length();
            System.out.println("Alignment length: " + length);

            // Check if all sequences have the same length
            boolean allSameLength = sequences.stream().allMatch(seq -> seq.length() == length);
            if (!allSameLength) {
                System.out.println("Not all sequences have the same length!");
            } else {
                System.out.println("All sequences are aligned (equal length).");
            }

            // Preview first sequence
            System.out.println("\nPreview of first sequence:");
            System.out.println(sequences.get(0).substring(0, Math.min(50, length)));

        } catch (Exception e) {
            System.err.println("Error while processing: " + e.getMessage());
        }
    }
}