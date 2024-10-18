/*Pr�ctica 3
Paradigmas de Programaci�n II
Iv�n Alexander Cort�s P�rez
Grupo 512*/

public class EmpleadoPorDias extends Empleado {

	private double sueldoDiario;
	private float diasTrabajadosMes;

	protected EmpleadoPorDias(String numeroEmpleado, String curp, String primerNombre, String segundoNombre,
			String apellidoPaterno, String apellidoMaterno, String sueldoDiario, String diasTrabajadosMes) {
		super(numeroEmpleado, curp, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);
		this.setSueldoDiario(sueldoDiario);
		this.setDiasTrabajadosMes(diasTrabajadosMes);
	}

	// Setters y Getters por defecto
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

	// M�todo obtener detalles
	public String obtenerDetalles() {
		Formateador formatea = new Formateador();
		return super.obtenerDetalles() + "\n" + "Sueldo diario: " + formatea.formatearMoneda(sueldoDiario) + "\n"
				+ "D�as trabajados en el mes: " + formatea.formatearUnDecimal(diasTrabajadosMes);
	}

	// M�todo para c�lcular el sueldo
	@Override
	public double calcularSueldoMes() {
		// TODO Auto-generated method stub
		return sueldoDiario * diasTrabajadosMes;
	}

}
