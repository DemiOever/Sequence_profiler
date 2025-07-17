import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CommandlineProcessor()).execute(args);
        System.exit(exitCode);
    }

    public static int multiply(int x, int y, int z) {
        return x * y * z;
    }

    private int zValue;

    public Main(int zValue){
        this.zValue = zValue;
    }

    public void start(String[] args) {
        int length = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int surface = multiply(length, width, this.zValue);
        System.out.println("surface = " + surface);
    }
}
