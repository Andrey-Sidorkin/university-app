package com.example.universityapp.service.impl;

import com.example.universityapp.dao.StudyDao;
import com.example.universityapp.model.Auditorium;
import com.example.universityapp.model.Professor;
import com.example.universityapp.model.Study;
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
class StudyServiceImplTest {
    @InjectMocks
    private StudyServiceImpl studyService;
    @Mock
    private StudyDao studyDao;
    private Study study;

    @BeforeEach
    void setUp() {
        study = new Study();
        study.setId(1L);
        study.setName("Philosophy of logic and language");
        study.setAuditorium(new Auditorium());
        study.setProfessor(new Professor());
        study.setType(Study.StudyType.THEORY);
    }

    @Test
    void findById_ok() {
        Mockito.when(studyDao.findById(1L)).thenReturn(Optional.of(study));
        Assertions.assertEquals(studyService.findById(1L), study);
    }

    @Test
    void save_ok() {
        studyService.save(study);
        Mockito.verify(studyDao, Mockito.times(1)).save(study);
    }

    @Test
    void findAll_ok() {
        List<Study> studies = List.of(study);
        Mockito.when(studyDao.findAll()).thenReturn(studies);
        Assertions.assertEquals(studyService.findAll(), studies);
    }

    @Test
    void deleteById_ok() {
        studyService.deleteById(1L);
        Mockito.verify(studyDao, Mockito.times(1)).deleteById(1L);
    }
}
