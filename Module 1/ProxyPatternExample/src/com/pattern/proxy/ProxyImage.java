package com.pattern.proxy;

/**
 * Proxy class that controls access to the RealImage class.
 * It implements lazy loading and caching to avoid loading images repeatedly.
 */
public class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    /**
     * Constructor. RealImage is NOT instantiated here.
     * 
     * @param filename name of the image file
     */
    public ProxyImage(String filename) {
        this.filename = filename;
    }

    /**
     * Displays the image. Loads it from the server if not already loaded,
     * otherwise serves it directly from the cache.
     */
    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("[Proxy] First request for \"" + filename + "\". Lazy initializing RealImage...");
            realImage = new RealImage(filename);
        } else {
            System.out.println("[Proxy] Serving \"" + filename + "\" from cache.");
        }
        realImage.display();
    }
}
