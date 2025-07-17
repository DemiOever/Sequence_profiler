import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.Arrays;

@CommandLine.Command(name="VCFfilter", version="VCFfilter 0.1", mixinStandardHelpOptions = true)
public class CommandlineProcessor implements Runnable {
    private static Logger logger = LogManager.getLogger(CommandlineProcessor.class.getName());

    @Parameters(index = "0", paramLabel = "<output>", description = "Output VCF file name")
    private String outputVCF;

    // FIXME: should be required, but is ignored
    @Parameters(index = "1..*", description = "Input VCF file(s)")
    private String[] inputVCF;

    @Option(names = {"-f", "--filter-value"}, description = "Filter value")
    private int filterOptions;

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

        logger.info("Output file: {}", outputVCF);
        logger.info("Input VCF files: {}", Arrays.toString(inputVCF));
        logger.info("Filter options: {}", filterOptions);
        logger.info("Verbosity: {}", Arrays.toString(verbose));

        // Do something with the input
        logger.debug("Program finished");
    }
}
