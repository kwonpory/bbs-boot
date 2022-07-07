package com.example.bbsspring.repository;

import com.example.bbsspring.domain.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.*;

public class DepartmentRepository {

    private final JdbcTemplate jdbcTemplate;

    public DepartmentRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Department department) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("department").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("partName", department.getPartName());
        parameters.put("contact", department.getContact());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        department.setId(key.longValue());
    }

    public Optional<Department> findById(Long id) {
        List<Department> result = jdbcTemplate.query("select * from department where id = ?", departmentRowMapper(), id);
        return result.stream().findAny();
    }

    public List<Department> findAll() {
        return jdbcTemplate.query("select * from department", departmentRowMapper());
    }

    public void edit(Department department) {
        jdbcTemplate.update(
                "update department set partName = ?, contact = ? where id = ?",
                department.getPartName(), department.getContact(), department.getId()
        );
    }

    public void remove(Long id) {
        jdbcTemplate.update("delete from department where id = ?", id);
    }

    private RowMapper<Department> departmentRowMapper() {
        return (rs, rowNum) -> {
            Department department = new Department();
            department.setId(rs.getLong("id"));
            department.setPartName(rs.getString("partName"));
            department.setContact(rs.getString("contact"));
            return department;
        };
    }
}
