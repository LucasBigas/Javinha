package log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private String fileName;

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private void writeToFile(String logLevel, String message) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(getCurrentTime() + " [" + logLevel + "] " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logDebug(String message) {
        writeToFile("DEBUG", message);
    }

    @Override
    public void logWarning(String message) {
        writeToFile("WARNING", message);
    }

    @Override
    public void logError(String message) {
        writeToFile("ERROR", message);
    }
}

