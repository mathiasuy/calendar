package grupouno.dao.consultas;

public class FactoryConsultas {

	public FactoryConsultas (){
	}
	
	public ConsultasClientes getConsultaClientes(){
		return new ConsultasClientes();
	}
	
	public ConsultasDescuentos getConsultaDescuentos(){
		return new ConsultasDescuentos();
	}
	
	public ConsultasEmpleados getConsultasEmpleados(){
		return new ConsultasEmpleados();
	};
	
	public ConsultasProductos getConsultasProductos(){
		return new ConsultasProductos();
	}
	
	public ConsultasProveedores getConsultasProveedores(){
		return new ConsultasProveedores();
	}
	
	public ConsultasServicios getConsultasServicios(){
		return new ConsultasServicios();
	}
	
	public ConsultasTelefonosProveedores getConsultasTelefonosProveedores(){
		return new ConsultasTelefonosProveedores();
	}
	
	public ConsultasUsuarios getConsultasUsuarios(){
		return new ConsultasUsuarios();
	}

	public ConsultasDescuentos getConsultasDescuentos() {
		// TODO Auto-generated method stub
		return new ConsultasDescuentos();
	}

	public ConsultasClientes getConsultasClientes() {
		// TODO Auto-generated method stub
		return new ConsultasClientes();
	}

	public ConsultasCitas getConsultasCitas() {
		// TODO Auto-generated method stub
		return new ConsultasCitas();
	}

	public ConsultasCuponeras getConsultasCuponeras() {
		// TODO Auto-generated method stub
		return new ConsultasCuponeras();
	}

	public ConsultasCitasSimples getConsultasCitaSimples() {
		// TODO Auto-generated method stub
		return new ConsultasCitasSimples();
	}
}
