package com.company.task;

import java.util.Arrays;

/**
 * Demo program for the singly linked list based task management system.
 * Shows add, search, traverse and delete operations along with simple timing.
 */
public class TaskDemo {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();
        Task[] sample = new Task[]{
                new Task(1, "Design module", "Pending"),
                new Task(2, "Implement feature", "In Progress"),
                new Task(3, "Write tests", "Pending"),
                new Task(4, "Code review", "Pending"),
                new Task(5, "Deploy", "Pending")
        };

        // Add tasks
        long startAdd = System.nanoTime();
        for (Task t : sample) {
            list.add(t);
        }
        long endAdd = System.nanoTime();
        System.out.println("Added " + list.count() + " tasks in " + (endAdd - startAdd) + " ns");

        // Search for a task
        long startSearch = System.nanoTime();
        Task found = list.search(3);
        long endSearch = System.nanoTime();
        System.out.println("Search result: " + (found != null ? found : "Not found") + " (" + (endSearch - startSearch) + " ns)");

        // Traverse all tasks
        long startTraverse = System.nanoTime();
        Task[] all = list.traverse();
        long endTraverse = System.nanoTime();
        System.out.println("All tasks: " + Arrays.toString(all) + " (" + (endTraverse - startTraverse) + " ns)");

        // Delete a task
        long startDelete = System.nanoTime();
        boolean deleted = list.delete(2);
        long endDelete = System.nanoTime();
        System.out.println("Deleted task 2: " + deleted + " (" + (endDelete - startDelete) + " ns)");
        System.out.println("Tasks after deletion: " + Arrays.toString(list.traverse()));

        // Complexity summary
        System.out.println("\nComplexity Summary (worst case):");
        System.out.println("Add (append) – O(n) without tail reference, O(1) with tail.");
        System.out.println("Search – O(n).");
        System.out.println("Traverse – O(n).");
        System.out.println("Delete – O(n).");
        System.out.println("Linked lists allow O(1) insertion/deletion at the head and dynamic growth without resizing, unlike arrays which need shifting or reallocation.");
    }
}
