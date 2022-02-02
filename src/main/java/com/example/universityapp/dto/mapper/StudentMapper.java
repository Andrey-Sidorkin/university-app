package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.StudentRequestDto;
import com.example.universityapp.dto.response.StudentResponseDto;
import com.example.universityapp.model.Student;
import com.example.universityapp.service.AcademicYearService;
import com.example.universityapp.service.DepartmentService;
import com.example.universityapp.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentMapper implements Mapper<Student, StudentResponseDto, StudentRequestDto> {
    private final AcademicYearService yearService;
    private final GroupService groupService;
    private final DepartmentService departmentService;

    @Override
    public StudentResponseDto modelToDto(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setStudentCard(student.getStudentCard());
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setAcademicYearId(student.getAcademicYear().getId());
        dto.setDepartmentName(student.getDepartment().getName());
        dto.setGroupId(student.getGroup().getId());
        return dto;
    }

    @Override
    public Student dtoToModel(StudentRequestDto dto) {
        Student student = new Student();
        student.setStudentCard(dto.getStudentCard());
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setAcademicYear(yearService.findById(dto.getAcademicYearId()));
        student.setDepartment(departmentService.findByName(dto.getDepartmentName()));
        student.setGroup(groupService.findById(dto.getGroupId()));
        return student;
    }
}
