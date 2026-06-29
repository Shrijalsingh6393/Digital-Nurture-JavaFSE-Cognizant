package com.pattern.builder;

/**
 * Product class representing a Computer with various configurable parts.
 * Uses the Builder Pattern for construction.
 */
public class Computer {
    // Required attributes
    private final String CPU;
    private final String RAM;

    // Optional attributes
    private final String storage;
    private final String GPU;
    private final String OS;
    private final boolean hasWiFi;
    private final boolean hasBluetooth;

    // Private constructor so that Computer can only be instantiated via the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.OS = builder.OS;
        this.hasWiFi = builder.hasWiFi;
        this.hasBluetooth = builder.hasBluetooth;
    }

    // Getters for the attributes
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    public String getOS() {
        return OS;
    }

    public boolean hasWiFi() {
        return hasWiFi;
    }

    public boolean hasBluetooth() {
        return hasBluetooth;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computer Configuration:\n");
        sb.append(" - CPU: ").append(CPU).append("\n");
        sb.append(" - RAM: ").append(RAM).append("\n");
        sb.append(" - Storage: ").append(storage != null ? storage : "None").append("\n");
        sb.append(" - GPU: ").append(GPU != null ? GPU : "Integrated Graphics").append("\n");
        sb.append(" - OS: ").append(OS != null ? OS : "None").append("\n");
        sb.append(" - WiFi: ").append(hasWiFi ? "Enabled" : "Disabled").append("\n");
        sb.append(" - Bluetooth: ").append(hasBluetooth ? "Enabled" : "Disabled").append("\n");
        return sb.toString();
    }

    /**
     * Static nested Builder class to build instances of Computer.
     */
    public static class Builder {
        // Required attributes
        private final String CPU;
        private final String RAM;

        // Optional attributes with default values
        private String storage;
        private String GPU;
        private String OS;
        private boolean hasWiFi;
        private boolean hasBluetooth;

        /**
         * Builder constructor with required parameters.
         * 
         * @param CPU the processor model
         * @param RAM the amount of system memory
         */
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        /**
         * Sets the storage parameter.
         * 
         * @param storage e.g., "1TB NVMe SSD"
         * @return this Builder instance
         */
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        /**
         * Sets the GPU parameter.
         * 
         * @param GPU e.g., "NVIDIA RTX 4070"
         * @return this Builder instance
         */
        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        /**
         * Sets the Operating System parameter.
         * 
         * @param OS e.g., "Windows 11 Home"
         * @return this Builder instance
         */
        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        /**
         * Enables/disables WiFi module.
         * 
         * @param hasWiFi true if WiFi is present
         * @return this Builder instance
         */
        public Builder setWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        /**
         * Enables/disables Bluetooth module.
         * 
         * @param hasBluetooth true if Bluetooth is present
         * @return this Builder instance
         */
        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        /**
         * Constructs the final Computer object.
         * 
         * @return a new Computer instance configured by this Builder
         */
        public Computer build() {
            return new Computer(this);
        }
    }
}
