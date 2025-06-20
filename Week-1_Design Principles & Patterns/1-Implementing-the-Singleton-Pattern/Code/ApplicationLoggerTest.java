// Singleton Logger class
class ApplicationLogger {

    // Static instance for Singleton pattern
    private static ApplicationLogger instance;

    // Private constructor to prevent external instantiation
    private ApplicationLogger() {
        // Initialization if needed
    }

    /**
     * Provides access to the single instance of ApplicationLogger.
     *
     * @return Singleton instance
     */
    public static ApplicationLogger getInstance() {
        if (instance == null) {
            instance = new ApplicationLogger();
        }
        return instance;
    }

    /**
     * Logs a message to the console.
     *
     * @param message Message to log
     */
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Class to test the Singleton Logger implementation
public class ApplicationLoggerTest {
    public static void main(String[] args) {

        // Get Singleton instances
        ApplicationLogger logger1 = ApplicationLogger.getInstance();
        ApplicationLogger logger2 = ApplicationLogger.getInstance();

        // Test logging
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Verify Singleton behavior
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance. Singleton works!");
        } else {
            System.out.println("Different instances exist. Singleton failed.");
        }
    }
}
