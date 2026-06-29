package com.company.task;

/**
 * Singly linked list implementation to manage {@link Task} objects.
 *
 * <p>Operations and their worst‑case time complexities:</p>
 * <ul>
 *   <li>Add (append) – O(n) because we traverse to the end. (Can be O(1) if we keep a tail reference.)</li>
 *   <li>Search – O(n) – linear scan until the id matches.</li>
 *   <li>Traverse – O(n) – visit each node.</li>
 *   <li>Delete – O(n) – locate the node then adjust links.</li>
 * </ul>
 */
public class TaskLinkedList {
    /**
     * Internal node class storing a Task and a reference to the next node.
     */
    private static class Node {
        Task task;
        Node next;
        Node(Task task) {
            this.task = task;
        }
    }

    private Node head;
    private int size;

    /**
     * Adds a task to the end of the list.
     * @return true if added successfully.
     */
    public boolean add(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Searches for a task by its id.
     * @return the matching Task or null if not found.
     */
    public Task search(int taskId) {
        Node curr = head;
        while (curr != null) {
            if (curr.task.getTaskId() == taskId) {
                return curr.task;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * Traverses the list and returns an array containing all tasks in insertion order.
     */
    public Task[] traverse() {
        Task[] result = new Task[size];
        Node curr = head;
        int i = 0;
        while (curr != null) {
            result[i++] = curr.task;
            curr = curr.next;
        }
        return result;
    }

    /**
     * Deletes the first task with the given id.
     * @return true if deletion succeeded, false if not found.
     */
    public boolean delete(int taskId) {
        if (head == null) return false;
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            size--;
            return true;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.task.getTaskId() == taskId) {
                prev.next = curr.next;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    /**
     * Returns the number of tasks stored.
     */
    public int count() {
        return size;
    }
}
