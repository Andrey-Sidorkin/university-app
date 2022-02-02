package com.example.universityapp.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
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

    public Professor() {
    }

    public String getProfessorCard() {
        return professorCard;
    }

    public void setProfessorCard(String professorCard) {
        this.professorCard = professorCard;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    public boolean isDismissed() {
        return isDismissed;
    }

    public void setDismissed(boolean dismissed) {
        isDismissed = dismissed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Professor{"
                + "professorCard='" + professorCard + '\''
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + ", rank=" + rank
                + ", studies=" + studies
                + ", isDismissed=" + isDismissed
                + '}';
    }
}
