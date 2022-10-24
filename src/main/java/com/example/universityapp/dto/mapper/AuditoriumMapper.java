package com.example.universityapp.dto.mapper;

import com.example.universityapp.dto.request.AuditoriumRequestDto;
import com.example.universityapp.dto.response.AuditoriumResponseDto;
import com.example.universityapp.model.Auditorium;
import com.example.universityapp.model.Faculty;
import com.example.universityapp.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuditoriumMapper implements Mapper<Auditorium,
        AuditoriumResponseDto, AuditoriumRequestDto> {
    private final FacultyService facultyService;

    @Override
    public AuditoriumResponseDto modelToDto(Auditorium auditorium) {
        AuditoriumResponseDto dto = new AuditoriumResponseDto();
        dto.setId(auditorium.getId());
        dto.setFacultyName(auditorium.getFaculty().getName());
        dto.setIndex(auditorium.getIndex());
        dto.setCapacity(auditorium.getCapacity());
        dto.hasScreen(auditorium.hasScreen());
        return dto;
    }

    @Override
    public Auditorium dtoToModel(AuditoriumRequestDto dto) {
        Auditorium auditorium = new Auditorium();
        Faculty faculty = facultyService.findByName(dto.getFacultyName());
        auditorium.setFaculty(faculty);
        auditorium.setIndex(dto.getIndex());
        auditorium.setCapacity(dto.getCapacity());
        auditorium.hasScreen(dto.hasScreen());
        return auditorium;
    }
}
