package boletin2.ejer7;

import java.util.Scanner;

public class GestionarClientes {
	// scanner
	private static Scanner leer = new Scanner(System.in);

	public static void main(String[] args) {

		// variable para almacenar la opcion del menu
		int opcion = 0;

		// objeto
		Cliente cliente = null;

		do {

			menu();
			System.out.print("Seleccione una opción: ");
			opcion = leer.nextInt();
			// limpiar buffer
			leer.nextLine();

			switch (opcion) {
			case 1 -> {

				System.out.println("DAR DE ALTA A UN CLIENTE");
				cliente = recogerDatos();

				if (CRUDCliente.altaCliente(cliente)) {
					System.out.println("\tEl cliente se agregó con éxito");
				} else {
					System.err.println("\tEl cliente no se pudo agregar");
				}

			}
			case 2 -> {

				System.out.println("DAR DE BAJA A UN CLIENTE");
				cliente = new Cliente(recogerDni());

				if (CRUDCliente.bajaCliente(cliente)) {
					System.out.println("\tEl cliente se dió de baja con éxito");
				} else {
					System.err.println("\tEl cliente no se pudo dar de baja");
				}
			}
			case 3 -> {

				System.out.println("LISTA DE CLIENTES");

				CRUDCliente.listarClientes();

			}
			case 4 -> {
				System.out.println("\tSaliendo...");
			}
			default -> {
				System.err.println("\tOpción no válida");
			}
			}

		} while (opcion >= 1 && opcion <= 3);

		// guardar los datos en el fichero
		CRUDCliente.guardarDatos();

		System.out.println("Fin del programa");

		// cerrar el scanner
		leer.close();

	}

	private static void menu() {
		System.out.println();
		System.out.println("\t1. Alta cliente");
		System.out.println("\t2. Baja cliente");
		System.out.println("\t3. Lista clientes");
		System.out.println("\t4. Salir");
		System.out.println();
	}

	/**
	 * Recoger el dni del cliente
	 * 
	 * @return
	 */
	private static String recogerDni() {
		String dni = "";

		System.out.print("Introduzca el DNI: ");
		dni = leer.nextLine();

		return dni;
	}

	/**
	 * Recoger datos
	 * 
	 * @return
	 */
	private static Cliente recogerDatos() {

		String nombreCompleto = "";
		String fechaNacimiento = "";
		double saldo = 0;
		String dni;

		dni = recogerDni();

		System.out.print("Introduzca el nombre completo: ");
		nombreCompleto = leer.nextLine();

		System.out.print("Introduzca la fecha de nacimiento: ");
		fechaNacimiento = leer.nextLine();

		System.out.print("Introduzca el saldo: ");
		saldo = leer.nextDouble();

		Cliente cliente = new Cliente(dni, nombreCompleto, fechaNacimiento, saldo);

		return cliente;
	}

}
