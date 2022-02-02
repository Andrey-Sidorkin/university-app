package com.example.universityapp.service.impl;

import com.example.universityapp.dao.DepartmentDao;
import com.example.universityapp.model.Department;
import com.example.universityapp.model.Faculty;
import com.example.universityapp.service.DepartmentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;

    @Override
    public Department findByName(String name) {
        return departmentDao.findById(name).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public List<Department> findAllByFaculty(Faculty faculty) {
        return departmentDao.findAllByFaculty(faculty);
    }

    @Override
    public void deleteByName(String name) {
        departmentDao.deleteById(name);
    }
}
