package com.azulgames.model;

import java.util.Random;

// Generador de cartas
public class GeneradorCartas {
    private Carta carta;

    public static Carta generarCartaAleatoria() {
        String id = generarIdUnico();
        //Carta carta = new Carta.CartaBuilder(id, "Carta" + id);
        return carta;
    }

    public static Carta obtenerCartaPorId(String id) {
        return carta.get(id);
    }

    private static String generarIdUnico() {
        return "ID" + Random.nextInt(10000); // Genera un ID único simple
    }
}
