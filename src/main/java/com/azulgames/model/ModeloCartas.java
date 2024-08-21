package com.azulgames.model;

//Clase que contiene las cartas del juego
public class ModeloCartas {

    public static ConstructorJugador.Carta rey() {
        return new ConstructorCartas.CartaBuilder(1,"Champiñon Dorado")
                .tipo("Noble")
                .vida(2)
                .daño("1")
                .tipoAtaque("Doble")
                .posición("Terrestre")
                .defensa("1")
                .build();
    }

    public static Carta Goomba() {
        return new Carta.CartaBuilder(1,"Goomba")
                .tipo("Tropa")
                .vida(2)
                .daño("1")
                .tipoAtaque("Doble")
                .posición("Terrestre")
                .defensa("1")
                .build();
    }

    public static Carta BWomp(){
        return new Carta.CartaBuilder(1,"B-Womp")
                .tipo("Bloque")
                .vida(2)
                .daño("Mortal")
                .defensa("Mortal")
                .tipoAtaque("Defensivo")
                .gastoTurno(false)
                .posición("Volador")
                .regeneración(2)
                .build();
    }
}
