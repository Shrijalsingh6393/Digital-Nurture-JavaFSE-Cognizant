package com.pattern.adapter;

/**
 * Adaptee class representing the PayPal payment gateway.
 * This class has an incompatible interface that does not implement PaymentProcessor.
 */
public class PayPalGateway {
    /**
     * Specialized method for PayPal payments.
     * 
     * @param amount amount to pay
     */
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal Gateway.");
    }
}
