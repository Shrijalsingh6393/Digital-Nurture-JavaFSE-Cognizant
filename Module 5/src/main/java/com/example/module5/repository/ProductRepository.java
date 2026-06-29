package com.example.module5.repository;

import com.example.module5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Search by containing text (case‑insensitive)
    List<Product> findByNameContainingIgnoreCase(String text);

    // Filter with starting text (case‑insensitive)
    List<Product> findByNameStartingWithIgnoreCase(String prefix);

    // Sorting by name ascending
    List<Product> findAllByOrderByNameAsc();

    // Fetch between dates (inclusive)
    List<Product> findByCreatedDateBetween(LocalDate start, LocalDate end);

    // Greater than price
    List<Product> findByPriceGreaterThan(java.math.BigDecimal price);

    // Lesser than price
    List<Product> findByPriceLessThan(java.math.BigDecimal price);

    // Top 5 most expensive products
    List<Product> findTop5ByOrderByPriceDesc();
}
