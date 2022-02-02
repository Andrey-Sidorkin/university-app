package com.example.universityapp.service;

import com.example.universityapp.model.Group;

public interface GroupService {
    Group findById(Long id);

    Group findByStudentCard(String studentCard);

    Group save(Group group);

    void deleteById(Long id);
}
