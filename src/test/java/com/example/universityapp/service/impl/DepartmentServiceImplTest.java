package com.example.universityapp.service.impl;

import com.example.universityapp.dao.DepartmentDao;
import com.example.universityapp.model.Department;
import com.example.universityapp.model.Faculty;
import com.example.universityapp.model.Professor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Mock
    private DepartmentDao departmentDao;
    private Department department;
    private Faculty faculty;

    @BeforeEach
    void setUp() {
        faculty = new Faculty();
        faculty.setName("Philosophy");
        List<Professor> professors = new ArrayList<>();
        department = new Department();
        department.setName("Phenomenology");
        department.setFaculty(faculty);
        department.setProfessors(professors);
        department.setFaculty(faculty);
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        faculty.setDepartments(departments);
    }

    @Test
    void findByName_ok() {
        Mockito.when(departmentDao.findById("Phenomenology")).thenReturn(Optional.of(department));
        Assertions.assertEquals(departmentService.findByName("Phenomenology"), department);
    }

    @Test
    void findAllByFaculty_ok() {
        List<Department> departments = List.of(department);
        Mockito.when(departmentDao.findAllByFaculty(faculty)).thenReturn(departments);
        Assertions.assertEquals(departmentService.findAllByFaculty(faculty), departments);
    }

    @Test
    void save_ok() {
        departmentService.save(department);
        Mockito.verify(departmentDao, Mockito.times(1)).save(department);
    }

    @Test
    void deleteByName_ok() {
        departmentService.deleteByName("Phenomenology");
        Mockito.verify(departmentDao, Mockito.times(1)).deleteById("Phenomenology");
    }
}
