package com.jaxrs.poc.service;

import com.jaxrs.poc.dao.MarksRepository;
import com.jaxrs.poc.model.Marks;
import com.jaxrs.poc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarksService {

    @Autowired
    private MarksRepository repository;

    /*
    public List<Marks> getAllMarks() {
        return repository.findAll();
    } */

    public List<Marks> getStudentMarks(int sid) {
        return repository.getStudentMarks(sid);
    }

    public Marks getMarksById(int seqId) {
        return repository.getOne(seqId);
    }

    public Marks addMarks(int sid, Marks marks) {
        Student student = new Student();
        student.setStudentId(sid);
        marks.setStudent(student);
        return repository.save(marks);
    }

    public Marks updateMarks(int sid, int seqId, Marks marks) {
        Student student = new Student();
        student.setStudentId(sid);
        marks.setStudent(student);
        marks.setSeqId(seqId);
        return repository.save(marks);
    }

    public void deleteMarksById(int seqId) {
        repository.deleteById(seqId);
    }
}
