package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "at_us_id", nullable = false)
    private User user;

    @Column(name = "at_date", nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "attempt")
    private Set<AttemptQuestion> attemptQuestions;

    public Attempt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }
}
