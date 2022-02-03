package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.DepartmentMapper;
import com.example.universityapp.dto.request.DepartmentRequestDto;
import com.example.universityapp.dto.response.DepartmentResponseDto;
import com.example.universityapp.model.Department;
import com.example.universityapp.model.Faculty;
import com.example.universityapp.service.DepartmentService;
import com.example.universityapp.service.FacultyService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/departments")
@Validated
public class DepartmentController {
    private final DepartmentService departmentService;
    private final FacultyService facultyService;
    private final DepartmentMapper mapper;

    @GetMapping("/{name}")
    public DepartmentResponseDto get(
            @PathVariable @NotBlank @Size(min = 3, max = 50) String name) {
        Department department = departmentService.findByName(name);
        return mapper.modelToDto(department);
    }

    @GetMapping("/by-faculty")
    public List<DepartmentResponseDto> getAllByFacultyName(
            @RequestParam(name = "name") @NotBlank @Size(min = 3, max = 50) String facultyName) {
        Faculty faculty = facultyService.findByName(facultyName);
        List<Department> departments = departmentService.findAllByFaculty(faculty);
        return departments.stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public DepartmentResponseDto save(@RequestBody @Valid DepartmentRequestDto dto) {
        Department department = mapper.dtoToModel(dto);
        departmentService.save(department);
        return mapper.modelToDto(department);
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable @NotBlank @Size(min = 3, max = 50) String name) {
        departmentService.deleteByName(name);
    }
}
