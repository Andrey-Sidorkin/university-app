package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.AcademicYearRequestDto;
import com.example.universityapp.dto.response.AcademicYearResponseDto;
import com.example.universityapp.model.AcademicYear;
import org.springframework.stereotype.Component;

@Component
public class AcademicYearMapper implements Mapper<AcademicYear,
        AcademicYearResponseDto, AcademicYearRequestDto> {
    @Override
    public AcademicYearResponseDto modelToDto(AcademicYear year) {
        AcademicYearResponseDto dto = new AcademicYearResponseDto();
        dto.setId(year.getId());
        dto.setCalendarYear(year.getCalendarYear());
        dto.setNumber(year.getNumber().name());
        return dto;
    }

    @Override
    public AcademicYear dtoToModel(AcademicYearRequestDto dto) {
        AcademicYear year = new AcademicYear();
        year.setCalendarYear(dto.getCalendarYear());
        year.setNumber(AcademicYear.YearNumber.valueOf(dto.getNumber()));
        return year;
    }
}
