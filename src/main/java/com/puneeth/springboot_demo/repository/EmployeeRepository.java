package com.puneeth.springboot_demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    public String getEmployeeName() {
        return "Rahul";
    }
}