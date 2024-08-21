package com.azulgames;

import java.util.ArrayList;
import java.util.List;

import com.azulgames.model.Player;

public class GameController {
    private final List<Player> players;
    private Player activePlayer;
    private String winner;
    private boolean gameFinished;

    private GameController(Builder builder) {
        this.players = builder.players;
        this.activePlayer = builder.activePlayer;
        this.winner = builder.winner;
        this.gameFinished = builder.gameFinished;
    }

    public static class Builder {
        private List<Player> players = new ArrayList<>();
        private Player activePlayer;
        private String winner;
        private boolean gameFinished = false;

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder setActivePlayer(Player activePlayer) {
            this.activePlayer = activePlayer;
            return this;
        }

        public Builder setWinner(String winner) {
            this.winner = winner;
            return this;
        }

        public Builder setGameFinished(boolean gameFinished) {
            this.gameFinished = gameFinished;
            return this;
        }

        public GameController build() {
            return new GameController(this);
        }
    }

    public void nextTurn() {
        if (gameFinished) {
            System.out.println("The game is over. The winner is " + winner);
            return;
        }

        if (!activePlayer.isActiveTurn()) {
            passTurnToNextPlayer();
        }
    }

    private void passTurnToNextPlayer() {
        int currentIndex = players.indexOf(activePlayer);
        do {
            currentIndex = (currentIndex + 1) % players.size();
            activePlayer = players.get(currentIndex);
        } while (!activePlayer.isActiveTurn());

        System.out.println("It's now " + activePlayer.getName() + "'s turn.");
    }

    public void checkWinner() {
        List<Player> activePlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.isActiveTurn()) {
                activePlayers.add(player);
            }
        }

        if (activePlayers.size() == 1) {
            winner = activePlayers.get(0).getName();
            gameFinished = true;
            System.out.println("The winner is " + winner + "!");
        }
    }

    public void removePlayer(Player player) {
        player.setActiveTurn(false);
    }
}
