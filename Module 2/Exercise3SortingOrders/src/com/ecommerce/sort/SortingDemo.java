package com.ecommerce.sort;

import java.util.Arrays;

/**
 * Demo class to showcase Bubble Sort and Quick Sort on {@link Order} objects.
 * It also prints a brief complexity analysis.
 */
public class SortingDemo {
    public static void main(String[] args) {
        Order[] orders = new Order[]{
                new Order(101, "Alice", 250.75),
                new Order(202, "Bob", 99.99),
                new Order(303, "Charlie", 540.00),
                new Order(404, "Diana", 320.40),
                new Order(505, "Eve", 150.20)
        };

        // Clone arrays for independent sorting
        Order[] bubbleArray = Arrays.copyOf(orders, orders.length);
        Order[] quickArray = Arrays.copyOf(orders, orders.length);

        // Bubble Sort timing
        long startBubble = System.nanoTime();
        BubbleSort.sort(bubbleArray);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort result: " + Arrays.toString(bubbleArray));
        System.out.println("Bubble Sort time (ns): " + (endBubble - startBubble));

        // Quick Sort timing
        long startQuick = System.nanoTime();
        QuickSort.sort(quickArray);
        long endQuick = System.nanoTime();
        System.out.println("Quick Sort result: " + Arrays.toString(quickArray));
        System.out.println("Quick Sort time (ns): " + (endQuick - startQuick));

        // Complexity notes
        System.out.println("\nComplexity Comparison:");
        System.out.println("Bubble Sort – O(n^2) worst/average, O(n) best (already sorted). Uses O(1) extra space.");
        System.out.println("Quick Sort – O(n log n) average/best, O(n^2) worst (poor pivot). Uses O(log n) recursive stack space.");
        System.out.println("For typical e‑commerce order lists, Quick Sort provides much faster sorting, especially as the number of orders grows.");
    }
}
