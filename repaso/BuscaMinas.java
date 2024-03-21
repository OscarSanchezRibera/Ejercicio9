package repaso;

import java.util.Random;
import java.util.Scanner;

public class BuscaMinas {

	public static void main(String[] args) {
		// Buscaminas
		
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int filas = 5;
        int columnas = 5;
        int minas = 5;

        char[][] tablero = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = '-';
            }
        }

        // Colocar minas
        for (int i = 0; i < minas; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(filas);
                columna = random.nextInt(columnas);
            } while (tablero[fila][columna] == '*');
            tablero[fila][columna] = '*';
        }

        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            // Mostrar el estado actual del tablero
            System.out.println("-------------");
            for (int i = 0; i < filas; i++) {
                System.out.print("| ");
                for (int j = 0; j < columnas; j++) {
                    System.out.print(tablero[i][j] + " | ");
                }
                System.out.println("\n-------------");
            }

            // Solicitar movimiento al jugador
            System.out.print("Ingresa la fila (1-" + filas + "): ");
            int fila = scanner.nextInt() - 1;
            System.out.print("Ingresa la columna (1-" + columnas + "): ");
            int columna = scanner.nextInt() - 1;

            if (tablero[fila][columna] == '*') {
                System.out.println("¡Boom! Has encontrado una mina. ¡Juego terminado!");
                juegoEnCurso = false;
            } else {
                int minasCercanas = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nuevaFila = fila + i;
                        int nuevaColumna = columna + j;
                        if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                            if (tablero[nuevaFila][nuevaColumna] == '*') {
                                minasCercanas++;
                            }
                        }
                    }
                }

                tablero[fila][columna] = (char) (minasCercanas + '0');

                if (minasCercanas == 0) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int nuevaFila = fila + i;
                            int nuevaColumna = columna + j;
                            if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                                if (tablero[nuevaFila][nuevaColumna] == '-') {
                                    int minasCercanasVecina = 0;
                                    for (int k = -1; k <= 1; k++) {
                                        for (int l = -1; l <= 1; l++) {
                                            int nuevaFilaVecina = nuevaFila + k;
                                            int nuevaColumnaVecina = nuevaColumna + l;
                                            if (nuevaFilaVecina >= 0 && nuevaFilaVecina < filas && nuevaColumnaVecina >= 0 && nuevaColumnaVecina < columnas) {
                                                if (tablero[nuevaFilaVecina][nuevaColumnaVecina] == '*') {
                                                    minasCercanasVecina++;
                                                }
                                            }
                                        }
                                    }
                                    tablero[nuevaFila][nuevaColumna] = (char) (minasCercanasVecina + '0');
                                }
                            }
                        }
                    }
                }

                // Verificar si el juego ha sido ganado
                int casillasLibres = filas * columnas - minas;
                int casillasDescubiertas = 0;
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (tablero[i][j] != '-' && tablero[i][j] != '*') {
                            casillasDescubiertas++;
                        }
                    }
                }
                if (casillasDescubiertas == casillasLibres) {
                    System.out.println("¡Felicidades! Has ganado el juego.");
                    juegoEnCurso = false;
                }
            }
        }
		
		
		
		
		

	}

}
