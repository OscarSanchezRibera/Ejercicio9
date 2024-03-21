package repaso;

import java.util.Scanner;

public class Ahorcado {

	public static void main(String[] args) {
		// Ahorcado con Matrices:
		//Usa un array para almacenar la palabra a adivinar y otro para rastrear las letras adivinadas.
		Scanner scanner = new Scanner(System.in);

        char[] palabraAAdivinar = {'c', 'o', 'd', 'i', 'f', 'i', 'c', 'a', 'r'};
        boolean[] letrasAdivinadas = new boolean[palabraAAdivinar.length];

        int intentosRestantes = 6;

        System.out.println("¡Bienvenido al Juego del Ahorcado!");

        while (intentosRestantes > 0 && !juegoCompletado(letrasAdivinadas)) {
            // Mostrar estado actual de la palabra
            for (int i = 0; i < palabraAAdivinar.length; i++) {
                if (letrasAdivinadas[i]) {
                    System.out.print(palabraAAdivinar[i] + " ");
                } else {
                    System.out.print("_ ");
                }
            }

            // Solicitar una letra al usuario
            System.out.print("\nIngresa una letra: ");
            char letra = scanner.next().charAt(0);

            // Verificar si la letra está en la palabra
            boolean letraAdivinada = false;
            for (int i = 0; i < palabraAAdivinar.length; i++) {
                if (palabraAAdivinar[i] == letra) {
                    letrasAdivinadas[i] = true;
                    letraAdivinada = true;
                }
            }

            if (letraAdivinada) {
                System.out.println("¡Correcto!");
            } else {
                intentosRestantes--;
                System.out.println("Incorrecto. Te quedan " + intentosRestantes + " intentos.");
            }

            System.out.println();
        }

        // Mostrar resultado del juego
        if (juegoCompletado(letrasAdivinadas)) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + String.valueOf(palabraAAdivinar));
        } else {
            System.out.println("¡Oh no! Te has quedado sin intentos. La palabra era: " + String.valueOf(palabraAAdivinar));
        }

    }

    // Método para verificar si todas las letras han sido adivinadas
    private static boolean juegoCompletado(boolean[] letrasAdivinadas) {
        for (boolean letraAdivinada : letrasAdivinadas) {
            if (!letraAdivinada) {
                return false;
            }
        }
        return true;
    }
}
