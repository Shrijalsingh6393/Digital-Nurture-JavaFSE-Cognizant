package com.company.employee;

import java.util.Arrays;

/**
 * Simple in‑memory employee management using a fixed‑size array.
 * Demonstrates basic operations: add, search, traverse, delete.
 *
 * <p>Time‑Complexity (worst case):
 *   <ul>
 *     <li>Add – O(1) (if there is space) – just insert at the first empty slot.</li>
 *     <li>Search – O(n) – linear scan for the employeeId.</li>
 *     <li>Traverse – O(n) – iterate over all stored elements.</li>
 *     <li>Delete – O(n) – locate then shift subsequent elements left.</li>
 *   </ul>
 * </p>
 */
public class EmployeeManagement {
    private Employee[] employees;
    private int size; // number of stored employees

    /**
     * Initialise with a maximum capacity.
     */
    public EmployeeManagement(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    /**
     * Adds a new employee to the first free slot.
     * Returns true if added, false if the array is full.
     */
    public boolean add(Employee e) {
        if (size >= employees.length) {
            return false; // no space
        }
        employees[size++] = e;
        return true;
    }

    /**
     * Searches for an employee by ID.
     * @return the matching Employee or null if not found.
     */
    public Employee search(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    /**
     * Traverses all stored employees and returns a copy of the active portion.
     */
    public Employee[] traverse() {
        return Arrays.copyOf(employees, size);
    }

    /**
     * Deletes the employee with the given ID.
     * Returns true if deletion succeeded, false if not found.
     */
    public boolean delete(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                // shift left the remaining elements
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // clear last slot
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the current number of stored employees.
     */
    public int count() {
        return size;
    }
}
