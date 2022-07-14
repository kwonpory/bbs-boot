package com.example.bbsspring;

import com.example.bbsspring.repository.DepartmentRepository;
import com.example.bbsspring.repository.EmployeeRepository;
import com.example.bbsspring.service.MemoryDepartmentService;
import com.example.bbsspring.service.MemoryEmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemoryDepartmentService departmentService() {
        return new MemoryDepartmentService(departmentRepository());
    }

    @Bean
    public DepartmentRepository departmentRepository() {
        return new DepartmentRepository(dataSource);
    }

    @Bean
    public MemoryEmployeeService employeeService() {
        return new MemoryEmployeeService(employeeRepository());
    }

    @Bean
    public EmployeeRepository employeeRepository() {
        return new EmployeeRepository(em);
    }
}
