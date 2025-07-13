package com.example.Emolyeeapi.service;


import com.example.Emolyeeapi.dao.EmployeeDao;
import com.example.Emolyeeapi.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}