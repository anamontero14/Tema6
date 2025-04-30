package boletin2.ejer6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BuscarFutbolistas {

	public static void main(String[] args) {

		/**
		 * Implementa un programa que lea el fichero e imprimirá por pantalla el nombre
		 * del deportista de mayor edad, el mayor peso y el de mayor estatura.
		 */

		// lista para almacenar los futbolistas
		ArrayList<Deportista> listaDeportistas = new ArrayList<Deportista>();

		// objeto de la clase deportista sin valores
		Deportista depo = null;

		// array para almacenar lo que se lea del fichero
		String datosDeportista[];

		// mayor edad
		int mayorEdad = Integer.MIN_VALUE;

		// mayor peso
		double mayorPeso = Double.MIN_VALUE;

		// mayor estatura
		double mayorEstatura = Double.MIN_VALUE;

		// variables para almacenar los datos del deportista
		String nombre = "";
		int edad;
		double peso;
		double estatura;

		// linea que se lee del fichero
		String linea = "";

		try (BufferedReader leerFichero = new BufferedReader(
				new FileReader("C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin2\\ejer6\\deportistas.txt"))) {

			// almaceno la primera linea en la variable
			linea = leerFichero.readLine();

			// almaceno la segunda linea porque la primera es la cabecera
			linea = leerFichero.readLine();

			while (linea != null) {

				// almaceno todos los datos en el array
				datosDeportista = linea.split("\\t");

				nombre = datosDeportista[0];
				edad = Integer.parseInt(datosDeportista[1]);
				peso = Double.parseDouble(datosDeportista[2]);
				estatura = Double.parseDouble(datosDeportista[3]);

				// hago un nuevo objeto con los respectivos datos del deportista
				depo = new Deportista(nombre, edad, peso, estatura);

				// lo almaceno en la lista
				listaDeportistas.add(depo);

				// leo la siguiente linea
				linea = leerFichero.readLine();
			}

		} catch (FileNotFoundException e) {
			System.err.println("No se puede encontrar el archivo " + e.getMessage());
		} catch (IOException e) {
			System.err.println("No se puede abrir el archivo " + e.getMessage());
		}

		// una vez estén todos los deportistas en la lista RECORRO la lista para
		// averiguar los diferentes parametros
		for (Deportista d : listaDeportistas) {
			// averiguar la edad maxima
			if (d.getEdad() > mayorEdad) {
				mayorEdad = d.getEdad();
			}
			// averiguar el peso maximo
			if (d.getPeso() > mayorPeso) {
				mayorPeso = d.getPeso();
			}
			// averiguar la estatura maxima
			if (d.getEstatura() > mayorEstatura) {
				mayorEstatura = d.getEstatura();
			}
		}

		// recorro otra vez la lista para esta vez mostrar los nombres
		for (Deportista d : listaDeportistas) {

			if (d.getEdad() == mayorEdad) {
				System.out.println("Nombre del deportista con mayor edad: " + d.getNombre());
			}

			if (d.getPeso() == mayorPeso) {
				System.out.println("Nombre del deportista con mayor peso: " + d.getPeso());
			}

			if (d.getEstatura() == mayorEstatura) {
				System.out.println("Nombre del deportista con mayor estatura: " + d.getEstatura());
			}

		}

	}

}
