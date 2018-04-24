package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dto.Cupon;
import grupouno.dto.Cuponera;
import grupouno.dto.Descuento;
import grupouno.dto.Cuponera;
import grupouno.interfaces.IMetodosDAO;

public class CCuponeras implements IMetodosDAO<Cuponera>{

	@Override
	public int alta(Cuponera c) {
		validar(c);
		if (FACTORY_DAO.getDAOCuponeras().alta(c) <= 0){
			
		}
		return 1;
	}
	
	public void validar(Cuponera c){
		if (c.getCliente()==null){
			throw new Error("La cuponera debe tener un cliente asociado");
		}
		if (c.getFecha_de_vencimiento().compareTo(new java.util.Date())<=0){
			throw new Error("La fecha de vencimiento es anterior a hoy");
		}
	}

	@Override
	public int baja(Object key) {
		ArrayList<Cupon> cupones = FACTORY_DAO.getDAOCuponeras().listarCuponesXCuponera((int)key, "cuponeraID");
		if (cupones.isEmpty()){
			if (FACTORY_DAO.getDAOCuponeras().baja(key)<=0){
				throw new Error("No se pudo dar de baja la cuponera");
			}
		}else{
			throw new Error("No se pudo borrar porque hay cupones asociados");
		}
		return 1;
	}

	@Override
	public int modificar(Cuponera c) {
		// TODO Auto-generated method stub
		validar(c);
		if (FACTORY_DAO.getDAOCuponeras().modificar(c) <=0){
			throw new Error("No se pudo modificar la cuponera");
		}
		return 1;
	}

	@Override
	public Cuponera obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCuponeras().obtener(key);
	}

	@Override
	public ArrayList<Cuponera> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCuponeras().listar();
	}

	@Override
	public ArrayList<Cuponera> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCuponeras().filtro(campo, filter);
	}

}
