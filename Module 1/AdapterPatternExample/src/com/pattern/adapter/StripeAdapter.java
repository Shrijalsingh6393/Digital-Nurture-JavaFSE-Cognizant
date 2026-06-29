package com.pattern.adapter;

/**
 * Adapter class that integrates StripeGateway with the PaymentProcessor interface.
 */
public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    /**
     * Constructs the adapter with a StripeGateway instance.
     * 
     * @param stripeGateway the Stripe payment gateway
     */
    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    /**
     * Translates the PaymentProcessor processPayment call to StripeGateway's charge.
     */
    @Override
    public void processPayment(double amount) {
        stripeGateway.charge(amount);
    }
}
