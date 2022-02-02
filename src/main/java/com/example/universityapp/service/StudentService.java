package com.example.universityapp.service;

import com.example.universityapp.model.Student;
import java.util.List;

public interface StudentService {
    Student findByStudentCard(String studentCard);

    Student save(Student student);

    List<Student> findAll();

    void deleteByStudentCard(String studentCard);

    void expelByStudentCard(String studentCard);
}
