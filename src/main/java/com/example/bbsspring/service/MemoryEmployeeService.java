package com.example.bbsspring.service;

import com.example.bbsspring.controller.EmployeeForm;
import com.example.bbsspring.domain.Department;
import com.example.bbsspring.domain.Employee;
import com.example.bbsspring.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemoryEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public MemoryEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void add(EmployeeForm form) {
        Employee employee = form.toEntityNotIncludeDepartment();
        Optional<Department> department = findDepartment(form.getDepartment());

        if (department.isPresent()) {   // department 존재 여부 확인
            employee.setDepartment(department.get());
            employeeRepository.save(employee);
        }
    }

    @Override
    public List<Employee> find() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findOne(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Department> findDepartment(Long id) {
        return employeeRepository.findDepartment(id);
    }

    @Override
    public void update(EmployeeForm form) {
        if (!employeeRepository.existsById(form.getId())) {
            // Exception Throw
            throw new NullPointerException("존재하지 않는 직원입니다.");
        }
        Employee employee = form.toEntityNotIncludeDepartment();
        Department department = findDepartment(form.getDepartment()).get();
        employee.setDepartment(department);

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> search(String keyword) {
        return null;
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
