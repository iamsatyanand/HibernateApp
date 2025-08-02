package com.satyanand.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AnswerTable {

    @Id
    private Integer id;

    private String answer;

    @ManyToOne()
    @JoinColumn(name = "question_id")
    private QuestionTable question;

    public AnswerTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionTable getQuestion() {
        return question;
    }

    public void setQuestion(QuestionTable question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "AnswerTable{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
//                ", question=" + question +
                '}';
    }
}
