package org.example.quest.model;

import lombok.Getter;
import lombok.Setter;
import org.example.quest.repository.QuestionsRepository;
import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class GameState implements Serializable {
    private Player player;
    private boolean statsApplied;
    private int currentQuestionId;
    private QuestionsRepository questionsRepository;
    private boolean gameOver;
    private boolean victory;

    public GameState(Player player) {
        this.player = player;
        this.currentQuestionId = 1;
        this.questionsRepository = new QuestionsRepository();
        this.gameOver = false;
        this.victory = false;
        this.statsApplied = false;
    }

    public Question getCurrentQuestion() {
        return questionsRepository.getQuestion(currentQuestionId);
    }

    public Map<Integer, Question> getQuestions() {
        return questionsRepository.getQuestions();
    }
}
