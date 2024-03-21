package repaso;

import java.util.Scanner;

public class Escoba {

    public static void main(String[] args) {
    	//Juego de la escoba
    	
        Scanner scanner = new Scanner(System.in);

        // Inicializar el mazo
        int[][] mazo = new int[4][12];
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[i].length; j++) {
                mazo[i][j] = j + 1;
            }
        }

        // Barajar el mazo
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[i].length; j++) {
                int filaAleatoria = (int) (Math.random() * mazo.length);
                int colAleatoria = (int) (Math.random() * mazo[i].length);

                int temp = mazo[i][j];
                mazo[i][j] = mazo[filaAleatoria][colAleatoria];
                mazo[filaAleatoria][colAleatoria] = temp;
            }
        }

        // Repartir las cartas al jugador y colocar una en la mesa
        int[] manoJugador = new int[12];
        int[] mesa = new int[12];

        for (int i = 0; i < 3; i++) {
            manoJugador[i] = mazo[0][i];
            mesa[i] = mazo[0][i + 3];
        }

        // Juego
        boolean finJuego = false;

        while (!finJuego) {
            // Mostrar estado actual
            System.out.println("Mano del jugador: " + arrayToString(manoJugador));
            System.out.println("Mesa: " + arrayToString(mesa));

            // Turno del jugador
            System.out.println("Es tu turno. Elige una carta para colocar en la mesa (1-3): ");
            int cartaElegida = scanner.nextInt() - 1;

            if (cartaElegida >= 0 && cartaElegida < 3) {
                mesa[cartaElegida] = manoJugador[cartaElegida];
                manoJugador[cartaElegida] = mazo[0][3 + cartaElegida];

                // Verificar si hay una escoba
                if (manoJugador[cartaElegida] == mesa[2]) {
                    System.out.println("¡Escoba! Has limpiado la mesa.");
                    // Puntuar y reiniciar la mesa (implementar según las reglas)
                }

                // Verificar fin del juego
                finJuego = true;
                for (int carta : manoJugador) {
                    if (carta != 0) {
                        finJuego = false;
                        break;
                    }
                }

                for (int i = 0; i < mazo.length; i++) {
                    for (int j = 0; j < mazo[i].length; j++) {
                        if (mazo[i][j] != 0) {
                            finJuego = false;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Número de carta inválido. Intenta de nuevo.");
            }
        }

    }

    private static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value).append(" ");
        }
        return result.toString().trim();
    }
}
