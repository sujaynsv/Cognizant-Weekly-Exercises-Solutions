// Singleton class responsible for logging messages throughout the application
public class ApplicationLogger {

    // Static instance of the Singleton class
    private static ApplicationLogger instance;

    // Private constructor to prevent external instantiation
    private ApplicationLogger() {
        // Any initialization if needed
    }

    /**
     * Provides global access to the single instance of ApplicationLogger.
     * 
     * @return Singleton instance of ApplicationLogger
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
     * @param message The message to log
     */
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }

    // Main method for simple testing of Singleton behavior
    public static void main(String[] args) {
        ApplicationLogger loggerInstance1 = ApplicationLogger.getInstance();
        ApplicationLogger loggerInstance2 = ApplicationLogger.getInstance();

        loggerInstance1.log("This is the first log message.");
        loggerInstance2.log("This is the second log message.");

        if (loggerInstance1 == loggerInstance2) {
            System.out.println("Both loggerInstance1 and loggerInstance2 refer to the same instance. Singleton works!");
        } else {
            System.out.println("Different instances exist. Singleton failed.");
        }
    }
}
