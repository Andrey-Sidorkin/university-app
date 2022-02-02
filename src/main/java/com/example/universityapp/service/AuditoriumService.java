package com.example.universityapp.service;

import com.example.universityapp.model.Auditorium;
import com.example.universityapp.model.Faculty;
import java.util.List;

public interface AuditoriumService {
    Auditorium findById(Long id);

    List<Auditorium> findAllByFaculty(Faculty faculty);

    Auditorium save(Auditorium auditorium);

    Auditorium update(Auditorium auditorium);

    void deleteById(Long id);
}
