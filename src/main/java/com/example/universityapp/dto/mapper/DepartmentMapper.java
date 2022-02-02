package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.DepartmentRequestDto;
import com.example.universityapp.dto.response.DepartmentResponseDto;
import com.example.universityapp.model.Department;
import com.example.universityapp.model.Professor;
import com.example.universityapp.service.FacultyService;
import com.example.universityapp.service.ProfessorService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DepartmentMapper implements Mapper<Department,
        DepartmentResponseDto, DepartmentRequestDto> {
    private final FacultyService facultyService;
    private final ProfessorService professorService;

    @Override
    public DepartmentResponseDto modelToDto(Department department) {
        DepartmentResponseDto dto = new DepartmentResponseDto();
        dto.setName(department.getName());
        dto.setFacultyName(department.getFaculty().getName());
        dto.setProfessorsCards(department.getProfessors()
                .stream()
                .map(Professor::getProfessorCard)
                .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public Department dtoToModel(DepartmentRequestDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setFaculty(facultyService.findByName(dto.getFacultyName()));
        department.setProfessors(dto.getProfessorsCards()
                .stream()
                .map(professorService::findByProfessorCard)
                .collect(Collectors.toList()));
        return department;
    }
}
