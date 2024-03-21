package repaso;

import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijeraCG {

	public static void main(String[] args) {
		// Piedra papel o tijera contra la maquina
		
		 Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        String[] opciones = {"Piedra", "Papel", "Tijera"};

	        // Matriz de reglas del juego
	        // 0: Piedra, 1: Papel, 2: Tijera
	        // 0: Empate, 1: Gana jugador, -1: Gana computadora
	        int[][] reglas = {
	                {0, -1, 1}, // Piedra vs. Piedra, Papel, Tijera
	                {1, 0, -1}, // Papel vs. Piedra, Papel, Tijera
	                {-1, 1, 0}  // Tijera vs. Piedra, Papel, Tijera
	        };

	        int victoriasJugador = 0;
	        int victoriasComputadora = 0;

	        System.out.println("Bienvenido al juego Piedra, Papel o Tijera.");

	        while (true) {
	            System.out.println("Puntuación: Jugador " + victoriasJugador + " - Computadora " + victoriasComputadora);
	            System.out.print("Elige (0: Piedra, 1: Papel, 2: Tijera, 3: Salir): ");
	            int eleccionUsuario = scanner.nextInt();

	            if (eleccionUsuario < 0 || eleccionUsuario > 3) {
	                System.out.println("Opción inválida. Elige nuevamente.");
	                continue;
	            }

	            if (eleccionUsuario == 3) {
	                System.out.println("¡Gracias por jugar! Hasta luego.");
	                break;
	            }

	            int eleccionComputadora = random.nextInt(3);

	            System.out.println("Jugador: " + opciones[eleccionUsuario]);
	            System.out.println("Computadora: " + opciones[eleccionComputadora]);

	            int resultado = reglas[eleccionUsuario][eleccionComputadora];

	            if (resultado == 0) {
	                System.out.println("¡Empate!");
	            } else if (resultado == 1) {
	                System.out.println("¡Has ganado!");
	                victoriasJugador++;
	            } else {
	                System.out.println("¡La computadora ha ganado!");
	                victoriasComputadora++;
	            }

	            if (victoriasJugador == 3 || victoriasComputadora == 3) {
	                System.out.println("Partida terminada. Puntuación final: Jugador " + victoriasJugador + " - Computadora " + victoriasComputadora);
	                break;
	            }

	            System.out.println(); // Separador entre rondas
	        }
		
		
		
		
		
		
		
		
		

	}

}
