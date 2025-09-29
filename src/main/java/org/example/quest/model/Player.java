package org.example.quest.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class Player implements Serializable {
    private String name;
    private int gamesPlayed;
    private int wins;

    public Player(String name) {
        this.name = name;
        this.gamesPlayed = 0;
        this.wins = 0;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

    public void incrementWins() {
        this.wins++;
    }
}
