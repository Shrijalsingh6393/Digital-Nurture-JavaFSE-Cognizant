package com.cognizant.employeemanagementsystem.service;

import com.cognizant.employeemanagementsystem.dto.EmployeeDTO;
import com.cognizant.employeemanagementsystem.entity.Department;
import com.cognizant.employeemanagementsystem.entity.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeProjection;
import com.cognizant.employeemanagementsystem.repository.DepartmentRepository;
import com.cognizant.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Exercise 4: CRUD Operations
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    public Employee createEmployee(Employee employee, Long departmentId) {
        if (departmentId != null) {
            Department department = departmentRepository.findById(departmentId)
                    .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
            employee.setDepartment(department);
        }
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee updatedEmployee, Long departmentId) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(updatedEmployee.getName());
            emp.setEmail(updatedEmployee.getEmail());
            if (departmentId != null) {
                Department department = departmentRepository.findById(departmentId)
                        .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
                emp.setDepartment(department);
            }
            return employeeRepository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Exercise 6: Pagination & Sorting
    @Transactional(readOnly = true)
    public Page<Employee> getEmployeesPaginatedAndSorted(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }

    // Exercise 8: Interface Projection
    @Transactional(readOnly = true)
    public List<EmployeeProjection> getEmployeeProjectionsByDepartment(Long deptId) {
        return employeeRepository.findByDepartmentId(deptId);
    }

    // Exercise 8: Class DTO Projection
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getEmployeeDTOsByDepartment(Long deptId) {
        return employeeRepository.findEmployeeDTOsByDepartmentId(deptId);
    }

    // Exercise 10: Batch Processing
    @Transactional
    public List<Employee> saveAllBatch(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }
}
