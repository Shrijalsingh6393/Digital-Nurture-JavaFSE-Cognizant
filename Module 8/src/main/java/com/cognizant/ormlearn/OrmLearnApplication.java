package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            LOGGER.info("==========================================");
            LOGGER.info("Executing Module 8 Hands-on Demonstrations");
            LOGGER.info("==========================================");

            // Hands-on 1: Country Query Methods
            testCountryQueries();

            // Hands-on 2: Stock Query Methods
            testStockQueries();

            // Hands-on 4: ManyToOne Relationship
            testGetEmployee();
            testAddEmployee();
            testUpdateEmployee();

            // Hands-on 5: OneToMany Relationship
            testGetDepartment();

            // Hands-on 6: ManyToMany Relationship
            testAddSkillToEmployee();

            LOGGER.info("==========================================");
            LOGGER.info("Module 8 Demonstrations Completed Successfully!");
            LOGGER.info("==========================================");
        };
    }

    // Hands-on 1
    private void testCountryQueries() {
        System.out.println("\n--- Hands-on 1: Country Query Methods ---");
        
        System.out.println("\n1. Search countries containing 'ou':");
        List<Country> list1 = countryRepository.findByNameContaining("ou");
        for (Country c : list1) {
            System.out.println(c);
        }

        System.out.println("\n2. Search countries containing 'ou' (Ascending order):");
        List<Country> list2 = countryRepository.findByNameContainingOrderByNameAsc("ou");
        for (Country c : list2) {
            System.out.println(c);
        }

        System.out.println("\n3. Search countries starting with 'Z':");
        List<Country> list3 = countryRepository.findByNameStartingWith("Z");
        for (Country c : list3) {
            System.out.println(c);
        }
    }

    // Hands-on 2
    private void testStockQueries() {
        System.out.println("\n--- Hands-on 2: Stock Query Methods ---");

        System.out.println("\n1. Facebook stock details in September 2019:");
        List<Stock> fbSep = stockRepository.findByCodeAndDateBetween("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        for (Stock s : fbSep) {
            System.out.println(s);
        }

        System.out.println("\n2. Google stock details with close price > 1250:");
        List<Stock> googGt = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        for (Stock s : googGt) {
            System.out.println(s);
        }

        System.out.println("\n3. Top 3 highest transaction volume dates:");
        List<Stock> top3Volume = stockRepository.findTop3ByOrderByVolumeDesc();
        for (Stock s : top3Volume) {
            System.out.println(s);
        }

        System.out.println("\n4. Top 3 lowest Netflix stock prices:");
        List<Stock> lowestNflx = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        for (Stock s : lowestNflx) {
            System.out.println(s);
        }
    }

    // Hands-on 4: Fetch Employee
    private void testGetEmployee() {
        System.out.println("\n--- Hands-on 4: Get Employee along with Department ---");
        LOGGER.info("Start testGetEmployee");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        if (employee != null) {
            System.out.println("Employee: " + employee);
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Skills: " + employee.getSkillList());
        }
        LOGGER.info("End testGetEmployee");
    }

    // Hands-on 4: Add Employee
    private void testAddEmployee() {
        System.out.println("\n--- Hands-on 4: Add Employee ---");
        LOGGER.info("Start testAddEmployee");
        Employee newEmployee = new Employee();
        newEmployee.setName("David Miller");
        newEmployee.setSalary(55000.00);
        newEmployee.setPermanent(true);
        newEmployee.setDateOfBirth(LocalDate.of(1996, 4, 12));

        Department department = departmentService.get(1);
        newEmployee.setDepartment(department);

        employeeService.save(newEmployee);
        LOGGER.debug("Added Employee:{}", newEmployee);
        System.out.println("Successfully added employee with ID: " + newEmployee.getId());
        LOGGER.info("End testAddEmployee");
    }

    // Hands-on 4: Update Employee
    private void testUpdateEmployee() {
        System.out.println("\n--- Hands-on 4: Update Employee ---");
        LOGGER.info("Start testUpdateEmployee");
        Employee employee = employeeService.get(1);
        Department newDepartment = departmentService.get(2);
        if (employee != null && newDepartment != null) {
            employee.setDepartment(newDepartment);
            employeeService.save(employee);
            LOGGER.debug("Updated Employee:{}", employee);
            System.out.println("Updated Employee " + employee.getId() + " department to: " + employee.getDepartment());
        }
        LOGGER.info("End testUpdateEmployee");
    }

    // Hands-on 5: OneToMany Department -> Employees
    private void testGetDepartment() {
        System.out.println("\n--- Hands-on 5: Get Department along with Employees ---");
        LOGGER.info("Start testGetDepartment");
        Department department = departmentService.get(1);
        if (department != null) {
            System.out.println("Department: " + department);
            System.out.println("Employee List: " + department.getEmployeeList());
        }
        LOGGER.info("End testGetDepartment");
    }

    // Hands-on 6: ManyToMany Employee <-> Skill
    private void testAddSkillToEmployee() {
        System.out.println("\n--- Hands-on 6: Add Skill to Employee ---");
        LOGGER.info("Start testAddSkillToEmployee");
        Employee employee = employeeService.get(3);
        Skill skill = skillService.get(4);
        if (employee != null && skill != null) {
            employee.getSkillList().add(skill);
            employeeService.save(employee);
            System.out.println("Added Skill '" + skill.getName() + "' to Employee '" + employee.getName() + "'");
            System.out.println("Updated Skills for Employee: " + employee.getSkillList());
        }
        LOGGER.info("End testAddSkillToEmployee");
    }
}
