package com.example.universityapp.dao;

import com.example.universityapp.model.Professor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessorDao extends JpaRepository<Professor, String> {
    @Query("FROM Professor p WHERE p.isDismissed = false")
    List<Professor> findAllWorking();
}
