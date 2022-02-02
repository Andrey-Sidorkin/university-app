package com.example.universityapp.dto.response;

import java.util.Set;
import lombok.Data;

@Data
public class ProfessorResponseDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private String professorCard;
    private String rank;
    private Set<Long> studyIds;
    private boolean isDismissed;
}
