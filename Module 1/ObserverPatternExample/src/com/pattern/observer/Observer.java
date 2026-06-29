package com.pattern.observer;

/**
 * Observer interface that defines the contract to receive updates from a Subject.
 */
public interface Observer {
    /**
     * Receives price updates from the stock market subject.
     * 
     * @param stockName the name of the stock
     * @param stockPrice the updated price of the stock
     */
    void update(String stockName, double stockPrice);
}
