package com.pattern.strategy;

/**
 * Concrete Strategy class that implements PayPal payments.
 */
public class PayPalPayment implements PaymentStrategy {
    private final String email;
    private final String password;

    /**
     * Constructor for PayPal payment details.
     * 
     * @param email PayPal account email
     * @param password PayPal account password
     */
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " [Account Email: " + email + "]");
    }
}
