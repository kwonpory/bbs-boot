package com.example.bbsspring.controller;

import com.example.bbsspring.domain.Department;
import com.example.bbsspring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
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
        Department department = new Department();
        department.setPartName(form.getPartName());
        department.setContact(form.getContact());

        departmentService.add(department);
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
        Department department = new Department();
        department.setId(form.getId());
        department.setPartName(form.getPartName());
        department.setContact(form.getContact());

        departmentService.update(department);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        departmentService.delete(id);
        return "redirect:/";
    }
}
