package com.libraray.controller;

import com.libraray.model.Book;
import com.libraray.model.Student;
import com.libraray.service.BookService;
import com.libraray.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get/all/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get/student/{id}")
    public Optional<Student> getByStudentId(@PathVariable UUID id) {
        return Optional.ofNullable(studentService.getStudentById(id));
    }

    @PostMapping("/add/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    @PutMapping("/update/student")
    public Student updateStudent(@RequestBody Student student){

        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable UUID id){
        studentService.deleteStudent(id);
    }
}
