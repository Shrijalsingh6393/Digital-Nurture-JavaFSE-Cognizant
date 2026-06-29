# Inventory Management System (Exercise 1)

## Problem Overview
Efficient data storage and retrieval are critical for a warehouse inventory system that may handle thousands or even millions of products. Choosing the right **data structures** and applying appropriate **algorithms** directly impacts performance, memory usage, and the ability to scale.

## Why Data Structures & Algorithms Matter
- **Speed of Operations**: Adding, updating, or deleting inventory records must be fast to keep the system responsive for users and external services.
- **Memory Efficiency**: Storing large numbers of items should minimise overhead.
- **Predictable Behaviour**: Knowing the time‑complexity guarantees helps us design SLAs and capacity plans.

## Suitable Data Structures
| Requirement | Recommended Structure | Reason |
|--------------|----------------------|--------|
| Fast lookup by `productId` | `HashMap<String, Product>` | Average‑case **O(1)** for `get`, `put`, and `remove`.
| Preserve insertion order (optional) | `LinkedHashMap` | Still O(1) while maintaining order for reporting.
| Sorted view by ID or name | `TreeMap` | Guarantees **O(log n)** ordered operations.
| Simple list where order matters | `ArrayList<Product>` | Good for iteration, but lookup is **O(n)** – not ideal for large inventories.

For this exercise we chose a **`HashMap`** because the primary operations are keyed by `productId`.

## Implementation Summary
- **`Product`** – POJO representing a product (ID, name, quantity, price).
- **`Inventory`** – Manages a `HashMap<String, Product>` with methods:
  - `addProduct(Product)` – O(1)
  - `updateProduct(String, Product)` – O(1)
  - `deleteProduct(String)` – O(1)
  - `getProduct(String)` – O(1)
  - `displayAll()` – O(n) to iterate over all entries.
- **`InventoryDemo`** – Demonstrates add, update, delete, and display.

## Time‑Complexity Analysis
| Operation | Method | Complexity (Average) | Explanation |
|-----------|--------|----------------------|-------------|
| Add | `addProduct` (HashMap.put) | **O(1)** | Inserts or overwrites entry directly.
| Update | `updateProduct` (containsKey + put) | **O(1)** | Constant‑time check and replace.
| Delete | `deleteProduct` (HashMap.remove) | **O(1)** | Direct removal by key.
| Retrieve | `getProduct` (HashMap.get) | **O(1)** | Direct hash lookup.
| Display All | `displayAll` (iteration) | **O(n)** | Must visit each product once.

## Possible Optimisations
1. **Concurrency** – Replace `HashMap` with `ConcurrentHashMap` for thread‑safe access in a multi‑threaded environment.
2. **Batch Operations** – Provide bulk add/update/delete methods that minimise locking/rehashing overhead.
3. **Caching** – If certain products are accessed frequently, maintain a small LRU cache of `Product` objects.
4. **Persistence Layer** – Sync the in‑memory map to a database or file using write‑behind strategies to avoid performance hits on every operation.
5. **Indexing** – For additional query patterns (e.g., by name or price range) maintain secondary maps or use a dedicated search library.

---

Run the demo with:
```bash
javac -d bin src/com/pattern/inventory/*.java
java -cp bin com.pattern.inventory.InventoryDemo
```
The console output shows the inventory lifecycle and confirms that add, update, and delete operations execute in constant time.
