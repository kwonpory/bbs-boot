package com.example.bbsspring.controller;

import com.example.bbsspring.domain.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeForm {
    private Long id;
    private String name;
    private Integer age;
    private Integer career;
    private Long department;
}
