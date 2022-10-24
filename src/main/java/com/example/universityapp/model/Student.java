package com.example.universityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "student_card")
    private String studentCard;
    private String name;
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYear academicYear;
    @ManyToOne
    private Department department;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
