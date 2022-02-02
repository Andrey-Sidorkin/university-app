package com.example.universityapp.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class DepartmentResponseDto {
    private String name;
    private String facultyName;
    private List<String> professorsCards;
}
