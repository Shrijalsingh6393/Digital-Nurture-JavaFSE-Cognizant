package com.pattern.command;

/**
 * Receiver class containing the actual business logic.
 * Knows how to perform the operations associated with carrying out a request.
 */
public class Light {
    private final String location;

    /**
     * Constructor.
     *
     * @param location descriptive location of the light (e.g., "Living Room")
     */
    public Light(String location) {
        this.location = location;
    }

    /**
     * Turns the light on.
     */
    public void turnOn() {
        System.out.println("[Light] " + location + " light is now ON.");
    }

    /**
     * Turns the light off.
     */
    public void turnOff() {
        System.out.println("[Light] " + location + " light is now OFF.");
    }
}
