package com.jaxrs.poc.dao;

import com.jaxrs.poc.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer>{

    @Query("select marks from Marks marks where marks.student.studentId=(:sid)")
    public List<Marks> getStudentMarks(@Param("sid") int sid);
}
