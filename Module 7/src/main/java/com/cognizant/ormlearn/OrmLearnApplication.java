package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CountryRepository countryRepository) {
        return args -> {
            LOGGER.info("Starting OrmLearnApplication tests...");

            // 1. Find countries containing "ou"
            System.out.println("\n--- Countries containing 'ou' (Ordered by Code) ---");
            List<Country> countriesContainingOu = countryRepository.findByNameContaining("ou");
            printCountries(countriesContainingOu);

            // 2. Find countries containing "ou" ordered by name ascending
            System.out.println("\n--- Countries containing 'ou' (Ordered by Name Ascending) ---");
            List<Country> countriesContainingOuSorted = countryRepository.findByNameContainingOrderByNameAsc("ou");
            printCountries(countriesContainingOuSorted);

            // 3. Find countries starting with "Z"
            System.out.println("\n--- Countries starting with 'Z' ---");
            List<Country> countriesStartingWithZ = countryRepository.findByNameStartingWith("Z");
            printCountries(countriesStartingWithZ);

            LOGGER.info("OrmLearnApplication tests completed.");
        };
    }

    private void printCountries(List<Country> countries) {
        for (Country country : countries) {
            System.out.printf(" %-8s %s%n", country.getCode(), country.getName());
        }
    }
}
