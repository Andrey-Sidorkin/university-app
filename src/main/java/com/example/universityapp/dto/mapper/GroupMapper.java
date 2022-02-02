package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.GroupRequestDto;
import com.example.universityapp.dto.response.GroupResponseDto;
import com.example.universityapp.model.DaySchedule;
import com.example.universityapp.model.Group;
import com.example.universityapp.model.Student;
import com.example.universityapp.service.AcademicYearService;
import com.example.universityapp.service.DayScheduleService;
import com.example.universityapp.service.DepartmentService;
import com.example.universityapp.service.StudentService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GroupMapper implements Mapper<Group, GroupResponseDto, GroupRequestDto> {
    private final DepartmentService departmentService;
    private final AcademicYearService academicYearService;
    private final StudentService studentService;
    private final DayScheduleService scheduleService;

    @Override
    public GroupResponseDto modelToDto(Group group) {
        GroupResponseDto dto = new GroupResponseDto();
        dto.setId(group.getId());
        dto.setDepartmentName(group.getDepartment().getName());
        dto.setAcademicYearId(group.getAcademicYear().getId());
        dto.setGroupNumber(group.getGroupNumber().name());
        dto.setStudentCards(group.getStudents()
                .stream()
                .map(Student::getStudentCard)
                .collect(Collectors.toSet()));
        dto.setDayScheduleIds(group.getWeekSchedule()
                .stream()
                .map(DaySchedule::getId)
                .collect(Collectors.toSet()));
        return dto;
    }

    @Override
    public Group dtoToModel(GroupRequestDto dto) {
        Group group = new Group();
        group.setDepartment(departmentService.findByName(dto.getDepartmentName()));
        group.setAcademicYear(academicYearService.findById(dto.getAcademicYearId()));
        group.setGroupNumber(Group.GroupNumber.valueOf(dto.getGroupNumber()));
        group.setStudents(dto.getStudentCards()
                .stream()
                .map(studentService::findByStudentCard)
                .collect(Collectors.toSet()));
        group.setWeekSchedule(dto.getDayScheduleIds()
                .stream()
                .map(scheduleService::findById)
                .collect(Collectors.toSet()));
        return group;
    }
}
