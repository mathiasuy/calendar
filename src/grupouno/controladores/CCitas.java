package grupouno.controladores;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.dao.DAOCitas;
import grupouno.dao.Mensajes;
import grupouno.dto.Cita;
import grupouno.dto.ItemCita;
import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

public class CCitas implements IMetodosDAO<Cita>{

	private void validarCita(Cita c) {
		// TODO Auto-generated method stub
//		if (c.getFecha_de_cita().compareTo(new java.util.Date())<0){
//			throw new Error("La fecha de la cita es anterior a hoy")
//		}
	}
	
	private void validarItems(ArrayList<ItemCita> items) {
		// TODO Auto-generated method stub
//		for (ItemCita i : items){
//			if ()
//		}
	}
	
	@Override
	public int alta(Cita c) {
		if (FACTORY_DAO.getDAOCitas().alta(c)<=0){
			throw new Error("No se pudo agendar la cita");
		}
		return 1;
	}

	@Override
	public int baja(Object key) {
		// TODO Auto-generated method stub
		ArrayList<ItemCita> items = FACTORY_DAO.getDAOCitas().listarItemsXCita((int)key);
		Cita c = FACTORY_DAO.getDAOCitas().obtener(key);
		quitarItems(c);
		if (FACTORY_DAO.getDAOCitas().baja(key) <= 0){
			throw new Error("No se pudo dar de baja la cita");
		}
		return 1;
	}

	@Override
	public int modificar(Cita c) {
		// TODO Auto-generated method stub

		return FACTORY_DAO.getDAOCitas().modificar(c);
	}

	public void agregarItems(ArrayList<ItemCita> l, int citaID) {
		// TODO Auto-generated method stub
		validarItems(l);
		FACTORY_DAO.getDAOCitas().agregarItems(citaID, l);
	}
	
	public void quitarItems(Cita c){
		int[] affectedRows = FACTORY_DAO.getDAOCitas().quitarItems(c.getCitaID(), c.getItem());
		int cant = 0;
		for (int f : affectedRows){
			cant+=(f>0)?1:0;
		}
		if(cant<c.getCantidadDeItems()){
			throw new Error("No se pudo quitar los items de la cita");
		};
	}
	
	@Override
	public Cita obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitas().obtener(key);
	}

	@Override
	public ArrayList<Cita> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitas().listar();
	}

	private void listarItemsXCita() {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<ItemCita> listarItemsXCita(int key) {
		if (FACTORY_DAO.getDAOCitas().obtener(key)==null){
			throw new Error("No hay cita registrada con ese identificador "+key);
		}
		return FACTORY_DAO.getDAOCitas().listarItemsXCita(key);
	}	
	
    /**
     * Devuelve la lista de elementos de la busqueda between sobre columna columna_entre y con el filtro tipo con los objetos del tipo indicado
     * @param desde fecha desde
     * @param hasta fecha hasta
     * @return la lista
     */    
	public ArrayList<Cita> entreFechas(Date desde, Date hasta) {
		return  FACTORY_DAO.getDAOCitas().entreFechas(desde, hasta);
	}

    /**
     * Devuelve la lista de elementos de la busqueda citas del día
     * @param fecha 
     * @return la lista
     */    
	public ArrayList<Cita> delDia(Date dia) {
		return FACTORY_DAO.getDAOCitas().delDia(dia);
	}		
	
	
    /**
     * Devuelve la lsita de objetos del tipo adecuado, igual que betweenByDate, pero ademas filtra por columna_filtro
     * @param desde inicio del rango a aplicar sobre columna_entre
     * @param hasta fin del rango a aplicar sobre columna_entre
     * @param columna_filtro columna a aplicar el filtro filtro Puede ser: NombreCliente, NombreEmpleado, NombreServicio, DescripcionServicio, NombreDescuento, DescripcionDescuento
     * @param filtro filtro a aplicar sobre columna_filtro
     * @return 
     */    
    public ArrayList<Cita> entreFechasYFiltro(Date desde, Date hasta, String columna_filtro,String filtro){
    	return FACTORY_DAO.getDAOCitas().entreFechasYFiltro(desde, hasta, columna_filtro, filtro);
	}
    
	public ArrayList<Cita> filtro(String filter) {
		return null;
	}	    	

	
	@Override
	public ArrayList<Cita> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOCitas().filtro(campo, filter);
	}

}
