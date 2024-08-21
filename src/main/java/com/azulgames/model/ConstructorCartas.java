package com.azulgames.model;

// Clase que representa una Carta del juego
public class ConstructorCartas {
    private final String id;
    private final String nombre;
    private final String tipo;
    private int vida;
    private final String daño;
    private final String tipoAtaque;
    private final String defensa;
    private final boolean gastoTurno;
    private final String posición;
    private final int regeneración;

    //Constructor de las cartas con el bouilder
    private Carta(CartaBuilder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.tipo = builder.tipo;
        this.vida = builder.vida;
        this.daño = builder.daño;
        this.tipoAtaque = builder.tipoAtaque;
        this.defensa = builder.defensa;
        this.gastoTurno = builder.gastoTurno;
        this.posición = builder.posición;
        this.regeneración = builder.regeneración;
    }

    //Mètodos de las cartas

    public void defender(int dañoRecibido) {
        int defensaValor = Integer.parseInt(defensa);
        int dañoReducido = Math.max(dañoRecibido - defensaValor, 0);
        vida = Math.max(vida - dañoReducido, 0);
        System.out.println(nombre + " se defendió y su vida ahora es: " + vida);
    }

    public void atacar(Carta objetivo) {
        int dañoCausado = Integer.parseInt(daño);
        System.out.println(nombre + " ataca a " + objetivo.nombre + " causando " + dañoCausado + " puntos de daño.");
        objetivo.defender(dañoCausado);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Carta: " + nombre + "\n" +
                "Tipo: " + tipo + "\n" +
                "Vida: " + vida + "\n" +
                "Daño: " + daño + "\n" +
                "Tipo de Ataque: " + tipoAtaque + "\n" +
                "Defensa: " + defensa + "\n" +
                "Gasto de Turno: " + (gastoTurno ? "Sí" : "No") + "\n" +
                "Posición: " + posición + "\n" +
                "Regeneración: " + regeneración;
    }

    //Getters y Setters
    public String getID() {
        return this.id;
    }

    // Builder estático para las cartas
    public static class CartaBuilder {
        private final int id;
        private final String nombre;
        private String tipo;
        private int vida;
        private String daño;
        private String tipoAtaque;
        private String defensa;
        private boolean gastoTurno;
        private String posición;
        private int regeneración;

        public CartaBuilder(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public CartaBuilderTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public CartaBuildervida(int vida) {
            this.vida = vida;
            return this;
        }

        public CartaBuilder daño(String daño) {
            this.daño = daño;
            return this;
        }

        public CartaBuilder tipoAtaque(String tipoAtaque) {
            this.tipoAtaque = tipoAtaque;
            return this;
        }

        public CartaBuilder defensa(String defensa) {
            this.defensa = defensa;
            return this;
        }

        public CartaBuilder gastoTurno(boolean gastoTurno) {
            this.gastoTurno = gastoTurno;
            return this;
        }

        public CartaBuilder posición(String posición) {
            this.posición = posición;
            return this;
        }

        public CartaBuilder regeneración(int regeneración) {
            this.regeneración = regeneración;
            return this;
        }

        public Carta build() {
            return new Carta(this);
        }
    }
}

