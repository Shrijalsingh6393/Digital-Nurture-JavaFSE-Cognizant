package com.pattern.adapter;

/**
 * Adaptee class representing the Stripe payment gateway.
 * This class has an incompatible interface that does not implement PaymentProcessor.
 */
public class StripeGateway {
    /**
     * Specialized method for Stripe payments.
     * 
     * @param amount amount to charge
     */
    public void charge(double amount) {
        System.out.println("Charging $" + amount + " using Stripe Gateway.");
    }
}
