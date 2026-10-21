package com.puneeth.springboot_demo.service;

import org.springframework.stereotype.Service;

import com.puneeth.springboot_demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String displayEmployee() {
        return "Employee name: " + repository.getEmployeeName();
    }
}