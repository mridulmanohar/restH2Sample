package com.jaxrs.poc.service;

import com.jaxrs.poc.dao.EmployeeDAO;
import com.jaxrs.poc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeDAO dao;

    public Employee getEmployeeById(int id) {
        return dao.getOne(id);
    }

    public List<Employee> getEmployeesByCriteria(int deptId, long salary) {
        return dao.getEmployeesByCriteria(deptId);
    }

    public Employee createEmployee(Employee emp) {
        return dao.save(emp);
    }

    public Employee updateEmployee(Employee emp) {
        return dao.save(emp);
    }

    public void deleteEmployeeById(int empId) {
        dao.deleteById(empId);
    }
}
