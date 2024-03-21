package repaso;

import java.util.Scanner;

public class Veintiuno {

    public static void main(String[] args) {
    	//NO FUNCIONA BIEN DEL TODO
        Scanner scanner = new Scanner(System.in);

        String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Inicializar el mazo
        String[][] mazo = new String[palos.length * valores.length][2];
        int indiceMazo = 0;

        for (String palo : palos) {
            for (String valor : valores) {
                mazo[indiceMazo][0] = valor;
                mazo[indiceMazo][1] = palo;
                indiceMazo++;
            }
        }

        // Barajar el mazo
        for (int i = 0; i < mazo.length; i++) {
            int indiceAleatorio = (int) (Math.random() * mazo.length);

            String[] temp = mazo[i];
            mazo[i] = mazo[indiceAleatorio];
            mazo[indiceAleatorio] = temp;
        }

        // Inicializar las manos de los jugadores
        String[][] manoJugador = new String[10][2];
        int totalJugador = 0;

        String[][] manoComputadora = new String[10][2];
        int totalComputadora = 0;

        // Repartir las primeras dos cartas a cada jugador
        manoJugador[0][0] = mazo[0][0];
        manoJugador[0][1] = mazo[0][1];
        totalJugador++;
        mazo = eliminarCarta(mazo);

        manoJugador[1][0] = mazo[0][0];
        manoJugador[1][1] = mazo[0][1];
        totalJugador++;
        mazo = eliminarCarta(mazo);

        manoComputadora[0][0] = mazo[0][0];
        manoComputadora[0][1] = mazo[0][1];
        totalComputadora++;
        mazo = eliminarCarta(mazo);

        manoComputadora[1][0] = mazo[0][0];
        manoComputadora[1][1] = mazo[0][1];
        totalComputadora++;
        mazo = eliminarCarta(mazo);

        // Juego
        boolean finJuego = false;

        while (!finJuego) {
            System.out.println("Tu mano: " + mostrarMano(manoJugador, totalJugador));
            System.out.println("Total: " + totalJugador);
            System.out.println("Computadora: " + mostrarMano(manoComputadora, totalComputadora));

            System.out.print("¿Quieres tomar otra carta? (s/n): ");
            char respuesta = scanner.next().charAt(0);

            if (respuesta == 's') {
                manoJugador[totalJugador][0] = mazo[0][0];
                manoJugador[totalJugador][1] = mazo[0][1];
                totalJugador++;
                mazo = eliminarCarta(mazo);

                if (totalJugador > 21) {
                    System.out.println("¡Te has pasado de 21! Has perdido.");
                    finJuego = true;
                }
            } else {
                // La computadora toma cartas hasta llegar a un total de al menos 17
                while (totalComputadora < 17) {
                    manoComputadora[totalComputadora][0] = mazo[0][0];
                    manoComputadora[totalComputadora][1] = mazo[0][1];
                    totalComputadora++;
                    mazo = eliminarCarta(mazo);
                }

                System.out.println("Tu mano final: " + mostrarMano(manoJugador, totalJugador));
                System.out.println("Total: " + totalJugador);
                System.out.println("Computadora final: " + mostrarMano(manoComputadora, totalComputadora));
                System.out.println("Total Computadora: " + totalComputadora);

                // Determinar el ganador
                if (totalJugador > 21) {
                    System.out.println("¡Te has pasado de 21! Has perdido.");
                } else if (totalComputadora > 21 || totalJugador > totalComputadora) {
                    System.out.println("¡Felicidades! Has ganado.");
                } else if (totalJugador == totalComputadora) {
                    System.out.println("Es un empate.");
                } else {
                    System.out.println("La computadora gana. Mejor suerte la próxima vez.");
                }

                finJuego = true;
            }
        }

        scanner.close();
    }

    private static String[][] eliminarCarta(String[][] mazo) {
        String[][] nuevoMazo = new String[mazo.length - 1][2];
        for (int i = 0; i < mazo.length - 1; i++) {
            nuevoMazo[i] = mazo[i + 1];
        }
        return nuevoMazo;
    }

    private static String mostrarMano(String[][] mano, int total) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < total; i++) {
            resultado.append(mano[i][0]).append(" de ").append(mano[i][1]).append(", ");
        }
        return resultado.toString();
    }
}