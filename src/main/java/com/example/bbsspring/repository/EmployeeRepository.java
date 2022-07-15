package com.example.bbsspring.repository;

import com.example.bbsspring.domain.Department;
import com.example.bbsspring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT d FROM Department d WHERE d.id = :id")
    public Optional<Department> findDepartment(Long id);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE '%:keyword%'")
    public List<Employee> findByNameLike(String keyword);
}
