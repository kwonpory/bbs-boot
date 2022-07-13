package com.example.bbsspring.service;

import com.example.bbsspring.controller.DepartmentForm;
import com.example.bbsspring.domain.Department;
import com.example.bbsspring.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

public class MemoryDepartmentService implements DepartmentService {
    private final DepartmentRepository repository;
    Department department = new Department();

    public MemoryDepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    /**
     * 부서 추가
     */
    @Override
    public void add(DepartmentForm form) {
        department.setPartName(form.getPartName());
        department.setContact(form.getContact());

        repository.save(department);
    }

    /**
     * 조회
     */
    @Override
    public List<Department> find() {
        return repository.findAll();
    }

    @Override
    public Optional<Department> findOne(Long id) {
        return repository.findById(id);
    }
    /**
     * 부서 수정
     */
    @Override
    public void update(DepartmentForm form) {
        department.setId(form.getId());
        department.setPartName(form.getPartName());
        department.setContact(form.getContact());

        repository.edit(department);
    }

    /**
     * 부서 삭제
     */
    @Override
    public void delete(Long id) {
        repository.remove(id);
    }
}
