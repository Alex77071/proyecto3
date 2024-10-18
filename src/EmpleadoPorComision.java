/*Práctica 3
Paradigmas de Programación II
Iván Alexander Cortés Pérez
Grupo 512*/

public class EmpleadoPorComision extends Empleado {
	private float porcentajeTasaComision;
	private double ventaMensual;

	// Constructor
	protected EmpleadoPorComision(String numeroEmpleado, String curp, String primerNombre, String segundoNombre,
			String apellidoPaterno, String apellidoMaterno, String porcentajeTasaComision, String ventaMensual) {
		super(numeroEmpleado, curp, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno);
		setPorcentajeTasaComision(porcentajeTasaComision);
		setVentaMensual(ventaMensual);
	}

	// Getters y Setters por defecto
	public float getPorcentajeTasaComision() {
		return porcentajeTasaComision;
	}

	public void setPorcentajeTasaComision(float porcentajeTasaComision) {
		this.porcentajeTasaComision = porcentajeTasaComision;
	}

	public double getVentaMensual() {
		return ventaMensual;
	}

	public void setVentaMensual(double ventaMensual) {
		this.ventaMensual = ventaMensual;
	}

	// Convertir float a String
	public void setPorcentajeTasaComision(String porcentajeTasaComision) {
		setPorcentajeTasaComision(Float.parseFloat(porcentajeTasaComision));
	}

	// Convertir double a String
	public void setVentaMensual(String ventaMensual) {
		setVentaMensual(Double.parseDouble(ventaMensual));
	}

	// Método obtener detalles
	public String obtenerDetalles() {
		Formateador formatea = new Formateador();
		return super.obtenerDetalles() + "\n" + "Porcentaje tasa de comisión: "
				+ formatea.formatearUnDecimal(porcentajeTasaComision) + "%" + "\n" + "Venta mensual: "
				+ formatea.formatearMoneda(ventaMensual);
	}

	// Método para cálcular el sueldo
	@Override
	public double calcularSueldoMes() {
		return (porcentajeTasaComision * ventaMensual) / 100;
	}
}
