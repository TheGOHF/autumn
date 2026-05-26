package ru.bgpu.autumn.models;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Column(name = "allow_multiple")
    private Boolean allowMultiple;

    @ManyToOne
    @JoinColumn(name = "vote_id")
    private Vote vote;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AnswerOption> answerOptions = new HashSet<>();

    public Question() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public Boolean getAllowMultiple() { return allowMultiple; }
    public void setAllowMultiple(Boolean allowMultiple) { this.allowMultiple = allowMultiple; }
    public Vote getVote() { return vote; }
    public void setVote(Vote vote) { this.vote = vote; }
    public Set<AnswerOption> getAnswerOptions() { return answerOptions; }
    public void setAnswerOptions(Set<AnswerOption> answerOptions) { this.answerOptions = answerOptions; }
}