package com.example.universityapp.service;

import com.example.universityapp.model.Professor;
import java.util.List;

public interface ProfessorService {
    Professor findByProfessorCard(String professorCard);

    Professor save(Professor professor);

    List<Professor> findAll();

    void dismissByProfessorCard(String professorCard);

    void deleteByProfessorCard(String professorCard);
}
