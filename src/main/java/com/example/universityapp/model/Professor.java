package com.example.universityapp.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "professors")
public class Professor {
    @Id
    @Column(name = "professor_card")
    private String professorCard;
    private String name;
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Rank rank;
    @OneToMany(mappedBy = "professor")
    private Set<Study> studies;
    @Column(name = "is_dismissed")
    private boolean isDismissed;

    public enum Rank {
        INSTRUCTOR,
        ASSISTANT_PROFESSOR,
        ASSOCIATE_PROFESSOR,
        PROFESSOR
    }
}
