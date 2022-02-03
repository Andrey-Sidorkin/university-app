package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.DayScheduleMapper;
import com.example.universityapp.dto.request.DayScheduleRequestDto;
import com.example.universityapp.dto.response.DayScheduleResponseDto;
import com.example.universityapp.dto.response.TimeTableResponseDto;
import com.example.universityapp.model.DaySchedule;
import com.example.universityapp.model.Group;
import com.example.universityapp.model.Student;
import com.example.universityapp.service.DayScheduleService;
import com.example.universityapp.service.GroupService;
import com.example.universityapp.service.StudentService;
import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/schedules")
@Validated
public class DayScheduleController {
    private static final String DAY_PATTERN = "MONDAY|TUESDAY|THURSDAY|WEDNESDAY|FRIDAY|SATURDAY";
    private static final String SEMESTER_PATTERN = "FIRST|SECOND";
    private static final String CARD_PATTERN = "^STDNT-\\d{3}-\\d{3}-\\d{4}$";
    private final DayScheduleService scheduleService;
    private final GroupService groupService;
    private final StudentService studentService;
    private final DayScheduleMapper mapper;

    @GetMapping("/{id}")
    public DayScheduleResponseDto get(@PathVariable @Positive Long id) {
        DaySchedule schedule = scheduleService.findById(id);
        return mapper.modelToDto(schedule);
    }

    @GetMapping
    public DayScheduleResponseDto getByGroupIdSemesterDay(
            @RequestParam @NotNull @Positive Long id,
            @RequestParam(name = "semester") @NotBlank @Pattern(
                    regexp = SEMESTER_PATTERN) String semesterName,
            @RequestParam(name = "day") @NotBlank @Pattern(regexp = DAY_PATTERN) String dayName) {
        DaySchedule.Semester semester = DaySchedule.Semester.valueOf(semesterName);
        DaySchedule.StudyDay day = DaySchedule.StudyDay.valueOf(dayName);
        Group group = groupService.findById(id);
        DaySchedule schedule = scheduleService.findByGroupSemesterDay(group, semester, day);
        return mapper.modelToDto(schedule);
    }

    @GetMapping("/by-card")
    public TimeTableResponseDto getTimeTableByStudentCard(
            @RequestParam(name = "card") @NotBlank @Pattern(
                    regexp = CARD_PATTERN) String studentCard,
            @RequestParam(name = "day") @NotBlank @Pattern(
                    regexp = DAY_PATTERN) String dayName) {
        DaySchedule.Semester semester = LocalDate.now().getMonthValue() >= 8
                ? DaySchedule.Semester.FIRST : DaySchedule.Semester.SECOND;
        DaySchedule.StudyDay day = DaySchedule.StudyDay.valueOf(dayName);
        Group group = groupService.findByStudentCard(studentCard);
        Student student = studentService.findByStudentCard(studentCard);
        DaySchedule schedule = scheduleService.findByGroupSemesterDay(group, semester, day);
        return mapper.composeTableDto(schedule, student);
    }

    @PostMapping
    public DayScheduleResponseDto save(@RequestBody @Valid DayScheduleRequestDto dto) {
        DaySchedule schedule = mapper.dtoToModel(dto);
        scheduleService.save(schedule);
        return mapper.modelToDto(schedule);
    }

    @PutMapping("/{id}")
    public DayScheduleResponseDto update(@PathVariable @Positive Long id,
                                          @RequestBody @Valid DayScheduleRequestDto dto) {
        DaySchedule schedule = mapper.dtoToModel(dto);
        schedule.setId(id);
        scheduleService.save(schedule);
        return mapper.modelToDto(schedule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Positive Long id) {
        scheduleService.deleteById(id);
    }
}
