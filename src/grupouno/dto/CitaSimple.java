package grupouno.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class CitaSimple {
	private int citaSimpleID;
	private String cliente;
	private String empleado;
	private String descripcion;
	private java.util.Date fecha_registrada;
	private LocalDateTime fecha_de_cita;
	private double precio;
	
	public CitaSimple(int citaSimpleID, String cliente, String empleado, String descripcion, Date fecha_registrada,
			LocalDateTime fecha_de_cita, double precio) {
		this.citaSimpleID = citaSimpleID;
		this.cliente = cliente;
		this.empleado = empleado;
		this.descripcion = descripcion;
		this.fecha_registrada = fecha_registrada;
		this.fecha_de_cita = fecha_de_cita;
		this.precio = precio;
	}

	public CitaSimple() {
		// TODO Auto-generated constructor stub
	}

	public int getCitaSimpleID() {
		return citaSimpleID;
	}

	public void setCitaSimpleID(int citaSimpleID) {
		this.citaSimpleID = citaSimpleID;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public java.util.Date getFecha_registrada() {
		return fecha_registrada;
	}

	public void setFecha_registrada(java.util.Date fecha_registrada) {
		this.fecha_registrada = fecha_registrada;
	}

	public LocalDateTime getFecha_de_cita() {
		return fecha_de_cita;
	}

	public void setFecha_de_cita(LocalDateTime fecha_de_cita) {
		this.fecha_de_cita = fecha_de_cita;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "CitaSimple [citaID=" + citaSimpleID + ", cliente=" + cliente + ", empleado=" + empleado + ", descripcion="
				+ descripcion + ", fecha_registrada=" + fecha_registrada + ", fecha_de_cita=" + fecha_de_cita.toLocalDate() + " hora=" + fecha_de_cita.toLocalTime()
				+ ", precio=" + precio + "]";
	}
	
}
