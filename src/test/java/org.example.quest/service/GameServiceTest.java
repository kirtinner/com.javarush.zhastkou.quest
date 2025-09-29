package org.example.quest.service;

import org.example.quest.model.GameState;
import org.example.quest.model.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private final GameService gameService = new GameService();

    @Test
    void testCreateNewGameFromString() {
        GameState gs = gameService.createNewGame(new Player("Tester"));
        assertNotNull(gs);
        assertEquals("Tester", gs.getPlayer().getName());
        assertEquals(1, gs.getCurrentQuestionId());
        assertFalse(gs.isGameOver());
    }

    @Test
    void testCreateNewGameFromPlayer() {
        Player p = new Player("Alice");
        GameState gs = gameService.createNewGame(p);
        assertNotNull(gs);
        assertSame(p, gs.getPlayer());
        assertEquals(1, gs.getCurrentQuestionId());
    }

    @Test
    void testProcessAnswer_WinningPath() {
        GameState gs = gameService.createNewGame(new Player("Player"));

        // 1 -> 2 -> 4 -> 8 -> 11 (win)
        gameService.processAnswer(gs, 1); // to 2
        assertEquals(2, gs.getCurrentQuestionId());
        assertFalse(gs.isGameOver());

        gameService.processAnswer(gs, 1); // to 4
        assertEquals(4, gs.getCurrentQuestionId());
        assertFalse(gs.isGameOver());

        gameService.processAnswer(gs, 1); // to 8
        assertEquals(8, gs.getCurrentQuestionId());
        assertFalse(gs.isGameOver());

        gameService.processAnswer(gs, 1); // to 11 (final win)
        assertEquals(11, gs.getCurrentQuestionId());
        assertTrue(gs.isGameOver());
        assertTrue(gs.isVictory());
    }

    @Test
    void testProcessAnswer_LosingPath() {
        GameState gs = gameService.createNewGame(new Player("Player"));

        // 1 -> 3 -> 7 (lose)
        gameService.processAnswer(gs, 2); // to 3
        assertEquals(3, gs.getCurrentQuestionId());
        assertFalse(gs.isGameOver());

        gameService.processAnswer(gs, 2); // to 7 (final lose)
        assertEquals(7, gs.getCurrentQuestionId());
        assertTrue(gs.isGameOver());
        assertFalse(gs.isVictory());
    }

    @Test
    void testProcessAnswerIgnoredAfterGameOver() {
        GameState gs = gameService.createNewGame(new Player("Player"));

        // bring to final (win)
        gameService.processAnswer(gs, 1); // 2
        gameService.processAnswer(gs, 1); // 4
        gameService.processAnswer(gs, 1); // 8
        gameService.processAnswer(gs, 1); // 11 (final)
        assertTrue(gs.isGameOver());

        int before = gs.getCurrentQuestionId();
        gameService.processAnswer(gs, 2); // should be ignored
        assertEquals(before, gs.getCurrentQuestionId());
        assertTrue(gs.isVictory());
    }
}
