package com.azulgames.model;

public class Player {
    private final int id;
    private final String name;
    private final Deck deck;
    private final boolean activeTurn;
    private final int turnOrder;

    private Player(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.deck = builder.deck;
        this.activeTurn = builder.activeTurn;
        this.turnOrder = builder.turnOrder;
    }

    public void setActiveTurn(boolean active) {
    }

    public boolean isActiveTurn() {
        return activeTurn;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private int id;
        private String name;
        private Deck deck;
        private boolean activeTurn;
        private int turnOrder;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDeck(Deck deck) {
            if (deck.getLength() != 5) {
                throw new IllegalArgumentException("The deck must contain exactly 5 cards.");
            }
            this.deck = deck;
            return this;
        }

        public Builder setActiveTurn(boolean activeTurn) {
            this.activeTurn = activeTurn;
            return this;
        }

        public Builder setTurnOrder(int turnOrder) {
            this.turnOrder = turnOrder;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }

    public String printPlayer() {
        return "id: " + id +
                "\nname:" + name +
                "\nactiveTurn:" + activeTurn +
                "\nturnOrder:" + turnOrder;
    }
}
