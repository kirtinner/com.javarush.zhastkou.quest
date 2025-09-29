package org.example.quest.model;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    @Test
    void testInitialization() {
        Player player = new Player("Test Player");
        GameState gameState = new GameState(player);

        assertNotNull(gameState);
        assertSame(player, gameState.getPlayer());
        assertEquals(1, gameState.getCurrentQuestionId());
        assertFalse(gameState.isGameOver());
        assertFalse(gameState.isVictory());
        assertNotNull(gameState.getCurrentQuestion());
        assertNotNull(gameState.getCurrentQuestion().getText());
    }

    @Test
    void testQuestionsInitialization() {
        GameState gameState = new GameState(new Player("P"));
        Map<Integer, Question> questions = gameState.getQuestions();

        assertNotNull(questions);
        assertEquals(12, questions.size());
        assertTrue(questions.containsKey(1));
        assertTrue(questions.containsKey(12));

        Question q1 = questions.get(1);
        assertNotNull(q1.getOption1());
        assertNotNull(q1.getOption2());
    }

    @Test
    void testFinalQuestions() {
        GameState gameState = new GameState(new Player("P"));

        Question q7 = gameState.getQuestions().get(7);
        assertTrue(q7.isFinal());
        assertFalse(q7.isWin());

        Question q10 = gameState.getQuestions().get(10);
        assertTrue(q10.isFinal());
        assertTrue(q10.isWin());
    }
}
