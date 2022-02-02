package com.example.universityapp.dto.request;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class GroupRequestDto {
    public static final String GROUP_PATTERN = "FIRST|SECOND|THIRD|FOURTH";
    @NotBlank
    @Size(min = 3, max = 50)
    private String departmentName;
    @NotNull
    @Positive
    private Long academicYearId;
    @NotBlank
    @Pattern(regexp = GROUP_PATTERN)
    private String groupNumber;
    private Set<String> studentCards;
    private Set<Long> dayScheduleIds;
}
