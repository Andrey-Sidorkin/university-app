package com.example.universityapp.dao;

import com.example.universityapp.model.AcademicYear;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicYearDao extends JpaRepository<AcademicYear, Long> {
    Optional<AcademicYear> findByCalendarYearAndNumber(
            String calendarYear, AcademicYear.YearNumber number);
}
