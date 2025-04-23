package boletin1.ejer3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerAlumnos {

	public static void main(String[] args) {

		// almacenar los datos que se lean, da igual su tipo
		String dato = "";
		// lista de nombres
		String nombres = "";
		// suma edad
		int sumaEdad = 0;
		// suma de la altura
		double sumaAltura = 0;
		// media de la edad
		double mediaEdad;
		// media de la estatura
		double mediaEstatura;
		// array donde se guardarán los datos
		String almacenar[];
		// contador
		int cont = 0;

		try (BufferedReader in = new BufferedReader(new FileReader("src\\boletin1\\ejer3\\Alumnos.txt"))) {
			// se lee la línea
			dato = in.readLine();

			// mientras que la línea no sea null
			while (dato != null) {
				almacenar = dato.split(" ");

				// almaceno los nombres
				nombres += " " + almacenar[0];

				// la edad estará en la posición 1 y la sumo "casteando" antes el nº
				sumaEdad += Integer.parseInt(almacenar[1]);

				// lo mismo con la altura
				sumaAltura += Double.parseDouble(almacenar[2]);

				// incremento
				cont++;

				// leo otra línea o si no se me queda en un bucle infinito
				dato = in.readLine();
			}

			// hago la media de la edad
			mediaEdad = sumaEdad / cont;

			// hago la media de la altura
			mediaEstatura = sumaAltura / cont;

			System.out.println(nombres);
			System.out.println("Suma de la edad: " + sumaEdad);
			System.out.println("Suma de la altura: " + sumaAltura);
			System.out.println("Media de la edad: " + mediaEdad);
			System.out.println("Media de la altura: " + mediaEstatura);

		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe o no se encontró");
		} catch (IOException e) {
			System.err.println("Error");
		}
	}

}
