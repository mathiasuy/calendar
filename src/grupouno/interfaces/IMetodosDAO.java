package grupouno.interfaces;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import grupouno.conexion.Conectar;
import grupouno.dao.FactoryDAO;
import grupouno.dao.consultas.FactoryConsultas;
import grupouno.dto.Descuento;

public interface IMetodosDAO <Objeto>{
	
	public final FactoryConsultas CONSULTAS = new FactoryConsultas();
	public final FactoryDAO FACTORY_DAO = new FactoryDAO();
	//public final Conectar CONNECTION = Conectar.estado();
	public static final Conectar CONNECTION = Conectar.estado();
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

 }
