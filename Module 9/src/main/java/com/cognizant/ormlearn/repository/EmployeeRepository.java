package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Hands-on 2: HQL with JOIN FETCH for optimized loading
    @Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Hands-on 4: HQL Aggregate function with parameter binding
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    Double getAverageSalary(@Param("id") int id);

    // Hands-on 5: Native SQL Query
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
