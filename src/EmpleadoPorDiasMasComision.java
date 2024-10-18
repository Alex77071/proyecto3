/*Práctica 3
Paradigmas de Programación II
Iván Alexander Cortés Pérez
Grupo 512*/

public class EmpleadoPorDiasMasComision extends EmpleadoPorComision {

	private double sueldoDiario;
	private float diasTrabajadosMes;

	// Constructor
	protected EmpleadoPorDiasMasComision(String numeroEmpleado, String curp, String primerNombre, String segundoNombre,
			String apellidoPaterno, String apellidoMaterno, String porcentajeTasaComision, String ventaMensual,
			String sueldoDiario, String diasTrabajadosMes) {
		super(numeroEmpleado, curp, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno,
				porcentajeTasaComision, ventaMensual);
		setSueldoDiario(sueldoDiario);
		setDiasTrabajadosMes(diasTrabajadosMes);
	}

	// Getters y Setters por defecto
	public double getSueldoDiario() {
		return sueldoDiario;
	}

	public void setSueldoDiario(double sueldoDiario) {
		this.sueldoDiario = sueldoDiario;
	}

	public float getDiasTrabajadosMes() {
		return diasTrabajadosMes;
	}

	public void setDiasTrabajadosMes(float diasTrabajadosMes) {
		this.diasTrabajadosMes = diasTrabajadosMes;
	}

	// Convertir double a String
	public void setSueldoDiario(String sueldoDiario) {
		setSueldoDiario(Double.parseDouble(sueldoDiario));
	}

	// Convertir float a String
	public void setDiasTrabajadosMes(String diasTrabajadosMes) {
		setDiasTrabajadosMes(Float.parseFloat(diasTrabajadosMes));
	}

	// Método obtener detalles
	public String obtenerDetalles() {
		Formateador formatea = new Formateador();
		return super.obtenerDetalles() + "\n" + "Sueldo diario: " + formatea.formatearMoneda(sueldoDiario) + "\n"
				+ "Días trabajados en el mes: " + formatea.formatearUnDecimal(diasTrabajadosMes);
	}

	// Método para cálcular el sueldo
	public double calcularSueldoMes() {
		return super.calcularSueldoMes() + sueldoDiario * diasTrabajadosMes;
	}

}
