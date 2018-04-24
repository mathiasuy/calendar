package grupouno.dto;

import java.util.Date;

public class Descuento {
	private int descuentoID;
	private String nombre;
	private boolean esConvenio;
	private String descripcion;
	private double porcentaje;
	private String dias;
	private java.util.Date fecha_de_expiracion;
	private boolean habilitado;

	public Descuento(int descuentoID, String nombre, boolean esConvenio, String descripcion, double porcentaje, String dias,
			Date fecha_de_expiracion, boolean habilitado) {
		super();
		this.nombre = nombre;
		this.esConvenio = esConvenio;
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
		this.dias = dias;
		this.fecha_de_expiracion = fecha_de_expiracion;
		this.habilitado = habilitado;
	}	
	
	public Descuento(String nombre, boolean esConvenio, String descripcion, double porcentaje, String dias,
			Date fecha_de_expiracion, boolean habilitado) {
		super();
		this.nombre = nombre;
		this.esConvenio = esConvenio;
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
		this.dias = dias;
		this.fecha_de_expiracion = fecha_de_expiracion;
		this.habilitado = habilitado;
	}

	public int getDescuentoID() {
		return descuentoID;
	}

	public void setDescuentoID(int descuentoID) {
		this.descuentoID = descuentoID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEsConvenio() {
		return esConvenio;
	}

	public void setEsConvenio(boolean esConvenio) {
		this.esConvenio = esConvenio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public java.util.Date getFecha_de_expiracion() {
		return fecha_de_expiracion;
	}

	public void setFecha_de_expiracion(java.util.Date fecha_de_expiracion) {
		this.fecha_de_expiracion = fecha_de_expiracion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	@Override
	public String toString() {
		return "Descuento [descuentoID=" + descuentoID + ", nombre=" + nombre + ", esConvenio=" + esConvenio
				+ ", descripcion=" + descripcion + ", porcentaje=" + porcentaje + ", dias=" + dias
				+ ", fecha_de_expiracion=" + fecha_de_expiracion + ", habilitado=" + habilitado + "]";
	}
	
}
