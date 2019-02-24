package com.jaxrs.poc.service;

import com.jaxrs.poc.dao.EmployeeDAO;
import com.jaxrs.poc.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeDAO dao;

    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    public Employee getEmployeeById(int id) {
        Employee emp = null;
        try {
            emp = dao.getOne(id);
        } catch (EntityNotFoundException ex) {
            logger.info(ex.getMessage());
        }

        return emp;
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
