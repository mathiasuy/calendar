package grupouno.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasTelefonosProveedores;
import grupouno.dto.TelefonoProveedor;
import grupouno.interfaces.IMetodosDAO;

public class DAOTelefonosProveedores implements IMetodosDAO<TelefonoProveedor>{

	private static int retorno = 0;
    private PreparedStatement ps;
    private TelefonoProveedor telefono = null;
    private ResultSet rs;            
    private ArrayList<TelefonoProveedor> l;
    private final ConsultasTelefonosProveedores consultar = CONSULTAS.getConsultasTelefonosProveedores();
	
	@Override
	public int alta(TelefonoProveedor c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.alta());
            ps.setInt(1, c.getProveedor().getProveedorID());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getTelefono());

            if (ps.executeUpdate() > 0){
            	rs = ps.executeQuery(consultar.getID());
            	if (rs.next()){
            		c.setId(rs.getInt("id"));
            		retorno = 1;
            	}
            }            
        } catch (Exception e) {
            throw new Error("ERROR "+Mensajes.ALTA_TELEFONO + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public int baja(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.baja());
            ps.setInt(1, (Integer.parseInt(key.toString())));
            if (ps.executeUpdate()>0){
                retorno = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTelefonosProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public int modificar(TelefonoProveedor c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.modificar());
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setInt(3, c.getProveedor().getProveedorID());
            ps.setInt(4, c.getId());

            if (ps.executeUpdate()>0){
                retorno = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTelefonosProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.BAJA_TELEFONO + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public TelefonoProveedor obtener(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.obtener());
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){

            	telefono = new TelefonoProveedor(
            			 FACTORY_DAO.getDAOProveedores().obtener(rs.getInt("proveedorID")),
                		 rs.getString("nombre"),
                		 rs.getString("telefono")
                		 );
                 telefono.setId((int)key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTelefonosProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.BUSCAR_TELEFONO + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return telefono;
	}

	@Override
	public ArrayList<TelefonoProveedor> listar() {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.listar("nombre"));
            rs = ps.executeQuery();
            while(rs.next()){

            	telefono = new TelefonoProveedor(
            			FACTORY_DAO.getDAOProveedores().obtener(rs.getInt("proveedorID")),
                		 rs.getString("nombre"),
                		 rs.getString("telefono")
                		 );
                 telefono.setId(rs.getInt("id"));
                l.add(telefono);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTelefonosProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_TELEFONOS + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<TelefonoProveedor> filtro(String campo, String filter) {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.buscar(campo, "nombre"));
            ps.setString(1, "%"+filter+"%");
            rs = ps.executeQuery();
            while(rs.next()){
            	telefono = new TelefonoProveedor(
            			 FACTORY_DAO.getDAOProveedores().obtener(rs.getInt("proveedorID")),
                		 rs.getString("nombre"),
                		 rs.getString("telefono")
                		 );
                 telefono.setId(rs.getInt("id"));
                l.add(telefono);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTelefonosProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_TELEFONOS + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

}
