package ru.bgpu.autumn.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vote_answers")
public class VoteAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_option_id")
    private AnswerOption answerOption;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public VoteAnswer() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
    public AnswerOption getAnswerOption() { return answerOption; }
    public void setAnswerOption(AnswerOption answerOption) { this.answerOption = answerOption; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}