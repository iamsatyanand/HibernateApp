package com.satyanand.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer {

    @Id
    private Integer id;

    private String answer;

    public Answer() {
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

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                '}';
    }
}
