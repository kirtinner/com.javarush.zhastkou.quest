package org.example.quest.model;

import lombok.Getter;

@Getter
public class Question {
    private String text;
    private String option1;
    private String option2;
    private int nextQuestionId1;
    private int nextQuestionId2;
    private boolean isFinal;
    private boolean isWin;

    // Constructor for follow-up questions
    public Question(String text, String option1, int nextQuestionId1,
                    String option2, int nextQuestionId2) {
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
        this.nextQuestionId1 = nextQuestionId1;
        this.nextQuestionId2 = nextQuestionId2;
        this.isFinal = false;
        this.isWin = false;
    }

    // Constructor for final statements
    public Question(String text, boolean isWin) {
        this.text = text;
        this.isFinal = true;
        this.isWin = isWin;
    }
}
