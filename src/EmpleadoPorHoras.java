/*Pr�ctica 3
Paradigmas de Programaci�n II
Iv�n Alexander Cort�s P�rez
Grupo 512*/

public class EmpleadoPorHoras extends Empleado {
	private float horasTrabajadasMes;
	private double sueldoPorHora;

	// Constructor
	protected EmpleadoPorHoras(String numeroEmpleado, String curp, String primerNombre, String segundoNombre,
			String apellidoPaterno, String apellidoMaterno, String horasTrabajadasMes, String sueldoPorHora) {
		super(numeroEmpleado, curp, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);
		setHorasTrabajadasMes(horasTrabajadasMes);
		setSueldoPorHora(sueldoPorHora);
	}

	// Setters y Getters por defecto
	public float getHorasTrabajadasMes() {
		return horasTrabajadasMes;
	}

	public void setHorasTrabajadasMes(float horasTrabajadasMes) {
		this.horasTrabajadasMes = horasTrabajadasMes;
	}

	public double getSueldoPorHora() {
		return sueldoPorHora;
	}

	public void setSueldoPorHora(double sueldoPorHora) {
		this.sueldoPorHora = sueldoPorHora;
	}

	// Convertir float a String
	public void setHorasTrabajadasMes(String horasTrabajadasMes) {
		setHorasTrabajadasMes(Float.parseFloat(horasTrabajadasMes));
	}

	// Convertir double a String
	public void setSueldoPorHora(String sueldoPorHora) {
		setSueldoPorHora(Double.parseDouble(sueldoPorHora));
	}

	// M�todo obtener detalles
	public String obtenerDetalles() {
		Formateador formatea = new Formateador();

		return super.obtenerDetalles() + "\n" + "Horas trabajadas en el mes: " + formatea.formatearUnDecimal(horasTrabajadasMes) + "\n"
				+ "Sueldo por hora: " + formatea.formatearMoneda(sueldoPorHora);
	}


	// M�todo C�lcular Sueldo
	@Override
	public double calcularSueldoMes() {
		// TODO Auto-generated method stub
		return horasTrabajadasMes * sueldoPorHora;
	}

}
