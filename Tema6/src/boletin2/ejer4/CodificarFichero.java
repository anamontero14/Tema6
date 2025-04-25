package boletin2.ejer4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodificarFichero {
	// array donde se guardan los alfabetos
	static char alfabeto[];
	static char alfabetoCodificado[];
	// almacenar la ruta de el código
	static final String CODIGO_CODIFICACION = "src\\boletin2\\ejer4\\codec.txt";

	public static void main(String[] args) {
		/*
		 * Un encriptador es una aplicación que transforma un texto haciéndolo ilegible
		 * para aquellos que desconocen el código. Diseña un programa que lea un fichero
		 * de texto, lo codifique y cree un nuevo archivo con el mensaje cifrado. El
		 * alfabeto de codificación se encontrará en el fichero codec.txt. Un ejemplo de
		 * codificación de alfabeto es:
		 * 
		 * Alfabeto: a b c d e f g h i j k l m n o p q r s t u v w x y z
		 * 
		 * Cifrado: e m s r c y j n f x i w t a k o z d l q v b h u p g
		 */

		// array donde almacenar la linea que se lea
		char lineaFichero[];
		// linea codificada
		String lineaCodificada = "";
		// almacenar la linea
		String linea = "";

		// llamo a la funcion para leer los alfabetos
		leerAlfabetos();

		// una vez tengo los alfabetos leo el fichero a codificar
		try (BufferedReader leerFichero = new BufferedReader(
				new FileReader("src\\boletin2\\ejer4\\ficheroCodificar.txt"))) {

			// leer la linea
			linea = leerFichero.readLine();

			while (linea != null) {

				// paso de linea
				linea = leerFichero.readLine();

				// almaceno la linea el el array
				lineaFichero = linea.toCharArray();

				// recorro el array del la linea sin codificar
				for (int i = 0; i < lineaFichero.length; i++) {
					// recorro el alfabeto sin codificar
					for (int j = 0; j < alfabetoCodificado.length; j++) {
						
						if (lineaFichero[i] == alfabetoCodificado[j]) {
							
						}
						
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.err.println("El fichero no se encuentra: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	private static void leerAlfabetos() {
		// almacenar la linea
		String linea = "";
		// contador
		int cont = 0;

		try (BufferedReader leerFichero = new BufferedReader(new FileReader(CODIGO_CODIFICACION))) {

			// almacenar la linea
			linea = leerFichero.readLine();

			while (linea != null) {

				if (cont == 0) {
					// almaceno la linea en el array
					alfabeto = linea.toCharArray();
				} else {
					alfabetoCodificado = linea.toCharArray();
				}

				// almacenar la linea
				linea = leerFichero.readLine();

				cont++;

			}

		} catch (FileNotFoundException e) {
			System.err.println("El fichero no se encuentra: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
