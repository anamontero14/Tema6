package boletin2.ejer5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Comp {

	public static void main(String[] args) {

		/*
		 * Algunos sistemas operativos disponen de la orden comp, que compara dos
		 * archivos y nos dice si son iguales o distintos. Diseña esta orden de forma
		 * que, además, nos diga en qué línea y carácter se encuentra la primera
		 * diferencia.
		 */

		// constantes con las rutas de los archivos
		final String FICHERO_1 = "C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin2\\ejer5\\Archivo1.txt";
		final String FICHERO_2 = "C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin2\\ejer5\\Archivo2.txt"; // el que
																												// es
																												// diferente
		final String FICHERO_3 = "C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin2\\ejer5\\Archivo3.txt";

		// variable que almacene la linea del fichero 1
		String lineaF1 = "";

		// variable que almacene la linea del fichero 2
		String lineaF2 = "";

		// variable que cambia entre true y false dependiendo de si son iguales o no
		boolean sonDistintas = false;

		// variable que almacena el caracter que es el diferente
		char caracterDiferente = ' ';

		// posicion del caracter diferente
		int pos = 0;

		int cont = 0;

		boolean caracterEsDiferente = false;

		try (BufferedReader leerFichero1 = new BufferedReader(new FileReader(FICHERO_1));
				BufferedReader leerFichero2 = new BufferedReader(new FileReader(FICHERO_3))) {

			// leo la primera linea del primer fichero
			lineaF1 = leerFichero1.readLine();

			// leo la primera linea del segundo fichero
			lineaF2 = leerFichero2.readLine();

			while (lineaF1 != null && lineaF2 != null && !sonDistintas) {

				// si no son iguales
				if (!lineaF1.equalsIgnoreCase(lineaF2)) {

					// quiere decir que las frases NO son iguales
					sonDistintas = true;

					// compruebo su longitud
					if (lineaF1.length() >= lineaF2.length()) {

						while (!caracterEsDiferente && cont < lineaF2.length()) {
							if (lineaF1.charAt(cont) != lineaF2.charAt(cont)) {
								// la posicion del caracter diferente es la i
								pos = cont;

								// e igualo el caracter diferente
								caracterDiferente = lineaF2.charAt(cont);

								caracterEsDiferente = true;

							}
							cont++;
						}

					} else {
						while (!caracterEsDiferente && cont < lineaF1.length()) {
							if (lineaF1.charAt(cont) != lineaF2.charAt(cont)) {
								// la posicion del caracter diferente es la i
								pos = cont;

								// e igualo el caracter diferente
								caracterDiferente = lineaF2.charAt(cont);

								caracterEsDiferente = true;

							}
							cont++;
						}
					}

				}

				// leo la primera linea del primer fichero
				lineaF1 = leerFichero1.readLine();

				// leo la primera linea del segundo fichero
				lineaF2 = leerFichero2.readLine();
			}

		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el archivo" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al abrir el archivo" + e.getMessage());
		}

		// anuncio los resultados
		if (sonDistintas) {
			System.out.println("Los archivos son diferentes.");
			System.out.println("Línea diferente: ");
			System.out.println("\t" + lineaF1);
			System.out.println("\t" + lineaF2);
			System.out.println("Caracter diferente: " + caracterDiferente);
			System.out.println("Posición del caracter diferente: " + pos);
		} else {
			System.out.println("Los archivos son iguales");
		}

	}

}
