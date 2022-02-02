package com.example.universityapp.service.impl;

import com.example.universityapp.dao.ProfessorDao;
import com.example.universityapp.model.Professor;
import com.example.universityapp.service.ProfessorService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorDao professorDao;

    @Override
    public Professor findByProfessorCard(String professorCard) {
        return professorDao.findById(professorCard).orElseThrow(
                () -> new RuntimeException("Can't find professor by card " + professorCard));
    }

    @Override
    public Professor save(Professor professor) {
        return professorDao.save(professor);
    }

    @Override
    public List<Professor> findAll() {
        return professorDao.findAllWorking();
    }

    @Override
    public void dismissByProfessorCard(String professorCard) {
        Professor professor = findByProfessorCard(professorCard);
        professor.setDismissed(true);
        save(professor);
    }

    @Override
    public void deleteByProfessorCard(String professorCard) {
        professorDao.deleteById(professorCard);
    }
}
