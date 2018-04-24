package grupouno.controladores;

import java.util.ArrayList;

import grupouno.dto.Cuponera;
import grupouno.dto.TelefonoProveedor;
import grupouno.dto.TelefonoProveedor;
import grupouno.interfaces.IMetodosDAO;

public class CTelefonosProveedores  implements IMetodosDAO<TelefonoProveedor>{

	@Override
	public int alta(TelefonoProveedor c) {
		
		return FACTORY_DAO.getDAOTelefonosProveedores().alta(c);
	}

	@Override
	public int baja(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOTelefonosProveedores().baja(key);
	}

	@Override
	public int modificar(TelefonoProveedor c) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOTelefonosProveedores().modificar(c);
	}

	@Override
	public TelefonoProveedor obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOTelefonosProveedores().obtener(key);
	}

	@Override
	public ArrayList<TelefonoProveedor> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOTelefonosProveedores().listar();
	}

	@Override
	public ArrayList<TelefonoProveedor> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOTelefonosProveedores().filtro(campo, filter);
	}

}
