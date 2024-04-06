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
import com.studentadmin.service.AdminService;

	
	@RestController
	@RequestMapping("/admin")
	@CrossOrigin(origins = "https://student-frontend-yigh.onrender.com")
	public class AdminController {

	    @Autowired
	    private AdminService adminService;

	    @GetMapping("/allstudents")
	    public List<Student> getAllStudents() {
	        return adminService.getAllStudents();
	    }

	    @GetMapping("/studentsbyid/{id}")
	    public Student getStudentById(@PathVariable Long id) {
	        return adminService.getStudentById(id);
	    }

	    @PostMapping("/students")
	    public Student createStudent(@RequestBody Student student) {
	        return adminService.saveStudent(student);
	    }

//	    @PutMapping("/students/{id}")
//	    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
//	        return adminService.updateStudent(id, studentDetails);
//	    }
	    @PutMapping("/students/{id}")
	    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
	        Student student = adminService.getStudentById(id);
	        if (student == null) {
	            return null;
	        }
	        student.setName(studentDetails.getName());
	       
	        student.setAge(studentDetails.getAge());
	       student.setGender(studentDetails.getGender());
	        student.setEmail(studentDetails.getEmail());
	        student.setGrade(studentDetails.getGrade());
	        return adminService.saveStudent(student);
	    }

	    @DeleteMapping("/deletestudents/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
	        adminService.deleteStudent(id);
	        return ResponseEntity.noContent().build();
	    }
	    @PostMapping("/login")
	    public String login(@RequestBody Student student) {
	        // Implement login logic here, validate user credentials
	        return "Login successful"; // return some response
	    }

	    @PostMapping("/register")
	    public String register(@RequestBody Student student) {
	        // Implement registration logic here, save user to database
	        return "Registration successful"; 
	    }
	}

 
