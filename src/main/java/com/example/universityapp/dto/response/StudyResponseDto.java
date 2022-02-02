package com.example.universityapp.dto.response;

import lombok.Data;

@Data
public class StudyResponseDto {
    private Long id;
    private String name;
    private String studyType;
    private Long auditoriumId;
    private String professorCard;
}
