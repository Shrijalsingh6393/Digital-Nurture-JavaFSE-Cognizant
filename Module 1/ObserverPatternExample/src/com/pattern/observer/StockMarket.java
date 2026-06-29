package com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject class implementing the Stock interface.
 * Tracks stock prices and notifies registered observers of any changes.
 */
public class StockMarket implements Stock {
    private final List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    /**
     * Updates the stock market data and triggers a notification to all observers.
     * 
     * @param stockName name of the stock
     * @param stockPrice new price of the stock
     */
    public void setStockPrice(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}
