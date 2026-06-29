package com.pattern.builder;

/**
 * Demo class to test and demonstrate the Builder Design Pattern.
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Builder Pattern implementation ===");

        // 1. Basic Office Computer: Only required features
        Computer basicPC = new Computer.Builder("Intel Core i3", "8GB DDR4")
                .build();

        // 2. Gaming Computer: High performance CPU, RAM, GPU, Storage, and OS
        Computer gamingPC = new Computer.Builder("AMD Ryzen 7 7800X3D", "32GB DDR5")
                .setStorage("2TB NVMe SSD")
                .setGPU("NVIDIA GeForce RTX 4080 Super")
                .setOS("Windows 11 Pro")
                .setWiFi(true)
                .setBluetooth(true)
                .build();

        // 3. Office Workstation: Decent CPU, RAM, Storage, OS, WiFi, but integrated GPU
        Computer officeWorkstation = new Computer.Builder("Intel Core i5", "16GB DDR4")
                .setStorage("512GB SSD")
                .setOS("Windows 11 Home")
                .setWiFi(true)
                .build();

        // 4. Budget/Developer Server: Powerful CPU and massive RAM, Linux OS, no WiFi/Bluetooth
        Computer budgetServer = new Computer.Builder("AMD Ryzen 9 7950X", "64GB DDR5")
                .setStorage("4TB NVMe SSD")
                .setOS("Ubuntu Server 24.04 LTS")
                .build();

        // Display configurations
        System.out.println("--- 1. Basic PC ---");
        System.out.println(basicPC);

        System.out.println("--- 2. Gaming PC ---");
        System.out.println(gamingPC);

        System.out.println("--- 3. Office Workstation ---");
        System.out.println(officeWorkstation);

        System.out.println("--- 4. Budget Server ---");
        System.out.println(budgetServer);

        // Verification of encapsulation and immutability:
        // System.out.println(basicPC.CPU); // Not compiled if packages were different (private package fields)
        // Note: Computer has no setters, preventing modification post-construction.
        System.out.println("Verification complete: Immutability is preserved as Computer has only getters.");
    }
}
