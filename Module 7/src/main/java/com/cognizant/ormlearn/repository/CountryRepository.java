package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // 1. Search by name containing characters
    List<Country> findByNameContainingIgnoreCase(String name);

    // 2. Search by name containing characters, ordered by name ascending
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    // 3. Search by prefix (starting with a character/string)
    List<Country> findByNameStartingWith(String prefix);
}
