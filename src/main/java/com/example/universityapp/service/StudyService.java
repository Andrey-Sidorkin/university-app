package com.example.universityapp.service;

import com.example.universityapp.model.Study;
import java.util.List;

public interface StudyService {
    Study findById(Long id);

    Study save(Study study);

    List<Study> findAll();

    void deleteById(Long id);
}
