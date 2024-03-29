package com.example.universityapp.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class AuditoriumRequestDto {
    @NotBlank
    @Size(min = 3, max = 50)
    private String facultyName;
    @NotBlank
    @Size(min = 1, max = 5)
    private String index;
    @NotNull
    @Positive
    private Short capacity;
    @NotNull
    @Accessors(fluent = true)
    private boolean hasScreen;
}
