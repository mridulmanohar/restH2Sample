package com.jaxrs.poc.dao;

import com.jaxrs.poc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    @Query("select emp from Employee emp where emp.deptId=(:deptId)")
    public List<Employee> getEmployeesByCriteria(@Param("deptId") int deptId);

}
