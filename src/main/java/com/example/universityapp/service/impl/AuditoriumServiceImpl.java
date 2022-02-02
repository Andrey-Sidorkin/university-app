package com.example.universityapp.service.impl;

import com.example.universityapp.dao.AuditoriumDao;
import com.example.universityapp.model.Auditorium;
import com.example.universityapp.model.Faculty;
import com.example.universityapp.service.AuditoriumService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    private final AuditoriumDao auditoriumDao;

    @Override
    public Auditorium findById(Long id) {
        return auditoriumDao.findById(id).orElse(null);
    }

    @Override
    public List<Auditorium> findAllByFaculty(Faculty faculty) {
        return auditoriumDao.findAllByFaculty(faculty);
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        return auditoriumDao.save(auditorium);
    }

    @Override
    public Auditorium update(Auditorium auditorium) {
        if (auditorium.getId() == null) {
            throw new RuntimeException("Can't update auditorium " + auditorium + ": no id");
        }
        return auditoriumDao.save(auditorium);
    }

    @Override
    public void deleteById(Long id) {
        auditoriumDao.deleteById(id);
    }
}
