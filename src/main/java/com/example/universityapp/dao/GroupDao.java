package com.example.universityapp.dao;

import com.example.universityapp.model.Group;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupDao extends JpaRepository<Group, Long> {
    @Query("SELECT g FROM Group g JOIN g.students s WHERE s.studentCard = :studentCard")
    Optional<Group> findByStudentCard(String studentCard);
}
