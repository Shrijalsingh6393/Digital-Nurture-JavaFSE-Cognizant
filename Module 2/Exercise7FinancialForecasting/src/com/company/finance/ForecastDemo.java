package com.company.finance;

/**
 * Demo program for financial forecasting using recursive algorithms.
 * It showcases:
 *   - constant growth rate forecasting (futureValueRecursive)
 *   - variable yearly growth rates (futureValueVariableRates)
 *   - basic analysis of time/space complexity and a note on optimizing with tail recursion.
 */
public class ForecastDemo {
    public static void main(String[] args) {
        double principal = 10000.0; // initial investment
        double annualRate = 0.05;    // 5% constant growth
        int years = 5;

        // Constant rate recursion
        long startConst = System.nanoTime();
        double fvConst = FinancialForecast.futureValueRecursive(principal, annualRate, years);
        long endConst = System.nanoTime();
        System.out.printf("Constant rate (%d years, %.2f%%): %.2f (time: %d ns)%n", years, annualRate * 100, fvConst, (endConst - startConst));

        // Variable rates example
        double[] rates = {0.04, 0.05, 0.03, 0.06, 0.05}; // 5 years of different rates
        long startVar = System.nanoTime();
        double fvVar = FinancialForecast.futureValueVariableRates(principal, rates, rates.length);
        long endVar = System.nanoTime();
        System.out.printf("Variable rates (5 years): %.2f (time: %d ns)%n", fvVar, (endVar - startVar));

        // Complexity discussion printed as comments
        System.out.println("\nComplexity Analysis:");
        System.out.println("Both recursive methods have O(n) time complexity (n = years) and O(n) call‑stack space.");
        System.out.println("To optimise, convert to an iterative loop (O(1) space) or use tail‑recursion if the JVM performs tail‑call optimisation (which it typically does not)." );
    }
}
