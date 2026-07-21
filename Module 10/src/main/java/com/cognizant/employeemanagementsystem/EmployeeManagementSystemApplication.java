package com.cognizant.employeemanagementsystem;

import com.cognizant.employeemanagementsystem.dto.EmployeeDTO;
import com.cognizant.employeemanagementsystem.entity.Department;
import com.cognizant.employeemanagementsystem.entity.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeProjection;
import com.cognizant.employeemanagementsystem.repository.DepartmentRepository;
import com.cognizant.employeemanagementsystem.repository.EmployeeRepository;
import com.cognizant.employeemanagementsystem.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementSystemApplication.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            LOGGER.info("=================================================");
            LOGGER.info("Starting EmployeeManagementSystem Demonstration");
            LOGGER.info("=================================================");

            // 1. Initialize Departments
            Department itDept = Department.builder().name("Engineering").build();
            Department hrDept = Department.builder().name("Human Resources").build();
            departmentRepository.save(itDept);
            departmentRepository.save(hrDept);

            // 2. Initialize Employees (Exercise 2 & 7: Entities & Auditing)
            Employee emp1 = Employee.builder().name("Alice Smith").email("alice@company.com").department(itDept).build();
            Employee emp2 = Employee.builder().name("Bob Jones").email("bob@company.com").department(itDept).build();
            Employee emp3 = Employee.builder().name("Charlie Brown").email("charlie@company.com").department(hrDept).build();
            
            employeeRepository.save(emp1);
            employeeRepository.save(emp2);
            employeeRepository.save(emp3);

            System.out.println("\n--- Initial Employees Saved ---");
            employeeRepository.findAll().forEach(e -> {
                System.out.println("ID: " + e.getId() + ", Name: " + e.getName() + ", Email: " + e.getEmail() +
                        ", CreatedBy: " + e.getCreatedBy() + ", CreatedDate: " + e.getCreatedDate());
            });

            // 3. Exercise 3 & 5: Derived Queries, Custom Queries, Named Queries
            System.out.println("\n--- Exercise 3 & 5: Repository & Custom Query Methods ---");
            System.out.println("Find by Name containing 'Alice': " + employeeRepository.findByNameContaining("Alice"));
            System.out.println("Find by Custom JPQL Email: " + employeeRepository.findByCustomEmailQuery("bob@company.com"));
            System.out.println("Find by Named Query Email: " + employeeRepository.findByEmailNamed("charlie@company.com"));

            // 4. Exercise 6: Pagination and Sorting
            System.out.println("\n--- Exercise 6: Pagination and Sorting ---");
            Page<Employee> page = employeeService.getEmployeesPaginatedAndSorted(0, 2, "name", "asc");
            System.out.println("Page 0 (size 2, sorted by name asc):");
            page.getContent().forEach(e -> System.out.println(" - " + e.getName()));

            // 5. Exercise 8: Interface and Class Projections
            System.out.println("\n--- Exercise 8: Projections ---");
            List<EmployeeProjection> projections = employeeRepository.findByDepartmentId(itDept.getId());
            System.out.println("Interface Projections:");
            projections.forEach(p -> System.out.println(" Formatted Info: " + p.getFormattedContactInfo()));

            List<EmployeeDTO> dtos = employeeRepository.findEmployeeDTOsByDepartmentId(itDept.getId());
            System.out.println("Class DTO Projections:");
            dtos.forEach(dto -> System.out.println(" DTO: " + dto));

            // 6. Exercise 10: Batch Operations
            System.out.println("\n--- Exercise 10: Batch Operations ---");
            List<Employee> batchList = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                batchList.add(Employee.builder().name("BatchEmp " + i).email("batch" + i + "@company.com").department(itDept).build());
            }
            List<Employee> savedBatch = employeeService.saveAllBatch(batchList);
            System.out.println("Saved " + savedBatch.size() + " employees in batch mode.");

            LOGGER.info("=================================================");
            LOGGER.info("EmployeeManagementSystem Demonstration Completed Successfully!");
            LOGGER.info("=================================================");
        };
    }
}
