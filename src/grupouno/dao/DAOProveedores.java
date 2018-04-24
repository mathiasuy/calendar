package grupouno.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasProveedores;
import grupouno.dao.consultas.FactoryConsultas;
import grupouno.dto.Proveedor;

import grupouno.interfaces.IMetodosDAO;

public class DAOProveedores implements IMetodosDAO<Proveedor>{
    private static int retorno = 0;
    private PreparedStatement ps;
    private Proveedor proveedor = null;
    private ResultSet rs;            
    private ArrayList<Proveedor> l;
    private final ConsultasProveedores consultar = CONSULTAS.getConsultasProveedores();
	
	@Override
	public int alta(Proveedor c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.alta());
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setString(3, c.getDireccion());
           
            if (ps.executeUpdate() > 0){
            	rs = ps.executeQuery(consultar.getID());
            	if (rs.next()){
            		c.setProveedorID(rs.getInt("id"));
            		retorno = 1;
            	}
            }
        } catch (Exception e) {
            throw new Error("ERROR "+Mensajes.ALTA_PROVEEDOR + e.getMessage() + " en " + this.getClass().getName());
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
            Logger.getLogger(DAOProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public int modificar(Proveedor c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.modificar());
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setString(3, c.getDireccion());
            ps.setInt(4, c.getProveedorID());

            if (ps.executeUpdate()>0){
                retorno = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.MODIFICAR_PROVEEDOR + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public Proveedor obtener(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.obtener());
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){
            	proveedor = new Proveedor(
            			rs.getInt("proveedorID"),
                		 rs.getString("nombre"),
                		 rs.getString("descripcion"),
                		 rs.getString("direccion"),
                		 rs.getBoolean("habilitado")
                		 );
                 proveedor.setProveedorID((int)key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.BUSCAR_PROVEEDOR + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return proveedor;
	}

	@Override
	public ArrayList<Proveedor> listar() {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.listar("nombre"));
            rs = ps.executeQuery();
            while(rs.next()){
                proveedor = new Proveedor(
            		rs.getInt("proveedorID"),
               		 rs.getString("nombre"),
               		 rs.getString("descripcion"),
               		 rs.getString("direccion"),
               		 rs.getBoolean("habilitado")
               		 );
                proveedor.setProveedorID(rs.getInt("proveedorID"));
                l.add(proveedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_PROVEEDORES + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Proveedor> filtro(String campo, String filter) {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.buscar(campo, "nombre"));
            ps.setString(1, "%"+filter+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                proveedor = new Proveedor(
		            		rs.getInt("proveedorID"),
		               		 rs.getString("nombre"),
		               		 rs.getString("descripcion"),
		               		 rs.getString("direccion"),
		               		 rs.getBoolean("habilitado")
                  		 );
                proveedor.setProveedorID(rs.getInt("proveedorID"));
                   l.add(proveedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProveedores.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_PROVEEDORES + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

}
