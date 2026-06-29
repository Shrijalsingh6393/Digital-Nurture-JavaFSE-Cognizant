package com.pattern.observer;

/**
 * Concrete observer class representing a web application client.
 */
public class WebApp implements Observer {
    private final String clientName;

    /**
     * Constructor.
     * 
     * @param clientName user/web client name
     */
    public WebApp(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("WebApp [" + clientName + "] Notification: Stock " + stockName + " is now trading at $" + stockPrice);
    }
}
