package boletin1.ejer7;

import java.util.Scanner;
import java.util.TreeMap;

public class Agenda {

	public static Scanner leer = new Scanner(System.in);

	public static void main(String[] args) {

		TreeMap<String, String> agendaContactos = new TreeMap<String, String>();

		int opcion = 0;
		// nombre del contacto
		String nombreContacto = "";
		// nº contacto
		String numContacto;

		do {
			menu();
			System.out.print("Escoja una opción: ");
			opcion = leer.nextInt();
			// limpiar el buffer
			leer.nextLine();

			switch (opcion) {
			case 1 -> {

				System.out.println("\tNUEVO CONTACTO");
				System.out.println();
				// le asigno el nuevo nombre a la variable
				nombreContacto = pedirNombre();
				// le asigno el nuevo numero a la variable
				numContacto = pedirNumero();

				// busco en el mapa si esta el nombre de contacto
				if (agendaContactos.containsKey(nombreContacto) && agendaContactos.containsValue(numContacto)) {
					agendaContactos.put(nombreContacto, numContacto);
				}

			}
			case 2 -> {
			}
			case 3 -> {
			}
			case 4 -> {
				System.out.println();
				System.out.println("\tSaliendo...");
				System.out.println();
			}
			default -> {
				System.err.println("Opción incorrecta");
			}
			}

		} while (opcion <= 4 && opcion >= 1);

		System.out.println("Fin");
		leer.close();

	}

	public static void menu() {
		System.out.println("\t1. Nuevo contacto");
		System.out.println("\t2. Buscar por nombre");
		System.out.println("\t3. Mostrar todos");
		System.out.println("\t4. Salir");
	}

	// función para pedir un nuevo nombre de contacto
	public static String pedirNombre() {
		String nombre = "";

		System.out.print("Introduzca el nombre del contacto: ");
		nombre = leer.nextLine();

		return nombre;
	}

	// función para pedir el nuevo número del contacto
	public static String pedirNumero() {
		String numero = "";

		System.out.print("Introduzca el número de teléfono del contacto: ");
		numero = leer.nextLine();

		return numero;
	}

}
