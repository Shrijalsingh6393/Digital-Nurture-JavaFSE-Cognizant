package com.pattern.strategy;

/**
 * Context class that holds a reference to a PaymentStrategy.
 * Clients configure this context with the appropriate strategy.
 */
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    /**
     * Sets/Changes the payment strategy at runtime.
     * 
     * @param paymentStrategy the concrete payment strategy to use
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Executes the payment strategy.
     * 
     * @param amount the payment amount
     */
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Payment strategy has not been selected.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
