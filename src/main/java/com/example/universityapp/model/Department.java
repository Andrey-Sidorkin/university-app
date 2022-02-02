package com.example.universityapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    private String name;
    @ManyToOne
    @JoinColumn(name = "faculty_name")
    private Faculty faculty;
    @OneToMany
    @JoinTable(name = "departments_professors",
            joinColumns = @JoinColumn(name = "department_name"),
            inverseJoinColumns = @JoinColumn(name = "professor_card"))
    private List<Professor> professors;

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "Department{"
                + "name='" + name + '\''
                + ", faculty=" + faculty
                + ", professors=" + professors
                + '}';
    }
}
