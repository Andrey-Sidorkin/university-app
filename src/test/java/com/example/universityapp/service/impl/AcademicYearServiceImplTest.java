package com.example.universityapp.service.impl;

import com.example.universityapp.dao.AcademicYearDao;
import com.example.universityapp.model.AcademicYear;
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
class AcademicYearServiceImplTest {
    @InjectMocks
    private AcademicYearServiceImpl yearService;
    @Mock
    private AcademicYearDao yearDao;
    private AcademicYear academicYear;

    @BeforeEach
    void setUp() {
        academicYear = new AcademicYear();
        academicYear.setCalendarYear("2021/2022");
        academicYear.setNumber(AcademicYear.YearNumber.FIRST);
    }

    @Test
    void findById_ok() {
        Mockito.when(yearDao.findById(1L)).thenReturn(Optional.of(academicYear));
        Assertions.assertEquals(yearService.findById(1L), academicYear);
    }

    @Test
    void findById_wrongId_notOk() {
        Mockito.when(yearDao.findById(2L)).thenReturn(Optional.empty());
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> yearService.findById(2L));
        Assertions.assertEquals("Can't find academic year by id 2", exception.getMessage());
    }

    @Test
    void findByYearAndNumber_oK() {
        Mockito.when(yearDao.findByCalendarYearAndNumber(
                "2021/2022", AcademicYear.YearNumber.FIRST))
                .thenReturn(Optional.of(academicYear));
        Assertions.assertEquals(yearService.findByYearAndNumber(
                "2021/2022", AcademicYear.YearNumber.FIRST), academicYear);
    }

    @Test
    void findByYearAndNumber_wrongData_notOk() {
        Mockito.when(yearDao.findByCalendarYearAndNumber(
                        "2023/2024", AcademicYear.YearNumber.SECOND))
                .thenReturn(Optional.empty());
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> yearService.findByYearAndNumber(
                        "2023/2024", AcademicYear.YearNumber.SECOND));
        Assertions.assertEquals("Can't find academic year by year 2023/2024 and number SECOND",
                exception.getMessage());
    }

    @Test
    void save_ok() {
        yearService.save(academicYear);
        Mockito.verify(yearDao, Mockito.times(1)).save(academicYear);
    }

    @Test
    void deleteById_ok() {
        yearService.deleteById(1L);
        Mockito.verify(yearDao, Mockito.times(1)).deleteById(1L);
    }
}
