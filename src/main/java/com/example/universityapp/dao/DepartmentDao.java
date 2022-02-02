package com.example.universityapp.dao;

import com.example.universityapp.model.Department;
import com.example.universityapp.model.Faculty;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentDao extends JpaRepository<Department, String> {
    @Query("FROM Department d WHERE d.faculty = :faculty")
    List<Department> findAllByFaculty(Faculty faculty);
}
