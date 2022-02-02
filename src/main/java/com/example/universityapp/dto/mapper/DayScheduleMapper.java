package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.DayScheduleRequestDto;
import com.example.universityapp.dto.response.DayScheduleResponseDto;
import com.example.universityapp.dto.response.TimeTableResponseDto;
import com.example.universityapp.model.DaySchedule;
import com.example.universityapp.model.Group;
import com.example.universityapp.model.Professor;
import com.example.universityapp.model.Student;
import com.example.universityapp.model.Study;
import com.example.universityapp.service.GroupService;
import com.example.universityapp.service.StudyService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DayScheduleMapper implements Mapper<DaySchedule,
        DayScheduleResponseDto, DayScheduleRequestDto> {
    private final GroupService groupService;
    private final StudyService studyService;

    @Override
    public DayScheduleResponseDto modelToDto(DaySchedule schedule) {
        DayScheduleResponseDto dto = new DayScheduleResponseDto();
        dto.setId(schedule.getId());
        dto.setSemester(schedule.getSemester().name());
        dto.setStudyDay(schedule.getStudyDay().name());
        dto.setGroupId(schedule.getGroup().getId());
        dto.setStudyIds(schedule.getStudies()
                .stream()
                .map(Study::getId)
                .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public DaySchedule dtoToModel(DayScheduleRequestDto dto) {
        DaySchedule schedule = new DaySchedule();
        Group group = groupService.findById(dto.getGroupId());
        schedule.setSemester(DaySchedule.Semester.valueOf(dto.getSemester()));
        schedule.setStudyDay(DaySchedule.StudyDay.valueOf(dto.getStudyDay()));
        schedule.setGroup(group);
        schedule.setStudies(dto.getStudyIds()
                .stream()
                .map(studyService::findById)
                .collect(Collectors.toList()));
        return schedule;
    }

    public TimeTableResponseDto composeTableDto(DaySchedule schedule, Student student) {
        String template = "%s(%s, aud.%s)";
        TimeTableResponseDto dto = new TimeTableResponseDto();
        String studentName = String.join(" ", student.getName(), student.getSurname());
        dto.setStudentName(studentName);
        dto.setStudyDay(schedule.getStudyDay().name());
        List<Study> studies = schedule.getStudies();
        Map<String, String> table = new LinkedHashMap<>();
        table.put("I (09:00-10:30) ", studies.size() > 0
                ? String.format(template, studies.get(0).getName(),
                getProfessorName(studies.get(0).getProfessor()),
                studies.get(0).getAuditorium().getIndex()) : " ");
        table.put("II (10:40-12:10) ", studies.size() > 1
                ? String.format(template, studies.get(1).getName(),
                getProfessorName(studies.get(1).getProfessor()),
                studies.get(1).getAuditorium().getIndex()) : " ");
        table.put("III (12:20-13:50) ", studies.size() > 2
                ? String.format(template, studies.get(2).getName(),
                getProfessorName(studies.get(2).getProfessor()),
                studies.get(2).getAuditorium().getIndex()) : " ");
        table.put("VI (14:05-15:35) ", studies.size() > 3
                ? String.format(template, studies.get(3).getName(),
                getProfessorName(studies.get(3).getProfessor()),
                studies.get(3).getAuditorium().getIndex()) : " ");
        table.put("V (15:45-17:15) ", studies.size() > 4
                ? String.format(template, studies.get(4).getName(),
                getProfessorName(studies.get(4).getProfessor()),
                studies.get(4).getAuditorium().getIndex()) : " ");
        table.put("VI (17:25-19:05) ", studies.size() > 5
                ? String.format(template, studies.get(5).getName(),
                getProfessorName(studies.get(5).getProfessor()),
                studies.get(5).getAuditorium().getIndex()) : " ");
        dto.setTimeTable(table);
        return dto;
    }

    private String getProfessorName(Professor professor) {
        return professor.getName().replaceAll(
                "^((\\w{1})\\w+)$", "$2\\.") + professor.getSurname();
    }
}
