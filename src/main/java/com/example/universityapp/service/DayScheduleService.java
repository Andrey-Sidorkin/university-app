package com.example.universityapp.service;

import com.example.universityapp.model.DaySchedule;
import com.example.universityapp.model.Group;

public interface DayScheduleService {
    DaySchedule findById(Long id);

    DaySchedule findByGroupSemesterDay(
            Group group, DaySchedule.Semester semester, DaySchedule.StudyDay studyDay);

    DaySchedule save(DaySchedule daySchedule);

    DaySchedule update(DaySchedule daySchedule);

    void deleteById(Long id);
}
