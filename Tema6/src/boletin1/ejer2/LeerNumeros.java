package boletin1.ejer2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeerNumeros {

	public static void main(String[] args) {
		// variable que almacena el numero
		int num;
		// suma de los numeros
		int suma = 0;
		// media de los numeros
		double media = 0;
		// contador
		int cont = 0;

		try (Scanner leer = new Scanner(new FileReader("src\\boletin1\\ejer2\\Enteros"))) {

			while (leer.hasNextInt()) {
				num = leer.nextInt();
				suma += num;
				cont++;
			}

			media = suma / cont;
			System.out.println("Suma de los numeros: " + suma);
			System.out.println("Media de los numeros: " + media);

		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el archivo");
		}

	}

}
