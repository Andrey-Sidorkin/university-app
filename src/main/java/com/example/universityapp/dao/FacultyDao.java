package com.example.universityapp.dao;

import com.example.universityapp.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyDao extends JpaRepository<Faculty, String> {
}
