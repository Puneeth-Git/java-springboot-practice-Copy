package com.puneeth.springboot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.puneeth.springboot_demo.service.EmployeeService;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(
                        SpringbootDemoApplication.class, args);

        EmployeeHelper helper =
                context.getBean(EmployeeHelper.class);

        System.out.println(helper.getMessage());

		EmployeeService service =
        context.getBean(EmployeeService.class);

		System.out.println(service.displayEmployee());


    }
}