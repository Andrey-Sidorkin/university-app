package com.example.universityapp.service.impl;

import com.example.universityapp.dao.GroupDao;
import com.example.universityapp.model.Group;
import com.example.universityapp.model.Student;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GroupServiceImplTest {
    @InjectMocks
    private GroupServiceImpl groupService;
    @Mock
    private GroupDao groupDao;
    private Group group;

    @BeforeEach
    void setUp() {
        group = new Group();
        group.setId(1L);
        group.setGroupNumber(Group.GroupNumber.FIRST);
        Student student = new Student();
        student.setStudentCard("STDNT-345-365-1345");
        student.setGroup(group);
        group.setStudents(Set.of(student));
    }

    @Test
    void findById_ok() {
        Mockito.when(groupDao.findById(1L)).thenReturn(Optional.of(group));
        Assertions.assertEquals(groupService.findById(1L), group);
    }

    @Test
    void findByStudentCard_ok() {
        Mockito.when(groupDao.findByStudentCard("STDNT-345-365-1345")).thenReturn(Optional.of(group));
        Assertions.assertEquals(groupService.findByStudentCard("STDNT-345-365-1345"), group);
    }

    @Test
    void save_ok() {
        groupService.save(group);
        Mockito.verify(groupDao, Mockito.times(1)).save(group);
    }

    @Test
    void deleteById_ok() {
        groupService.deleteById(1L);
        Mockito.verify(groupDao, Mockito.times(1)).deleteById(1L);
    }
}
