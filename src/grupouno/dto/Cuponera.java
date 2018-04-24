package grupouno.dto;

import java.util.ArrayList;
import java.util.Date;

public class Cuponera {
	private int cuponeraID;
	private Cliente cliente;
	private double descuento;
	private java.util.Date fecha_de_inicio;
	private java.util.Date fecha_de_vencimiento;
	private ArrayList<Cupon> cupones;

	public Cuponera(Cliente cliente, double descuento, Date fecha_de_inicio, Date fecha_de_vencimiento,
			ArrayList<Cupon> cupones) {
		super();
		this.cuponeraID = -1;
		this.cliente = cliente;
		this.descuento = descuento;
		this.fecha_de_inicio = fecha_de_inicio;
		this.fecha_de_vencimiento = fecha_de_vencimiento;
		this.cupones = cupones;
	}

	/**
	 * Borra el cupón que está en la posición "posicion" de la cuponera
	 * @param posicion
	 * @return Cupon
	 */
	public boolean delCupon(int cuponID) {
		for (Cupon c : this.cupones){
			if (c.getCuponID() == cuponID){
				return cupones.remove(c);
			}
		}
		return false;
	}

	/**
	 * Devuelve la cantidad de cupones de la cuponera
	 * @return
	 */
	public int getCantidadDeCupones(){
		return this.cupones.size();
	}
	
	/**
	 * Agrega un cupón a la cuponera con los datos especificados
	 * @param servicioID
	 * @param fecha_concretado
	 * @return
	 */
	public boolean addCupon(Cupon c) {
		return this.cupones.add(c);
	}
	
	public boolean contieneCupon(int cuponID){
		for (Cupon c : this.cupones){
			if (c.getCuponID() == cuponID){
				return true;
			}
		}
		return false;		
	}
	
	public Cupon getCuponPorId(int cuponID){
		for (Cupon c : this.cupones){
			if (c.getCuponID() == cuponID){
				return c;
			}
		}
		return null;
	}
	
	public Cupon getCupon(int posicion){
		return this.cupones.get(posicion);
	}
	
	public int getCuponeraID() {
		return cuponeraID;
	}

	public void setCuponeraID(int cuponeraID) {
		this.cuponeraID = cuponeraID;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setClienteID(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public java.util.Date getFecha_de_inicio() {
		return fecha_de_inicio;
	}

	public void setFecha_de_inicio(java.util.Date fecha_de_inicio) {
		this.fecha_de_inicio = fecha_de_inicio;
	}

	public java.util.Date getFecha_de_vencimiento() {
		return fecha_de_vencimiento;
	}

	public void setFecha_de_vencimiento(java.util.Date fecha_de_vencimiento) {
		this.fecha_de_vencimiento = fecha_de_vencimiento;
	}

	public ArrayList<Cupon> getCupones() {
		return cupones;
	}

	public void setCupones(ArrayList<Cupon> cupones) {
		this.cupones = cupones;
	}

	@Override
	public String toString() {
		return "Cuponera [cuponeraID=" + cuponeraID + ", clienteID=" + cliente + ", descuento=" + descuento
				+ ", fecha_de_inicio=" + fecha_de_inicio + ", fecha_de_vencimiento=" + fecha_de_vencimiento
				+ ", cupones=" + cupones + "]";
	}
	
}
