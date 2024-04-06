package com.studentadmin.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentadmin.entity.Student;
import com.studentadmin.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "https://student-frontend-yigh.onrender.com")
public class StudentController {

    @Autowired
    private StudentService studentService;

    

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return null;
        }
        student.setName(studentDetails.getName());
        
        student.setAge(studentDetails.getAge());
        student.setGender(studentDetails.getGender());
        student.setEmail(studentDetails.getEmail());
        student.setGrade(studentDetails.getGrade());
        
        return studentService.saveStudent(student);
    }

    
}

