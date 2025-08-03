import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReturnFile {
    public void writeProfileToFile(String profile, Path outputPath) throws IOException {
        Files.writeString(outputPath, profile);
    }
}
