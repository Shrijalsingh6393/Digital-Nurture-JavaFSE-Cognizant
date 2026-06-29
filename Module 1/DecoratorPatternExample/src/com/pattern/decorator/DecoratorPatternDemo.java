package com.pattern.decorator;

/**
 * Demo class to test and demonstrate the Decorator Design Pattern.
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Decorator Pattern implementation ===");

        // 1. Basic Notifier (Email only)
        System.out.println("\n--- Scenario 1: Basic Email Notifier ---");
        Notifier basicEmail = new EmailNotifier();
        basicEmail.send("Welcome to our service!");

        // 2. Email + SMS Notifier
        System.out.println("\n--- Scenario 2: Email + SMS Notifier ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send("Security alert: New login detected.");

        // 3. Email + Slack Notifier
        System.out.println("\n--- Scenario 3: Email + Slack Notifier ---");
        Notifier emailAndSlack = new SlackNotifierDecorator(new EmailNotifier());
        emailAndSlack.send("Monthly report is ready to view.");

        // 4. Email + SMS + Slack Notifier
        System.out.println("\n--- Scenario 4: Email + SMS + Slack Notifier ---");
        Notifier allChannels = new SlackNotifierDecorator(
                                    new SMSNotifierDecorator(
                                        new EmailNotifier()
                                    )
                               );
        allChannels.send("CRITICAL: Server CPU usage exceeded 95%!");

        System.out.println("\nVerification complete: Decorator Pattern allows dynamic addition of responsibilities.");
    }
}
