package com.ecommerce.search;

/**
 * Utility class providing a linear search implementation for an array of {@link Product}.
 */
public class LinearSearch {
    /**
     * Performs a linear search for a product with the given {@code productId}.
     *
     * @param products array of products (unsorted)
     * @param productId the id to search for
     * @return the matching {@link Product} if found, otherwise {@code null}
     */
    public static Product linearSearch(Product[] products, int productId) {
        for (Product p : products) {
            if (p.getProductId() == productId) {
                return p; // found
            }
        }
        return null; // not found
    }
}
