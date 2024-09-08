package logger;

import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        // Get logger instance
        LoggerImpl logger = LoggerImpl.getInstance();

        // Set log file path
        logger.setLogFile("app.log");

        // Log some messages
        logger.log(Level.INFO, "Application started.");
        logger.log(Level.WARNING, "An error occurred.");

        // Flush and close the logger
        logger.flush();
        logger.close();

        // Reset the logger if necessary
        LoggerImpl.resetInstance();
    }
}
