package main.java.com.matrodriguezpa.mushroomtrouble;

import Model.Player;
import Controller.GameController;
import Model.Card;
import java.util.List;

public class TestConsole {

    public static void main(String[] args) {
        Card king1 = Card.CardBuilder.createKingCard("King Arthur");
        Card king2 = Card.CardBuilder.createKingCard("King Charles");
        
        Player player1 = new Player("Player 1", king1);
        Player player2 = new Player("Player 2", king2);

        GameController game = new GameController(List.of(player1, player2));
        game.startGame();
    }
}
