package com.example.stdmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stdmanagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
