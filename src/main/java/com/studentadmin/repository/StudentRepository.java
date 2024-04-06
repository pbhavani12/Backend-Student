package com.studentadmin.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.studentadmin.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}