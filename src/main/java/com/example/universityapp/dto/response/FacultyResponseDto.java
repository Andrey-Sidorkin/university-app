package com.example.universityapp.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class FacultyResponseDto {
    private String name;
    private List<String> departmentNames;
}
