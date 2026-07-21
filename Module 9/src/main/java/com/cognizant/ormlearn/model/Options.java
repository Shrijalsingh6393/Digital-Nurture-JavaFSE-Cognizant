package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "op_qt_id", nullable = false)
    private Question question;

    @Column(name = "op_text", length = 100, nullable = false)
    private String text;

    @Column(name = "op_score", nullable = false)
    private double score;

    @Column(name = "op_is_correct", nullable = false)
    private boolean isCorrect;

    public Options() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
