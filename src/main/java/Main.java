import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        // Later this will be replaced with CLI parsing (-i and -o)
        Path fastaFile = Paths.get("C:/Users/DemiS/Documents/School/Schooljaar_24_25/60_amniota_vertebrates_Mercator_Pecan.fa");

        SequenceProcessor processor = new SequenceProcessor();
        processor.process(fastaFile);
    }
}