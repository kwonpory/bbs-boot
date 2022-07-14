package com.example.bbsspring.controller;

import com.example.bbsspring.domain.Department;
import com.example.bbsspring.domain.Employee;
import com.example.bbsspring.service.MemoryDepartmentService;
import com.example.bbsspring.service.MemoryEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    private final MemoryDepartmentService departmentService;
    private final MemoryEmployeeService employeeService;

    public EmployeeController(MemoryDepartmentService departmentService, MemoryEmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> employees = employeeService.find();
        model.addAttribute("employees", employees);
        return "home";
    }

    @GetMapping("/addEmployee")
    public String createEmployeeForm(Model model) {
        List<Department> departments = departmentService.find();
        model.addAttribute("departments", departments);
        return "editEmployee";
    }

    @PostMapping("/editEmployee")
    public String editEmployee(EmployeeForm form) {
        Employee employee = new Employee();
        employee.setName(form.getName());
        employee.setAge(form.getAge());
        employee.setCareer(form.getCareer());
        Optional<Department> department = employeeService.findDepartment(form.getDepartment());
        employee.setDepartment(department.get());

        employeeService.add(employee);
        return "redirect:/";
    }
}
