package com.example.universityapp.service.impl;

import com.example.universityapp.dao.FacultyDao;
import com.example.universityapp.model.Faculty;
import com.example.universityapp.service.FacultyService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyDao facultyDao;

    @Override
    public Faculty findByName(String name) {
        return facultyDao.findById(name).orElse(null);
    }

    @Override
    public Faculty save(Faculty faculty) {
        return facultyDao.save(faculty);
    }

    @Override
    public List<Faculty> findAll() {
        return facultyDao.findAll();
    }

    @Override
    public void deleteByName(String name) {
        facultyDao.deleteById(name);
    }
}
