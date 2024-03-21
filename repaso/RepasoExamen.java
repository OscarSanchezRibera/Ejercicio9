package repaso;

import java.util.Arrays;
import java.util.Iterator;

public class RepasoExamen {

	public static void main(String[] args) {
		
		int notas[]=new int [20];
		
		for (int i = 0; i < notas.length; i++) {
			notas[i]=(int)(1+Math.random()*10);  //10 numeros random
		}
		
		//imprimir array
		System.out.println(Arrays.toString(notas));
		
		//cuantos suspensos hay
		int suspensos=0;
		for (int i = 0; i < notas.length; i++) {
			if(notas[i]<5)
				suspensos++;
		}		
		
		System.out.println("El numero de suspensos es: "+suspensos);
		
		//Nota media
		double suma=0;
		for (int i = 0;  i < notas.length; i++) {
			suma=suma+notas[i];
		}
		
		System.out.println("La media de notas es: "+(suma/notas.length));
		
		//Cuandos 9 o 10
		int sobre=0;
		for (int i = 0; i < notas.length; i++) {
			if(notas[i]>8) {
				sobre++;
			}
		}
		
		System.out.println("El numero de 9 o 10 es: "+sobre);
		
		
		
		
		
		
		
		
		

	}

}
