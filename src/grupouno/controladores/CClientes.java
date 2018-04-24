package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dto.Cliente;
import grupouno.interfaces.IMetodos;
import grupouno.interfaces.IMetodosDAO;

public class CClientes implements IMetodosDAO<Cliente>{

	@Override
	public int alta(Cliente c) {
		
		return FACTORY_DAO.getDAOClientes().alta(c);
	}

	@Override
	public int baja(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOClientes().baja(key);
	}

	@Override
	public int modificar(Cliente c) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOClientes().modificar(c);
	}

	@Override
	public Cliente obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOClientes().obtener(key);
	}

	@Override
	public ArrayList<Cliente> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOClientes().listar();
	}

	@Override
	public ArrayList<Cliente> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOClientes().filtro(campo, filter);
	}

}


