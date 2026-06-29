package com.pattern.decorator;

/**
 * Concrete decorator that adds SMS notification capabilities.
 */
public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Send existing notifications (e.g. Email)
        sendSMS(message);     // Add SMS functionality
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification with message: \"" + message + "\"");
    }
}
