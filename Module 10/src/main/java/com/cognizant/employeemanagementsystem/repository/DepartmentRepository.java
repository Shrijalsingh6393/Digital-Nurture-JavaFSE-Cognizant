package com.cognizant.employeemanagementsystem.repository;

import com.cognizant.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived Query Method
    Optional<Department> findByName(String name);

    // Named Query Execution (Exercise 5)
    Department findByNameNamed(@Param("name") String name);
}
