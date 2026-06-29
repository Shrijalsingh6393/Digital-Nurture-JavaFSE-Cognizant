package com.ecommerce.sort;

/**
 * Implements an in‑place Quick Sort to order an array of {@link Order} by {@code totalPrice} in ascending order.
 *
 * <p>Time Complexity:
 *   <ul>
 *     <li>Best: O(n log n) – when the pivot divides the array evenly.</li>
 *     <li>Average: O(n log n).</li>
 *     <li>Worst: O(n^2) – when the pivot is always the smallest or largest element (e.g., already sorted array with naïve pivot).</li>
 *   </ul>
 * </p>
 *
 * The implementation uses the last element as the pivot and sorts in place.
 */
public class QuickSort {
    /**
     * Public entry point to sort the array.
     * @param orders array of {@link Order} to be sorted by totalPrice
     */
    public static void sort(Order[] orders) {
        quickSort(orders, 0, orders.length - 1);
    }

    private static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Partition the sub‑array using the last element as pivot.
     * Elements smaller than the pivot are moved to the left, larger to the right.
     */
    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].getTotalPrice();
        int i = low - 1; // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j].getTotalPrice() <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // place pivot at the correct position
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
