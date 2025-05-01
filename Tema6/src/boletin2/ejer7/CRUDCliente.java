package boletin2.ejer7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class CRUDCliente {

	// lista de clientes
	private static TreeSet<Cliente> listaClientes = new TreeSet<Cliente>();

	/**
	 * Métiodo para agregar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	public static boolean altaCliente(Cliente cliente) {
		return listaClientes.add(cliente);
	}

	/**
	 * Método para eliminar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	public static boolean bajaCliente(Cliente cliente) {
		return listaClientes.remove(cliente);
	}

	/**
	 * Listar clientes
	 */
	public static void listarClientes() {
		double saldoMax = Double.MIN_NORMAL;
		double saldoMin = Double.MAX_VALUE;
		double saldoMedio = 0;
		double count = 0;

		for (Cliente c : listaClientes) {
			System.out.println(c);

			if (c.getSaldo() > saldoMax) {
				saldoMax = c.getSaldo();
			}

			if (c.getSaldo() < saldoMin) {
				saldoMax = c.getSaldo();
			}

			saldoMedio += c.getSaldo();

			count++;
		}

		System.out.println("");
		System.out.println("Saldo máximo: " + saldoMax);
		System.out.println("Saldo mínimo: " + saldoMin);
		System.out.println("Media del saldo: " + (saldoMedio /= count));
	}

	public static void guardarDatos() {
		try (BufferedWriter escribirFichero = new BufferedWriter(new FileWriter(
				"C:\\Users\\USUARIO\\git\\Tema6\\Tema6\\src\\boletin2\\ejer7\\almacenarClientes.txt", true))) {

			// escribo todos los datos de los clientes almacenados separados por ;
			for (Cliente c : listaClientes) {
				escribirFichero.write(c.getDni());
				escribirFichero.write(';');
				escribirFichero.write(c.getNombreCompleto());
				escribirFichero.write(';');
				escribirFichero.write(c.getFechaNacimiento());
				escribirFichero.write(';');
				escribirFichero.write((int) c.getSaldo());
				escribirFichero.newLine();
			}

		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo " + e.getMessage());
		}
	}

}
