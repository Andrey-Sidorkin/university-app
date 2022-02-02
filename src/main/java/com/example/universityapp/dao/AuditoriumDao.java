package com.example.universityapp.dao;

import com.example.universityapp.model.Auditorium;
import com.example.universityapp.model.Faculty;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumDao extends JpaRepository<Auditorium, Long> {
    List<Auditorium> findAllByFaculty(Faculty faculty);
}
