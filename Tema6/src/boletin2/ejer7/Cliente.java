package boletin2.ejer7;

public class Cliente implements Comparable<Cliente> {

	private String dni = "";
	private String nombreCompleto = "";
	private String fechaNacimiento = "";
	private double saldo;

	Cliente(String dni) {
		if (dni != null && !dni.isBlank()) {
			this.dni = dni;
		}
	}

	Cliente(String dni, String nombreCompleto, String fechaNacimiento, double saldo) {
		if (dni != null && !dni.isBlank()) {
			this.dni = dni;
		}

		if (nombreCompleto != null && !nombreCompleto.isBlank()) {
			this.nombreCompleto = nombreCompleto;
		}

		if (fechaNacimiento != null && !fechaNacimiento.isBlank()) {
			this.fechaNacimiento = fechaNacimiento;
		}

		if (saldo >= 0) {
			this.saldo = saldo;
		}
	}

	public String getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "CLIENTE: " + dni + " " + nombreCompleto + " " + fechaNacimiento + "\nSaldo: " + saldo;
	}

	@Override
	public int compareTo(Cliente o) {
		return this.dni.compareTo(o.dni);
	}

}
