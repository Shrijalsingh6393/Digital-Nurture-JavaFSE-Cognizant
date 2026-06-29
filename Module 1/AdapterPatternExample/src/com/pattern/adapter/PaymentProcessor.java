package com.pattern.adapter;

/**
 * Target interface that defines the contract for processing payments.
 */
public interface PaymentProcessor {
    /**
     * Processes a payment for the specified amount.
     * 
     * @param amount the payment amount
     */
    void processPayment(double amount);
}
