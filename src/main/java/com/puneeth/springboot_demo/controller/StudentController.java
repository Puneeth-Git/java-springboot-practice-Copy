
package com.puneeth.springboot_demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puneeth.springboot_demo.entity.Student;
import com.puneeth.springboot_demo.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // GET student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CREATE student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        student.setId(null);
        return repository.save(student);
    }

    // UPDATE student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Integer id,
            @RequestBody Student updatedStudent) {

        return repository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            return ResponseEntity.ok(repository.save(student));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
