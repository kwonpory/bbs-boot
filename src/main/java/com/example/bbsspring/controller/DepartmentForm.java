package com.example.bbsspring.controller;

public class DepartmentForm {
    private Long id;
    private String part_name;
    private String contact;

    public String getPartName() {
        return part_name;
    }

    public void setPartName(String partName) {
        this.part_name = partName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
