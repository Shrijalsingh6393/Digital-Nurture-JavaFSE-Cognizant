package com.library.search;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Demo program for library book search using linear and binary search.
 */
public class LibraryDemo {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book(1, "Effective Java", "Joshua Bloch"),
                new Book(2, "Clean Code", "Robert Martin"),
                new Book(3, "Design Patterns", "Erich Gamma"),
                new Book(4, "Java Concurrency in Practice", "Brian Goetz"),
                new Book(5, "Head First Design Patterns", "Eric Freeman")
        };

        String searchTitle = "Design Patterns";

        // Linear search (unsorted array)
        long startLinear = System.nanoTime();
        Book linearResult = LinearSearch.searchByTitle(books, searchTitle);
        long endLinear = System.nanoTime();
        System.out.println("Linear Search result: " + (linearResult != null ? linearResult : "Not found"));
        System.out.println("Linear Search time (ns): " + (endLinear - startLinear));

        // Sort books by title for binary search
        Book[] sorted = Arrays.copyOf(books, books.length);
        Arrays.sort(sorted, Comparator.comparing(Book::getTitle));

        // Binary search (sorted array)
        long startBinary = System.nanoTime();
        Book binaryResult = BinarySearch.searchByTitle(sorted, searchTitle);
        long endBinary = System.nanoTime();
        System.out.println("Binary Search result: " + (binaryResult != null ? binaryResult : "Not found"));
        System.out.println("Binary Search time (ns): " + (endBinary - startBinary));

        System.out.println("\nComplexity Comparison:");
        System.out.println("Linear Search – O(n) time, O(1) extra space.");
        System.out.println("Binary Search – O(log n) time (requires sorted data), O(1) extra space.");
        System.out.println("Use linear search for small or unsorted collections; binary search for large, sorted collections.");
    }
}
