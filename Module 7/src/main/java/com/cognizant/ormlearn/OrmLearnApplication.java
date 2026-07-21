package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            LOGGER.info("Starting OrmLearnApplication tests...");

            // Hands on 6: Find a country based on country code
            testGetCountryByCodeTest();

            // Hands on 7: Add a new country
            testAddCountry();

            // Hands on 8: Update a country based on code
            testUpdateCountry();

            // Hands on 9: Delete a country based on code
            testDeleteCountry();

            // Hands on 5: Find list of countries matching a partial country name
            testSearchCountry();

            LOGGER.info("OrmLearnApplication tests completed.");
        };
    }

    private void testGetCountryByCodeTest() {
        LOGGER.info("Start testGetCountryByCodeTest");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
            System.out.println("Fetched Country: " + country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End testGetCountryByCodeTest");
    }

    private void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country("ZZ", "Zootopia");
        countryService.addCountry(newCountry);
        try {
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added Country:{}", country);
            System.out.println("Successfully added and verified country: " + country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception after adding country: {}", e.getMessage());
        }
        LOGGER.info("End testAddCountry");
    }

    private void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("ZZ", "Zootopia Updated");
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated Country:{}", country);
            System.out.println("Successfully updated and verified country: " + country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception while updating country: {}", e.getMessage());
        }
        LOGGER.info("End testUpdateCountry");
    }

    private void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
            LOGGER.error("Country ZZ was not deleted!");
        } catch (CountryNotFoundException e) {
            LOGGER.info("Country ZZ successfully deleted as expected.");
            System.out.println("Successfully deleted country ZZ and verified deletion.");
        }
        LOGGER.info("End testDeleteCountry");
    }

    private void testSearchCountry() {
        LOGGER.info("Start testSearchCountry");
        List<Country> countries = countryService.findCountriesMatchingPartialName("ou");
        System.out.println("Countries matching 'ou':");
        for (Country c : countries) {
            System.out.println(c);
        }
        LOGGER.info("End testSearchCountry");
    }
}
