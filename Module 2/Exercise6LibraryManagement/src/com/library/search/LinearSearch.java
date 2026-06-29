package com.library.search;

/**
 * Utility class providing a linear search for a book by title.
 */
public class LinearSearch {
    /**
     * Searches the array for a book whose title equals the given title (case‑sensitive).
     * @return the matching {@link Book} or {@code null} if not found.
     */
    public static Book searchByTitle(Book[] books, String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }
}
