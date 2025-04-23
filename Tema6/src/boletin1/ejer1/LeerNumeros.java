package boletin1.ejer1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeerNumeros {

	public static void main(String[] args) {

		double media;
		int cont = 0;
		int num;
		int suma = 0;

		try (Scanner leer = new Scanner(new FileReader("src\\boletin1\\ejer1\\NumerosReales"))) {
			while (leer.hasNextInt()) {
				num = leer.nextInt();
				suma += num;
				cont++;
			}

			media = suma / cont;

			System.out.println("Suma total: " + suma);
			System.out.println("Media de los números: " + media);

		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		}

	}

}
