package Controller;

import Model.Card;
import Model.Player;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private final List<Player> players;
    private int currentPlayerIndex;
    private final Scanner scanner = new Scanner(System.in);

    public GameController(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

public void startGame() {
    System.out.println("Filling players' decks...");

    for (Player player : players) {
        player.fillDeck();
        System.out.println(player.getName() + "'s Deck:");
        player.printDeck();
        System.out.println();

        // Place the king in the center of the player's territory
        player.placeCard(player.getKing(), 1, 1);
        System.out.println(player.getName() + "'s king has been placed at the center of their territory.");
        System.out.println();
    }

    System.out.println("Battle of Kingdoms begins!");
    while (!isGameOver()) {
        Player currentPlayer = players.get(currentPlayerIndex);
        takeTurn(currentPlayer);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
    announceWinner();
}



    private void takeTurn(Player player) {
        System.out.println(player.getName() + "'s turn!");
        player.printTerritory();

        // Collect a free card for the turn or 3 if the player has no cards.
        if (!player.getDeck().isEmpty()) {
            System.out.println("Collected free card (not implemented)");
        } else {
            System.out.println("Empty deck refilled3 card (not implemented)");
        }

        // Allow the player to take actions
        boolean turnEnded = false;
        while (!turnEnded) {
            System.out.println("Choose an action:");
            System.out.println("1. Use a placed card");
            System.out.println("2. Place a card from your deck");
            System.out.println("3. End turn");
            int action = getPlayerChoice();

            switch (action) {
                case 1: // Use a placed card
                    System.out.println("Select card position to use (row, col):");
                    int[] pos = getPlayerPosition();
                    Card selectedCard = player.getTerritory()[pos[0]][pos[1]];

                    if (selectedCard == null) {
                        System.out.println("No card at selected position.");
                        break;
                    }

                    System.out.println("Choose an action for " + selectedCard.getName() + ":");
                    System.out.println("1. Attack another card");
                    System.out.println("2. Switch positions with another card");
                    int subAction = getPlayerChoice();

                    if (subAction == 1) { // Attack
                        System.out.println("Select target position to attack (row, col):");
                        int[] targetPos = getPlayerPosition();
                        Card targetCard = getTargetCard(targetPos);
                        if (targetCard != null) {
                            targetCard.takeDamage(selectedCard.getAttackDamage());
                            System.out.println("Target card after attack: " + targetCard);
                        } else {
                            System.out.println("No target card at selected position.");
                        }
                    } else if (subAction == 2) { // Switch positions
                        System.out.println("Select position to switch with (row, col):");
                        int[] switchPos = getPlayerPosition();
                        switchCardPositions(player, pos, switchPos);
                    }
                    turnEnded = true;
                    break;

                case 2: // Place a card from deck
                    System.out.println("Select a card from your deck:");
                    showDeck(player.getDeck());
                    int cardIndex = getPlayerChoice() - 1;

                    if (cardIndex >= 0 && cardIndex < player.getDeck().size()) {
                        Card cardToPlace = player.getDeck().get(cardIndex);
                        System.out.println("Select position to place card (row, col):");
                        int[] placePos = getPlayerPosition();
                        player.placeCard(cardToPlace, placePos[0], placePos[1]);
                    } else {
                        System.out.println("Invalid card selection.");
                    }
                    turnEnded = true;
                    break;

                case 3: // End turn
                    turnEnded = true;
                    break;

                default:
                    System.out.println("Invalid action. Please choose again.");
                    break;
            }
        }
    }

    private int getPlayerChoice() {
        int choice = -1;
        while (choice < 1 || choice > 3) {
            System.out.print("Enter your choice (1-3): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }
        return choice;
    }

    private int[] getPlayerPosition() {
        int row = -1, col = -1;
        while (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.print("Enter position as row and column (0-2 for each, separated by space): ");
            try {
                String[] input = scanner.nextLine().trim().split("\\s+");
                if (input.length == 2) {
                    row = Integer.parseInt(input[0]);
                    col = Integer.parseInt(input[1]);
                } else {
                    System.out.println("Invalid input. Please enter two numbers separated by a space.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers between 0 and 2.");
            }
        }
        return new int[]{row, col};
    }

    private Card getTargetCard(int[] position) {
        int row = position[0];
        int col = position[1];
        for (Player opponent : players) {
            if (opponent != players.get(currentPlayerIndex)) { // Exclude the current player
                Card targetCard = opponent.getTerritory()[row][col];
                if (targetCard != null) {
                    return targetCard;
                }
            }
        }
        System.out.println("No target card found at the specified position.");
        return null;
    }

    private void showDeck(List<Card> deck) {
        if (deck.isEmpty()) {
            System.out.println("Your deck is empty.");
            return;
        }
        System.out.println("Your deck:");
        for (int i = 0; i < deck.size(); i++) {
            System.out.println((i + 1) + ". " + deck.get(i).getName());
        }
    }

    private void switchCardPositions(Player player, int[] pos1, int[] pos2) {
        Card temp = player.getTerritory()[pos1[0]][pos1[1]];
        player.getTerritory()[pos1[0]][pos1[1]] = player.getTerritory()[pos2[0]][pos2[1]];
        player.getTerritory()[pos2[0]][pos2[1]] = temp;
    }

    private boolean isGameOver() {
        return players.stream().anyMatch(p -> p.getKing().isDead());
    }

    private void announceWinner() {
        players.stream()
                .filter(p -> !p.getKing().isDead())
                .forEach(p -> System.out.println(p.getName() + " wins!"));
    }

}
