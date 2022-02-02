package com.example.universityapp.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentRequestDto {
    private static final String CARD_PATTERN = "^STDNT-\\d{3}-\\d{3}-\\d{4}$";
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
    private String studentCard;
    @NotNull
    @Positive
    private Long academicYearId;
    @NotBlank
    @Size(min = 3, max = 50)
    private String departmentName;
    @NotNull
    @Positive
    private Long groupId;
}
