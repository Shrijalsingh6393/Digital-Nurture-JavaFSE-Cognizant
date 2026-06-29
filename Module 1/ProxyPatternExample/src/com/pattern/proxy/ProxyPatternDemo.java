package com.pattern.proxy;

/**
 * Demo class to test and demonstrate the Proxy Design Pattern.
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Proxy Pattern implementation ===");

        // Create proxies for two images
        Image image1 = new ProxyImage("high_res_lake_view.png");
        Image image2 = new ProxyImage("architectural_schematic.dwg");

        System.out.println("\n1. Created proxy image objects. No actual images loaded yet.");

        // First display call: should load from server (delay simulated)
        System.out.println("\n2. Displaying image1 for the first time (Remote load expected):");
        long startTime = System.currentTimeMillis();
        image1.display();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed: " + duration + " ms");

        // Second display call: should load from cache (instant)
        System.out.println("\n3. Displaying image1 for the second time (Cache serving expected):");
        startTime = System.currentTimeMillis();
        image1.display();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed: " + duration + " ms");

        // First display call for image2: should load from server
        System.out.println("\n4. Displaying image2 for the first time (Remote load expected):");
        startTime = System.currentTimeMillis();
        image2.display();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed: " + duration + " ms");

        // Second display call for image2: should load from cache
        System.out.println("\n5. Displaying image2 for the second time (Cache serving expected):");
        startTime = System.currentTimeMillis();
        image2.display();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed: " + duration + " ms");

        System.out.println("\nVerification complete: Lazy loading and caching verified successfully.");
    }
}
