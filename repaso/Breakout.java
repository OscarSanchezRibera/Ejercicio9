package repaso;

import java.util.Scanner;

public class Breakout {

	public static void main(String[] args) {
		// Snake con Matrices:
		//Utiliza una matriz para representar el tablero y las posiciones de la serpiente y la comida.
		
		Scanner scanner = new Scanner(System.in);

        int filas = 10;
        int columnas = 10;

        char[][] tablero = new char[filas][columnas];
        int pelotaFila = filas - 2;
        int pelotaColumna = columnas / 2;
        int paleta = columnas / 2 - 1;

        // Inicializar tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (i == pelotaFila && j == pelotaColumna) {
                    tablero[i][j] = 'O'; // Pelota
                } else if (i == tablero.length - 1 && j == paleta) {
                    tablero[i][j] = '='; // Paleta
                } else {
                    tablero[i][j] = ' '; // Espacio vacío
                }
            }
        }

        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            // Mostrar el estado actual del tablero
            System.out.println("Tablero:");
            for (char[] fila : tablero) {
                for (char celda : fila) {
                    System.out.print(celda + " ");
                }
                System.out.println();
            }
            System.out.println();

            // Solicitar dirección al jugador
            System.out.print("Ingresa la dirección (a: Izquierda, d: Derecha, q: Salir): ");
            char direccion = scanner.next().charAt(0);

            if (direccion == 'q') {
                System.out.println("¡Gracias por jugar! Hasta luego.");
                juegoEnCurso = false;
            } else {
                // Mover la paleta
                tablero[tablero.length - 1][paleta] = ' '; // Limpiar posición anterior de la paleta

                if (direccion == 'a' && paleta > 0) {
                    paleta--;
                } else if (direccion == 'd' && paleta < tablero[0].length - 1) {
                    paleta++;
                }

                tablero[tablero.length - 1][paleta] = '='; // Dibujar la paleta en la nueva posición

                // Mover la pelota
                tablero[pelotaFila][pelotaColumna] = ' '; // Limpiar posición anterior de la pelota

                // Mover la pelota hacia arriba y a la izquierda
                pelotaFila--;
                pelotaColumna--;

                // Dibujar la pelota en la nueva posición
                tablero[pelotaFila][pelotaColumna] = 'O';

                // Verificar colisión con la paleta
                if (pelotaFila == tablero.length - 1 && pelotaColumna >= paleta && pelotaColumna <= paleta + 1) {
                    System.out.println("¡Colisión con la paleta!");
                }

                // Verificar colisión con los bordes del tablero
                if (pelotaFila == 0 || pelotaColumna == 0 || pelotaColumna == tablero[0].length - 1) {
                    System.out.println("¡Colisión con los bordes! Fin del juego.");
                    juegoEnCurso = false;
                }
            }
        }



	}

}
