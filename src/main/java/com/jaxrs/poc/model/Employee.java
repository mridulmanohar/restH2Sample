package com.jaxrs.poc.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Proxy(lazy = false)
@XmlRootElement
public class Employee implements Serializable {

    private static final long serialVersionUID = 4715038353399117027L;

    @Id
    @GeneratedValue
    private int empId;

    private String empName;
    private long salary;
    private int deptId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
