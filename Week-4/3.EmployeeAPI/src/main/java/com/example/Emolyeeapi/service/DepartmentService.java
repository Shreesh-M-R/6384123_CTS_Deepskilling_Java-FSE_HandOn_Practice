package com.example.Emolyeeapi.service;


import com.example.Emolyeeapi.dao.DepartmentDao;
import com.example.Emolyeeapi.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}