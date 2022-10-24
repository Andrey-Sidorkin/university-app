package com.example.universityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
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
    @Accessors(fluent = true)
    private boolean hasScreen;
}
