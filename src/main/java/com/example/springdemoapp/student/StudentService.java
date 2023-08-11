package com.example.springdemoapp.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRpository studentRpository;

    @Autowired
    public StudentService(StudentRpository studentRpository) {
        this.studentRpository = studentRpository;
    }

    public List<Student> getStudents() {
        return studentRpository.findAll();
    }

    public Student getOneStudent(Long studentId) {
        boolean exists = studentRpository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "Student with ID " + studentId + "doesn't exists!"
            );
        }
        return studentRpository.getReferenceById(studentId);
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        Optional<Student> studentByEmail = studentRpository.findByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        studentRpository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRpository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "Student with ID " + studentId + "doesn't exists!"
            );
        }
        studentRpository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRpository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with ID " + studentId + "doesn't exists"
        ));

        if(name != null && !name.isEmpty() && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if(email !=null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRpository.findByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email is taken");
            }
            student.setEmail(email);
        }
    }
}
