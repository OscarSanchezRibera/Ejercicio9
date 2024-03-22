package repaso;

import java.util.Scanner;

public class Laberinto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] laberinto = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        int filaActual = 1;
        int columnaActual = 1;
        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            // Mostrar el laberinto
            System.out.println("Laberinto:");
            for (int i = 0; i < laberinto.length; i++) {
                for (int j = 0; j < laberinto[i].length; j++) {
                    if (i == filaActual && j == columnaActual) {
                        System.out.print('x'); // Posición del jugador
                    } else {
                        System.out.print(laberinto[i][j] + " ");
                    }
                }
                System.out.println();
            }
            System.out.println();

            // Solicitar la dirección al jugador
            System.out.print("Ingresa la dirección (w: Arriba, s: Abajo, a: Izquierda, d: Derecha, q: Salir): ");
            char direccion = scanner.next().charAt(0);

            // Actualizar la posición del jugador según la dirección
            switch (direccion) {
                case 'w':
                    if (laberinto[filaActual - 1][columnaActual] != '#') {
                        filaActual--;
                    }
                    break;
                case 's':
                    if (laberinto[filaActual + 1][columnaActual] != '#') {
                        filaActual++;
                    }
                    break;
                case 'a':
                    if (laberinto[filaActual][columnaActual - 1] != '#') {
                        columnaActual--;
                    }
                    break;
                case 'd':
                    if (laberinto[filaActual][columnaActual + 1] != '#') {
                        columnaActual++;
                    }
                    break;
                case 'q':
                    System.out.println("¡Gracias por jugar! Hasta luego.");
                    juegoEnCurso = false;
                    break;
                default:
                    System.out.println("Dirección no válida. Inténtalo de nuevo.");
                    break;
            }

            // Verificar si el jugador ha llegado a la salida
            if (filaActual == 5 && columnaActual == 8) {
                System.out.println("¡Felicidades! Has llegado a la salida. Fin del juego.");
                juegoEnCurso = false;
            }
        }
        System.out.println("ESTA ES UNA MODIFICACIÓN DEL EJERCICIO 11");
    }
}