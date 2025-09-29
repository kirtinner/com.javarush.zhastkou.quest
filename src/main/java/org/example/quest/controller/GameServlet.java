package org.example.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.quest.model.GameState;
import org.example.quest.model.Player;
import org.example.quest.service.GameService;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");

        if (gameState == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        // Passing everything to the JSP
        req.setAttribute("gameState", gameState);
        req.setAttribute("question", gameState.getCurrentQuestion());
        req.setAttribute("showOptions", !gameState.getCurrentQuestion().isFinal());

        if (gameState.isGameOver()) {
            if (!gameState.isStatsApplied()) {
                Player player = gameState.getPlayer();
                player.incrementGamesPlayed();
                if (gameState.isVictory()) player.incrementWins();
                gameState.setStatsApplied(true);
            }
            req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");
        if (gameState == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        int choice = Integer.parseInt(req.getParameter("choice"));
        gameService.processAnswer(gameState, choice);

        resp.sendRedirect(req.getContextPath() + "/game");
    }
}
