/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.CountryController.dao;

import com.example.CountryController.exception.EmployeeNotFoundException;
import com.example.CountryController.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> employeeList = new ArrayList<>();

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(employee.getId())) {
                employeeList.set(i, employee);
                found = true;
                break;
            }
        }
        if (!found) throw new EmployeeNotFoundException("Employee Not Found");
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        boolean removed = employeeList.removeIf(e -> e.getId() == id);
        if (!removed) throw new EmployeeNotFoundException("Employee Not Found");
    }
}
