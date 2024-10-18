import java.util.*;
import javax.swing.*;

/*Práctica 3
Paradigmas de Programación II
Iván Alexander Cortés Pérez
Grupo 512*/

public class EmpleadoMain {
	public static void main(String[] args) {
		List<Empleado> empleados = new ArrayList<>();

		String sueldoDiario = null;
		String diasTrabajados = null;
		String horasTrabajadas = null;
		String sueldoPorHora = null;
		String porcentajeComision = null;
		String ventaMensual = null;

		do {
			String[] opciones = { "Empleado por días", "Empleado por horas", "Empleado por comisión",
					"Empleado por días más comisión" };

			String tipoEmpleado = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de empleado:",
					"Tipo de empleado", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			if (tipoEmpleado == null) {
				continue;
			}

			// Pedir datos generales del empleado
			// Número de empleado
			String numeroEmpleado = JOptionPane.showInputDialog(null, "Escriba el número del empleado",
					"Datos generales", JOptionPane.QUESTION_MESSAGE);
			if (numeroEmpleado == null) {
				continue;
			}

			// CURP del empleado
			String curp = JOptionPane.showInputDialog(null, "Escriba la CURP del empleado", "Datos generales",
					JOptionPane.QUESTION_MESSAGE);
			if (curp == null) {
				continue;
			}

			// Primer nombre del empleado
			String primerNombre = JOptionPane.showInputDialog(null, "Escriba el primer nombre del empleado",
					"Datos generales", JOptionPane.QUESTION_MESSAGE);
			if (primerNombre == null) {
				continue;
			}

			// Segundo nombre del empleado
			String segundoNombre = JOptionPane.showInputDialog(null, "Escriba el segundo nombre del empleado",
					"Datos generales", JOptionPane.QUESTION_MESSAGE);
			if (segundoNombre == null) {
				continue;
			}

			// Apellido paterno del empleado
			String apellidoPaterno = JOptionPane.showInputDialog(null, "Escriba el apellido paterno del empleado",
					"Datos generales", JOptionPane.QUESTION_MESSAGE);
			if (apellidoPaterno == null) {
				continue;
			}

			// Apellido materno del empleado
			String apellidoMaterno = JOptionPane.showInputDialog(null, "Escriba el apellido materno del empleado",
					"Datos generales", JOptionPane.QUESTION_MESSAGE);
			if (apellidoMaterno == null) {
				continue;
			}

			// Datos particulares del empleado
			Empleado empleado = null;

			if (tipoEmpleado.equals("Empleado por días") || tipoEmpleado.equals("Empleado por días más comisión")) {
				sueldoDiario = JOptionPane.showInputDialog(null, "Escriba el sueldo diario", "Empleado por días",
						JOptionPane.QUESTION_MESSAGE);
				if (sueldoDiario == null) {
					continue;
				}
				diasTrabajados = JOptionPane.showInputDialog(null, "Escriba días trabajados", "Empleado por días",
						JOptionPane.QUESTION_MESSAGE);
				if (diasTrabajados == null) {
					continue;
				}
				if (tipoEmpleado.equals("Empleado por días")) {
					empleado = new EmpleadoPorDias(numeroEmpleado, curp, primerNombre, segundoNombre, apellidoPaterno,
							apellidoMaterno, sueldoDiario, diasTrabajados);
				}
			}
			if (tipoEmpleado.equals("Empleado por horas")) {
				horasTrabajadas = JOptionPane.showInputDialog(null, "Escriba las horas trabajadas",
						"Empleado por horas", JOptionPane.QUESTION_MESSAGE);
				if (horasTrabajadas == null) {
					continue;
				}
				sueldoPorHora = JOptionPane.showInputDialog(null, "Escriba el sueldo por hora", "Empleado por horas",
						JOptionPane.QUESTION_MESSAGE);
				if (sueldoPorHora == null) {
					continue;
				}
				empleado = new EmpleadoPorHoras(numeroEmpleado, curp, primerNombre, segundoNombre, apellidoPaterno,
						apellidoMaterno, horasTrabajadas, sueldoPorHora);
			}
			if (tipoEmpleado.equals("Empleado por comisión") || tipoEmpleado.equals("Empleado por días más comisión")) {
				porcentajeComision = JOptionPane.showInputDialog(null, "Escriba el porcentaje de comisión",
						"Empleado por comisión", JOptionPane.QUESTION_MESSAGE);
				if (porcentajeComision == null) {
					continue;
				}
				ventaMensual = JOptionPane.showInputDialog(null, "Escriba la venta mensual", "Empleado por comisión",
						JOptionPane.QUESTION_MESSAGE);
				if (ventaMensual == null) {
					continue;
				}

				if (tipoEmpleado.equals("Empleado por días mas comisión")) {
					empleado = new EmpleadoPorDiasMasComision(numeroEmpleado, curp, primerNombre, segundoNombre,
							apellidoPaterno, apellidoMaterno, porcentajeComision, ventaMensual, sueldoDiario,
							diasTrabajados);
				} else {
					empleado = new EmpleadoPorComision(numeroEmpleado, curp, primerNombre, segundoNombre,
							apellidoPaterno, apellidoMaterno, porcentajeComision, ventaMensual);
				}

			}

			// Agregar registro del empleado
			empleados.add(empleado);

		} while (JOptionPane.showConfirmDialog(null, "¿Desea registrar a un nuevo empleado?", "Registro de empleados",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

		// Verifica si hay datos de empleados
		if (!empleados.isEmpty()) {
			// Pedir método para ordenar
			String[] opcionesOrd = { "Por nombres", "Por apellidos", "Por número de empleado" };
			String tipoOrdenacionSeleccionada = (String) JOptionPane.showInputDialog(null,
					"Seleccione el tipo de ordenación:", "Tipo de ordenación", JOptionPane.QUESTION_MESSAGE, null,
					opcionesOrd, opcionesOrd[0]);

			if (tipoOrdenacionSeleccionada != null) {
				switch (tipoOrdenacionSeleccionada) {

				case "Por número de empleado":
					Empleado.setTipoOrdenacion(Empleado.POR_NUM_EMPLEADO);
					break;

				case "Por apellidos":
					Empleado.setTipoOrdenacion(Empleado.POR_APELLIDOS);
					break;

				default:
					break;

				}
			}

			// Ordenar
			Collections.sort(empleados);
		}

		// Mostrar datos del empleado
		for (Empleado e : empleados) {
			JOptionPane.showMessageDialog(null,
					e.obtenerDetalles() + "\n" + "\nSueldo al mes: $" + e.calcularSueldoMes(),
					"Empleado " + e.getNumeroEmpleado(), JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
