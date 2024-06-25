package log2;

public class Main {
    public static void main(String[] args) {
        Logger consoleLogger = LoggerFactory.onConsole();
        Logger fileLogger = LoggerFactory.onFile("log.txt");

        consoleLogger.log(Level.DEBUG, "Este é um debug message.");
        consoleLogger.log(Level.WARNING, "Este é um warning message.");
        consoleLogger.log(Level.ERROR, "Este é um error message.");

        fileLogger.log(Level.DEBUG, "Este é um debug message.");
        fileLogger.log(Level.WARNING, "Este é um warning message.");
        fileLogger.log(Level.ERROR, "Este é um error message.");
    }
}

