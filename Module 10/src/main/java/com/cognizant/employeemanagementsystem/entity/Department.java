package com.cognizant.employeemanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQueries({
    @NamedQuery(
        name = "Department.findByNameNamed",
        query = "SELECT d FROM Department d WHERE d.name = :name"
    )
})
public class Department extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("department")
    @BatchSize(size = 10) // Exercise 10: Hibernate-specific BatchSize annotation
    @Builder.Default
    private List<Employee> employees = new ArrayList<>();
}
