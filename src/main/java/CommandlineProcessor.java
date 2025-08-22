import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.nio.file.Files;
import java.nio.file.Path;

@CommandLine.Command(name="SequenceProfiler", version="SequenceProfiler 0.1", mixinStandardHelpOptions = true)
public class CommandlineProcessor implements Runnable {
    private static Logger logger = LogManager.getLogger(CommandlineProcessor.class.getName());

    @Option(names = {"-i", "--input-file"}, required = true)
    private String inputFasta;

    @Option(names = {"-op", "--output-profile"}, required = false)
    private String outputProfileFile;

    @Option(names = {"-o", "--output-file"}, required = false)
    private String outputFile;

    @Option(names = {"-v"}, description = "Verbose logging")
    private boolean[] verbose = new boolean[0];

    @Override
    public void run() {
        if (verbose.length > 1) {
            Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.DEBUG);
        } else if (verbose.length > 0) {
            Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.INFO);
        }
        logger.debug("Processing input arguments ...");

        logger.info("Input FASTA file: {}", inputFasta);
        logger.info("Output profile file: {}", outputProfileFile);
        if (outputFile != null) {
            logger.info("Full results file: {}", outputFile);
        }

        try {
            Path inputPath = Path.of(inputFasta);
            if (!Files.exists(inputPath)) {
                logger.error("Input file does not exist: {}", inputPath);
                return;
            }

            Path outputPath = Path.of(outputProfileFile);
            logger.info("Processing file {} -> {}", inputPath, outputPath);

            SequenceProcessor processor = new SequenceProcessor();
            processor.process(inputPath, outputPath);

            logger.info("Processing finished successfully");

        } catch(Exception e){
            logger.error("Failed to process {}: {}", inputFasta, e.getMessage(), e);
        }
    }
}
