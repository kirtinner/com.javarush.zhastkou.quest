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

@WebServlet("/start")
public class StartServlet extends HttpServlet {
    private final GameService gameService = new GameService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String playerName = req.getParameter("playerName");
        HttpSession session = req.getSession();

        // Save a player in a session so that the player's name and stats are saved between games within the same session
        Player player = (Player) session.getAttribute("player");
        if (player == null || !player.getName().equals(playerName)) {
            player = new Player(playerName);
            session.setAttribute("player", player);
        }

        GameState gameState = gameService.createNewGame(player);
        session.setAttribute("gameState", gameState);

        resp.sendRedirect(req.getContextPath() + "/game");
    }
}
