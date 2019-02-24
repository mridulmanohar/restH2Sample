package com.jaxrs.poc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Proxy(lazy = false)
@XmlRootElement
public class Marks {

    @Id
    @GeneratedValue
    private int seqId;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    @JsonBackReference
    private Student student;

    private int standard;
    private String subject;
    private int marksObtained;

    public Marks() {}

    public Marks(int seqId, Student student, int standard,
                 String subject, int marksObtained) {
        this.seqId = seqId;
        this.student = student;
        this.standard = standard;
        this.subject = subject;
        this.marksObtained = marksObtained;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }
}
