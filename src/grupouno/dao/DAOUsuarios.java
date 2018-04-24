package grupouno.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasProductos;
import grupouno.dao.consultas.ConsultasUsuarios;
import grupouno.dao.consultas.FactoryConsultas;
import grupouno.dto.Empleado;
import grupouno.dto.Usuario;
import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

public class DAOUsuarios 
{
    private static int retorno = 0;
    private static final Conectar CONNECTION = Conectar.estado();
    private CallableStatement ps;
    private Usuario usuario = null;
    private ResultSet rs;            
    private ArrayList<Usuario> l;
    private final ConsultasUsuarios consultar = (new FactoryConsultas()).getConsultasUsuarios();
    
    public int Login(Usuario c)
    {
    	try
    	{
            ps = CONNECTION.getConnection().prepareCall(consultar.Login());
            ps.setString(1, c.getUsuarioID());
            ps.setString(2, c.getContrasena());
            ps.registerOutParameter(3, java.sql.Types.INTEGER);
            
            
            retorno = ps.getInt(3);
            
           
        } catch (Exception e) {
            throw new Error("ERROR "+Mensajes.LOGIN + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONNECTION.cerrarConexion();
        }
    	
        return retorno;  
    }
    
    public int cambiarContrasena(String usuario,String contrasena)
    {
    	try
    	{
            ps = CONNECTION.getConnection().prepareCall(consultar.cambiarContrasena());
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            
            ps.execute();
            
            retorno = 1;
            	
            
    	}
    	
    	catch (Exception e) {
            throw new Error("ERROR "+Mensajes.CAMBIAR_PASS + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONNECTION.cerrarConexion();
        }
    	  	
    	return retorno;
    }
    
    
    
    public ArrayList<Usuario> listar() 
	{
		l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareCall(consultar.listar("nombre"));
            ps.execute();
            rs = ps.getResultSet();
            while(rs.next())
            {
                usuario = new Usuario(
                		rs.getString("usuarioID"), 
                		rs.getString("contrasena"), 
                		Utilidades.aUtil(rs.getDate("fecha_de_registro")) 
               		 );
                usuario.setUsuarioID(rs.getString("Usuario"));
                l.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_USUARIOS + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}
}