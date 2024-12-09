package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final Card king; // The player's king card
    private final List<Card> deck; // Cards in the player's hand
    private final Card[][] territory; // 3x3 grid for placing cards
    private final int maxCardsInHand = 5;

    public Player(String name, Card king) {
        this.name = name;
        this.king = king;
        this.deck = new ArrayList<>();
        this.territory = new Card[3][3]; // 3x3 grid
    }

    public Player() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        return name;
    }

    public Card getKing() {
        return king;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public Card[][] getTerritory() {
        return territory;
    }

    public void addCardToDeck(Card card) {
        if (deck.size() < maxCardsInHand) {
            deck.add(card);
        } else {
            System.out.println(name + "'s hand is full! Bonus card sent to opponent.");
        }
    }

    public void placeCard(Card card, int row, int col) {
        if (territory[row][col] == null) {
            territory[row][col] = card;
            deck.remove(card);
        } else {
            System.out.println("Position already occupied!");
        }
    }

    public void printTerritory() {
        for (Card[] row : territory) {
            for (Card card : row) {
                System.out.print((card == null ? "[]" : "[" + card.getName() + "]") + " ");
            }
            System.out.println();
        }
    }

    public void fillDeck() {
        // Add Troop cards
        for (int i = 0; i < 3; i++) {
            deck.add(Card.CardBuilder.createTroopCard( 2, 1, 4, Card.Location.LAND));
        }

        // Add Support cards
        for (int i = 0; i < 2; i++) {
            deck.add(Card.CardBuilder.createSupportCard("Support " + (i + 1), 2));
        }

        // Add Bonus cards
        for (int i = 0; i < 2; i++) {
            deck.add(Card.CardBuilder.createBonusCard("Bonus " + (i + 1)));
        }

        System.out.println(name + "'s deck has been filled with cards.");
    }

    public void printDeck() {
        if (deck.isEmpty()) {
            System.out.println("The deck is empty.");
            return;
        }

        for (int i = 0; i < deck.size(); i++) {
            System.out.println((i + 1) + ". " + deck.get(i).getName() + " (" + deck.get(i).getClassification() + ")");
        }
    }
}
