package com.satyanand.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuestionTable {

    @Id
    private Integer id;

    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AnswerTable> answerList;

    public QuestionTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerTable> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AnswerTable> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "QuestionTable{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
