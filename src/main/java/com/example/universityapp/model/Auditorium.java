package com.example.universityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "auditoriums",
        uniqueConstraints = @UniqueConstraint(columnNames = {"faculty_name", "index"}))
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Faculty faculty;
    private String index;
    private Short capacity;
    @Column(name = "has_screen")
    private boolean hasScreen;

    public Auditorium() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public boolean getHasScreen() {
        return hasScreen;
    }

    public void setHasScreen(boolean hasScreen) {
        this.hasScreen = hasScreen;
    }

    @Override
    public String toString() {
        return "Auditorium{"
                + "id=" + id
                + ", faculty=" + faculty
                + ", capacity=" + capacity
                + ", hasScreen=" + hasScreen
                + '}';
    }
}
