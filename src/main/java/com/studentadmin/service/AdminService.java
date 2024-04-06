package com.studentadmin.service;


import java.util.List;

import com.studentadmin.entity.Admin;
import com.studentadmin.entity.Student;


public interface AdminService {

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	Student saveStudent(Student student);

	Student updateStudent(Long id, Student studentDetails);

	void deleteStudent(Long id);

	

	

}
