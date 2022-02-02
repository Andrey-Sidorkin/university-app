package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.ProfessorRequestDto;
import com.example.universityapp.dto.response.ProfessorResponseDto;
import com.example.universityapp.model.Professor;
import com.example.universityapp.model.Study;
import com.example.universityapp.service.StudyService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProfessorMapper implements Mapper<Professor,
        ProfessorResponseDto, ProfessorRequestDto> {
    private final StudyService studyService;

    @Override
    public ProfessorResponseDto modelToDto(Professor professor) {
        ProfessorResponseDto dto = new ProfessorResponseDto();
        dto.setProfessorCard(professor.getProfessorCard());
        dto.setName(professor.getName());
        dto.setSurname(professor.getSurname());
        dto.setPhoneNumber(professor.getPhoneNumber());
        dto.setRank(professor.getRank().name());
        dto.setStudyIds(professor.getStudies()
                .stream()
                .map(Study::getId)
                .collect(Collectors.toSet()));
        dto.setDismissed(professor.isDismissed());
        return dto;
    }

    @Override
    public Professor dtoToModel(ProfessorRequestDto dto) {
        Professor professor = new Professor();
        professor.setProfessorCard(dto.getProfessorCard());
        professor.setName(dto.getName());
        professor.setSurname(dto.getSurname());
        professor.setPhoneNumber(dto.getPhoneNumber());
        professor.setRank(Professor.Rank.valueOf(dto.getRank()));
        professor.setStudies(dto.getStudyIds()
                .stream()
                .map(studyService::findById)
                .collect(Collectors.toSet()));
        professor.setDismissed(dto.isDismissed());
        return professor;
    }
}
