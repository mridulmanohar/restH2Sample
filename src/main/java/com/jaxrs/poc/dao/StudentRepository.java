package com.jaxrs.poc.dao;

import com.jaxrs.poc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
