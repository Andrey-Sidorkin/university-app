package com.example.universityapp.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class AuditoriumResponseDto {
    private Long id;
    private String facultyName;
    private String index;
    private Short capacity;
    @Accessors(fluent = true)
    private boolean hasScreen;
}
