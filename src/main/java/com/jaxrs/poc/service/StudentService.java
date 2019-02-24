package com.jaxrs.poc.service;

import com.jaxrs.poc.dao.StudentRepository;
import com.jaxrs.poc.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int sid) {
        Student student = null;
        try {
            student = repository.getOne(sid);
        } catch (EntityNotFoundException ex) {
            logger.info(ex.getMessage());
        }

        return student;
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudentById(int sid) {
        repository.deleteById(sid);
    }
}
