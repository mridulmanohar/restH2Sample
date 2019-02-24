package com.jaxrs.poc.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Proxy(lazy = false)
@XmlRootElement
public class Student {
    @Id
    @GeneratedValue
    private int studentId;

    private String studentName;
    private int standard;

    private String classTeacher;

    @Column(nullable = false)
    private String schoolName;

    @Column(nullable = true)
    private int rank;

    @OneToMany(mappedBy="student", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Marks> marks;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }
}
