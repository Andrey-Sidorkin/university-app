package com.example.universityapp.controller;

import com.example.universityapp.dto.mapper.GroupMapper;
import com.example.universityapp.dto.request.GroupRequestDto;
import com.example.universityapp.dto.response.GroupResponseDto;
import com.example.universityapp.model.Group;
import com.example.universityapp.service.GroupService;
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
@RequestMapping("/groups")
public class GroupController {
    public static final String GROUP_PATTERN = "FIRST|SECOND|THIRD|FOURTH";
    private final GroupService groupService;
    private final GroupMapper mapper;

    @GetMapping("/{id}")
    public GroupResponseDto getById(@PathVariable @Positive Long id) {
        Group group = groupService.findById(id);
        return mapper.modelToDto(group);
    }

    @GetMapping("/by-card")
    public GroupResponseDto getByStudentCard(
            @RequestParam(name = "card") @NotBlank @Pattern(
                    regexp = GROUP_PATTERN) String studentCard) {
        Group group = groupService.findByStudentCard(studentCard);
        return mapper.modelToDto(group);
    }

    @PostMapping
    public GroupResponseDto save(@RequestBody @Valid GroupRequestDto dto) {
        Group group = mapper.dtoToModel(dto);
        groupService.save(group);
        return mapper.modelToDto(group);
    }

    @PutMapping("/{id}")
    public GroupResponseDto update(@PathVariable @Positive Long id,
                                        @RequestBody @Valid GroupRequestDto dto) {
        Group group = mapper.dtoToModel(dto);
        group.setId(id);
        groupService.save(group);
        return mapper.modelToDto(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Positive Long id) {
        groupService.deleteById(id);
    }
}
