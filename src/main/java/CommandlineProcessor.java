import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.Arrays;

@CommandLine.Command(name="SequenceProfiler", version="SequenceProfiler 0.1", mixinStandardHelpOptions = true)
public class CommandlineProcessor implements Runnable {
    private static Logger logger = LogManager.getLogger(CommandlineProcessor.class.getName());

    @Option(names = {"-i", "--input-file"}, required = true)
    private String[] inputFasta;

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

        logger.info("Input FASTA file(s): {}", Arrays.toString(inputFasta));
        logger.info("Output profile file: {}", outputProfileFile);
        logger.info("Output full result file: {}", outputFile);
        logger.info("Verbosity: {}", Arrays.toString(verbose));

        // Do something with the input
        logger.debug("Program finished");
    }
}
