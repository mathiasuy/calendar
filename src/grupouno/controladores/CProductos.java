package grupouno.controladores;

import java.util.ArrayList;

import grupouno.dto.Producto;
import grupouno.interfaces.IMetodosDAO;

public class CProductos implements IMetodosDAO<Producto>{

	@Override
	public int alta(Producto c)	{
		
		return FACTORY_DAO.getDAOProductos().alta(c);
	}

	@Override
	public int baja(Object key) {
		
		return FACTORY_DAO.getDAOProductos().baja(key);
	}

	@Override
	public int modificar(Producto c) {
		
		return FACTORY_DAO.getDAOProductos().modificar(c);
	}

	@Override
	public Producto obtener(Object key) {
		
		return FACTORY_DAO.getDAOProductos().obtener(key);
	}

	@Override
	public ArrayList<Producto> listar()	{
		
		return FACTORY_DAO.getDAOProductos().listar();
	}

	@Override
	public ArrayList<Producto> filtro(String campo, String filter) {
		
		return FACTORY_DAO.getDAOProductos().filtro(campo, filter);
	}	
	
}
