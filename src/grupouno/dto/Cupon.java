package grupouno.dto;

import java.util.Date;

public class Cupon {
	private int cuponID;
	private int cuponeraID;
	private int servicioID;
	private java.util.Date fecha_concretado;
	
	public Cupon(int cuponID, int cuponeraID, int servicioID, Date fecha_concretado) {
		super();
		this.cuponID = cuponID;
		this.cuponeraID = cuponeraID;
		this.servicioID = servicioID;
		this.fecha_concretado = fecha_concretado;
	}

	public int getCuponID() {
		return cuponID;
	}

	public void setCuponID(int cuponID) {
		this.cuponID = cuponID;
	}

	public int getCuponeraID() {
		return cuponeraID;
	}

	public void setCuponeraID(int cuponeraID) {
		this.cuponeraID = cuponeraID;
	}

	public int getServicioID() {
		return servicioID;
	}

	public void setServicioID(int servicioID) {
		this.servicioID = servicioID;
	}

	public java.util.Date getFecha_concretado() {
		return fecha_concretado;
	}

	public void setFecha_concretado(java.util.Date fecha_concretado) {
		this.fecha_concretado = fecha_concretado;
	}

	@Override
	public String toString() {
		return "Cupon [cuponID=" + cuponID + ", cuponeraID=" + cuponeraID + ", servicioID=" + servicioID
				+ ", fecha_concretado=" + fecha_concretado + "]";
	}

	
	
}