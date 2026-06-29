package com.ecommerce.search;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Demonstrates linear and binary search on an array of {@link Product}.
 *
 * <p>Big O Notation:
 *   <ul>
 *     <li>Linear Search – O(n) in the worst, average and best case (best case O(1) if the element is first).</li>
 *     <li>Binary Search – O(log n) for best, average and worst case when the array is sorted.</li>
 *   </ul>
 * </p>
 */
public class SearchDemo {
    public static void main(String[] args) {
        // Sample products
        Product[] products = new Product[]{
                new Product(101, "Smartphone", "Electronics"),
                new Product(205, "Running Shoes", "Footwear"),
                new Product(302, "Coffee Maker", "Home Appliances"),
                new Product(410, "Gaming Laptop", "Electronics"),
                new Product(523, "Bluetooth Headphones", "Electronics"),
                new Product(634, "Leather Wallet", "Accessories"),
                new Product(745, "LED TV", "Electronics"),
                new Product(856, "Water Bottle", "Sports"),
                new Product(967, "Smart Watch", "Electronics")
        };

        int searchId = 410; // productId to search for

        // Linear search (unsorted array)
        Product linearResult = LinearSearch.linearSearch(products, searchId);
        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "Not found"));

        // Prepare sorted array for binary search (by productId)
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        // Binary search (requires sorted array)
        Product binaryResult = BinarySearch.binarySearch(sortedProducts, searchId);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Not found"));

        // Complexity Analysis (documented in comments and printed below)
        System.out.println("\nComplexity Analysis:");
        System.out.println("Linear Search – O(n) time, O(1) extra space.");
        System.out.println("Binary Search – O(log n) time, O(1) extra space (iterative implementation).\n");
        System.out.println("For large product catalogs, binary search is far more efficient, provided the data is kept sorted or indexed.");
    }
}
