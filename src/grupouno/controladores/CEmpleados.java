package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;
import grupouno.dto.Empleado;
import grupouno.interfaces.IMetodos;
import grupouno.interfaces.IMetodosDAO;

public class CEmpleados implements IMetodosDAO<Empleado>{

	@Override
	public int alta(Empleado c) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOEmpleados().alta(c);
	}

	@Override
	public int baja(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOEmpleados().baja(key);
	}

	@Override
	public int modificar(Empleado c) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOEmpleados().modificar(c);
	}

	@Override
	public Empleado obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOEmpleados().obtener(key);
	}

	@Override
	public ArrayList<Empleado> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOEmpleados().listar();
	}

	@Override
	public ArrayList<Empleado> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOEmpleados().filtro(campo, filter);
	}
	
}


