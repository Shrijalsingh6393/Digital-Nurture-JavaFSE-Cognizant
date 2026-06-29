package com.example.module5;

import com.example.module5.entity.Product;
import com.example.module5.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class QueryMethodsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryMethodsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return args -> {
            // Seed sample data
            repository.save(new Product("Apple iPhone", "Smartphone", new BigDecimal("999.99"), LocalDate.of(2023, 1, 10)));
            repository.save(new Product("Samsung Galaxy", "Android smartphone", new BigDecimal("799.99"), LocalDate.of(2023, 2, 5)));
            repository.save(new Product("Google Pixel", "Android phone", new BigDecimal("699.99"), LocalDate.of(2023, 3, 20)));
            repository.save(new Product("Dell Laptop", "Windows laptop", new BigDecimal("1199.00"), LocalDate.of(2023, 4, 15)));
            repository.save(new Product("HP Laptop", "Business laptop", new BigDecimal("1099.00"), LocalDate.of(2023, 5, 12)));
            repository.save(new Product("Apple Watch", "Smartwatch", new BigDecimal("399.99"), LocalDate.of(2023, 6, 1)));

            System.out.println("--- findByNameContainingIgnoreCase('apple') ---");
            List<Product> containing = repository.findByNameContainingIgnoreCase("apple");
            containing.forEach(System.out::println);

            System.out.println("--- findByNameStartingWithIgnoreCase('s') ---");
            List<Product> starting = repository.findByNameStartingWithIgnoreCase("s");
            starting.forEach(System.out::println);

            System.out.println("--- findAllByOrderByNameAsc() ---");
            List<Product> sorted = repository.findAllByOrderByNameAsc();
            sorted.forEach(System.out::println);

            System.out.println("--- findByCreatedDateBetween(2023-02-01, 2023-05-31) ---");
            List<Product> between = repository.findByCreatedDateBetween(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 5, 31));
            between.forEach(System.out::println);

            System.out.println("--- findByPriceGreaterThan(800) ---");
            List<Product> greater = repository.findByPriceGreaterThan(new BigDecimal("800"));
            greater.forEach(System.out::println);

            System.out.println("--- findByPriceLessThan(800) ---");
            List<Product> less = repository.findByPriceLessThan(new BigDecimal("800"));
            less.forEach(System.out::println);

            System.out.println("--- findTop5ByOrderByPriceDesc() ---");
            List<Product> top5 = repository.findTop5ByOrderByPriceDesc();
            top5.forEach(System.out::println);
        };
    }
}
