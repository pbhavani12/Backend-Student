package com.studentadmin.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentadmin.entity.Admin;
import com.studentadmin.entity.Student;
import com.studentadmin.repository.StudentRepository;
import com.studentadmin.service.AdminService;


@Service
	public class AdminServiceImpl implements AdminService {

	    @Autowired
	    private StudentRepository studentRepository;

	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    public Student getStudentById(Long id) {
	        return studentRepository.findById(id).orElse(null);
	    }

	    public Student saveStudent(Student student) {
	        return studentRepository.save(student);
	    }

	    public Student updateStudent(Long id, Student studentDetails) {
	        Student student = studentRepository.findById(id).orElse(null);
	        if (student != null) {
	        	student.setName(studentDetails.getName());
	            
	            student.setAge(studentDetails.getAge());
	           student.setGender(studentDetails.getGender());
	            student.setEmail(studentDetails.getEmail());
	            student.setGrade(studentDetails.getGrade());
	            // Set other attributes
	            return studentRepository.save(student);
	        }
	        return null;
	    }

	    public void deleteStudent(Long id) {
	        studentRepository.deleteById(id);
	    }

		
		}

			


