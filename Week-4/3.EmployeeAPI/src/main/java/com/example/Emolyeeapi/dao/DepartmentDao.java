package com.example.Emolyeeapi.dao;


import com.example.Emolyeeapi.model.Department;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {
    private static List<Department> DEPARTMENT_LIST;

    public DepartmentDao(@Value("#{departmentList}") List<Department> departmentList) {
        DEPARTMENT_LIST = departmentList;
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
