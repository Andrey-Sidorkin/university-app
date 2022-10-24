package com.example.universityapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "faculties")
public class Faculty {
    @Id
    private String name;
    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;
}
