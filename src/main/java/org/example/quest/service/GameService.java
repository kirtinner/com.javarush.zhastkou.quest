package org.example.quest.service;

import org.example.quest.model.GameState;
import org.example.quest.model.Player;
import org.example.quest.model.Question;

public class GameService {

    public GameState createNewGame(Player player) {
        return new GameState(player);
    }

    public void processAnswer(GameState gameState, int choice) {
        if (gameState.isGameOver()) return;

        Question current = gameState.getCurrentQuestion();
        if (current.isFinal()) {
            gameState.setGameOver(true);
            gameState.setVictory(current.isWin());
            return;
        }

        int nextId = (choice == 1) ? current.getNextQuestionId1() : current.getNextQuestionId2();
        gameState.setCurrentQuestionId(nextId);

        Question next = gameState.getQuestions().get(nextId);
        if (next.isFinal()) {
            gameState.setGameOver(true);
            gameState.setVictory(next.isWin());
        }
    }
}
