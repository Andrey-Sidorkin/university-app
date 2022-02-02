package com.example.universityapp.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AcademicYearRequestDto {
    public static final String YEAR_PATTERN = "^FIRST|SECOND|THIRD|FOURTH|FIFTH|SIXTH$";
    public static final String CALENDAR_YEAR_PATTERN = "^(20\\d)\\d/\\1\\d$";
    @NotBlank
    @Pattern(regexp = CALENDAR_YEAR_PATTERN)
    private String calendarYear;
    @NotBlank
    @Pattern(regexp = YEAR_PATTERN)
    private String number;
}
