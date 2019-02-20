package com.jaxrs.poc.dao;

import com.jaxrs.poc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
