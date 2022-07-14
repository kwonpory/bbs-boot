package com.example.bbsspring.service;

import com.example.bbsspring.domain.Department;
import com.example.bbsspring.domain.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void add(Employee employee);
    public List<Employee> find();
    public Optional<Department> findDepartment(Long id);
}
