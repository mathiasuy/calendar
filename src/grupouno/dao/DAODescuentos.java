package grupouno.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasDescuentos;
import grupouno.dto.Descuento;
import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

public class DAODescuentos implements IMetodosDAO<Descuento>{
    private static int retorno = 0;
    private PreparedStatement ps;
    private Descuento descuento = null;
    private ResultSet rs;            
    private ArrayList<Descuento> l;
    private final ConsultasDescuentos consultar = CONSULTAS.getConsultaDescuentos();
	
	@Override
	public int alta(Descuento c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.alta());
            ps.setString(1, c.getNombre());
            ps.setBoolean(2, c.isEsConvenio());
            ps.setString(3, c.getDescripcion());
            ps.setDouble(4, c.getPorcentaje());
            ps.setString(5, c.getDias());
            ps.setDate(6, Utilidades.aSQL(c.getFecha_de_expiracion()));
            
            if (ps.executeUpdate() > 0){
            	rs = ps.executeQuery(consultar.getID());
            	if (rs.next()){
            		c.setDescuentoID(rs.getInt("id"));
            		retorno = 1;
            	}
            }
        } catch (Exception e) {
            throw new Error("ERROR "+Mensajes.ALTA_DESCUENTO + e.getMessage() + " en " + this.getClass().getName());
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
            Logger.getLogger(DAODescuentos.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public int modificar(Descuento c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.modificar());
            ps.setString(1, c.getNombre());
            ps.setBoolean(2, c.isEsConvenio());
            ps.setString(3, c.getDescripcion());
            ps.setDouble(4, c.getPorcentaje());
            ps.setString(5, c.getDias());
            ps.setDate(6, Utilidades.aSQL(c.getFecha_de_expiracion()));
            ps.setInt(7, c.getDescuentoID());

            if (ps.executeUpdate()>0){
                retorno = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODescuentos.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.MODIFICAR_DESCUENTO + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public Descuento obtener(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.obtener());
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){
            	descuento = new Descuento(
                		 rs.getString("nombre"),
                		 rs.getBoolean("es_por_convenio"),
                		 rs.getString("descripcion"),
                		 rs.getDouble("porcentaje"),
                		 rs.getString("dias"),
                		 Utilidades.aUtil(rs.getDate("fecha_de_expiracion")),
                		 rs.getBoolean("habilitado")
                		 );
                 descuento.setDescuentoID((int)key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODescuentos.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.BUSCAR_DESCUENTO + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return descuento;
	}

	@Override
	public ArrayList<Descuento> listar() {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.listar("nombre"));
            rs = ps.executeQuery();
            while(rs.next()){
                descuento = new Descuento(
	               		 rs.getString("nombre"),
	               		 rs.getBoolean("es_por_convenio"),
	               		 rs.getString("descripcion"),
	               		 rs.getDouble("porcentaje"),
	               		 rs.getString("dias"),
	               		 Utilidades.aUtil(rs.getDate("fecha_de_expiracion")),
	               		 rs.getBoolean("habilitado")
               		 );
                descuento.setDescuentoID(rs.getInt("DescuentoID"));
                l.add(descuento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODescuentos.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_DESCUENTOS + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Descuento> filtro(String campo, String filter) {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(consultar.buscar(campo, "nombre"));
            ps.setString(1, "%"+filter+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                descuento = new Descuento(
		               		 rs.getString("nombre"),
		               		 rs.getBoolean("es_por_convenio"),
		               		 rs.getString("descripcion"),
		               		 rs.getDouble("porcentaje"),
		               		 rs.getString("dias"),
		               		 Utilidades.aUtil(rs.getDate("fecha_de_expiracion")),
		               		 rs.getBoolean("habilitado")
                  		 );
                descuento.setDescuentoID(rs.getInt("DescuentoID"));
                l.add(descuento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODescuentos.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR "+Mensajes.LISTAR_DESCUENTOS + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

}
