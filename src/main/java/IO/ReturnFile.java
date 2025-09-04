package IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedWriter;

public class ReturnFile {

    /**
     * Writes the IUPAC profile to both console and to the given file
     *
     * @param profile the IUPAC profile
     * @param outputPath path to output file
     * @throws IOException if writing to the file fails
     */
    public void writeProfile(String profile, Path outputPath) throws IOException {
        System.out.println("Generated IUPAC Profile:");
        System.out.println(profile);

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            writer.write(">IUPAC_Profile");
            writer.newLine();
            writer.write(profile);
            writer.newLine();
        }
    }
}
