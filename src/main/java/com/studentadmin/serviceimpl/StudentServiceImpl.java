package com.studentadmin.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentadmin.entity.Student;
import com.studentadmin.repository.StudentRepository;
import com.studentadmin.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student saveStudent(Student student) {
		 return studentRepository.save(student);
	}

}
