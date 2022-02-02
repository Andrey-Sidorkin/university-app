package com.example.universityapp.dao;

import com.example.universityapp.model.DaySchedule;
import com.example.universityapp.model.Group;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayScheduleDao extends JpaRepository<DaySchedule, Long> {
    Optional<DaySchedule> findByGroupAndSemesterAndStudyDay(
            Group group, DaySchedule.Semester semester, DaySchedule.StudyDay studyDay);
}
