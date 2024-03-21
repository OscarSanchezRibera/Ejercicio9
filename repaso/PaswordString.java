package repaso;

import java.util.Scanner;

public class PaswordString {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String letra =sc.next();
		
		String[] palabrasAleatorias = {"Murmullo","Deslumbrante","Enigma","Jubiloso","Frágil","Serenidad",
										"Estruendo","Intrincado","Deslizar","Resplandor","Melodía","Esbozo",
										"Desbordante","Voraz","Laberinto","Imperturbable","Vértigo","Nostalgia",
										"Fulgor","Intrépido"
		};
		
		//Palabras que empiezan por la letra introducida
		for (int i = 0; i < palabrasAleatorias.length; i++) {
			if(palabrasAleatorias[i].startsWith(letra)) {    //El empiece de la palabra
				System.out.println(palabrasAleatorias[i]);
			}
			
		}
		
		
		//Palabras de longitug mayor a 5
//		for (int i = 0; i < palabrasAleatorias.length; i++) {
//			if(palabrasAleatorias[i].length()<=5) {
//				System.out.println(palabrasAleatorias[i]);
//			}
//			
//		}
//		
		
		

	}

}
