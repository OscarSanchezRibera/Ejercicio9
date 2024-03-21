package repaso;

import java.util.Scanner;

public class TresRaya {

	public static void main(String[] args) {
		//Ta-Te-Ti (Tic-Tac-Toe) con Matrices:
		//Implementa el tablero de juego con una matriz.

		
		Scanner scanner = new Scanner(System.in);

        char[][] tablero = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char jugadorActual = 'X';
        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            // Mostrar el estado actual del tablero
            System.out.println("-------------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(tablero[i][j] + " | ");
                }
                System.out.println("\n-------------");
            }

            // Solicitar movimiento al jugador
            System.out.println("Turno del Jugador " + jugadorActual);
            System.out.print("Ingresa la fila (1-3): ");
            int fila = scanner.nextInt() - 1;
            System.out.print("Ingresa la columna (1-3): ");
            int columna = scanner.nextInt() - 1;

            // Verificar si la posición está ocupada
            if (tablero[fila][columna] == ' ') {
                tablero[fila][columna] = jugadorActual;
            } else {
                System.out.println("¡Posición ocupada! Intenta de nuevo.");
                continue;
            }

            // Verificar si hay un ganador o empate
            // Verificar filas y columnas
            for (int i = 0; i < 3; i++) {
                if ((tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) ||
                        (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)) {
                    juegoEnCurso = false;
                    break;
                }
            }

            // Verificar diagonales
            if ((tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
                    (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)) {
                juegoEnCurso = false;
            }

            // Cambiar al siguiente jugador
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';

            // Verificar empate
            boolean empate = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == ' ') {
                        empate = false;
                        break;
                    }
                }
                if (!empate) {
                    break;
                }
            }
            if (empate) {
                juegoEnCurso = false;
                System.out.println("¡Empate! El juego ha terminado sin ganador.");
            }
        }

        // Mostrar resultado del juego
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }

        System.out.println("¡Juego terminado!");

	}

}
