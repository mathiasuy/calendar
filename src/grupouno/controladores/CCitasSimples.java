package grupouno.controladores;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import grupouno.dto.CitaSimple;
import grupouno.interfaces.IMetodosDAO;

public class CCitasSimples implements IMetodosDAO<CitaSimple>{

	private void validar(CitaSimple c) {
		// TODO Auto-generated method stub
		if (c.getCliente().trim().isEmpty()){
			throw new Error("Debe ingresar un cliente");
		}
	}
	
	@Override
	public int alta(CitaSimple c) {
		// TODO Auto-generated method stub
		validar(c);
		return FACTORY_DAO.getDAOCitasSimples().alta(c);
	}

	@Override
	public int baja(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitasSimples().baja(key);
	}

	@Override
	public int modificar(CitaSimple c) {
		// TODO Auto-generated method stub
		validar(c);
		return FACTORY_DAO.getDAOCitasSimples().modificar(c);
	}

	@Override
	public CitaSimple obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitasSimples().obtener(key);
	}

	@Override
	public ArrayList<CitaSimple> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitasSimples().listar();
	}

	@Override
	public ArrayList<CitaSimple> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitasSimples().filtro(campo, filter);
	}

	public ArrayList<CitaSimple> entreFechas(LocalDate desde, LocalDate hasta) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitasSimples().entreFechas(desde, hasta);
	}

	public ArrayList<CitaSimple> deHora(LocalDateTime fecha_y_hora) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitasSimples().deHora(fecha_y_hora);
	}	
}
