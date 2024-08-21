package com.azulgames.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck;
    private int length;

    public Deck() {
        this.deck = new ArrayList<>();
        this.length = 5;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        System.out.println(deck.toString());
        return null;
    }
}
