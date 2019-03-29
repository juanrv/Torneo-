package com.torneo.domain;

import java.util.ArrayList;

public class Torneo {
	private String nombre;
	private ArrayList<Fecha> fechas;
	private ArrayList<Equipo> equipos;

	public Torneo(String nombre) {
		this.nombre = nombre;
	}

	public void comenzarTorneo() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				this.fechas.get(i).getPartidos().get(j).iniciarPartido();
			}
		}
	}

	public ArrayList<String> verResultado() {
		ArrayList<String> listaEquipos = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			listaEquipos.add(this.equipos.get(i).getNombre());
			listaEquipos.add(Byte.toString(this.equipos.get(i).getPuntosGanados()));
		}
		byte valorMaximo = 0;
		String equipoGanador = null;
		for (int i = 0; i < 4; i++) {

			if (this.equipos.get(i).getPuntosGanados() > valorMaximo) {
				valorMaximo = this.equipos.get(i).getPuntosGanados();
				equipoGanador = this.equipos.get(i).getNombre();
			}

		}
		listaEquipos.add(equipoGanador);
		return listaEquipos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Fecha> getFechas() {
		return fechas;
	}

	public void setFechas(ArrayList<Fecha> fechas) {
		this.fechas = fechas;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

}
