package repaso;

import java.util.Arrays;

public class RepasoMatrices {

	public static void main(String[] args) {

		
		//notas de fol de 5 alumnos
		
		String[]alumnos= {"Jaime","Marta","Lucia","Raul","Ana"};
		double []media=new double[5]; //guardar la media de los alumnos
		double []nDiez=new double[5];
		
		int[][]notas=new int[5][10]; //5filas y 10 columnas
		
		for (int i = 0; i < notas.length; i++) { //filas=5
			for(int j=0; j<notas[0].length;j++) { //columnas=10
				notas[i][j]=(int)(1+Math.random()*10);
			}
		}
		
		//Imprimir matriz
		for (int i = 0; i < notas.length; i++) { //filas=5
			System.out.println();
			System.out.println(alumnos[i]+": ");
			for(int j=0; j<notas[0].length;j++) { //columnas=10
				System.out.print(notas[i][j]+"\t");
			}
		}
		double suma=0;
		for (int i = 0; i < notas.length; i++) { //filas=5
			for(int j=0; j<notas[0].length;j++) {//columnas=10
				suma=suma+notas[i][j];
			}
			media[i]=(suma/10);
			suma=0; //resetear la suma para el siguiente alumno
		}
		
		System.out.println();
//		System.out.println(Arrays.toString(media));
		for (int i = 0; i < notas.length; i++) {
			System.out.println("El alumno"+alumnos[i]+" tiene la media: "+media[i]);
		}
		
		//Que alumno ha suspendido fol
		System.out.println("Alumnos suspensos");
		for (int i = 0; i < notas.length; i++) {
			if(media[i]<5)
				System.out.println(alumnos[i]);
		}
		
		//Quien ha sacado mas notas 10
		double cont10=0;
		for (int i = 0; i < notas.length; i++) { //filas=5
			for(int j=0; j<notas[0].length;j++) {//columnas=10
				if(notas[i][j]==10) {
					cont10++;
				}
			}
			nDiez[i]=cont10;
			cont10=0;
		}
		
		System.out.println(Arrays.toString(nDiez));
		
		//Alumno con mas 10 y en caso de empate el primero de todos
//		double mayor=0;
//		int posicion=0;
//		
//		for (int i = 0; i < notas.length; i++) {
//			if(nDiez[i]>mayor) {
//				mayor=nDiez[i];
//				posicion=i;
//			}
//		}
		
		
		
		//Alumno con mas 10 y con mas media
		double mayor=0;
		int posicion=0;
		double mayorMedia=0;
		
		for (int i = 0; i < nDiez.length; i++) {
			if(nDiez[i]>mayor && media[i]>mayorMedia) {
				mayor=nDiez[i];
				mayorMedia=media[i];
				posicion=i;
			}
		}
		
		System.out.println("Alumno premiado: "+alumnos[posicion]);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
