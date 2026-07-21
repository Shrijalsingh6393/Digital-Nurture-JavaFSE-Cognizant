package com.cognizant.employeemanagementsystem.controller;

import com.cognizant.employeemanagementsystem.dto.EmployeeDTO;
import com.cognizant.employeemanagementsystem.entity.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeProjection;
import com.cognizant.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Exercise 4: Basic CRUD
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee,
            @RequestParam(required = false) Long deptId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee, deptId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee,
            @RequestParam(required = false) Long deptId) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee, deptId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Exercise 6: Pagination and Sorting
    @GetMapping("/page")
    public ResponseEntity<Page<Employee>> getEmployeesPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        return ResponseEntity.ok(employeeService.getEmployeesPaginatedAndSorted(page, size, sortBy, sortDir));
    }

    // Exercise 8: Interface-Based Projections
    @GetMapping("/projections/{deptId}")
    public ResponseEntity<List<EmployeeProjection>> getEmployeeProjectionsByDepartment(@PathVariable Long deptId) {
        return ResponseEntity.ok(employeeService.getEmployeeProjectionsByDepartment(deptId));
    }

    // Exercise 8: Class-Based DTO Projections
    @GetMapping("/dtos/{deptId}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeDTOsByDepartment(@PathVariable Long deptId) {
        return ResponseEntity.ok(employeeService.getEmployeeDTOsByDepartment(deptId));
    }

    // Exercise 10: Batch Processing
    @PostMapping("/batch")
    public ResponseEntity<List<Employee>> createEmployeesBatch(@RequestBody List<Employee> employees) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveAllBatch(employees));
    }
}
