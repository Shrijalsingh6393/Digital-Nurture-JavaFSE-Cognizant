package com.pattern.inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * Inventory class that manages a collection of {@link Product} objects.
 * Uses a {@link HashMap} keyed by productId for O(1) average‑case
 * add, update, and delete operations.
 */
public class Inventory {
    // Key: productId, Value: Product instance
    private final Map<String, Product> productMap = new HashMap<>();

    /**
     * Adds a new product to the inventory.
     * If a product with the same ID already exists, it will be overwritten.
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
        System.out.println("[Inventory] Added: " + product);
    }

    /**
     * Updates an existing product. If the product does not exist, nothing happens.
     *
     * @param productId the ID of the product to update
     * @param newProduct a Product instance containing the new state
     */
    public void updateProduct(String productId, Product newProduct) {
        if (productMap.containsKey(productId)) {
            productMap.put(productId, newProduct);
            System.out.println("[Inventory] Updated: " + newProduct);
        } else {
            System.out.println("[Inventory] Cannot update – productId not found: " + productId);
        }
    }

    /**
     * Deletes a product from the inventory.
     *
     * @param productId the ID of the product to delete
     */
    public void deleteProduct(String productId) {
        Product removed = productMap.remove(productId);
        if (removed != null) {
            System.out.println("[Inventory] Deleted: " + removed);
        } else {
            System.out.println("[Inventory] Cannot delete – productId not found: " + productId);
        }
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productId the ID to look up
     * @return the Product if present, otherwise null
     */
    public Product getProduct(String productId) {
        return productMap.get(productId);
    }

    /**
     * Displays all products currently stored in the inventory.
     */
    public void displayAll() {
        System.out.println("--- Inventory Contents ---");
        if (productMap.isEmpty()) {
            System.out.println("[Inventory] No products.");
        } else {
            productMap.values().forEach(p -> System.out.println(p));
        }
    }
}
