package com.example.universityapp.dto.response;

import lombok.Data;

@Data
public class StudentResponseDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private String studentCard;
    private Long academicYearId;
    private String departmentName;
    private Long groupId;
}
