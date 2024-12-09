package Controller;

import Model.Player;
import View.Party;
import javax.swing.JPanel;

public class GameGenerator {

    Party party;
    short lives;
    short deck;
    short players;
    short gamemode;

    //Constructor de la partida
    public GameGenerator(short lives, short deck, short players, short gamemode) {
        lives = this.lives;
        deck = this.deck;
        players = this.players;
        gamemode = this.gamemode;

        party = new Party();
        party.setVisible(true);
    }

    //Generar el campo de juego
    public void GenerateField() {
    }

    //Segun el modo de juego modificar la malla
    //Segun los jugadores Agregar los campos de batalla
    //Segun las vidas agregar las cartas de reyez 
    //Segun las cartas Generar un mazo
    //Crear primer turno
}
