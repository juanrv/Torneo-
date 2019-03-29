package com.torneo.domain;

import java.util.ArrayList;

public class Equipo {
	private String nombre;
	private byte puntosGanados = 0;
	private ArrayList<Jugador> jugadores;

	public Equipo(String nombre, ArrayList<Jugador> jugadores) {
		this.nombre = nombre;
		if (jugadores.size() > 16) {

		}
		if (jugadores.size() < 7) {
			System.out.println("Se necesitan minimo 7 jugadores ");
		} else {
			this.jugadores = jugadores;
		}
	}

	public ArrayList<String> verJugadores() {
		ArrayList<String> listaJugadores = new ArrayList<String>();
		for (int i = 0; i < this.jugadores.size(); i++) {
			listaJugadores.add(this.jugadores.get(i).getNombre());
			listaJugadores.add(this.jugadores.get(i).getPosicion());
		}
		return listaJugadores;

	}

	public ArrayList<String> verJugadoresPorPosicion(String posicion) {
		ArrayList<String> listaJugadores = new ArrayList<String>();
		for (int i = 0; i < this.jugadores.size(); i++) {
			if (this.jugadores.get(i).getPosicion().contentEquals(posicion)) {
				listaJugadores.add(this.jugadores.get(i).getNombre());
			}
		}
		return listaJugadores;
	}

	public boolean agregarJugador(String nombre, String posicion) {
		boolean seAregoJugador = true;
		if (this.jugadores.size() <= 16) {
			this.jugadores.get(this.jugadores.size()).setNombre(nombre);
			this.jugadores.get(this.jugadores.size()).setPosicion(posicion);
		} else {
			seAregoJugador = false;
		}
		return seAregoJugador;
	}

	public boolean retirarJugador(String nombre, String posicion) {
		boolean seRetiroJugador = false;
		for (int i = 0; i < this.jugadores.size(); i++) {
			if ((this.jugadores.get(i).getNombre().contentEquals(nombre))
					&& (this.jugadores.get(i).getPosicion().contentEquals(posicion))) {
				this.jugadores.remove(i);
				seRetiroJugador = true;
			}
		}
		return seRetiroJugador;

	}

	public void agregarPuntos(byte puntos) {
		this.puntosGanados += puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getPuntosGanados() {
		return puntosGanados;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
}
