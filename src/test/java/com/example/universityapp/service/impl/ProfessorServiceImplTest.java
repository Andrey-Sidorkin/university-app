package com.example.universityapp.service.impl;

import com.example.universityapp.dao.ProfessorDao;
import com.example.universityapp.model.Professor;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProfessorServiceImplTest {
    @InjectMocks
    private ProfessorServiceImpl professorService;
    @Mock
    private ProfessorDao professorDao;
    private Professor professor;

    @BeforeEach
    void setUp() {
        professor = new Professor();
        professor.setProfessorCard("PRFSR-532-863-1263");
        professor.setName("Gilles");
        professor.setSurname("Deleuze");
        professor.setRank(Professor.Rank.PROFESSOR);
        professor.setDismissed(false);
        professor.setStudies(Collections.emptySet());
        professor.setPhoneNumber("(021) 343-24-64");
    }

    @Test
    void findByProfessorCard_ok() {
        Mockito.when(professorDao.findById("PRFSR-532-863-1263")).thenReturn(Optional.of(professor));
        Assertions.assertEquals(professorService.findByProfessorCard("PRFSR-532-863-1263"), professor);
    }

    @Test
    void findAll_ok() {
        List<Professor> professors = List.of(professor);
        Mockito.when(professorDao.findAllWorking()).thenReturn(professors);
        Assertions.assertEquals(professorService.findAll(), professors);
    }

    @Test
    void save_ok() {
        professorService.save(professor);
        Mockito.verify(professorDao, Mockito.times(1)).save(professor);
    }

    @Test
    void dismissByProfessorCard_ok() {
        Mockito.when(professorDao.findById("PRFSR-532-863-1263")).thenReturn(Optional.of(professor));
        professorService.dismissByProfessorCard("PRFSR-532-863-1263");
        Assertions.assertTrue(professor.isDismissed());
    }

    @Test
    void deleteByProfessorCard_ok() {
        professorService.deleteByProfessorCard("PRFSR-532-863-1263");
        Mockito.verify(professorDao, Mockito.times(1)).deleteById("PRFSR-532-863-1263");
    }
}
