package grupouno.interfaces;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dao.FactoryDAO;

public interface IMetodos  <Objeto> 
{
	public final FactoryDAO FACTORY_DAO = new FactoryDAO();

	/**
     * Crea el objeto en la base de datos
     * @param c 
     * @return true=exito, false=error
     */    
    public int alta(Objeto c);

    /**
     * borra el objeto de la bd
     * @param key identificador tipo int
     * @return true=exito, false=error
     */    
    public int baja(Object key);

    /**
     *  actualiza el objeto
     * @param c  representa el id del objeto
     * @return true=exito, false=error
     */    
    public int modificar(Objeto c);

    /**
     * Obtiene el objeto de la bd
     * @param key identificador, tipo int
     * @return 
     */    
    public Objeto obtener(Object key);

    /**
     * Devuelve todos los elementos de la bd de el tipo indicado
     * @return 
     */    
    public ArrayList<Objeto> listar();

     /**
     * Devuelve todos los elementos de la bd que contengan filter y sean de el tipo indicado
     * @param campo columna de la bd, DEBE EXISTIR
     * @param filter filtro a aplicar
     * @return lista acorde
     */
    public ArrayList<Objeto> filtro(String campo, String filter);

    /**
     * Devuelve la lista de elementos de la busqueda between sobre columna columna_entre y con el filtro tipo con los objetos del tipo indicado
     * @param columna_entre columna, tipo Date, de la bd, de la que se hace la busqueda
     * @param desde fecha desde
     * @param hasta fecha hasta
     * @return la lista
     */    
    public ArrayList<Objeto> entreFechas(String columna_entre, Date desde, Date hasta);

    /**
     * Devuelve la lsita de objetos del tipo adecuado, igual que betweenByDate, pero ademas filtra por columna_filtro
     * @param columna_entre columna, tipo Date, en la que se aplica desde hasta
     * @param desde inicio del rango a aplicar sobre columna_entre
     * @param hasta fin del rango a aplicar sobre columna_entre
     * @param columna_filtro columna a aplicar el filtro opcion_columna
     * @param opcion_columna filtro a aplicar sobre columna_filtro
     * @return 
     */    
    public ArrayList<Objeto> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,String opcion_columna);


}
