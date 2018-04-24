package grupouno.dto;

public class ItemCita {
	private int itemID;
	private int citaID;
	private Descuento descuento;
	private int duracion;
	private double precio;
	private Servicio servicio;

	public ItemCita(int itemID, Descuento descuento, int duracion, double precio, Servicio servicio) {
		super();
		this.itemID = itemID;
		this.descuento = descuento;
		this.duracion = duracion;
		this.precio = precio;
		this.servicio = servicio;
	}

	
	
	public int getItemID() {
		return itemID;
	}



	public void setItemID(int itemID) {
		this.itemID = itemID;
	}



	public int getCitaID() {
		return citaID;
	}

	public void setCitaID(int citaID) {
		this.citaID = citaID;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicioID(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "ItemCita [citaID=" + citaID + ", descuento=" + descuento + ", duracion=" + duracion + ", precio="
				+ precio + ", servicioID=" + servicio + "]";
	}
	
	
	
}
