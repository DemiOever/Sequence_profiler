import picocli.CommandLine;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SequenceReader reader = new SequenceReader();
        try {
            List<String> seqs = reader.readSequences(Paths.get("C:/Users/DemiS/Documents/School/Schooljaar_24_25/sequence.fasta"));
            seqs.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Fout bij inlezen: " + e.getMessage());
        }
    }

}
