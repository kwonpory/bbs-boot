package com.example.bbsspring.controller;

import com.example.bbsspring.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class EmployeeForm {
    private Long id;
    private String name;
    private Integer age;
    private Integer career;
    private Long department;

    public Employee toEntityNotIncludeDepartment() {
        return Employee.builder()
                .id(id)
                .name(name)
                .age(age)
                .career(career)
                .build();
    }
}
