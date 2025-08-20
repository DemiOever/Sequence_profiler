import java.nio.file.*;
import java.util.*;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SequenceProcessor {
    private static final Logger logger = LogManager.getLogger(SequenceProcessor.class);

    private final SequenceReader reader = new SequenceReader();
    private final IUPACProfileBuilder builder = new IUPACProfileBuilder();

    public void process(Path fastaFile, Path outputFile) {
        try {
            logger.info("Starting sequence processing...");
            logger.debug("Reading input file: {}", fastaFile.toAbsolutePath());

            List<String> sequences = reader.readSequences(fastaFile);

            logger.info("Number of sequences: {}", sequences.size());
            logger.info("Alignment length: {}", sequences.get(0).length());

            // Validation: equal length check
            boolean allEqual = sequences.stream()
                    .map(String::length)
                    .distinct()
                    .count() == 1;
            if (allEqual) {
                logger.info("All sequences are aligned (equal length).");
            } else {
                logger.warn("Sequences have different lengths!");
            }

            logger.debug("Preview of first sequence: {}...",
                    sequences.get(0).substring(0, Math.min(50, sequences.get(0).length())));

            // Build and print IUPAC profile
            String profile = builder.buildProfile(sequences);
            logger.info("IUPAC profile generated (length {} characters)", profile.length());

            // Save profile to file
            ReturnFile writer = new ReturnFile();
            writer.writeProfile(profile, outputFile);
            logger.info("Profile successfully saved to {}", outputFile.toAbsolutePath());

        } catch (IOException e) {
            logger.error("Error while processing: {}", e.getMessage(), e);
        }
    }
}