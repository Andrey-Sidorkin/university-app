package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.AuditoriumMapper;
import com.example.universityapp.dto.request.AuditoriumRequestDto;
import com.example.universityapp.dto.response.AuditoriumResponseDto;
import com.example.universityapp.model.Auditorium;
import com.example.universityapp.model.Faculty;
import com.example.universityapp.service.AuditoriumService;
import com.example.universityapp.service.FacultyService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auditoriums")
public class AuditoriumController {
    private final AuditoriumService auditoriumService;
    private final FacultyService facultyService;
    private final AuditoriumMapper mapper;

    @GetMapping("/{id}")
    public AuditoriumResponseDto get(@PathVariable @Positive Long id) {
        Auditorium auditorium = auditoriumService.findById(id);
        return mapper.modelToDto(auditorium);
    }

    @GetMapping("/by-faculty")
    public List<AuditoriumResponseDto> getByFacultyName(
            @RequestParam(name = "name") @NotBlank String facultyName) {
        Faculty faculty = facultyService.findByName(facultyName);
        return auditoriumService.findAllByFaculty(faculty)
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AuditoriumResponseDto save(@RequestBody @Valid AuditoriumRequestDto dto) {
        Auditorium auditorium = mapper.dtoToModel(dto);
        auditoriumService.save(auditorium);
        return mapper.modelToDto(auditorium);
    }

    @PutMapping("/{id}")
    public AuditoriumResponseDto update(@PathVariable @Positive Long id,
                                          @RequestBody @Valid AuditoriumRequestDto dto) {
        Auditorium auditorium = mapper.dtoToModel(dto);
        auditorium.setId(id);
        auditoriumService.save(auditorium);
        return mapper.modelToDto(auditorium);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Positive Long id) {
        auditoriumService.deleteById(id);
    }
}
