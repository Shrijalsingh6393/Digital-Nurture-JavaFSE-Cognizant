package com.pattern.decorator;

/**
 * Concrete decorator that adds Slack notification capabilities.
 */
public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Send existing notifications (e.g. Email, SMS)
        sendSlack(message);   // Add Slack functionality
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message notification with message: \"" + message + "\"");
    }
}
