package boletin1.ejer5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PedirNombreEdad {

	public static void main(String[] args) {
		// datos a introducir
		String datosAIntroducir;

		try (// creacion del scanner
				Scanner leer = new Scanner(System.in)) {

			try (BufferedWriter escribir = new BufferedWriter(
					new FileWriter("src\\boletin1\\ejer5\\datos.txt", true))) {

				System.out.print("Introduzca su nombre y su edad: ");
				datosAIntroducir = leer.nextLine();

				// nueva linea
				escribir.newLine();

				// meter el nombre
				escribir.write(datosAIntroducir);

				escribir.flush();
				escribir.close();
			} catch (IOException e) {
				System.err.println("Error");
			}
		}
	}

}
