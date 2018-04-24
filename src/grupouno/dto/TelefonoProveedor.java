package grupouno.dto;

public class TelefonoProveedor {
	int id;
	Proveedor proveedor;
	String nombre;
	String telefono;
	
	public TelefonoProveedor(Proveedor proveedor, String nombre, String telefono) {
		super();
		this.proveedor = proveedor;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "TelefonosProveedores [proveedorID=" + proveedor + ", nombre=" + nombre + ", telefono=" + telefono
				+ "]";
	}
	
}
