package com.example.universityapp.service.impl;

import com.example.universityapp.dao.StudyDao;
import com.example.universityapp.model.Study;
import com.example.universityapp.service.StudyService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudyServiceImpl implements StudyService {
    private final StudyDao studyDao;

    @Override
    public Study findById(Long id) {
        return studyDao.findById(id).orElse(null);
    }

    @Override
    public Study save(Study study) {
        return studyDao.save(study);
    }

    @Override
    public List<Study> findAll() {
        return studyDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        studyDao.deleteById(id);
    }
}
