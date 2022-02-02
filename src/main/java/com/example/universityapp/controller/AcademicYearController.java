package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.AcademicYearMapper;
import com.example.universityapp.dto.request.AcademicYearRequestDto;
import com.example.universityapp.dto.response.AcademicYearResponseDto;
import com.example.universityapp.model.AcademicYear;
import com.example.universityapp.service.AcademicYearService;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/academic-years")
public class AcademicYearController {
    private static final String CALENDAR_YEAR_PATTERN = "^(20\\d)\\d/\\1\\d$";
    private static final String YEAR_PATTERN = "^FIRST|SECOND|THIRD|FOURTH|FIFTH|SIXTH$";
    private final AcademicYearService yearService;
    private final AcademicYearMapper mapper;

    @GetMapping("/{id}")
    public AcademicYearResponseDto getById(@PathVariable @Positive Long id) {
        AcademicYear year = yearService.findById(id);
        return mapper.modelToDto(year);
    }

    @GetMapping
    public AcademicYearResponseDto getByYearAndNumber(
            @RequestParam(name = "year") @NotBlank @Pattern(
                    regexp = CALENDAR_YEAR_PATTERN) String calendarYear,
            @RequestParam(name = "number") @NotBlank @Pattern(
                    regexp = YEAR_PATTERN) String number) {
        AcademicYear.YearNumber yearNumber = AcademicYear.YearNumber.valueOf(number);
        AcademicYear year = yearService.findByYearAndNumber(calendarYear, yearNumber);
        return mapper.modelToDto(year);
    }

    @PostMapping
    public AcademicYearResponseDto save(@RequestBody @Valid AcademicYearRequestDto dto) {
        AcademicYear year = mapper.dtoToModel(dto);
        yearService.save(year);
        return mapper.modelToDto(year);
    }

    @PutMapping("/{id}")
    public AcademicYearResponseDto update(@PathVariable @Positive Long id,
                                          @RequestBody @Valid AcademicYearRequestDto dto) {
        AcademicYear year = mapper.dtoToModel(dto);
        year.setId(id);
        yearService.save(year);
        return mapper.modelToDto(year);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Positive Long id) {
        yearService.deleteById(id);
    }
}
