package com.example.universityapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
}
