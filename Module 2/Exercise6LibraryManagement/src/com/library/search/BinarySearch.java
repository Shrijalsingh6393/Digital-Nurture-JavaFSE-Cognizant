package com.library.search;

/**
 * Utility class providing a binary search for a book by title.
 * The array must be sorted in ascending order by {@code title}.
 */
public class BinarySearch {
    /**
     * Performs binary search on a sorted array of books.
     * @return the matching {@link Book} or {@code null} if not found.
     */
    public static Book searchByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareTo(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
