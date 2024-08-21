
package com.azulgames.model;

// Clase que representa el Campo de juego
public class ModeloCampo {
    private final Carta[][] matrizCampo;

    public ModeloCampo() {
        this.matrizCampo = new Carta[3][3]; // Crea una matriz 3x3 de cartas
    }

    public boolean agregarCarta(int fila, int columna, Carta carta) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            System.out.println("Posición fuera de rango.");
            return false;
        }
        if (matrizCampo[fila][columna] != null) {
            System.out.println("La posición ya está ocupada.");
            return false;
        }
        matrizCampo[fila][columna] = carta;
        return true;
    }

    public void imprimirCampo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCampo[i][j] != null) {
                    System.out.print("[" + matrizCampo[i][j].getID().charAt(0) + "] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}
