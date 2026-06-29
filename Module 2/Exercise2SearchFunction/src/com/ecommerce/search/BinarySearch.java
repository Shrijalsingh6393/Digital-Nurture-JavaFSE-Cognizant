package com.ecommerce.search;

/**
 * Utility class providing a binary search implementation for an array of {@link Product}.
 * The array must be sorted by {@code productId} in ascending order.
 */
public class BinarySearch {
    /**
     * Performs binary search on a sorted array of products.
     *
     * @param products sorted array of products (by productId)
     * @param productId the id to search for
     * @return the matching {@link Product} if found, otherwise {@code null}
     */
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();
            if (midId == productId) {
                return products[mid];
            } else if (midId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // not found
    }
}
