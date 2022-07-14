package com.example.bbsspring.service;

import com.example.bbsspring.domain.Department;
import com.example.bbsspring.domain.Employee;
import com.example.bbsspring.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemoryEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public MemoryEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> find() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Department> findDepartment(Long id) {
        return employeeRepository.findDepartment(id);
    }
}
