package grupouno.dto;

import java.util.ArrayList;

public class Producto {
	private int productoID;
	private String nombre;
	private String marca;
	private double precio;
	private String descripcion;
	private Proveedor proveedor;
	private int stock;
	private boolean habilitado;
	private ArrayList<Descuento> descuentos;
	
	public Producto(String nombre, String marca, double precio, String descripcion, Proveedor proveedor, int stock,
			boolean habilitado, ArrayList<Descuento> descuentos) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.descripcion = descripcion;
		this.proveedor = proveedor;
		this.stock = stock;
		this.habilitado = habilitado;
		this.descuentos = descuentos;
	}

	public int getProductoID() {
		return productoID;
	}

	public void setProductoID(int productoID) {
		this.productoID = productoID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public ArrayList<Descuento> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(ArrayList<Descuento> descuentos) {
		this.descuentos = descuentos;
	}

	@Override
	public String toString() {
		return "Producto [productoID=" + productoID + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", proveedor=" + proveedor + ", stock=" + stock + ", habilitado="
				+ habilitado + ", descuentos=" + descuentos + "]";
	}

}
