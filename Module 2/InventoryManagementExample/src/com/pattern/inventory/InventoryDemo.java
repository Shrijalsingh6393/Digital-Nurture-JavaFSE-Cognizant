package com.pattern.inventory;

public class InventoryDemo {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add products
        Product p1 = new Product("P001", "Widget", 100, 2.99);
        Product p2 = new Product("P002", "Gadget", 50, 5.49);
        inventory.addProduct(p1);
        inventory.addProduct(p2);

        // Display current inventory
        System.out.println();
        inventory.displayAll();

        // Update a product
        Product updatedP1 = new Product("P001", "Widget Pro", 120, 3.49);
        inventory.updateProduct("P001", updatedP1);

        // Delete a product
        inventory.deleteProduct("P002");

        // Final state
        System.out.println();
        inventory.displayAll();
    }
}
