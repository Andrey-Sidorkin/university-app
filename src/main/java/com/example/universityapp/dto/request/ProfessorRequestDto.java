package com.example.universityapp.dto.request;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ProfessorRequestDto {
    private static final String CARD_PATTERN = "^PRFSR-\\d{3}-\\d{3}-\\d{4}$";
    private static final String RANK_PATTERN =
            "^INSTRUCTOR|ASSISTANT_PROFESSOR|ASSOCIATE_PROFESSOR|PROFESSOR$";
    private static final String NAME_PATTERN = "^[A-Z]{1}[a-z]+$";
    private static final String PHONE_PATTERN = "^\\(\\d{3}\\)\\s?\\d{3}-\\d{2}-\\d{2}$";
    @NotBlank
    @Pattern(regexp = NAME_PATTERN)
    private String name;
    @NotBlank
    @Pattern(regexp = NAME_PATTERN)
    private String surname;
    @NotBlank
    @Pattern(regexp = PHONE_PATTERN)
    private String phoneNumber;
    @NotBlank
    @Pattern(regexp = CARD_PATTERN)
    private String professorCard;
    @NotBlank
    @Pattern(regexp = RANK_PATTERN)
    private String rank;
    private Set<Long> studyIds;
    @NotNull
    private boolean isDismissed;
}
