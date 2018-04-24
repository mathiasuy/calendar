package grupouno.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.conexion.MensajeError;
import grupouno.dao.consultas.Consultas;
import grupouno.dao.consultas.ConsultasDescuentos;
import grupouno.dao.consultas.ConsultasEmpleados;
import grupouno.dto.Descuento;
import grupouno.dto.Empleado;
import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

public class DAOEmpleados implements IMetodosDAO<Empleado>
{
	private static int retorno = 0;
    private CallableStatement ps;
    private Empleado empleado = null;
    private ResultSet rs;            
    private ArrayList<Empleado> l;
    private final ConsultasEmpleados consultar = CONSULTAS.getConsultasEmpleados();


	@Override
	public int alta(Empleado c)
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
	            ps.setDate(9, Utilidades.aSQL(c.getFecha_vencimiento_carnet_de_salud()));
	            ps.setDouble(10, c.getSueldo());
	            ps.registerOutParameter(11, java.sql.Types.INTEGER);            
	            
	            ps.execute();
            	retorno = ps.getInt(11);
           		c.setPersonaID(retorno);
	        } catch (Exception e) {
	            throw new Error("ERROR "+Mensajes.ALTA_EMPLEADO + e.getMessage() + " en " + this.getClass().getName());
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
	            throw new Error("ERROR "+Mensajes.BAJA_EMPLEADO + e.getMessage() + " en " + this.getClass().getName());
	        }finally{
	           CONNECTION.cerrarConexion();
	        }
		 
		 return retorno;    
	}

	@Override
	public int modificar(Empleado c) 
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
            ps.setDate(10, Utilidades.aSQL(c.getFecha_vencimiento_carnet_de_salud()));
            ps.setDouble(11, c.getSueldo());
            ps.registerOutParameter(12, java.sql.Types.INTEGER); 
            ps.execute();     		
           	retorno= ps.getInt(12);           	
		}
		catch (Exception e) {
            throw new Error("ERROR "+Mensajes.MODIFICAR_EMPLEADO + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONNECTION.cerrarConexion();
        }
		
		return retorno;
	}

	@Override
	public Empleado obtener(Object key) 
	{
		 try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.obtener());
	            ps.setInt(1,(int)key);
	            ps.execute();
	            rs = ps.getResultSet();
	            while(rs.next()){
	            	empleado = new Empleado(
	            					rs.getString("nombre"),
	            		            rs.getString("documento"),
	            		            Utilidades.aUtil(rs.getDate("fecha_de_nacimiento")),
	            		            Utilidades.aUtil(rs.getDate("fecha_registrado")),
	            		            rs.getString("comentarios"),
	            		            rs.getString("telefono"),
	            		            rs.getString("usuario"),
	            		            rs.getString("contrasena"),
	            		            rs.getBoolean("habilitado"),
	            		            Utilidades.aUtil(rs.getDate("fecha_vencimiento_carnet_de_salud")),
	            		            rs.getDouble("sueldo")  
	                		 );
	            	 empleado.setPersonaID((int)key);
	            	
	            }
		 }catch (SQLException ex) {
	            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_EMPLEADO + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return empleado;
	}


	@Override
	public ArrayList<Empleado> listar() 
	{
		l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareCall(consultar.listar("nombre"));
            ps.execute();
            rs = ps.getResultSet();
            while(rs.next()){
                empleado = new Empleado(
                		rs.getString("nombre"),
    		            rs.getString("documento"),
    		            Utilidades.aUtil(rs.getDate("fecha_de_nacimiento")),
    		            Utilidades.aUtil(rs.getDate("fecha_registrado")),
    		            rs.getString("comentarios"),
    		            rs.getString("telefono"),
    		            rs.getString("usuario"),
    		            rs.getString("contrasena"),
    		            rs.getBoolean("habilitado"),
    		            Utilidades.aUtil(rs.getDate("fecha_vencimiento_carnet_de_salud")),
    		            rs.getDouble("sueldo")  
               		 );
                empleado.setPersonaID(rs.getInt("EmpleadoID"));
                l.add(empleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_EMPLEADOS + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Empleado> filtro(String campo, String filter) 
	{
		  l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.buscar(campo, "nombre"));
	            ps.setString(1, "%"+filter+"%");
	            ps.execute();
	            rs = ps.getResultSet();
	            while(rs.next()){
	                empleado = new Empleado(
	                		rs.getString("nombre"),
	    		            rs.getString("documento"),
	    		            Utilidades.aUtil(rs.getDate("fecha_de_nacimiento")),
	    		            Utilidades.aUtil(rs.getDate("fecha_registrado")),
	    		            rs.getString("comentarios"),
	    		            rs.getString("telefono"),
	    		            rs.getString("usuario"),
	    		            rs.getString("contrasena"),
	    		            rs.getBoolean("habilitado"),
	    		            Utilidades.aUtil(rs.getDate("fecha_vencimiento_carnet_de_salud")),
	    		            rs.getDouble("sueldo")  
	                  		 );
	                empleado.setPersonaID(rs.getInt("EmpleadoID"));
	                l.add(empleado);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_EMPLEADOS + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
	}

}