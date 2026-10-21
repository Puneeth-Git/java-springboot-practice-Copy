package com.puneeth.springboot_demo;

import org.springframework.stereotype.Component;

@Component
public class EmployeeHelper{
    
    public String getMessage(){
        return "Hello! Spring is managing bean.";
    }
}