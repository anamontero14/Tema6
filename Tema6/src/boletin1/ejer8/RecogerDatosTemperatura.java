package boletin1.ejer8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecogerDatosTemperatura {

	public static void main(String[] args) {

		/**
		 * Implementa una aplicación que mantenga un registro de las temperaturas máxima
		 * y mínima diarias medidas en una estación meteorológica. Los datos se
		 * guardarán en un archivo de texto con el siguiente formato:
		 * 
		 * Fecha,Temperatura máxima,Temperatura mínima 2020-01-15,12,-1 2020-01-16,15,2
		 * … Al arrancar la aplicación aparecerá un menú con las opciones:
		 * 
		 * Registra nueva temperatura.
		 * 
		 * Mostrar historial de registros.
		 * 
		 * Salir.
		 * 
		 * El historial de registros mostrará todos los datos registrados junto con el
		 * máximo valor de las temperaturas máximas y el mínimo de las temperaturas
		 * mínimas.
		 * 
		 */

		try (// scanner
				Scanner leer = new Scanner(System.in)) {
			// ruta del archivo
			final String RUTA_ARCHIVO = "C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin1\\ejer8\\RegistroTemperatura.txt";

			// variable que almacena la temperatura y fecha
			String fecha = "";
			// variable que almacena el dato que leo
			String datoLeer = "";
			// array que almacena los datos separados
			String almacenarDatos[];
			// valor maximo
			int valorMaximo = Integer.MIN_VALUE;
			// valor minimo
			int valorMinimo = Integer.MAX_VALUE;
			// opcion del menu
			int opcion = 0;

			do {
				// mostrar menu
				menu();

				System.out.print("Introduzca su opción: ");
				opcion = leer.nextInt();
				// limpiar el buffer
				leer.nextLine();

				switch (opcion) {
				case 1 -> {

					System.out.println();
					System.out.println(
							"Introduzca una nueva temperatura (fecha,temperatura mínima, temperatura máxima): ");
					fecha = leer.nextLine();

					try (BufferedWriter escribir = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
						// lo escribo en el txt
						escribir.write(fecha);
						// salto de línea
						escribir.newLine();

						escribir.flush();
						escribir.close();
					} catch (IOException e) {
						System.err.println("Error " + e.getMessage());
					}

				}
				case 2 -> {
					try (BufferedReader leerFichero = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {

						// almacenar la linea
						datoLeer = leerFichero.readLine();

						// mientras que el dato no sea nulo
						while (datoLeer != null) {
							// muestro la cadena
							System.out.println(datoLeer);

							// almacenarlo en el array
							almacenarDatos = datoLeer.split(",");

							// hago un parse de la posicion 1 y compruebo si es mayor que el valor que esta
							// en la variable del valor maximo
							valorMaximo = Math.max(valorMaximo, Integer.parseInt(almacenarDatos[1]));
							// lo mismo pero con el valor minimo
							valorMinimo = Math.min(valorMinimo, Integer.parseInt(almacenarDatos[2]));
							
							// pasar de linea
							datoLeer = leerFichero.readLine();

						}

						// muestro los valores minimos y maximos
						System.out.println("Temperatura mínima: " + valorMinimo);
						System.out.println("Temperatura máxima: " + valorMaximo);

					} catch (FileNotFoundException e) {
						System.err.println("No se encuentra el archivo " + e.getMessage());
					} catch (IOException e) {
						System.err.println("Error " + e.getMessage());
					}
				}
				case 3 -> {
					System.out.println();
					System.out.println("Saliendo...");
					System.out.println();
				}
				default -> {
					System.out.println();
					System.err.println("\tOpción incorrecta");
					System.out.println();
				}
				}

			} while (opcion >= 1 && opcion < 3);
		} catch (NumberFormatException e) {
			System.err.println("Error " + e.getMessage());
		}

	}

	public static void menu() {
		System.out.println();
		System.out.println("\t1. Registrar nueva temperatura");
		System.out.println("\t2. Mostrar historial de registros");
		System.out.println("\t3. Salir");
		System.out.println();
	}

}
