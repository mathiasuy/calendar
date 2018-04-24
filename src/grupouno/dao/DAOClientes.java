package grupouno.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasClientes;
import grupouno.dto.Cliente;
import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

public class DAOClientes implements IMetodosDAO<Cliente>
{
	private static final Conectar CONNECTION = Conectar.estado();
	private static int retorno = 0;
    private CallableStatement ps;
    private Cliente cliente = null;
    private ResultSet rs;            
    private ArrayList<Cliente> l;
    private final ConsultasClientes consultar = CONSULTAS.getConsultasClientes();


	@Override
	public int alta(Cliente c)
	{
		 try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.alta());	            
	            ps.setString(1, c.getNombre());
	            ps.setString(2, c.getDocumento());
	            ps.setDate(3, Utilidades.aSQL(c.getFecha_de_nacimiento()));
	            ps.setString(4, c.getComentarios());
	            ps.setString(5, c.getTelefono());
	            ps.setString(6, c.getUsuario());
	            ps.setString(7, c.getContrasena());
	            ps.setBoolean(8, c.isHabilitado());
	            ps.setInt(9,c.getDescuento().getDescuentoID());
	            ps.registerOutParameter(10, java.sql.Types.INTEGER);            
	            
	            ps.execute();
            	retorno = ps.getInt(10);
           		c.setPersonaID(retorno);
	        } catch (Exception e) {
	            throw new Error("ERROR "+Mensajes.ALTA_CLIENTE + e.getMessage() + " en " + this.getClass().getName());
	        }finally{
	           CONNECTION.cerrarConexion();
	        }
	        return retorno;
	}

	@Override
	public int baja(Object key) 
	{
		 try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.baja());
	            ps.setInt(1, (Integer.parseInt(key.toString())));
	            ps.registerOutParameter(2, java.sql.Types.INTEGER);  
	            retorno = ps.getInt(2);          
		 }catch (Exception e) {
	            throw new Error("ERROR "+Mensajes.BAJA_CLIENTE + e.getMessage() + " en " + this.getClass().getName());
	        }finally{
	           CONNECTION.cerrarConexion();
	        }
		 
		 return retorno;    
	}

	@Override
	public int modificar(Cliente c) 
	{
		try{
			ps = CONNECTION.getConnection().prepareCall(consultar.modificar());
			ps.setInt(1, c.getPersonaID());
			ps.setString(2, c.getNombre());
            ps.setString(3, c.getDocumento());
            ps.setDate(4, Utilidades.aSQL(c.getFecha_de_nacimiento()));
            ps.setString(5, c.getComentarios());
            ps.setString(6, c.getTelefono());
            ps.setString(7, c.getUsuario());
            ps.setString(8, c.getContrasena());
            ps.setBoolean(9, c.isHabilitado());
            ps.setInt(10,c.getDescuento().getDescuentoID());
            ps.registerOutParameter(11, java.sql.Types.INTEGER); 
            
            ps.execute();     		
           	retorno= ps.getInt(11);           	
		}
		catch (Exception e) {
            throw new Error("ERROR "+Mensajes.MODIFICAR_CLIENTE + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONNECTION.cerrarConexion();
        }
		
		return retorno;
	}

	@Override
	public Cliente obtener(Object key) 
	{
		 try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.obtener());
	            ps.setInt(1,(int)key);
	            ps.execute();
	            rs = ps.getResultSet();
	            while(rs.next()){
	            	cliente = new Cliente(
	            					rs.getString("nombre"),
	            		            rs.getString("documento"),
	            		            Utilidades.aUtil(rs.getDate("fecha_de_nacimiento")),
	            		            Utilidades.aUtil(rs.getDate("fecha_registrado")),
	            		            rs.getString("comentarios"),
	            		            rs.getString("telefono"),
	            		            rs.getString("usuario"),
	            		            rs.getString("contrasena"),
	            		            rs.getBoolean("habilitado"),
	            		            FACTORY_DAO.getDAODescuentos().obtener(rs.getInt("descuentoID"))
	                		 );
	            	 cliente.setPersonaID((int)key);
	            	
	            }
		 }catch (SQLException ex) {
	            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CLIENTE + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return cliente;
	}


	@Override
	public ArrayList<Cliente> listar() 
	{
		l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareCall(consultar.listar("nombre"));
            ps.execute();
            rs = ps.getResultSet();
            while(rs.next()){
                cliente = new Cliente(
    					rs.getString("nombre"),
    		            rs.getString("documento"),
    		            Utilidades.aUtil(rs.getDate("fecha_de_nacimiento")),
    		            Utilidades.aUtil(rs.getDate("fecha_registrado")),
    		            rs.getString("comentarios"),
    		            rs.getString("telefono"),
    		            rs.getString("usuario"),
    		            rs.getString("contrasena"),
    		            rs.getBoolean("habilitado"),
    		            FACTORY_DAO.getDAODescuentos().obtener(rs.getInt("descuentoID"))
               		 );
                cliente.setPersonaID(rs.getInt("ClienteID"));
                l.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_CLIENTES + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Cliente> filtro(String campo, String filter) 
	{
		  l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.buscar(campo, "nombre"));
	            ps.setString(1, "%"+filter+"%");
	            ps.execute();
	            rs = ps.getResultSet();
	            while(rs.next()){
	                cliente = new Cliente(
        					rs.getString("nombre"),
        		            rs.getString("documento"),
        		            Utilidades.aUtil(rs.getDate("fecha_de_nacimiento")),
        		            Utilidades.aUtil(rs.getDate("fecha_registrado")),
        		            rs.getString("comentarios"),
        		            rs.getString("telefono"),
        		            rs.getString("usuario"),
        		            rs.getString("contrasena"),
        		            rs.getBoolean("habilitado"),
        		            FACTORY_DAO.getDAODescuentos().obtener(rs.getInt("descuentoID"))
	                  		 );
	                cliente.setPersonaID(rs.getInt("ClienteID"));
	                l.add(cliente);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_CLIENTES + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
	}
	
}