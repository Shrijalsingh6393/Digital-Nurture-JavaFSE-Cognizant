package com.pattern.adapter;

/**
 * Adapter class that integrates PayPalGateway with the PaymentProcessor interface.
 */
public class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    /**
     * Constructs the adapter with a PayPalGateway instance.
     * 
     * @param payPalGateway the PayPal payment gateway
     */
    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    /**
     * Translates the PaymentProcessor processPayment call to PayPalGateway's makePayment.
     */
    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}
