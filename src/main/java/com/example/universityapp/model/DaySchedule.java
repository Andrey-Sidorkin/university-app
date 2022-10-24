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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
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
}
