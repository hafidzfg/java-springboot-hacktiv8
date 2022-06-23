package com.belajar.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belajar.spring.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
