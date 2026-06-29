package com.pattern.decorator;

/**
 * Concrete component implementing the base Notifier functionality.
 * Standard notification is sent via Email.
 */
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email notification with message: \"" + message + "\"");
    }
}
