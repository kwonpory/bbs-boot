package com.example.bbsspring.controller;

import com.example.bbsspring.domain.Department;
import com.example.bbsspring.service.MemoryDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {

    private final MemoryDepartmentService departmentService;

    @Autowired
    public DepartmentController(MemoryDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Department> departments = departmentService.find();
        model.addAttribute("departments", departments);
        return "home";
    }

    @GetMapping("/create")
    public String createForm() {
        return "createDepartment";
    }

    @PostMapping("/add")
    public String add(DepartmentForm form) {
        departmentService.add(form);
        return "redirect:/";
    }

    @PostMapping("/updateForm")
    public String updateForm(Long id, Model model) {
        Department data = departmentService.findOne(id).get();
        model.addAttribute("data", data);
        return "updateDepartment";
    }

    @PostMapping("/update")
    public String update(DepartmentForm form) {
        departmentService.update(form);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        departmentService.delete(id);
        return "redirect:/";
    }
}
