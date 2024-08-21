package com.azulgames.model;

// Class representing the Game Field

public class Field {
    private final Card[][] fieldMatrix;

    public Field() {
        this.fieldMatrix = new Card[3][3]; // Creates a 3x3 matrix of cards
    }

    public boolean addCard(int row, int column, Card card) {
        if (row < 0 || row >= 3 || column < 0 || column >= 3) {
            System.out.println("Position out of range.");
            return false;
        }
        if (fieldMatrix[row][column] != null) {
            System.out.println("The position is already occupied.");
            return false;
        }
        fieldMatrix[row][column] = card;
        return true;
    }

    public void printField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fieldMatrix[i][j] != null) {
                    System.out.printf("[%s] ", fieldMatrix[i][j].getName());
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}
