package com.azulgames.mushroomtrouble;

import com.azulgames.model.*;

public class MushroomTrouble {
    public static void main(String[] args) {
        //Crea un mazo
        Deck deck = new Deck();

        //Crea un jugador y le agrega el mazo
        Player player = new Player.Builder()
                .setId(1)
                .setName("Player 1")
                .setDeck(deck)
                .setActiveTurn(true)
                .setTurnOrder(1)
                .build();

        //Crea una carta
        Card myGoomba = new Card.CardFactory().createGoomba();
        Card myBwomp = new Card.CardFactory().createBWomp();

        //Crea un campo de juego y agrega la carta
        Field myField = new Field();
        myField.addCard(0, 0, myGoomba);
        myField.addCard(2, 1, myBwomp);

        //Impresión de datos
        System.out.println("Goomba card:\n" + myGoomba.toString());
        System.out.println("Bwomp card:\n" + myBwomp.toString());
        System.out.println("Player data:\n");
        player.printPlayer();
        System.out.println("Deck data:\n" + deck.toString());
        System.out.println("Field data:\n");
        myField.printField();

    }
}
