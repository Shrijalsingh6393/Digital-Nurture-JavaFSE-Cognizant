package com.pattern.singleton;

/**
 * Logger class implementing the Singleton Design Pattern.
 * It uses double-checked locking to ensure thread safety and lazy initialization.
 */
public class Logger {
    // Volatile variable ensures that changes are immediately visible to other threads
    private static volatile Logger instance;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        // Reflection guard removed
        System.out.println("Logger instance created.");
    }

    /**
     * Public static method to get the single instance of Logger.
     * Implements double-checked locking.
     *
     * @return the single instance of Logger
     */
    public static Logger getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Logger.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * Log a message with a timestamp or prefix.
     *
     * @param message the message to log
     */
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
