import java.text.DecimalFormat;
import java.text.NumberFormat;

/*Práctica 3
Paradigmas de Programación II
Iván Alexander Cortés Pérez
Grupo 512*/

public abstract class Empleado implements Comparable<Empleado> {

	private int numeroEmpleado;
	private String curp;
	private String primerNombre;
	private String segundoNombre;
	private String apellidoPaterno;
	private String apellidoMaterno;

	// Nuevas variables
	public static final int POR_NOMBRES = 1;
	public static final int POR_APELLIDOS = 2;
	public static final int POR_NUM_EMPLEADO = 3;

	// Seleccionar por defecto POR_NOMBRES
	private static int tipoOrdenacion = POR_NOMBRES;

	// Constructor con 6 variables
	protected Empleado(String numeroEmpleado, String curp, String primerNombre, String segundoNombre,
			String apellidoPaterno, String apellidoMaterno) {
		setApellidoMaterno(apellidoMaterno);
		setApellidoPaterno(apellidoPaterno);
		setCurp(curp);
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setNumeroEmpleado(numeroEmpleado);
	}

	// Getters y Setters por defecto
	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	// Setter y getter para la nueva variable
	public void setNumeroEmpleado(String numeroEmpleado) {
		setNumeroEmpleado(Integer.parseInt(numeroEmpleado));
	}

	public static int getTipoOrdenacion() {
		return tipoOrdenacion;
	}

	// Nuevo método
	public String getSueldoMes() {
		Formateador formatear = new Formateador();
		return formatear.formatearMoneda(calcularSueldoMes());

	}

	// Convertir entero a String
	public static void setTipoOrdenacion(int tipoOrdenacion) {
		Empleado.tipoOrdenacion = tipoOrdenacion;
	}

	// Método obtener detalles
	public String obtenerDetalles() {
		return "Número de empleado: " + numeroEmpleado + "\n" + "CURP: " + curp + "\n" + "Primer nombre: "
				+ primerNombre + "\n" + "Segundo nombre: " + segundoNombre + "\n" + "Apellido paterno: "
				+ apellidoPaterno + "\n" + "Apellido materno: " + apellidoMaterno;

	}

	// Método Cálcular Sueldo
	public abstract double calcularSueldoMes();

	/*
	 * Regresa cero si los objetos son iguales, regresa un número negativo si el
	 * objeto actual es menor al objeto recibido, regresa un número positivo si el
	 * objeto actual es mayor al objeto recibido.
	 */
	public int compareTo(Empleado o) {
		int res = 0;
		switch (tipoOrdenacion) {
		case POR_NOMBRES:

			res = this.primerNombre.compareToIgnoreCase(o.primerNombre);

			if (res == 0) {
				res = this.segundoNombre.compareToIgnoreCase(o.segundoNombre);
			}

			if (res == 0) {
				res = this.apellidoPaterno.compareToIgnoreCase(o.apellidoPaterno);
			}

			if (res == 0) {
				res = this.apellidoMaterno.compareToIgnoreCase(o.apellidoMaterno);
			}

			break;

		case POR_APELLIDOS:

			res = this.apellidoPaterno.compareToIgnoreCase(o.apellidoPaterno);

			if (res == 0) {
				res = this.apellidoMaterno.compareToIgnoreCase(o.apellidoMaterno);
			}

			if (res == 0) {
				res = this.primerNombre.compareToIgnoreCase(o.primerNombre);
			}

			if (res == 0) {
				res = this.segundoNombre.compareToIgnoreCase(o.segundoNombre);
			}

			break;
		case POR_NUM_EMPLEADO:
			res = Integer.compare(this.numeroEmpleado, o.numeroEmpleado);
			break;
		}
		return res;
	}

	// Clase interna Formateador
	protected class Formateador {

		public String formatearMoneda(double moneda) {
			NumberFormat formato = NumberFormat.getCurrencyInstance();
			return formato.format(moneda);
		}

		public String formatearUnDecimal(float decimal) {
			DecimalFormat formato = new DecimalFormat("0.0");
			return formato.format(decimal);
		}

	}

}
