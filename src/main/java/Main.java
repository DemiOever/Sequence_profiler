import CLI.CommandlineProcessor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        Configurator.setRootLevel(Level.INFO);

        int exitCode = new CommandLine(new CommandlineProcessor()).execute(args);
        System.exit(exitCode);
    }
}