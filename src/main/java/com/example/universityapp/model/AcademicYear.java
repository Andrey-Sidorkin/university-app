package com.example.universityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
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

    public AcademicYear() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(String calendarYear) {
        this.calendarYear = calendarYear;
    }

    public YearNumber getNumber() {
        return number;
    }

    public void setNumber(YearNumber number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AcademicYear{"
                + "id=" + id
                + ", calendarYear=" + calendarYear
                + ", number=" + number
                + '}';
    }
}
