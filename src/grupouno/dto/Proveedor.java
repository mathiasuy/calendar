package grupouno.dto;

public class Proveedor {
	int proveedorID;
	private String nombre;
	private String descripcion;
	private String direccion;
	private boolean habilitado;
	public Proveedor(int proveedorID, String nombre, String descripcion, String direccion, boolean habilitado) {
		super();
		this.proveedorID = proveedorID;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.habilitado = habilitado;
	}
	public int getProveedorID() {
		return proveedorID;
	}
	public void setProveedorID(int proveedorID) {
		this.proveedorID = proveedorID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	@Override
	public String toString() {
		return "Proveedor [proveedorID=" + proveedorID + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", direccion=" + direccion + ", habilitado=" + habilitado + "]";
	}

}
