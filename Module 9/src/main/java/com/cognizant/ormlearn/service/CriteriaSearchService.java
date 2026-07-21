package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CriteriaSearchService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Employee> searchEmployeesDynamic(String namePrefix, Boolean permanent, Double minSalary) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (namePrefix != null && !namePrefix.trim().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("name")), namePrefix.toLowerCase() + "%"));
        }

        if (permanent != null) {
            predicates.add(cb.equal(root.get("permanent"), permanent));
        }

        if (minSalary != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("salary"), minSalary));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Employee> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
