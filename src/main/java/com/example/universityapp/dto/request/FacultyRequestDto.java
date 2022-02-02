package com.example.universityapp.dto.request;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class FacultyRequestDto {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @NotEmpty
    private List<String> departmentNames;
}
