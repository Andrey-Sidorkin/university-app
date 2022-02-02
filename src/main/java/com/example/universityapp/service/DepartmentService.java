package com.example.universityapp.service;

import com.example.universityapp.model.Department;
import com.example.universityapp.model.Faculty;
import java.util.List;

public interface DepartmentService {
    Department findByName(String name);

    Department save(Department department);

    List<Department> findAllByFaculty(Faculty faculty);

    void deleteByName(String name);
}
