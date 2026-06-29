package com.company.finance;

/**
 * Utility class providing recursive financial forecasting methods.
 */
public class FinancialForecast {
    /**
     * Calculates the future value of an investment recursively using a constant annual growth rate.
     *
     * @param principal the current value (e.g., current investment amount)
     * @param annualRate the growth rate per period expressed as a decimal (e.g., 0.05 for 5%)
     * @param years number of periods to forecast
     * @return the projected future value after the given number of periods
     *
     * <p>Recurrence relation:
     *   FV(0) = principal
     *   FV(n) = FV(n‑1) * (1 + annualRate)
     * </p>
     *
     * <p>Time Complexity: O(n) – one recursive call per year.</p>
     * <p>Space Complexity: O(n) – call‑stack depth equals the number of years.</p>
     */
    public static double futureValueRecursive(double principal, double annualRate, int years) {
        if (years <= 0) {
            return principal;
        }
        // recursive step: compute value for previous year then apply growth
        return futureValueRecursive(principal, annualRate, years - 1) * (1 + annualRate);
    }

    /**
     * Calculates future value using a list of possibly varying yearly growth rates.
     * The array length must be at least {@code years}; extra entries are ignored.
     *
     * @param principal the starting amount
     * @param yearlyRates array of growth rates per year (decimal form)
     * @param years number of periods to forecast
     * @return projected future value after applying the rates sequentially
     *
     * <p>Recurrence relation:
     *   FV(0) = principal
     *   FV(n) = FV(n‑1) * (1 + yearlyRates[n‑1])
     * </p>
     */
    public static double futureValueVariableRates(double principal, double[] yearlyRates, int years) {
        if (years <= 0) {
            return principal;
        }
        // Ensure we don't exceed the array bounds
        double rate = (years - 1 < yearlyRates.length) ? yearlyRates[years - 1] : 0.0;
        return futureValueVariableRates(principal, yearlyRates, years - 1) * (1 + rate);
    }
}
