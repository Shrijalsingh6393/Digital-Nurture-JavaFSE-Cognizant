package com.cognizant.employeemanagementsystem.repository;

import com.cognizant.employeemanagementsystem.dto.EmployeeDTO;
import com.cognizant.employeemanagementsystem.entity.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Exercise 3 & 5: Derived Query Methods
    List<Employee> findByNameContaining(String nameKeyword);

    List<Employee> findByEmailEndingWith(String domain);

    List<Employee> findByDepartmentName(String deptName);

    Optional<Employee> findByEmail(String email);

    // Exercise 5: Custom JPQL Query
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByCustomEmailQuery(@Param("email") String email);

    // Exercise 5: Native SQL Query
    @Query(value = "SELECT * FROM employees WHERE email LIKE %:domain", nativeQuery = true)
    List<Employee> findByNativeDomainQuery(@Param("domain") String domain);

    // Exercise 5: Named Queries
    Employee findByEmailNamed(@Param("email") String email);

    List<Employee> findByDepartmentNameNamed(@Param("deptName") String deptName);

    // Exercise 6: Pagination and Sorting Method
    Page<Employee> findByDepartmentName(String deptName, Pageable pageable);

    // Exercise 8: Interface-Based Projection
    List<EmployeeProjection> findByDepartmentId(Long deptId);

    // Exercise 8: Class-Based DTO Projection with Constructor Expression
    @Query("SELECT new com.cognizant.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d WHERE d.id = :deptId")
    List<EmployeeDTO> findEmployeeDTOsByDepartmentId(@Param("deptId") Long deptId);
}
