package com.example.universityapp.dto.response;

import lombok.Data;

@Data
public class AuditoriumResponseDto {
    private Long id;
    private String facultyName;
    private String index;
    private Short capacity;
    private boolean hasScreen;
}
