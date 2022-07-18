package com.example.bbsspring.service;

import com.example.bbsspring.controller.EmployeeForm;
import com.example.bbsspring.domain.Department;
import com.example.bbsspring.domain.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void add(EmployeeForm form);
    public List<Employee> find();
    public Employee findOne(Long id);
    public Optional<Department> findDepartment(Long id);
    public void update(EmployeeForm form);
    public List<Employee> search(String keyword);
}
