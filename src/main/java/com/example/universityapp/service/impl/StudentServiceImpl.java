package com.example.universityapp.service.impl;

import com.example.universityapp.dao.StudentDao;
import com.example.universityapp.model.Student;
import com.example.universityapp.service.StudentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Override
    public Student findByStudentCard(String studentCard) {
        return studentDao.findById(studentCard).orElseThrow(
                () -> new RuntimeException("Can't find student by card " + studentCard));
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAllStudying();
    }

    @Override
    public void deleteByStudentCard(String studentCard) {
        studentDao.deleteById(studentCard);
    }

    @Override
    public void expelByStudentCard(String studentCard) {
        Student student = findByStudentCard(studentCard);
        student.setAcademicYear(null);
        save(student);
    }
}
