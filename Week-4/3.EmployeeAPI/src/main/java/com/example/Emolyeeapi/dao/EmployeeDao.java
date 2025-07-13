package com.example.Emolyeeapi.dao;

import com.example.Emolyeeapi.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {
    private static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao(@Value("#{employeeList}") List<Employee> employeeList) {
        EMPLOYEE_LIST = employeeList;
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}