package com.example.universityapp.service.impl;

import com.example.universityapp.dao.AcademicYearDao;
import com.example.universityapp.model.AcademicYear;
import com.example.universityapp.service.AcademicYearService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AcademicYearServiceImpl implements AcademicYearService {
    private final AcademicYearDao yearDao;

    @Override
    public AcademicYear findById(Long id) {
        return yearDao.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find academic year by id " + id));
    }

    @Override
    public AcademicYear findByYearAndNumber(String calendarYear, AcademicYear.YearNumber number) {
        return yearDao.findByCalendarYearAndNumber(calendarYear, number).orElseThrow(
                () -> new RuntimeException("Can't find academic year by year " + calendarYear
                        + " and number " + number));
    }

    @Override
    public AcademicYear save(AcademicYear academicYear) {
        return yearDao.save(academicYear);
    }

    @Override
    public void deleteById(Long id) {
        yearDao.deleteById(id);
    }
}
