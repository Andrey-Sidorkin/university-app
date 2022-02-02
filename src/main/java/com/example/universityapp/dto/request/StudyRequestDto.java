package com.example.universityapp.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class StudyRequestDto {
    private static final String CARD_PATTERN = "PRFSR-\\d{3}-\\d{3}-\\d{4}";
    private static final String TYPE_PATTERN = "THEORY|PRACTICE";
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank
    @Pattern(regexp = TYPE_PATTERN)
    private String studyType;
    @NotNull
    @Positive
    private Long auditoriumId;
    @NotBlank
    @Pattern(regexp = CARD_PATTERN)
    private String professorCard;
}
