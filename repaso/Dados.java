package repaso;

import java.util.Random;
import java.util.Scanner;

public class Dados {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Este es el ejercicio 12 de ENDES OSCAR SANCHEZ");
        String j1, j2;

        // Validar el nick del jugador 1
        do {
            System.out.print("Ingrese el nick del jugador 1 (JXXX0): ");
            j1 = scanner.next();
        } while (!validarNick(j1));

        // Validar el nick del jugador 2
        do {
            System.out.print("Ingrese el nick del jugador 2 (JXXX0): ");
            j2 = scanner.next();
        } while (!validarNick(j2));

        // Lanzar dados y determinar ganador
        int[] resultado1 = lanzarDados();
        int[] resultado2 = lanzarDados();
        int conta1=0,conta2=0;

        // Mostrar resultados
        System.out.println("\nResultados del dado:");
        System.out.println(j1 + ": " + imprimirArray(resultado1));
        System.out.println(j2 + ": " + imprimirArray(resultado2));
       
        System.out.println();
        System.out.println("--COMIENZA EL JUEGO--");
        System.out.println();
       
        Random random = new Random();
       
        for (int i = 0; i < 5; i++) {
            int numeroAleatorio = random.nextInt(6) + 1; // El rango es [1, 6]
            System.out.println("--RONDA "+(i)+"-- Número: " + numeroAleatorio);
           
            if(numeroAleatorio==resultado1[i]) {
            conta1++;
            System.out.println("Encontrado "+numeroAleatorio+" en la tirada "+i+" de "+j1);
            }
           
            if(numeroAleatorio==resultado2[i]) {
            conta2++;
            System.out.println("Encontrado "+numeroAleatorio+" en la tirada "+i+" de "+j2);
            }
           
        }
       
       
       
        if(conta1==conta2) {
        System.out.println("empate");
        }else if(conta1>conta2) {
        System.out.println("GANA "+j1);
        }else {
        System.out.println("GANA "+j2);
        }
       
       
}

    // Función para validar el formato del nick
    private static boolean validarNick(String nick) {
        return nick.matches("^J[A-Z]{3}\\d$");
    }

    // Función para lanzar los dados
    private static int[] lanzarDados() {
        Random random = new Random();
        int[] resultado = new int[5];

        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = random.nextInt(6) + 1;
        }

        return resultado;
    }


    // Función para imprimir un array
    private static String imprimirArray(int[] array) {
        StringBuilder resultado = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            resultado.append(array[i]);
           
            if (i < array.length - 1) {
                resultado.append(", ");
            }
        }
        resultado.append("]");
        return resultado.toString();
           
    }
    
}
