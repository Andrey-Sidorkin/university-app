package com.example.universityapp.service.impl;

import com.example.universityapp.dao.DayScheduleDao;
import com.example.universityapp.model.DaySchedule;
import com.example.universityapp.model.Group;
import com.example.universityapp.service.DayScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DayScheduleServiceImpl implements DayScheduleService {
    private final DayScheduleDao dayScheduleDao;

    @Override
    public DaySchedule findById(Long id) {
        return dayScheduleDao.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find day schedule by id " + id));
    }

    @Override
    public DaySchedule findByGroupSemesterDay(
            Group group,
            DaySchedule.Semester semester,
            DaySchedule.StudyDay day) {
        return dayScheduleDao.findByGroupAndSemesterAndStudyDay(group, semester, day)
                .orElseThrow(() -> new RuntimeException(
                        "Can't find day schedule by group " + group + ", semester "
                                + semester + ", day " + day));
    }

    @Override
    public DaySchedule save(DaySchedule daySchedule) {
        return dayScheduleDao.save(daySchedule);
    }

    @Override
    public DaySchedule update(DaySchedule daySchedule) {
        if (daySchedule.getId() == null) {
            throw new RuntimeException("Can't update day schedule " + daySchedule + ": no id");
        }
        return dayScheduleDao.save(daySchedule);
    }

    @Override
    public void deleteById(Long id) {
        dayScheduleDao.deleteById(id);
    }
}
