package com.example.universityapp.service.impl;

import com.example.universityapp.dao.AuditoriumDao;
import com.example.universityapp.model.Auditorium;
import com.example.universityapp.model.Faculty;
import java.util.ArrayList;
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
class AuditoriumServiceImplTest {
    @InjectMocks
    private AuditoriumServiceImpl auditoriumService;
    @Mock
    private AuditoriumDao auditoriumDao;
    private Auditorium auditorium;
    private Faculty faculty;

    @BeforeEach
    void setUp() {
        faculty = new Faculty();
        faculty.setName("Philosophy");

        auditorium = new Auditorium();
        auditorium.setId(1L);
        auditorium.setFaculty(faculty);
        auditorium.setIndex("15A");
        auditorium.setCapacity((short) 25);
        auditorium.setHasScreen(true);
    }

    @Test
    void findById_ok() {
        Mockito.when(auditoriumDao.findById(1L)).thenReturn(Optional.of(auditorium));
        Assertions.assertEquals(auditoriumService.findById(1L), auditorium);
    }

    @Test
    void findById_wrongIdGetNull_ok() {
        Mockito.when(auditoriumDao.findById(2L)).thenReturn(Optional.empty());
        Assertions.assertNull(auditoriumService.findById(2L));
    }

    @Test
    void findAllByFaculty_ok() {
        List<Auditorium> auditoriums = List.of(auditorium);
        Mockito.when(auditoriumDao.findAllByFaculty(faculty)).thenReturn(auditoriums);
        Assertions.assertEquals(auditoriumService.findAllByFaculty(faculty), auditoriums);
    }

    @Test
    void save_ok() {
        auditoriumService.save(auditorium);
        Mockito.verify(auditoriumDao, Mockito.times(1)).save(auditorium);
    }

    @Test
    void update_noId_notOk() {
        auditorium.setId(null);
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> auditoriumService.update(auditorium));
        Assertions.assertEquals("Can't update auditorium " + auditorium + ": no id",
                exception.getMessage());
    }

    @Test
    void deleteById() {
        auditoriumService.deleteById(1L);
        Mockito.verify(auditoriumDao, Mockito.times(1)).deleteById(1L);
    }
}
