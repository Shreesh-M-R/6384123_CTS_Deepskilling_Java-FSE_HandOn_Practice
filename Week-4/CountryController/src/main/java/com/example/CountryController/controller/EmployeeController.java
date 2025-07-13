/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.CountryController.controller;


import org.springframework.web.bind.annotation.*;
import com.example.CountryController.model.Employee;
import com.example.CountryController.service.EmployeeService;
import javax.validation.Valid;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String getEmployees() {
        return "GET Employee endpoint working";
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody @Valid Employee employee) {
        return employee;
    }


    }
}
