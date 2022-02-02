package com.example.universityapp.service.impl;

import com.example.universityapp.dao.DayScheduleDao;
import com.example.universityapp.model.DaySchedule;
import com.example.universityapp.model.Group;
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
class DayScheduleServiceImplTest {
    @InjectMocks
    private DayScheduleServiceImpl scheduleService;
    @Mock
    private DayScheduleDao scheduleDao;
    private DaySchedule schedule;
    private Group group;

    @BeforeEach
    void setUp() {
        group = new Group();
        group.setId(1L);
        group.setGroupNumber(Group.GroupNumber.FIRST);

        schedule = new DaySchedule();
        schedule.setId(1L);
        schedule.setSemester(DaySchedule.Semester.FIRST);
        schedule.setStudyDay(DaySchedule.StudyDay.MONDAY);
        schedule.setGroup(group);
    }

    @Test
    void findById_ok() {
        Mockito.when(scheduleDao.findById(1L)).thenReturn(Optional.of(schedule));
        Assertions.assertEquals(scheduleService.findById(1L), schedule);
    }

    @Test
    void findByGroupSemesterDay_ok() {
        Mockito.when(scheduleDao.findByGroupAndSemesterAndStudyDay(
                group, DaySchedule.Semester.FIRST, DaySchedule.StudyDay.MONDAY))
                .thenReturn(Optional.of(schedule));
        Assertions.assertEquals(scheduleService.findByGroupSemesterDay(
                group, DaySchedule.Semester.FIRST, DaySchedule.StudyDay.MONDAY), schedule);
    }

    @Test
    void save_ok() {
        scheduleService.save(schedule);
        Mockito.verify(scheduleDao, Mockito.times(1)).save(schedule);
    }

    @Test
    void update_ok() {
        schedule.setId(null);
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> scheduleService.update(schedule));
        Assertions.assertEquals("Can't update day schedule " + schedule + ": no id",
                exception.getMessage());
    }

    @Test
    void deleteById_ok() {
        scheduleService.deleteById(1L);
        Mockito.verify(scheduleDao, Mockito.times(1)).deleteById(1L);
    }
}
