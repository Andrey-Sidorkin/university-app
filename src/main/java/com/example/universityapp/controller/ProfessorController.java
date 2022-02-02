package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.ProfessorMapper;
import com.example.universityapp.dto.request.ProfessorRequestDto;
import com.example.universityapp.dto.response.ProfessorResponseDto;
import com.example.universityapp.model.Professor;
import com.example.universityapp.service.ProfessorService;
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
@RequestMapping("/professors")
public class ProfessorController {
    private static final String CARD_PATTERN = "^PRFSR-\\d{3}-\\d{3}-\\d{4}$";
    private final ProfessorService professorService;
    private final ProfessorMapper mapper;

    @GetMapping("/{card}")
    public ProfessorResponseDto getByCard(
            @PathVariable @NotBlank @Pattern(regexp = CARD_PATTERN) String card) {
        Professor professor = professorService.findByProfessorCard(card);
        return mapper.modelToDto(professor);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ProfessorResponseDto save(@RequestBody @Valid ProfessorRequestDto dto) {
        Professor professor = mapper.dtoToModel(dto);
        professorService.save(professor);
        return mapper.modelToDto(professor);
    }

    @DeleteMapping("/{card}/delete")
    public void delete(@PathVariable @NotBlank @Pattern(regexp = CARD_PATTERN) String card) {
        professorService.deleteByProfessorCard(card);
    }

    @DeleteMapping("/{card}/dismiss")
    public void dismiss(@PathVariable @NotBlank @Pattern(regexp = CARD_PATTERN) String card) {
        professorService.dismissByProfessorCard(card);
    }
}
