package com.cognizant.employeemanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "employees")
@DynamicUpdate // Exercise 10: Hibernate-specific DynamicUpdate annotation
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByEmailNamed",
        query = "SELECT e FROM Employee e WHERE e.email = :email"
    ),
    @NamedQuery(
        name = "Employee.findByDepartmentNameNamed",
        query = "SELECT e FROM Employee e WHERE e.department.name = :deptName"
    )
})
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties("employees")
    private Department department;
}
