
package com.azulgames.controller;

import java.util.ArrayList;
import java.util.List;

import com.azulgames.model.ConstructorJugador;

public class ControladorJuego {
    private final List<ConstructorJugador> jugadores;
    private ConstructorJugador jugadorActivo;
    private String ganador;
    private boolean juegoTerminado;

    private ControladorJuego(Builder builder) {
        this.jugadores = builder.jugadores;
        this.jugadorActivo = builder.jugadorActivo;
        this.ganador = builder.ganador;
        this.juegoTerminado = builder.juegoTerminado;
    }

    public static class Builder {
        private List<ConstructorJugador> jugadores = new ArrayList<>();
        private ConstructorJugador jugadorActivo;
        private String ganador;
        private boolean juegoTerminado = false;

        public Builder agregarJugador(ConstructorJugador jugador) {
            this.jugadores.add(jugador);
            return this;
        }

        public Builder setJugadorActivo(ConstructorJugador jugadorActivo) {
            this.jugadorActivo = jugadorActivo;
            return this;
        }

        public Builder setGanador(String ganador) {
            this.ganador = ganador;
            return this;
        }

        public Builder setJuegoTerminado(boolean juegoTerminado) {
            this.juegoTerminado = juegoTerminado;
            return this;
        }

        public ControladorJuego build() {
            return new ControladorJuego(this);
        }
    }

    public void siguienteTurno() {
        if (juegoTerminado) {
            System.out.println("El juego ha terminado. El ganador es " + ganador);
            return;
        }

        if (!jugadorActivo.isTurnoActivo()) {
            pasarTurnoAlSiguienteJugador();
        }
    }

    private void pasarTurnoAlSiguienteJugador() {
        int indiceActual = jugadores.indexOf(jugadorActivo);
        do {
            indiceActual = (indiceActual + 1) % jugadores.size();
            jugadorActivo = jugadores.get(indiceActual);
        } while (!jugadorActivo.isTurnoActivo());

        System.out.println("El turno ahora es de: " + jugadorActivo.getNombre());
    }

    public void verificarGanador() {
        List<ConstructorJugador> jugadoresActivos = new ArrayList<>();
        for (ConstructorJugador jugador : jugadores) {
            if (jugador.isTurnoActivo()) {
                jugadoresActivos.add(jugador);
            }
        }

        if (jugadoresActivos.size() == 1) {
            ganador = jugadoresActivos.get(0).getNombre();
            juegoTerminado = true;
            System.out.println("¡El ganador es " + ganador + "!");
        }
    }

    public void eliminarJugador(ConstructorJugador jugador) {
        jugador.setTurnoActivo(false);
    }