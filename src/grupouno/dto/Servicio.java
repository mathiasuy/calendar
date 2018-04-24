package grupouno.dto;

import java.util.ArrayList;

public class Servicio {
	private int servicioID;
	private String nombre;
	private int duracion;
	private String descripcion;
	private double precio;
	private ArrayList<Producto> productos;
	/**
	 * Descuentos asociados a este servicio
	 */
	private ArrayList<Descuento> descuentos;

	public Servicio(String nombre, int duracion, String descripcion, double precio, ArrayList<Producto> productos,
			ArrayList<Descuento> descuentos) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.precio = precio;
		this.productos = productos;
		this.descuentos = descuentos;
	}

	public Servicio(String nombre, int duracion, String descripcion, double precio) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public boolean contieneDescuento(int descuentoID){
		for (Descuento p : this.descuentos){
			if (p.getDescuentoID() == descuentoID){
				return true;
			}
		}
		return false;		
	}
	
	public boolean delDescuento(int descuentoID) {
		for (Descuento p : this.descuentos){
			if (p.getDescuentoID() == descuentoID){
				return this.descuentos.remove(p);
			}
		}
		return false;
	}

	
	public boolean addDescuento(Descuento descuento) {
		return this.descuentos.add(descuento);
	}


	public boolean delProducto(int productoID) {
		for (Producto p : this.productos){
			if (p.getProductoID() == productoID){
				return this.productos.remove(p);
			}
		}
		return false;
	}

	
	public boolean addProducto(Producto producto) {
		return this.productos.add(producto);
	}
	
	
	public boolean contieneProducto(int productoID){
		for (Producto p : this.productos){
			if (p.getProductoID()==productoID){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Descuento> getDescuentos() {
		return descuentos;
	}


	public void setDescuentos(ArrayList<Descuento> descuentos) {
		this.descuentos = descuentos;
	}

	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getServicioID() {
		return servicioID;
	}

	public void setServicioID(int servicioID) {
		this.servicioID = servicioID;
	}

	@Override
	public String toString() {
		return "Servicio [servicioID=" + servicioID + ", nombre=" + nombre + ", duracion=" + duracion + ", descripcion="
				+ descripcion + ", precio=" + precio + "]";
	}
	
}
