package com.torneo.aplication;

import java.util.ArrayList;
import java.util.Arrays;

import com.torneo.domain.*;

public class Aplicacion {

	public static void main(String[] args) {
		Torneo torneoPrueba = new Torneo("Torneo de Prueba");
		Fecha fechaNro1 = new Fecha();
		Fecha fechaNro2 = new Fecha();
		Fecha fechaNro3 = new Fecha();
		Jugador pedro = new Jugador("Pedro", "Delantero");
		Jugador pablo = new Jugador("Pablo", "Portero");
		Jugador jasinto = new Jugador("Jasinto", "Lateral");
		Jugador daniel = new Jugador("Daniel", "Lateral");
		Jugador jose = new Jugador("José", "Medio Campo");
		Jugador juan = new Jugador("Juan", "Defenza Central");
		Jugador david = new Jugador("David", "Medio Campo");

		ArrayList<Jugador> jugadores = new ArrayList<Jugador>(
				Arrays.asList(pedro, pablo, jasinto, daniel, jose, juan, david));

		/*
		 * Solo se crea una lista de jugadores para todos los equipos debido a lo
		 * tedioso que resulta de crear una lista completa de jugadores para cada 
		 * equipo
		 */

		Equipo leon = new Equipo("Leon", jugadores);
		Equipo aguila = new Equipo("Aguila", jugadores);
		Equipo hipopotamo = new Equipo("Hipopotamo", jugadores);
		Equipo pez = new Equipo("Pez", jugadores);
		ArrayList<Equipo> equipos = new ArrayList<Equipo>(Arrays.asList(leon, aguila, hipopotamo, pez));
		torneoPrueba.setEquipos(equipos);

		Partido partido1 = new Partido(leon, aguila);
		Partido partido2 = new Partido(hipopotamo, pez);
		Partido partido3 = new Partido(leon, hipopotamo);
		Partido partido4 = new Partido(aguila, pez);
		Partido partido5 = new Partido(leon, pez);
		Partido partido6 = new Partido(aguila, hipopotamo);

		ArrayList<Partido> partidosFecha1 = new ArrayList<Partido>(Arrays.asList(partido1, partido2));
		ArrayList<Partido> partidosFecha2 = new ArrayList<Partido>(Arrays.asList(partido3, partido4));
		ArrayList<Partido> partidosFecha3 = new ArrayList<Partido>(Arrays.asList(partido5, partido6));

		fechaNro1.setPartidos(partidosFecha1);
		fechaNro2.setPartidos(partidosFecha2);
		fechaNro3.setPartidos(partidosFecha3);

		ArrayList<Fecha> fechas = new ArrayList<Fecha>(Arrays.asList(fechaNro1, fechaNro2, fechaNro3));

		torneoPrueba.setFechas(fechas);

		torneoPrueba.comenzarTorneo();

		System.out.println("Equipos del torneo: ");
		for (int i = 0; i < 4; i++) {
			System.out.println(torneoPrueba.getEquipos().get(i).getNombre());
		}
		System.out.println("\nGanadores de cada fecha:");
		for (int i = 0; i < 3; i++) {
			System.out.println("Fecha #" + (i + 1));
			for (int j = 0; j < 2; j++) {
				if (torneoPrueba.getFechas().get(i).getPartidos().get(j).getGanador() == null) {
					System.out.println("Hubo un empate entre: "
							+ torneoPrueba.getFechas().get(i).getPartidos().get(j).getEquipoLocal().getNombre() + " y "
							+ torneoPrueba.getFechas().get(i).getPartidos().get(j).getEquipoVisitante().getNombre());
				} else {
					System.out.println(
							"Ganador: " + torneoPrueba.getFechas().get(i).getPartidos().get(j).getGanador().getNombre()
									+ " ,Perdedor: "
									+ torneoPrueba.getFechas().get(i).getPartidos().get(j).getPerdedor().getNombre());
				}

			}
			System.out.println("\n");
		}

		System.out.println("Jugadores en la posicion lateral: "
				+ torneoPrueba.getEquipos().get(1).verJugadoresPorPosicion("Lateral"));
		System.out.println("Jugadores en la posicion Medio Campo: "
				+ torneoPrueba.getEquipos().get(1).verJugadoresPorPosicion("Medio Campo"));

		System.out.println("\n");
		ArrayList<String> resultados = torneoPrueba.verResultado();
		for (int i = 0; i < 8; i++) {
			System.out.println("Equipo: " + resultados.get(i) + " ,Puntos: " + resultados.get(i + 1));
			i++;
		}
		System.out.println("Ganador: " + resultados.get(8) + "\n");
	}

}
