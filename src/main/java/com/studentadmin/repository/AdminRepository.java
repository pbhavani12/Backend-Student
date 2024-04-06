package com.studentadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentadmin.entity.Student;

public interface AdminRepository extends JpaRepository<Student, Long>  {

}

