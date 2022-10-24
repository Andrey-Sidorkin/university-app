package com.example.universityapp.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "academic_years",
        uniqueConstraints = @UniqueConstraint(columnNames = {"calendar_year", "number"}))
public class AcademicYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "calendar_year")
    private String calendarYear;
    @Enumerated(value = EnumType.STRING)
    private YearNumber number;

    public enum YearNumber {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH,
        SIXTH
    }
}
