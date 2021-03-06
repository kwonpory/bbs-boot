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

    @GetMapping("/list")
    public String list(Model model) {
        List<Department> departments = departmentService.find();
        model.addAttribute("departments", departments);
        return "/department/departmentList";
    }

    @GetMapping("/create")
    public String createForm() {
        return "/department/createDepartment";
    }

    @PostMapping("/add")
    public String add(DepartmentForm form, Model model) {
        departmentService.add(form);
        List<Department> departments = departmentService.find();
        model.addAttribute("departments", departments);
        return "/department/departmentList";
    }

    @PostMapping("/updateForm")
    public String updateForm(Long id, Model model) {
        Department data = departmentService.findOne(id).get();
        model.addAttribute("data", data);
        return "/department/updateDepartment";
    }

    @PostMapping("/update")
    public String update(DepartmentForm form, Model model) {
        departmentService.update(form);
        List<Department> departments = departmentService.find();
        model.addAttribute("departments", departments);
        return "/department/departmentList";
    }

    @PostMapping("/delete")
    public String delete(Long id, Model model) {
        departmentService.delete(id);
        List<Department> departments = departmentService.find();
        model.addAttribute("departments", departments);
        return "/department/departmentList";
    }
}
