package grupouno.dao;

public class FactoryDAO {
	
	public FactoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public DAOProveedores getDAOProveedores(){
		return new DAOProveedores();
	}

	public DAOClientes getDAOClientes(){
		return new DAOClientes();
	}
	
	public DAOCitas getDAOCitas(){
		return new DAOCitas();
	}
	
	public DAOCuponeras getDAOCuponeras(){
		return new DAOCuponeras();
	}
	
	public DAODescuentos getDAODescuentos(){
		return new DAODescuentos();
	}

	public DAOEmpleados getDAOEmpleados(){
		return new DAOEmpleados();
	}
	
	public DAOProductos getDAOProductos(){
		return new DAOProductos();
	}
	
	public DAOServicios getDAOServicios(){
		return new DAOServicios();
	}
	
	public DAOTelefonosProveedores getDAOTelefonosProveedores(){
		return new DAOTelefonosProveedores();
	}
	
	public DAOUsuarios getDAOUsuarios(){
		return new DAOUsuarios();
	}

	public DAOCitasSimples getDAOCitasSimples() {
		// TODO Auto-generated method stub
		return new DAOCitasSimples();
	}

}
