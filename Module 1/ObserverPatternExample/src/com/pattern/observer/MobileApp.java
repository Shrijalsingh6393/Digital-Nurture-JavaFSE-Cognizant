package com.pattern.observer;

/**
 * Concrete observer class representing a mobile app client.
 */
public class MobileApp implements Observer {
    private final String appName;

    /**
     * Constructor.
     * 
     * @param appName user/application name
     */
    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("MobileApp [" + appName + "] Push Alert: " + stockName + " price changed to $" + stockPrice);
    }
}
