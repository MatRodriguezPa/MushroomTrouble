package com.azulgames.model;

// Class representing the game cards
public class Card {
    private final int id;
    private final String name;
    private final String type;
    private int health;
    private final String damage;
    private final String attackType;
    private final String defense;
    private final boolean turnCost;
    private final String position;
    private final int regeneration;

    // Card constructor
    private Card(CardBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.health = builder.health;
        this.damage = builder.damage;
        this.attackType = builder.attackType;
        this.defense = builder.defense;
        this.turnCost = builder.turnCost;
        this.position = builder.position;
        this.regeneration = builder.regeneration;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Card Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Health: " + health + "\n" +
                "Damage: " + damage + "\n" +
                "Attack Type: " + attackType + "\n" +
                "Defense: " + defense + "\n" +
                "Turn Cost: " + (turnCost ? "Yes" : "No") + "\n" +
                "Position: " + position + "\n" +
                "Regeneration: " + regeneration;
    }

    // Card methods
    public void defend(int receivedDamage) {
        int defenseValue = Integer.parseInt(defense);
        int reducedDamage = Math.max(receivedDamage - defenseValue, 0);
        health = Math.max(health - reducedDamage, 0);
        System.out.println(name + " defended and now has health: " + health);
    }

    // Card methods
    public void attack(Card target) {
        int inflictedDamage = Integer.parseInt(damage);
        System.out.println(name + " attacks " + target.name + " dealing " + inflictedDamage + " damage points.");
        target.defend(inflictedDamage);
    }

    // Getters and Setters
    public int getID() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    // Static Builder for the cards
    public static class CardBuilder {
        private final int id;
        private final String name;
        private String type;
        private int health;
        private String damage;
        private String attackType;
        private String defense;
        private boolean turnCost;
        private String position;
        private int regeneration;

        public CardBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public CardBuilder type(String type) {
            this.type = type;
            return this;
        }

        public CardBuilder health(int health) {
            this.health = health;
            return this;
        }

        public CardBuilder damage(String damage) {
            this.damage = damage;
            return this;
        }

        public CardBuilder attackType(String attackType) {
            this.attackType = attackType;
            return this;
        }

        public CardBuilder defense(String defense) {
            this.defense = defense;
            return this;
        }

        public CardBuilder turnCost(boolean turnCost) {
            this.turnCost = turnCost;
            return this;
        }

        public CardBuilder position(String position) {
            this.position = position;
            return this;
        }

        public CardBuilder regeneration(int regeneration) {
            this.regeneration = regeneration;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }

    // Card Generator
    public class CardGenerator {

        public static Card generateRandomCard() {
            //Generate the Id
            //Get from card models
            return null;
        }

        private static String generateUniqueId() {
            // Generates a simple unique ID
            return null;
        }
    }

    public static class CardFactory {

        public Card createGoomba() {
            return new CardBuilder(1, "Goomba")
                    .type("Troop")
                    .health(2)
                    .damage("1")
                    .attackType("Double")
                    .position("Ground")
                    .defense("1")
                    .build();
        }

        public Card createBWomp() {
            return new CardBuilder(1, "B-Womp")
                    .type("Block")
                    .health(2)
                    .damage("Fatal")
                    .defense("Fatal")
                    .attackType("Defensive")
                    .turnCost(false)
                    .position("Flying")
                    .regeneration(2)
                    .build();
        }

    }
}
