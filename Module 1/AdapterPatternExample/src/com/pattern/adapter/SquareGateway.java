package com.pattern.adapter;

/**
 * Adaptee class representing the Square payment gateway.
 * This class has an incompatible interface that does not implement PaymentProcessor.
 */
public class SquareGateway {
    /**
     * Specialized method for Square payments.
     * 
     * @param amount transaction amount
     */
    public void executeTransaction(double amount) {
        System.out.println("Executing transaction of $" + amount + " via Square Gateway.");
    }
}
