package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.StudyRequestDto;
import com.example.universityapp.dto.response.StudyResponseDto;
import com.example.universityapp.model.Study;
import com.example.universityapp.service.AuditoriumService;
import com.example.universityapp.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudyMapper implements Mapper<Study, StudyResponseDto, StudyRequestDto> {
    private final AuditoriumService auditoriumService;
    private final ProfessorService professorService;

    @Override
    public StudyResponseDto modelToDto(Study study) {
        StudyResponseDto dto = new StudyResponseDto();
        dto.setId(study.getId());
        dto.setName(study.getName());
        dto.setStudyType(study.getType().name());
        dto.setAuditoriumId(study.getAuditorium().getId());
        dto.setProfessorCard(study.getProfessor().getProfessorCard());
        return dto;
    }

    @Override
    public Study dtoToModel(StudyRequestDto dto) {
        Study study = new Study();
        study.setName(dto.getName());
        study.setType(Study.StudyType.valueOf(dto.getStudyType()));
        study.setAuditorium(auditoriumService.findById(dto.getAuditoriumId()));
        study.setProfessor(professorService.findByProfessorCard(dto.getProfessorCard()));
        return study;
    }
}
