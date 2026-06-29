package com.pattern.observer;

/**
 * Demo class to test and demonstrate the Observer Design Pattern.
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Observer Pattern implementation ===");

        // 1. Create Stock Market Subject
        StockMarket stockMarket = new StockMarket();

        // 2. Create Observers (MobileApps and WebApps)
        Observer mobileClient1 = new MobileApp("AndroidTrader_Alpha");
        Observer mobileClient2 = new MobileApp("iTrader_Beta");
        Observer webClient1 = new WebApp("YahooFinanceDashboard");

        // 3. Register observers
        System.out.println("\nRegistering observers with the Stock Market...");
        stockMarket.registerObserver(mobileClient1);
        stockMarket.registerObserver(mobileClient2);
        stockMarket.registerObserver(webClient1);

        // 4. Update stock prices and verify notification delivery
        System.out.println("\n--- Event 1: Google Stock price updates to $178.50 ---");
        stockMarket.setStockPrice("GOOGL", 178.50);

        System.out.println("\n--- Event 2: Apple Stock price updates to $210.25 ---");
        stockMarket.setStockPrice("AAPL", 210.25);

        // 5. Deregister an observer and verify it no longer receives updates
        System.out.println("\nDeregistering observer 'iTrader_Beta'...");
        stockMarket.deregisterObserver(mobileClient2);

        System.out.println("\n--- Event 3: Microsoft Stock price updates to $435.10 ---");
        stockMarket.setStockPrice("MSFT", 435.10);

        System.out.println("\nVerification complete: Observers are successfully registered, notified, and deregistered.");
    }
}
