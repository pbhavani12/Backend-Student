package com.studentadmin.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.studentadmin.entity.Student;



@Service
public interface StudentService {

	Student getStudentById(Long id);

	Student saveStudent(Student student);

	

    
}
