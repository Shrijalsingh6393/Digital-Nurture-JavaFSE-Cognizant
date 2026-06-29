package com.pattern.adapter;

/**
 * Demo class to test and demonstrate the Adapter Design Pattern.
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Adapter Pattern implementation ===");

        // 1. Using PayPal Gateway through the PayPalAdapter
        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);

        // 2. Using Stripe Gateway through the StripeAdapter
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        // 3. Using Square Gateway through the SquareAdapter
        SquareGateway squareGateway = new SquareGateway();
        PaymentProcessor squareProcessor = new SquareAdapter(squareGateway);

        // Process payments uniformly through the common PaymentProcessor interface
        System.out.println("\nProcessing various payments using our common PaymentProcessor interface:\n");

        double amount1 = 120.50;
        double amount2 = 450.00;
        double amount3 = 89.95;

        System.out.print("Client Request 1 (PayPal): ");
        payPalProcessor.processPayment(amount1);

        System.out.print("Client Request 2 (Stripe): ");
        stripeProcessor.processPayment(amount2);

        System.out.print("Client Request 3 (Square): ");
        squareProcessor.processPayment(amount3);

        System.out.println("\nVerification complete: All third-party gateways are integrated via the PaymentProcessor adapters.");
    }
}
