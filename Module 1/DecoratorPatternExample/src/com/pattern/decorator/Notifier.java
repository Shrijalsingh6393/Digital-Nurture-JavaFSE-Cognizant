package com.pattern.decorator;

/**
 * Component interface defining the contract for sending notifications.
 */
public interface Notifier {
    /**
     * Sends the notification message.
     * 
     * @param message the message to be sent
     */
    void send(String message);
}
