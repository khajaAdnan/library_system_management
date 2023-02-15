package com.libraray.service;

import com.libraray.model.Book;
import com.libraray.model.Student;
import com.libraray.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student getStudentById(UUID id){
        return studentRepo.findById(id).orElse( null);
    }

    public void deleteStudent(UUID id) {
        studentRepo.deleteById(id);
    }


    public Student updateStudent(Student student) {
        AtomicReference<Student> studentAtomicReference = new AtomicReference<>();
        Optional<Student> studentOptional = studentRepo.findById(student.getStudent_id());
        studentOptional.ifPresent(data -> {
            data.setStudentName(student.getStudentName());
            data.setEmail(student.getEmail());
            data.setAddress(student.getAddress());
            data.setMobileNumber(student.getMobileNumber());
            data.setEnroll(student.getEnroll());
            studentAtomicReference.set(studentRepo.save(data));
        });
        return studentAtomicReference.get();

    }
}
