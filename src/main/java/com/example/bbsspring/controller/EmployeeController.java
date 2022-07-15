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
        return "/employee/employeeList";
    }

    @GetMapping("/addEmployee")
    public String createEmployeeForm(Model model) {
        List<Department> departments = departmentService.find();
        model.addAttribute("departments", departments);
        return "/employee/createEmployee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(EmployeeForm form) {
        employeeService.add(form);
        return "redirect:/";
    }

    @PostMapping("/editEmployeeForm")
    public String editEmployeeForm(Long id, Model model) {
        Employee employee = employeeService.findOne(id).get();
        List<Department> departments = departmentService.find();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "/employee/editEmployee";
    }

    @PostMapping("/editEmployee")
    public String editEmployee(EmployeeForm form) {
        employeeService.update(form);
        return "redirect:/";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(Long id) {
        employeeService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(String keyword, Model model) {
        List<Employee> employees = employeeService.search(keyword);
        model.addAttribute("employees", employees);
        System.out.println(employees);
        return "/employee/employeeList";
    }
}
