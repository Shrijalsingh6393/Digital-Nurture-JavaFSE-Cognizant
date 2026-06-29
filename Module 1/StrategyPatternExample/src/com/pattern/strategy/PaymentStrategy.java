package com.pattern.strategy;

/**
 * Strategy interface that defines the payment contract.
 */
public interface PaymentStrategy {
    /**
     * Executes the payment for a given amount.
     * 
     * @param amount the payment amount
     */
    void pay(double amount);
}
