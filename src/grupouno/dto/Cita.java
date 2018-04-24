package grupouno.dto;

import java.util.ArrayList;
import java.util.Date;

public class Cita {
	private int citaID;
	private Cliente cliente;
	private Empleado empleado;
	private String descripcion;
	private java.util.Date fecha_registrada;
	private java.util.Date fecha_de_cita;
	private boolean concretada;
	private ArrayList<ItemCita> item;

	
	
	
	public boolean addItem(ItemCita i) {
		return this.item.add(i);
	}
	
	public ItemCita getItem( int posicion){
		return this.item.get(posicion);
	}	
	
	public ItemCita getItemPorId(int itemID){
		for (ItemCita c : this.item){
			if(c.getItemID() == itemID){
				return c;
			}
		}
		return null;
	}
	
	public boolean contieneItem(int itemID){
		for (ItemCita c : this.item){
			if(c.getItemID() == itemID){
				return true;
			}
		}
		return false;		
	}
	
	public boolean delItem( int itemID){
		for (ItemCita k : this.item){
			if (k.getItemID() == itemID){
				return item.remove(k);
			}
		}
		return false;
	}
	
	public int getCantidadDeItems(){
		return this.item.size();
	}
	
	public Cita(Cliente cliente, Empleado empleado, String descripcion, Date fecha_registrada, Date fecha_de_cita,
			boolean concretada, ArrayList<ItemCita> item) {
		super();
		this.cliente = cliente;
		this.empleado = empleado;
		this.descripcion = descripcion;
		this.fecha_registrada = fecha_registrada;
		this.fecha_de_cita = fecha_de_cita;
		this.concretada = concretada;
		this.item = item;
	}

	public int getCitaID() {
		return citaID;
	}

	public void setCitaID(int citaID) {
		this.citaID = citaID;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
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

	public java.util.Date getFecha_de_cita() {
		return fecha_de_cita;
	}

	public void setFecha_de_cita(java.util.Date fecha_de_cita) {
		this.fecha_de_cita = fecha_de_cita;
	}

	public boolean isConcretada() {
		return concretada;
	}

	public void setConcretada(boolean concretada) {
		this.concretada = concretada;
	}

	public ArrayList<ItemCita> getItem() {
		return item;
	}

	public void setItem(ArrayList<ItemCita> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Cita [citaID=" + citaID + ", cliente=" + cliente + ", empleado=" + empleado + ", descripcion="
				+ descripcion + ", fecha_registrada=" + fecha_registrada + ", fecha_de_cita=" + fecha_de_cita
				+ ", concretada=" + concretada + ", item=" + item + "]";
	}



}
