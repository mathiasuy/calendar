package grupouno.dto;

import java.util.Date;

public class Empleado extends Persona 
{

	private java.util.Date fecha_vencimiento_carnet_de_salud;
	private double sueldo;

	public Empleado(String nombre, String documento, Date fecha_de_nacimiento, Date fecha_registrado,
			String comentarios, String telefono, String usuario, String contrasena, boolean habilitado,
			Date fecha_vencimiento_carnet_de_salud, double sueldo) {
		super(nombre, documento, fecha_de_nacimiento, fecha_registrado, comentarios, telefono, usuario, contrasena,
				habilitado);
		this.fecha_vencimiento_carnet_de_salud = fecha_vencimiento_carnet_de_salud;
		this.sueldo = sueldo;
	}

	public java.util.Date getFecha_vencimiento_carnet_de_salud() {
		return fecha_vencimiento_carnet_de_salud;
	}

	public void setFecha_vencimiento_carnet_de_salud(java.util.Date fecha_vencimiento_carnet_de_salud) {
		this.fecha_vencimiento_carnet_de_salud = fecha_vencimiento_carnet_de_salud;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [fecha_vencimiento_carnet_de_salud=" + fecha_vencimiento_carnet_de_salud + ", sueldo=" + sueldo
				+ "]";
	}

}
