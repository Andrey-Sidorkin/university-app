package com.example.universityapp.service.impl;

import com.example.universityapp.dao.GroupDao;
import com.example.universityapp.model.Group;
import com.example.universityapp.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao;

    @Override
    public Group findById(Long id) {
        return groupDao.findById(id).orElse(null);
    }

    @Override
    public Group findByStudentCard(String studentCard) {
        return groupDao.findByStudentCard(studentCard)
                .orElseThrow(() -> new RuntimeException(
                        "Can't find group by student card " + studentCard));
    }

    @Override
    public Group save(Group group) {
        return groupDao.save(group);
    }

    @Override
    public void deleteById(Long id) {
        groupDao.deleteById(id);
    }
}
