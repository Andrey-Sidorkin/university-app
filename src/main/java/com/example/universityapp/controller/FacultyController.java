package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.FacultyMapper;
import com.example.universityapp.dto.request.FacultyRequestDto;
import com.example.universityapp.dto.response.FacultyResponseDto;
import com.example.universityapp.model.Faculty;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/faculties")
@Validated
public class FacultyController {
    private final FacultyService facultyService;
    private final FacultyMapper mapper;

    @GetMapping("/{name}")
    public FacultyResponseDto getByName(
            @PathVariable @NotBlank @Size(min = 3, max = 50) String name) {
        Faculty faculty = facultyService.findByName(name);
        return mapper.modelToDto(faculty);
    }

    @GetMapping
    public List<FacultyResponseDto> getAll() {
        List<Faculty> faculties = facultyService.findAll();
        return faculties.stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public FacultyResponseDto save(@RequestBody @Valid FacultyRequestDto dto) {
        Faculty faculty = mapper.dtoToModel(dto);
        facultyService.save(faculty);
        return mapper.modelToDto(faculty);
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable @NotBlank @Size(min = 3, max = 50) String name) {
        facultyService.deleteByName(name);
    }
}
