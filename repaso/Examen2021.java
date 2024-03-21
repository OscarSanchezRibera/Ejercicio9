package repaso;

import java.util.Scanner;

public class Examen2021 {

	public static void main(String[] args) {
		
		int x=0;
		int intentos=0;
		int y=0;
		int cont=1;
		int cont2=0;
		
		Scanner sn= new Scanner(System.in);
		
		do {
			
			System.out.println("Dame un numero");
			y=x;
			x=sn.nextInt();
			
			if(intentos>0) {
				if(x==y) {
					cont++;
				}else {
					if(cont>cont2) {
					cont2=cont;	
					}
					cont=0;
				}
			}
			intentos++;
		}while(x!=-1);
		
		System.out.println("La secuencia mayor de pares consecutivos es: "+cont2);
		
		sn.close();
	}
	
}
