package boletin2.ejer2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejer2 {

	public static void main(String[] args) {
		/*
		 * Un libro de firmas es útil para recoger los nombres de todas las personas que
		 * han pasado por un determinado lugar. Crea una aplicación que permita mostrar
		 * el libro de firmas e insertar un nuevo nombre (comprobando que no se
		 * encuentre repetido). Llamaremos al fichero firmas.txt.
		 */

		// scanner
		Scanner leer = new Scanner(System.in);

		// constante con la ruta del fichero
		final String RUTA_FICHERO = "src\\boletin2\\ejer2\\firmas.txt";

		// variable para almacenar la línea que se lee
		String linea = "";
		// nombre a escribir en el fichero
		String nombre = "";

		int opcion = 0;

		do {

			menu();
			System.out.print("Opción: ");
			opcion = leer.nextInt();
			// limpiar el buffer
			leer.nextLine();

			switch (opcion) {
			case 1 -> {

				System.out.println("MOSTRAR LIBRO DE FIRMAS");

				// leer el libro de firmas
				try (BufferedReader leerFichero = new BufferedReader(new FileReader(RUTA_FICHERO))) {

					// leer la primera línea y comprobar que esta no sea 0
					linea = leerFichero.readLine();

					// mientras que la línea no sea 0
					while (linea != null) {

						System.out.println(linea);

						// leer la primera línea y comprobar que esta no sea 0
						linea = leerFichero.readLine();
					}

				} catch (FileNotFoundException e) {
					System.err.println("Fichero no encontrado: " + e.getMessage());
				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				}

			}
			case 2 -> {

				System.out.println("ESCRIBIR UN NUEVO NOMBRE");

				try (BufferedWriter escribirFichero = new BufferedWriter(new FileWriter(RUTA_FICHERO, true))) {

					System.out.print("Introduzca el nombre a escribir: ");
					nombre = leer.nextLine();

					// si el nombre no es nulo
					if (nombre != null) {
						// escribo el nombre en el fichero
						escribirFichero.write(nombre);
						// salto de linea
						escribirFichero.newLine();
					}

					// cerrar el flujo
					escribirFichero.flush();
					escribirFichero.close();

				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				}

			}
			case 3 -> {
				System.out.println();
				System.out.println("\tSaliendo...");
				System.out.println();
			}
			default -> {
				System.err.println("Opción no reconocida");
			}
			}

		} while (opcion >= 1 && opcion < 3);

		System.out.println("Fin del programa");

		// cerrar el scanner
		leer.close();

	}

	private static void menu() {
		System.out.println();
		System.out.println("\t1. Mostrar libro de firmas");
		System.out.println("\t2. Insertar un nuevo nombre");
		System.out.println("\t3. Salir");
		System.out.println();
	}

}
