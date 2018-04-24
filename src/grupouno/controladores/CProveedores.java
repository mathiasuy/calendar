package grupouno.controladores;

import java.util.ArrayList;

import grupouno.conexion.Conectar;
import grupouno.dao.FactoryDAO;
import grupouno.dao.consultas.FactoryConsultas;
import grupouno.dto.Cuponera;
import grupouno.dto.Proveedor;
import grupouno.interfaces.IMetodosDAO;

public class CProveedores  implements IMetodosDAO<Proveedor>{

	
 
//	public final FactoryConsultas CONSULTAS = new FactoryConsultas();
//	public final FactoryDAO FACTORY_DAO = new FactoryDAO();
	//public final Conectar CONNECTION = Conectar.estado();	

	
	@Override
	public int alta(Proveedor c) {
		
		return FACTORY_DAO.getDAOProveedores().alta(c);
	}

	@Override
	public int baja(Object key) {
		// TODO Auto-generated method stub
		Proveedor o = obtener(key);
		if (FACTORY_DAO.getDAOProductos().listarProductosXProveedor((int)key).isEmpty()){
			return FACTORY_DAO.getDAOProveedores().baja(key);
		}else{
			throw new Error("No se puede borrar el proveedor porque hay productos asociados.");
		}
	}

	
	private boolean esIgual(Proveedor p, Proveedor q){
		if (!p.getNombre().equals(q)){
			return false; 
		} else if (!p.getDescripcion().equals(q)){
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public int modificar(Proveedor c) {
		// TODO Auto-generated method stub
		ArrayList<Proveedor> proveedores = FACTORY_DAO.getDAOProveedores().listar(); 
		boolean igual = false;
		for(Proveedor p : proveedores){
			if(esIgual(c, p)){
				igual = true;
			}
		}
//		if (!igual){
//			FACTORY_DAO.getDAOProveedores().modificar(c);
//		}else{
//			throw new Error("");
//		}
		return 1;
	}

	@Override
	public Proveedor obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOProveedores().obtener(key);
	}

	@Override
	public ArrayList<Proveedor> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOProveedores().listar();
	}

	@Override
	public ArrayList<Proveedor> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOProveedores().filtro(campo, filter);
	}

}
