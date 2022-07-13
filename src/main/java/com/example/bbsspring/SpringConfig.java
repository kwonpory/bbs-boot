package com.example.bbsspring;

import com.example.bbsspring.repository.DepartmentRepository;
import com.example.bbsspring.service.MemoryDepartmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemoryDepartmentService departmentService() {
        return new MemoryDepartmentService(departmentRepository());
    }

    @Bean
    public DepartmentRepository departmentRepository() {
        return new DepartmentRepository(dataSource);
    }
}
