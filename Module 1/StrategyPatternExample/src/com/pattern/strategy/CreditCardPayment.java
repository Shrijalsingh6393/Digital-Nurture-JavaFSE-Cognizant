package com.pattern.strategy;

/**
 * Concrete Strategy class that implements Credit Card payments.
 */
public class CreditCardPayment implements PaymentStrategy {
    private final String cardHolderName;
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;

    /**
     * Constructor for Credit Card payment details.
     * 
     * @param cardHolderName name of the card holder
     * @param cardNumber card number
     * @param cvv card CVV
     * @param expiryDate card expiry date (MM/YY)
     */
    public CreditCardPayment(String cardHolderName, String cardNumber, String cvv, String expiryDate) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount + " [Holder: " + cardHolderName + ", Card: ****-****-****-" + cardNumber.substring(cardNumber.length() - 4) + "]");
    }
}
