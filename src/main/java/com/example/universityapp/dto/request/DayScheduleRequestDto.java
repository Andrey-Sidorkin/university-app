package com.example.universityapp.dto.request;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DayScheduleRequestDto {
    public static final String DAY_PATTERN =
            "^MONDAY|TUESDAY|THURSDAY|WEDNESDAY|FRIDAY|SATURDAY$";
    public static final String SEMESTER_PATTERN = "^FIRST|SECOND$";
    @NotBlank
    @Pattern(regexp = DAY_PATTERN)
    private String studyDay;
    @NotBlank
    @Pattern(regexp = SEMESTER_PATTERN)
    private String semester;
    @NotNull
    private Long groupId;
    private List<Long> studyIds;
}
