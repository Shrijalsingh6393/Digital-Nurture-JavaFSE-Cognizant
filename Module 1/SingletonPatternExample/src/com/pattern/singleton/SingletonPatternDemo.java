package com.pattern.singleton;

/**
 * Test class to verify the Singleton implementation of the Logger class.
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern ===");

        // Retrieve the Logger instance for the first time
        Logger logger1 = Logger.getInstance();
        
        // Retrieve the Logger instance for the second time
        Logger logger2 = Logger.getInstance();

        // Print details and hash codes of both instances
        System.out.println("Logger 1 reference: " + logger1);
        System.out.println("Logger 2 reference: " + logger2);
        System.out.println("Logger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());

        // Verify if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("\nSUCCESS: Both logger1 and logger2 point to the exact same instance.");
        } else {
            System.out.println("\nFAILURE: Logger instances are different. Singleton pattern is violated!");
        }

        // Test logging functionality
        logger1.log("This is a message from logger1.");
        logger2.log("This is a message from logger2.");
    }
}
