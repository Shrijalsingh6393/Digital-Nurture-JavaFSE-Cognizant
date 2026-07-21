package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "aq_at_id", nullable = false)
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "aq_qt_id", nullable = false)
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion")
    private Set<AttemptOption> attemptOptions;

    public AttemptQuestion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public void setAttempt(Attempt attempt) {
        this.attempt = attempt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<AttemptOption> getAttemptOptions() {
        return attemptOptions;
    }

    public void setAttemptOptions(Set<AttemptOption> attemptOptions) {
        this.attemptOptions = attemptOptions;
    }
}
