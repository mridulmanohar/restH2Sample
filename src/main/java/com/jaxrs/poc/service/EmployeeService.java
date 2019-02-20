package com.jaxrs.poc.service;

import com.jaxrs.poc.dao.EmployeeDAO;
import com.jaxrs.poc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

    /*@Autowired
    EmployeeDAOImpl dao;*/

    @Autowired
    EmployeeDAO dao;

    /*public Employee getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }

    public Employee createEmployee(Employee emp) {
         return dao.createEmployee(emp);
    }

    public Employee updateEmployee(Employee emp) {
        return dao.updateEmployee(emp);
    }*/

    public Employee getEmployeeById(int id) {
        return dao.getOne(id);
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
