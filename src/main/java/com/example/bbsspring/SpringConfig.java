package com.example.bbsspring;

import com.example.bbsspring.repository.DepartmentRepository;
import com.example.bbsspring.service.DepartmentService;
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
    public DepartmentService departmentService() {
        return new DepartmentService(departmentRepository());
    }

    @Bean
    public DepartmentRepository departmentRepository() {
        return new DepartmentRepository(dataSource);
    }
}
