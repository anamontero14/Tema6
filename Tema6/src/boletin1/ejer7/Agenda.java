package boletin1.ejer7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
		// variable que almacena el contacto a insertar
		String contactoCompleto = "";

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
				if (!agendaContactos.containsKey(nombreContacto) && !agendaContactos.containsValue(numContacto)) {
					agendaContactos.put(nombreContacto, numContacto);
				}

			}
			case 2 -> {

				System.out.println("\tNUEVO CONTACTO");
				System.out.println();
				// le asigno el nuevo nombre a la variable
				nombreContacto = pedirNombre();

				// recoge el nº asignado al nombre de contacto
				numContacto = agendaContactos.get(nombreContacto);

				// si el nº de contacto no es nulo lo muestra
				if (numContacto != null) {
					System.out.println("\tNúmero de teléfono de " + nombreContacto + ": " + numContacto);
					// si lo es manda un mensaje de error
				} else {
					System.err.println("\tNo existe ese contacto");
				}

			}
			case 3 -> {

				System.out.println("MOSTRAR CONTACTOS");
				System.out.println();

				// recorrer el mapa
				for (String contacto : agendaContactos.keySet()) {
					// obtengo las claves y sus respectivos valores
					System.out.println(contacto + ": " + agendaContactos.get(contacto));
				}

			}
			case 4 -> {

				System.out.println("INSERTAR LOS NOMBRES EN LA AGENDA");
				System.out.println();

				// creo el buffered writer
				try (BufferedWriter escribir = new BufferedWriter(new FileWriter(
						"C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin1\\ejer7\\AgendaContactos", true))) {

					// recorrer el mapa
					for (String contacto : agendaContactos.keySet()) {
						// obtengo las claves y sus respectivos valores
						contactoCompleto = contacto + ": " + agendaContactos.get(contacto);

						// escribo el contacto completo en la agenda
						escribir.write(contactoCompleto);
						escribir.newLine();
					}

					escribir.flush();
					escribir.close();

				} catch (IOException e) {
					System.err.println("Error " + e.getMessage());
				}

			}
			case 5 -> {
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
		System.out.println("\t4. Guardar datos");
		System.out.println("\t5. Salir");
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
