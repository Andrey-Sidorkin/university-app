package com.example.universityapp.service.impl;

import com.example.universityapp.dao.StudentDao;
import com.example.universityapp.model.AcademicYear;
import com.example.universityapp.model.Department;
import com.example.universityapp.model.Group;
import com.example.universityapp.model.Student;
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
class StudentServiceImplTest {
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentDao studentDao;
    private Student student;

    @BeforeEach
    void setUp() {
        AcademicYear year = new AcademicYear();
        year.setId(1L);
        year.setCalendarYear("2021/2022");
        year.setNumber(AcademicYear.YearNumber.FIRST);

        student = new Student();
        student.setStudentCard("STDNT-342-345-3356");
        student.setAcademicYear(year);
        student.setName("Andrey");
        student.setSurname("Sidorkin");
        student.setPhoneNumber("(095) 309-61-78");
        student.setDepartment(new Department());
        student.setGroup(new Group());
    }

    @Test
    void findByStudentCard_ok() {
        Mockito.when(studentDao.findById("STDNT-342-345-3356")).thenReturn(Optional.of(student));
        Assertions.assertEquals(studentService.findByStudentCard("STDNT-342-345-3356"), student);
    }

    @Test
    void save_ok() {
        studentService.save(student);
        Mockito.verify(studentDao, Mockito.times(1)).save(student);
    }

    @Test
    void findAll_ok() {
        List<Student> students = List.of(student);
        Mockito.when(studentDao.findAllStudying()).thenReturn(students);
        Assertions.assertEquals(studentService.findAll(), students);
    }

    @Test
    void deleteByStudentCard_ok() {
        studentService.deleteByStudentCard("STDNT-342-345-3356");
        Mockito.verify(studentDao, Mockito.times(1)).deleteById("STDNT-342-345-3356");
    }

    @Test
    void expelByStudentCard_ok() {
        Mockito.when(studentDao.findById("STDNT-342-345-3356")).thenReturn(Optional.of(student));
        studentService.expelByStudentCard("STDNT-342-345-3356");
        Assertions.assertNull(student.getAcademicYear());
    }
}
