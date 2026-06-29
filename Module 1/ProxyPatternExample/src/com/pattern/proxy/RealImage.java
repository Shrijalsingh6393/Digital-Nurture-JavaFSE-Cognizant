package com.pattern.proxy;

/**
 * Real Subject class that represents the actual image loaded from a remote server.
 * Loading the image is resource-intensive and simulated with a delay.
 */
public class RealImage implements Image {
    private final String filename;

    /**
     * Constructor which triggers loading from the remote server.
     * 
     * @param filename name of the image file
     */
    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    /**
     * Simulates a heavy loading process from a remote server.
     */
    private void loadFromRemoteServer() {
        System.out.print("Connecting and loading \"" + filename + "\" from remote server... ");
        try {
            // Simulate a network/loading delay of 1.5 seconds
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Loading interrupted.");
        }
        System.out.println("[DONE]");
    }

    @Override
    public void display() {
        System.out.println("Displaying image: \"" + filename + "\"");
    }
}
