package com.example.universityapp.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "day_schedules")
public class DaySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "study_day")
    @Enumerated(value = EnumType.STRING)
    private StudyDay studyDay;
    @Enumerated(value = EnumType.STRING)
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToMany
    @JoinTable(name = "day_schedules_studies",
            joinColumns = @JoinColumn(name = "day_schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "study_id"))
    private List<Study> studies;

    public enum StudyDay {
        MONDAY,
        TUESDAY,
        THURSDAY,
        WEDNESDAY,
        FRIDAY,
        SATURDAY
    }

    public enum Semester {
        FIRST,
        SECOND
    }

    public DaySchedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudyDay getStudyDay() {
        return studyDay;
    }

    public void setStudyDay(StudyDay studyDay) {
        this.studyDay = studyDay;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Study> getStudies() {
        return studies;
    }

    public void setStudies(List<Study> studies) {
        this.studies = studies;
    }

    @Override
    public String toString() {
        return "DaySchedule{"
                + "id=" + id
                + ", studyDay=" + studyDay
                + ", semester=" + semester
                + ", group=" + group
                + ", studies=" + studies
                + '}';
    }
}
