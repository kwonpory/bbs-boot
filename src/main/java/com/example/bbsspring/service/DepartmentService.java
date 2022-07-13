package com.example.bbsspring.service;

import com.example.bbsspring.controller.DepartmentForm;
import com.example.bbsspring.domain.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public void add(DepartmentForm form);
    public List<Department> find();
    public Optional<Department> findOne(Long id);
    public void update(DepartmentForm form);
    public void delete(Long id);
}
