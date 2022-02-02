package com.example.universityapp.dto.response;

import java.util.Map;
import lombok.Data;

@Data
public class TimeTableResponseDto {
    private String studentName;
    private String studyDay;
    private Map<String, String> timeTable;
}
