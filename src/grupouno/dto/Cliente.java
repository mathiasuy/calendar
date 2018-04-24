package grupouno.dto;

import java.util.Date;

public class Cliente  extends Persona{
	private Descuento descuento;

	public Cliente(String nombre, String documento, Date fecha_de_nacimiento, Date fecha_registrado, String comentarios,
			String telefono, String usuario, String contrasena, boolean habilitado, Descuento descuento) {
		super(nombre, documento, fecha_de_nacimiento, fecha_registrado, comentarios, telefono, usuario, contrasena,
				habilitado);
		this.descuento = descuento;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return super.toString() + "Cliente [descuento=" + descuento + "]";
	}
	
	
}
