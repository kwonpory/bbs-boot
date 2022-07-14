package com.example.bbsspring.repository;

import com.example.bbsspring.domain.Department;
import com.example.bbsspring.domain.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private final EntityManager em;

    public EmployeeRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class)
                .getResultList();
    }

    public Optional<Department> findDepartment(Long id) {
        Department department = em.find(Department.class, id);
        return Optional.ofNullable(department);
    }
}
