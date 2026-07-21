package com.cognizant.employeemanagementsystem.service;

import com.cognizant.employeemanagementsystem.entity.Department;
import com.cognizant.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Transactional
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public Department updateDepartment(Long id, Department updatedDepartment) {
        return departmentRepository.findById(id).map(dept -> {
            dept.setName(updatedDepartment.getName());
            return departmentRepository.save(dept);
        }).orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    @Transactional
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
