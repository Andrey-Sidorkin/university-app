package com.example.universityapp.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class DayScheduleResponseDto {
    private Long id;
    private String studyDay;
    private String semester;
    private Long groupId;
    private List<Long> studyIds;
}
