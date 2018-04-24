package grupouno.controladores;

import java.util.ArrayList;

import grupouno.dto.Cuponera;
import grupouno.dto.ItemCita;
import grupouno.dto.Servicio;
import grupouno.interfaces.IMetodosDAO;

public class CServicios  implements IMetodosDAO<Servicio>{

	private void validar(Servicio c) {
		if (c.getDescripcion().trim().length() <= 8 ){
			throw new Error("La descripción del servicio debe tener al menos 8 caracteres");
		}
		if (c.getNombre().trim().length() <= 3){
			throw new Error("El nombre del servicio debe tener al menos 3 caracteres");
		}
		ArrayList<Servicio> servicios = FACTORY_DAO.getDAOServicios().listar();

		for (Servicio s : servicios){
			if (c.getServicioID() != s.getServicioID()){
				if (c.getNombre().equals(s.getNombre())) {
					throw new Error("Ya hay otro servicio con el mismo nombre.");
				}
			}
		}
	}
	
	@Override
	public int alta(Servicio c) {
		validar (c);
		if (FACTORY_DAO.getDAOServicios().alta(c)<=0){
			throw new Error("No se pudo dar de alta el Servicio");
		}
		return 1;
	}

	@Override
	public int baja(Object key) {
		
		ArrayList<ItemCita> items = FACTORY_DAO.getDAOCitas().listarItemsConServicio((int)key);
		
		if (!items.isEmpty()){
			throw new Error ("No se puede borrar el servicio, hay Citas con ese servicio agendadas.");
		}

		if (FACTORY_DAO.getDAOServicios().baja(key) <= 0){
			throw new Error("No se pudo dar de baja el Servicio");
		}
		
		return 1;
	}

	@Override
	public int modificar(Servicio c) {
		// TODO Auto-generated method stub
		validar(c);
		return FACTORY_DAO.getDAOServicios().modificar(c);
	}

	@Override
	public Servicio obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOServicios().obtener(key);
	}

	@Override
	public ArrayList<Servicio> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOServicios().listar();
	}

	@Override
	public ArrayList<Servicio> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOServicios().filtro(campo, filter);
	}

}
