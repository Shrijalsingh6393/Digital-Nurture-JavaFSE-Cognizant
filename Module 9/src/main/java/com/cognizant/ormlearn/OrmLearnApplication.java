package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.CriteriaSearchService;
import com.cognizant.ormlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AttemptService attemptService;

    @Autowired
    private CriteriaSearchService criteriaSearchService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            LOGGER.info("==========================================");
            LOGGER.info("Executing Module 9 Hands-on Demonstrations");
            LOGGER.info("==========================================");

            // Hands-on 2: Permanent Employees with JOIN FETCH
            testGetAllPermanentEmployees();

            // Hands-on 3: Quiz Attempt Details
            testQuizAttemptDetails();

            // Hands-on 4: Average Salary with HQL Aggregate
            testGetAverageSalary();

            // Hands-on 5: Native SQL Query
            testGetAllEmployeesNative();

            // Hands-on 6: Criteria API Dynamic Query
            testCriteriaQuery();

            LOGGER.info("==========================================");
            LOGGER.info("Module 9 Demonstrations Completed Successfully!");
            LOGGER.info("==========================================");
        };
    }

    // Hands-on 2
    public void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");
        System.out.println("\n--- Hands-on 2: Permanent Employees (HQL JOIN FETCH) ---");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        for (Employee e : employees) {
            System.out.println(e);
            System.out.println(" Department: " + e.getDepartment());
            System.out.println(" Skills: " + e.getSkillList());
            LOGGER.debug("Skills:{}", e.getSkillList());
        }
        LOGGER.info("End testGetAllPermanentEmployees");
    }

    // Hands-on 3
    public void testQuizAttemptDetails() {
        LOGGER.info("Start testQuizAttemptDetails");
        System.out.println("\n--- Hands-on 3: Quiz Attempt Details ---");
        Attempt attempt = attemptService.getAttempt(1, 1);
        if (attempt != null && attempt.getAttemptQuestions() != null) {
            Set<AttemptQuestion> attemptQuestions = attempt.getAttemptQuestions();
            for (AttemptQuestion aq : attemptQuestions) {
                Question question = aq.getQuestion();
                System.out.println(question.getText());

                Set<AttemptOption> attemptOptions = aq.getAttemptOptions();
                int optionNum = 1;
                for (AttemptOption ao : attemptOptions) {
                    Options option = ao.getOptions();
                    System.out.printf(" %d) %-10s %-7.1f %b%n",
                            optionNum++,
                            option.getText(),
                            option.getScore(),
                            ao.isSelected());
                }
                System.out.println();
            }
        }
        LOGGER.info("End testQuizAttemptDetails");
    }

    // Hands-on 4
    public void testGetAverageSalary() {
        LOGGER.info("Start testGetAverageSalary");
        System.out.println("\n--- Hands-on 4: Average Salary using HQL ---");
        int departmentId = 1;
        double avgSalary = employeeService.getAverageSalary(departmentId);
        System.out.printf("Average Salary for Department %d: %.2f%n", departmentId, avgSalary);
        LOGGER.info("End testGetAverageSalary");
    }

    // Hands-on 5
    public void testGetAllEmployeesNative() {
        LOGGER.info("Start testGetAllEmployeesNative");
        System.out.println("\n--- Hands-on 5: Native SQL Query ---");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        for (Employee e : employees) {
            System.out.println(e);
        }
        LOGGER.info("End testGetAllEmployeesNative");
    }

    // Hands-on 6
    public void testCriteriaQuery() {
        LOGGER.info("Start testCriteriaQuery");
        System.out.println("\n--- Hands-on 6: Criteria Query Dynamic Filtering ---");
        System.out.println("Searching employees starting with 'J', permanent=true, minSalary=40000:");
        List<Employee> result = criteriaSearchService.searchEmployeesDynamic("J", true, 40000.0);
        for (Employee e : result) {
            System.out.println(e);
        }
        LOGGER.info("End testCriteriaQuery");
    }
}
