package com.example.universityapp.service.impl;

import com.example.universityapp.dao.FacultyDao;
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
class FacultyServiceImplTest {
    @InjectMocks
    private FacultyServiceImpl facultyService;
    @Mock
    private FacultyDao facultyDao;
    private Faculty faculty;

    @BeforeEach
    void setUp() {
        faculty = new Faculty();
        faculty.setName("Philosophy");
        List<Professor> professors = new ArrayList<>();
        Department department = new Department();
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
        Mockito.when(facultyDao.findById("Philosophy")).thenReturn(Optional.of(faculty));
        Assertions.assertEquals(facultyService.findByName("Philosophy"), faculty);
    }

    @Test
    void save_ok() {
        facultyService.save(faculty);
        Mockito.verify(facultyDao, Mockito.times(1)).save(faculty);
    }

    @Test
    void findAll_ok() {
        List<Faculty> faculties = List.of(faculty);
        Mockito.when(facultyDao.findAll()).thenReturn(faculties);
        Assertions.assertEquals(facultyService.findAll(), faculties);
    }

    @Test
    void deleteByName_ok() {
        facultyService.deleteByName("Philosophy");
        Mockito.verify(facultyDao, Mockito.times(1)).deleteById("Philosophy");
    }
}
