package com.example.universityapp.dto.response;

import java.util.Set;
import lombok.Data;

@Data
public class GroupResponseDto {
    private Long id;
    private String departmentName;
    private Long academicYearId;
    private String groupNumber;
    private Set<String> studentCards;
    private Set<Long> dayScheduleIds;
}
