package com.company.employee;

import java.util.Arrays;

/**
 * Demo for the EmployeeManagement system.
 * Shows add, search, traverse, delete operations and prints simple timing info.
 */
public class EmployeeDemo {
    public static void main(String[] args) {
        // Initialise with capacity for 10 employees
        EmployeeManagement em = new EmployeeManagement(10);

        // Sample employees
        Employee[] sample = new Employee[]{
                new Employee(101, "Alice", "Developer", 75000),
                new Employee(102, "Bob", "Designer", 68000),
                new Employee(103, "Charlie", "Manager", 95000),
                new Employee(104, "Diana", "QA Engineer", 62000),
                new Employee(105, "Eve", "HR", 58000)
        };

        // Add employees
        long startAdd = System.nanoTime();
        for (Employee e : sample) {
            em.add(e);
        }
        long endAdd = System.nanoTime();
        System.out.println("Added " + em.count() + " employees in " + (endAdd - startAdd) + " ns");

        // Search for an employee
        long startSearch = System.nanoTime();
        Employee found = em.search(103);
        long endSearch = System.nanoTime();
        System.out.println("Search result: " + (found != null ? found : "Not found") + " (" + (endSearch - startSearch) + " ns)");

        // Traverse (list all)
        long startTraverse = System.nanoTime();
        Employee[] all = em.traverse();
        long endTraverse = System.nanoTime();
        System.out.println("All employees: " + Arrays.toString(all) + " (" + (endTraverse - startTraverse) + " ns)");

        // Delete an employee
        long startDelete = System.nanoTime();
        boolean deleted = em.delete(102);
        long endDelete = System.nanoTime();
        System.out.println("Deleted employee 102: " + deleted + " (" + (endDelete - startDelete) + " ns)");
        System.out.println("Employees after deletion: " + Arrays.toString(em.traverse()));

        // Complexity notes
        System.out.println("\nComplexity Summary (worst case):");
        System.out.println("Add – O(1) (if space available)");
        System.out.println("Search – O(n)");
        System.out.println("Traverse – O(n)");
        System.out.println("Delete – O(n) (need to shift elements)");
        System.out.println("Arrays give fast indexed access but have fixed capacity and costly deletions; for dynamic data a List or Map is usually preferred.");
    }
}
