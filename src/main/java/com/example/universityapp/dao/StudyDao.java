package com.example.universityapp.dao;

import com.example.universityapp.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyDao extends JpaRepository<Study, Long> {
}
