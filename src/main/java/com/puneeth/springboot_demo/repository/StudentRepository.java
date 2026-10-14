
package com.puneeth.springboot_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puneeth.springboot_demo.entity.Student;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {
}
