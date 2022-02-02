package com.example.universityapp.service;

import com.example.universityapp.model.Faculty;
import java.util.List;

public interface FacultyService {
    Faculty findByName(String name);

    Faculty save(Faculty faculty);

    List<Faculty> findAll();

    void deleteByName(String name);
}
