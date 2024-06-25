package log;

public class Main {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("log.txt");

        consoleLogger.logDebug("Essa é uma mensagem em debug.");
        consoleLogger.logWarning("Essa é uma mensagem de aviso(warning).");
        consoleLogger.logError("Essa é uma mensagem que da erro.");

        fileLogger.logDebug("Essa é uma mensagem em debug.");
        fileLogger.logWarning("Essa é uma mensagem de aviso(warning).");
        fileLogger.logError("Essa é uma mensagem que da erro.");
    }
}
