package com.pattern.observer;

/**
 * Subject interface defining methods to manage and notify observers.
 */
public interface Stock {
    /**
     * Registers an observer.
     * 
     * @param observer the observer to register
     */
    void registerObserver(Observer observer);

    /**
     * Deregisters/removes an observer.
     * 
     * @param observer the observer to deregister
     */
    void deregisterObserver(Observer observer);

    /**
     * Notifies all registered observers of price updates.
     */
    void notifyObservers();
}
