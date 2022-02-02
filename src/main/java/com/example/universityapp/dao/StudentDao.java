package com.example.universityapp.dao;

import com.example.universityapp.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentDao extends JpaRepository<Student, String> {
    @Query("FROM Student s WHERE s.academicYear IS NOT NULL")
    List<Student> findAllStudying();
}
