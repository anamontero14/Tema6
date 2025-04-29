package boletin2.ejer6;

public class Deportista {

	/**
	 * Atributos del deportista
	 */

	private String nombre = "";
	private int edad;
	private double peso;
	private double estatura;

	/**
	 * Constructor con todos los parámetros
	 * 
	 * @param nombre
	 * @param edad
	 * @param peso
	 * @param estatura
	 */
	public Deportista(String nombre, int edad, double peso, double estatura) {
		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}

		if (edad > 0) {
			this.edad = edad;
		}

		if (peso > 0) {
			this.peso = peso;
		}

		if (estatura > 0) {
			this.estatura = estatura;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public double getPeso() {
		return peso;
	}

	public double getEstatura() {
		return estatura;
	}

}
