package com.azulgames.model;

public class ConstructorJugador {
    private final int id;
    private final String nombre;
    private final Carta[] mazo;
    private final boolean turnoActivo;
    private final int ordenDeTurno;

    private ConstructorJugador(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.mazo = builder.mazo;
        this.turnoActivo = builder.turnoActivo;
        this.ordenDeTurno = builder.ordenDeTurno;
    }

    public static class Builder {
        private int id;
        private String nombre;
        private Carta[] mazo;
        private boolean turnoActivo;
        private int ordenDeTurno;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setMazo(Carta[] mazo) {
            if (mazo.length != 5) {
                throw new IllegalArgumentException("El mazo debe contener exactamente 5 cartas.");
            }
            this.mazo = mazo;
            return this;
        }

        public Builder setTurnoActivo(boolean turnoActivo) {
            this.turnoActivo = turnoActivo;
            return this;
        }

        public Builder setOrdenDeTurno(int ordenDeTurno) {
            this.ordenDeTurno = ordenDeTurno;
            return this;
        }

        public ConstructorJugador build() {
            return new ConstructorJugador(this);
        }
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", turnoActivo=" + turnoActivo +
                ", ordenDeTurno=" + ordenDeTurno +
                '}';
    }

    // Clase Carta como ejemplo
    public static class Carta {
        private String nombre;

        public Carta(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Carta[] mazo = {new Carta("Carta 1"), new Carta("Carta 2"), new Carta("Carta 3"), new Carta("Carta 4"), new Carta("Carta 5")};

        ConstructorJugador jugador = new ConstructorJugador.Builder()
                .setId(1)
                .setNombre("Jugador 1")
                .setMazo(mazo)
                .setTurnoActivo(true)
                .setOrdenDeTurno(1)
                .build();

        System.out.println(jugador);
    }
}
