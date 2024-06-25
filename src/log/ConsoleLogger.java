package log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements Logger {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public void logDebug(String message) {
        System.out.println(GREEN + getCurrentTime() + " [DEBUG] " + message + RESET);
    }

    @Override
    public void logWarning(String message) {
        System.out.println(YELLOW + getCurrentTime() + " [WARNING] " + message + RESET);
    }

    @Override
    public void logError(String message) {
        System.out.println(RED + getCurrentTime() + " [ERROR] " + message + RESET);
    }
}

