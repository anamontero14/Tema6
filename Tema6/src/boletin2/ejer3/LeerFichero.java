package boletin2.ejer3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerFichero {

	public static void main(String[] args) {

		/*
		 * En Linux disponemos del comando more, al que se le pasa un fichero y lo
		 * muestra poco a poco: cada 24 líneas. Implementa un programa que funcione de
		 * forma similar.
		 */

		// scanner
		Scanner leer = new Scanner(System.in);

		// variable para recoger la línea que se lee
		String linea;

		// contador
		int cont = 0;

		// leer el fichero
		try (BufferedReader leerFichero = new BufferedReader(new FileReader("src\\boletin2\\ejer3\\fichero.txt"))) {

			linea = leerFichero.readLine();

			// mientras que la variable no sea igual a nulo
			while (linea != null) {

				System.out.println(linea);

				// leo la siguiente linea
				linea = leerFichero.readLine();

				if (cont == 10) {
					leer.nextLine();
					cont = 0;
				}

				cont++;
			}

		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

		System.out.println();
		System.out.println("Fin");

		// cerrar el scanner
		leer.close();

	}

}
