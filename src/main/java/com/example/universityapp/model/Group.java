package com.example.universityapp.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "department_name")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYear academicYear;
    @Column(name = "group_number")
    @Enumerated(value = EnumType.STRING)
    private GroupNumber groupNumber;
    @OneToMany(mappedBy = "group")
    private Set<Student> students;
    @OneToMany(mappedBy = "group")
    private Set<DaySchedule> weekSchedule;

    public enum GroupNumber {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public GroupNumber getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(GroupNumber groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<DaySchedule> getWeekSchedule() {
        return weekSchedule;
    }

    public void setWeekSchedule(Set<DaySchedule> weekSchedule) {
        this.weekSchedule = weekSchedule;
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public String toString() {
        return "Group{"
                + "id=" + id
                + ", department=" + department
                + ", groupNumber=" + groupNumber
                + ", students=" + students
                + ", weekSchedule=" + weekSchedule
                + '}';
    }
}
