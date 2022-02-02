package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.StudentMapper;
import com.example.universityapp.dto.request.StudentRequestDto;
import com.example.universityapp.dto.response.StudentResponseDto;
import com.example.universityapp.model.Student;
import com.example.universityapp.service.StudentService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private static final String CARD_PATTERN = "^STDNT-\\d{3}-\\d{3}-\\d{4}$";
    private final StudentService studentService;
    private final StudentMapper mapper;

    @GetMapping("/{card}")
    public StudentResponseDto getByCard(
            @PathVariable @NotBlank @Pattern(regexp = CARD_PATTERN) String card) {
        Student student = studentService.findByStudentCard(card);
        return mapper.modelToDto(student);
    }

    @GetMapping
    public List<StudentResponseDto> getAll() {
        return studentService.findAll()
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public StudentResponseDto save(@RequestBody @Valid StudentRequestDto dto) {
        Student student = mapper.dtoToModel(dto);
        studentService.save(student);
        return mapper.modelToDto(student);
    }

    @DeleteMapping("/{card}/delete")
    public void delete(@PathVariable @NotBlank @Pattern(regexp = CARD_PATTERN) String card) {
        studentService.deleteByStudentCard(card);
    }

    @DeleteMapping("/{card}/expel")
    public void expel(@PathVariable @NotBlank @Pattern(regexp = CARD_PATTERN) String card) {
        studentService.expelByStudentCard(card);
    }
}
