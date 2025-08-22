import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
                SequenceProcessor processor = new SequenceProcessor();

        Path fastaFile = Paths.get("C:/Users/DemiS/Documents/School/Schooljaar_24_25/60_amniota_vertebrates_Mercator_Pecan.fa");
        Path outputFile = Paths.get("C:/Users/DemiS/Documents/School/Schooljaar_24_25/profile.txt");

        processor.process(fastaFile, outputFile);
    }
}