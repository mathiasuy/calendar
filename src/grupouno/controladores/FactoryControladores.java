package grupouno.controladores;

import java.util.ArrayList;

import grupouno.dto.CitaSimple;

public class FactoryControladores {
	public CCitas getCCitas() {
		return new CCitas();
	}
	public CClientes getCClientes() {
		return new CClientes();
	}
	public CCuponeras getCCuponeras() {
		return new CCuponeras();
	}
	public CDescuentos getCDescuentos() {
		return new CDescuentos();
	}
	public CEmpleados getCEmpleados() {
		return new CEmpleados();
	}
	public CProductos getCProductos() {
		return new CProductos();
	}
	public  CProveedores getCProveedores(){
		return new CProveedores();
	}
	public CServicios getCServicios(){
		return new CServicios();
	}
	public CTelefonosProveedores getCTelefonosProveedores(){
		return new CTelefonosProveedores();
	}
	public CUsuario getCUsuario(){
		return new CUsuario();
	}
	public CCitasSimples getCCitasSimples() {
		// TODO Auto-generated method stub
		return new CCitasSimples();
	}
}
