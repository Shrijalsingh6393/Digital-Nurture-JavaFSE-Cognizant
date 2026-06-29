package com.ecommerce.sort;

/**
 * Implements Bubble Sort to order an array of {@link Order} by {@code totalPrice} in ascending order.
 *
 * <p>Time Complexity:
 *   <ul>
 *     <li>Best: O(n)  – when the array is already sorted (optimized version with a swapped flag).</li>
 *     <li>Average/Worst: O(n²) – compares each pair of adjacent elements.</li>
 *   </ul>
 * </p>
 */
public class BubbleSort {
    /**
     * Sorts the given array in place.
     * @param orders array of orders to be sorted by totalPrice
     */
    public static void sort(Order[] orders) {
        boolean swapped;
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                // array is already sorted
                break;
            }
        }
    }
}
