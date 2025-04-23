package boletin1.ejer4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PedirDatos {

	public static void main(String[] args) {
		// dato a meter
		String dato;

		try (Scanner leer = new Scanner(System.in)) {

			try (BufferedWriter in = new BufferedWriter(new FileWriter("src\\boletin1\\ejer4\\AlmacenarDatos.txt"))) {

				dato = leer.nextLine();

				while (!dato.equalsIgnoreCase("fin")) {
					// meto el dato en el fichero
					in.write(dato);
					// salto de linea
					in.newLine();

					dato = leer.nextLine();
				}

				// cerrar
				in.flush();
				in.close();

			} catch (IOException e) {
				System.err.println("Error");
			}
		}

		System.out.println();
		System.out.println("Fin");
	}

}
