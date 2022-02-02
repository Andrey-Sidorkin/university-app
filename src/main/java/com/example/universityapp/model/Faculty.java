package com.example.universityapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    private String name;
    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;

    public Faculty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Faculty{"
                + "name='" + name + '\''
                + ", departments=" + departments
                + '}';
    }
}
