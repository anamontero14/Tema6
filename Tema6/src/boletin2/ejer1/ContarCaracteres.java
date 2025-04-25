package boletin2.ejer1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContarCaracteres {

	public static void main(String[] args) {

		/*
		 * Escribe un programa que lea un fichero de texto llamado carta.txt. Tenemos
		 * que contar los caracteres, las líneas y las palabras. Para simplificar
		 * supondremos que cada palabra está separada de otra por un único espacio en
		 * blanco o por un cambio de línea.
		 */

		// ruta del archivo
		final String RUTA_ARCHIVO = "src\\boletin2\\ejer1\\carta.txt";

		// contador de los caracteres
		int contCaracteres = 0;
		// contador de lineas
		int contLineas = 0;
		// contador de palabras
		int contPalabras = 0;
		// variable que almacena lo que se lee
		String almacenarLinea = "";
		// array donde almacenar las palabras de la linea
		String arrayPalabras[];

		try (BufferedReader leer = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {

			// almaceno la primera linea
			almacenarLinea = leer.readLine();

			// mientras que la variable no sea nula
			while (almacenarLinea != null) {

				// el array de las palabras almacena todas las palabras separadas por un espacio
				arrayPalabras = almacenarLinea.split(" ");

				// cuento la longitud del array que será el nº de palabras de la línea
				contPalabras += arrayPalabras.length;

				// recorro la linea entera para contar los caracteres ya que los espacios
				// también son un caracter
				for (int i = 0; i < almacenarLinea.length(); i++) {
					// voy contando todos los caracteres de la frase
					contCaracteres++;
				}

				// almaceno la primera linea
				almacenarLinea = leer.readLine();

				// aumento el contador de la linea
				contLineas++;
			}

			// muestro el resultado
			System.out.println("Número de líneas: " + contLineas);
			System.out.println("Número de palabras: " + contPalabras);
			System.out.println("Número de caracteres: " + contCaracteres);

		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el archivo: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
