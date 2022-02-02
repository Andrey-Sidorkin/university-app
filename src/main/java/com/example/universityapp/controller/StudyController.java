package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.StudyMapper;
import com.example.universityapp.dto.request.StudyRequestDto;
import com.example.universityapp.dto.response.StudyResponseDto;
import com.example.universityapp.model.Study;
import com.example.universityapp.service.StudyService;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/studies")
public class StudyController {
    private final StudyService studyService;
    private final StudyMapper mapper;

    @GetMapping("/{id}")
    public StudyResponseDto get(@PathVariable @Positive Long id) {
        Study study = studyService.findById(id);
        return mapper.modelToDto(study);
    }

    @PostMapping
    public StudyResponseDto save(@RequestBody @Valid StudyRequestDto dto) {
        Study study = mapper.dtoToModel(dto);
        studyService.save(study);
        return mapper.modelToDto(study);
    }

    @PutMapping("/{id}")
    public StudyResponseDto update(@PathVariable @Positive Long id,
                                        @RequestBody @Valid StudyRequestDto dto) {
        Study study = mapper.dtoToModel(dto);
        study.setId(id);
        studyService.save(study);
        return mapper.modelToDto(study);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Positive Long id) {
        studyService.deleteById(id);
    }
}
