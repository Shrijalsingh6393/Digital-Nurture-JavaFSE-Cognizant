package com.pattern.adapter;

/**
 * Adapter class that integrates SquareGateway with the PaymentProcessor interface.
 */
public class SquareAdapter implements PaymentProcessor {
    private final SquareGateway squareGateway;

    /**
     * Constructs the adapter with a SquareGateway instance.
     * 
     * @param squareGateway the Square payment gateway
     */
    public SquareAdapter(SquareGateway squareGateway) {
        this.squareGateway = squareGateway;
    }

    /**
     * Translates the PaymentProcessor processPayment call to SquareGateway's executeTransaction.
     */
    @Override
    public void processPayment(double amount) {
        squareGateway.executeTransaction(amount);
    }
}
