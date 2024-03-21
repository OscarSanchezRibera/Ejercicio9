package repaso;

import java.util.Random;
import java.util.Scanner;

public class Uno {

    public static void main(String[] args) {
    	//ESTE TAMPOCO FUNCIONA, VAS A SUSPENDER PEDAZO DE MIERDA
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Inicializar las cartas del mazo
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"};
        String[] valores = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] mazo = generarMazo(colores, valores);

        // Barajar el mazo
        for (int i = 0; i < mazo.length; i++) {
            int indiceAleatorio = random.nextInt(mazo.length);

            String temp = mazo[i];
            mazo[i] = mazo[indiceAleatorio];
            mazo[indiceAleatorio] = temp;
        }

        // Inicializar la mano del jugador
        String[] manoJugador = repartirCartas(mazo, 7);

        // Inicializar la carta en juego
        String cartaEnJuego = sacarCarta(mazo);

        // Juego
        boolean finJuego = false;
        boolean turnoJugador = true;

        while (!finJuego) {
            // Mostrar estado actual del juego
            System.out.println("Carta en juego: " + cartaEnJuego);
            System.out.print("Tus cartas: ");
            for (String carta : manoJugador) {
                System.out.print(carta + " ");
            }
            System.out.println();

            if (turnoJugador) {
                // Turno del jugador
                System.out.println("¿Qué carta quieres jugar? (Ingresa el índice): ");
                int indiceCarta = scanner.nextInt();

                String cartaJugador = manoJugador[indiceCarta];
                if (puedeJugar(cartaJugador, cartaEnJuego)) {
                    cartaEnJuego = cartaJugador;
                    turnoJugador = false;
                } else {
                    System.out.println("No puedes jugar esa carta. Elige otra.");
                }

                // Eliminar la carta jugada de la mano del jugador
                for (int i = indiceCarta; i < manoJugador.length - 1; i++) {
                    manoJugador[i] = manoJugador[i + 1];
                }
                manoJugador[manoJugador.length - 1] = null;

            } else {
                // Turno de la computadora (simulado)
                System.out.println("Turno de la Computadora...");
                boolean jugadaRealizada = false;

                for (int i = 0; i < manoJugador.length; i++) {
                    if (puedeJugar(manoJugador[i], cartaEnJuego)) {
                        cartaEnJuego = manoJugador[i];
                        jugadaRealizada = true;

                        // Eliminar la carta jugada de la mano de la computadora
                        for (int j = i; j < manoJugador.length - 1; j++) {
                            manoJugador[j] = manoJugador[j + 1];
                        }
                        manoJugador[manoJugador.length - 1] = null;

                        break;
                    }
                }

                if (!jugadaRealizada) {
                    // La computadora toma una carta del mazo
                    for (int i = 0; i < manoJugador.length; i++) {
                        if (manoJugador[i] == null) {
                            manoJugador[i] = sacarCarta(mazo);
                            break;
                        }
                    }
                    turnoJugador = true;
                }
            }

            // Verificar si el jugador o la computadora ganaron
            if (esGanador(manoJugador)) {
                System.out.println("¡Felicidades! Has ganado.");
                finJuego = true;
            } else if (mazo.length == 0) {
                System.out.println("¡La computadora ha ganado! Se acabaron las cartas del mazo.");
                finJuego = true;
            }
        }

        scanner.close();
    }

    private static String[] generarMazo(String[] colores, String[] valores) {
        String[] mazo = new String[colores.length * valores.length * 2];

        int index = 0;
        for (String color : colores) {
            for (String valor : valores) {
                mazo[index++] = color + " " + valor;
                mazo[index++] = color + " " + valor;
            }
        }

        return mazo;
    }

    private static String[] repartirCartas(String[] mazo, int cantidad) {
        String[] mano = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            mano[i] = sacarCarta(mazo);
        }
        return mano;
    }

    private static String sacarCarta(String[] mazo) {
        String carta = mazo[mazo.length - 1];
        mazo[mazo.length - 1] = null;
        return carta;
    }

    private static boolean puedeJugar(String cartaJugador, String cartaEnJuego) {
        String[] cartaJugadorSplit = cartaJugador.split(" ");
        String[] cartaEnJuegoSplit = cartaEnJuego.split(" ");

        return cartaJugadorSplit[0].equals(cartaEnJuegoSplit[0]) || cartaJugadorSplit[1].equals(cartaEnJuegoSplit[1]);
    }

    private static boolean esGanador(String[] manoJugador) {
        for (String carta : manoJugador) {
            if (carta != null) {
                return false;
            }
        }
        return true;
    }
}