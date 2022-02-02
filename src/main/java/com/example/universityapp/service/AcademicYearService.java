package com.example.universityapp.service;

import com.example.universityapp.model.AcademicYear;

public interface AcademicYearService {
    AcademicYear findById(Long id);

    AcademicYear findByYearAndNumber(String calendarYear,
                                     AcademicYear.YearNumber number);

    AcademicYear save(AcademicYear academicYear);

    void deleteById(Long id);
}
