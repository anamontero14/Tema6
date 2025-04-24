package boletin1.ejer6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LeerOrdenarYEscribirNumeros {

	public static final String RUTA_ARCHIVO1 = "src\\boletin1\\ejer6\\NumDesordenados";
	public static final String RUTA_ARCHIVO2 = "src\\boletin1\\ejer6\\NumOrdenados";

	public static void main(String[] args) {

		// lista para almacenar los numeros
		ArrayList<Integer> listaNums = new ArrayList<Integer>();

		// lo mismo que haya en recorrer lista
		listaNums = recorrerFichero();

		// ordeno la lista
		Collections.sort(listaNums);

		// llamo a la función y le paso la lista
		escribeFichero(listaNums);

		// fin del programa
		System.out.println("Fin");

	}

	// leer los datos del archivo
	public static ArrayList<Integer> recorrerFichero() {
		// lista donde se guardarán
		ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
		// numero
		int num;

		try (Scanner leer = new Scanner(new FileReader(RUTA_ARCHIVO1))) {
			// mientras haya numeros
			while (leer.hasNextInt()) {
				// recojo el numero
				num = leer.nextInt();

				// lo añado a la lista
				listaNumeros.add(num);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado: " + e.getMessage());
		}

		return listaNumeros;
	}

	public static void escribeFichero(ArrayList<Integer> listaNums) {

		try (BufferedWriter in = new BufferedWriter(new FileWriter(RUTA_ARCHIVO2))) {

			// for each para recorrer la lista
			for (int num : listaNums) {

				// escribir los numeros en el fichero
				in.write(String.valueOf(num));

				// nueva linea
				in.newLine();

			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}
}
