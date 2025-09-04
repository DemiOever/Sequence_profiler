package IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReturnFile {
private static final Logger logger = LogManager.getLogger(ReturnFile.class);

    /**
     * Writes the IUPAC profile to both console and to the given file
     *
     * @param profile the IUPAC profile
     * @param outputPath path to output file
     * @throws IOException if writing to the file fails
     */
    public void writeProfile(String profile, Path outputPath) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            writer.write(">IUPAC_Profile");
            writer.newLine();
            writer.write(profile);
            writer.newLine();
        }
    }

    public void logProfile(String profile) {
        logger.info("Generated IUPAC Profile: {}", profile);
    }
}
