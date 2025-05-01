package boletin2.ejer4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodificarFichero {
	// array donde se guardan los alfabetos
	static char alfabeto[];
	static char alfabetoCodificado[];
	// almacenar la ruta de el código
	static final String CODIGO_CODIFICACION = "C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin2\\ejer4\\codec.txt";
	static final String FICHERO_ESCRIBIR_CODIGO = "C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin2\\ejer4\\ficheroCodificado.txt";

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
		// variable auxiliar
		int posLetra;

		// llamo a la funcion para leer los alfabetos
		leerAlfabetos();

		// una vez tengo los alfabetos leo el fichero a codificar
		try (BufferedReader leerFichero = new BufferedReader(
				new FileReader("C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin2\\ejer4\\ficheroCodificar.txt"))) {

			// leer la linea
			linea = leerFichero.readLine();

			while (linea != null) {

				// almaceno la linea el el array
				lineaFichero = linea.toCharArray();

				// recorro el array del la linea sin codificar
				for (int i = 0; i < lineaFichero.length; i++) {
					// recorro el alfabeto normal
					for (int j = 0; j < alfabeto.length; j++) {
						if (lineaFichero[i] == alfabeto[j]) {
							// si la letra del abecedario es la misma que la de la frase almaceno la
							// posicion de la letra en la variable
							posLetra = j;

							// recorro el array del alfabeto codificado
							for (int x = 0; x < alfabetoCodificado.length; x++) {
								// si la posicion de la letra es la misma que la que se esta recorriendo
								if (posLetra == x) {
									// se añade la letra codificada que este en el mismo lugar que la otra letra
									lineaCodificada += alfabetoCodificado[posLetra];

								}

							}
							// si la letra no es igual a la del alfabeto pero es igual a un espacio
						} else if (lineaFichero[i] == ' ') {
							// se añade a la linea codificada
							lineaCodificada += " ";
						}
					}
				}

				// escribo la linea codificada
				escribirLinea(lineaCodificada);

				// paso de linea
				linea = leerFichero.readLine();

			}

		} catch (FileNotFoundException e) {
			System.err.println("El fichero no se encuentra: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

		System.out.println("Fin del programa");

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

	private static boolean escribirLinea(String lineaAEscribir) {
		boolean sePudo = true;

		try (BufferedWriter escribirFichero = new BufferedWriter(new FileWriter(FICHERO_ESCRIBIR_CODIGO, true))) {

			// escribir la linea que llega en el fichero
			escribirFichero.write(lineaAEscribir);
			escribirFichero.newLine();

		} catch (IOException e) {
			sePudo = false;
			System.err.println("No se pudo abrir el fichero " + e.getMessage());
		}

		return sePudo;
	}

}
