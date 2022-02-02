package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.FacultyRequestDto;
import com.example.universityapp.dto.response.FacultyResponseDto;
import com.example.universityapp.model.Department;
import com.example.universityapp.model.Faculty;
import com.example.universityapp.service.DepartmentService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FacultyMapper implements Mapper<Faculty,
        FacultyResponseDto, FacultyRequestDto> {
    private final DepartmentService departmentService;

    @Override
    public FacultyResponseDto modelToDto(Faculty faculty) {
        FacultyResponseDto dto = new FacultyResponseDto();
        dto.setName(faculty.getName());
        dto.setDepartmentNames(faculty.getDepartments()
                .stream()
                .map(Department::getName)
                .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public Faculty dtoToModel(FacultyRequestDto dto) {
        Faculty faculty = new Faculty();
        faculty.setName(dto.getName());
        faculty.setDepartments(dto.getDepartmentNames()
                .stream()
                .map(departmentService::findByName)
                .collect(Collectors.toList()));
        return faculty;
    }
}
