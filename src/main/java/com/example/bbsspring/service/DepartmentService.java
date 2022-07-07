package com.example.bbsspring.service;

import com.example.bbsspring.domain.Department;
import com.example.bbsspring.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    /**
     * 부서 추가
     */
    public void add(Department department) {
        repository.save(department);
    }

    /**
     * 조회
     */
    public List<Department> find() {
        return repository.findAll();
    }

    public Optional<Department> findOne(Long id) {
        return repository.findById(id);
    }
    /**
     * 부서 수정
     */
    public void update(Department department) {
        repository.edit(department);
    }

    /**
     * 부서 삭제
     */
    public void delete(Long id) {
        repository.remove(id);
    }
}
