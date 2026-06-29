package com.pattern.strategy;

/**
 * Demo class to test and demonstrate the Strategy Design Pattern.
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Strategy Pattern implementation ===");

        // Create the Context object
        PaymentContext context = new PaymentContext();

        // 1. Customer decides to pay with Credit Card
        System.out.println("\n1. Customer selects Credit Card payment method:");
        PaymentStrategy creditCard = new CreditCardPayment(
            "John Doe", 
            "1234567890123456", 
            "123", 
            "12/28"
        );
        context.setPaymentStrategy(creditCard);
        context.executePayment(540.25);

        // 2. Customer decides to pay with PayPal
        System.out.println("\n2. Customer selects PayPal payment method:");
        PaymentStrategy payPal = new PayPalPayment(
            "john.doe@example.com", 
            "mySecurePassword!"
        );
        context.setPaymentStrategy(payPal);
        context.executePayment(75.50);

        // 3. Trying to execute payment without selecting a strategy
        System.out.println("\n3. Testing execution with no strategy configured:");
        PaymentContext emptyContext = new PaymentContext();
        emptyContext.executePayment(10.00);

        System.out.println("\nVerification complete: Strategy Pattern successfully enables runtime algorithm switching.");
    }
}
