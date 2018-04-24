package grupouno.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.dao.consultas.ConsultasCitasSimples;
import grupouno.dto.CitaSimple;
import grupouno.interfaces.IMetodosDAO;
//import grupouno.utils.Utilidades;

public class DAOCitasSimples implements IMetodosDAO<CitaSimple>{
	
	   private static int retorno = 0;
	    private PreparedStatement ps;
	    private CitaSimple cita = null;
	    private ResultSet rs;            
	    private ArrayList<CitaSimple> l;
	    private final ConsultasCitasSimples consultar = CONSULTAS.getConsultasCitaSimples();
	    
		@Override
		public int alta(CitaSimple c) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.alta());
	            ps.setString(1, c.getCliente());
	            ps.setString(2, c.getEmpleado());
	            ps.setString(3, c.getDescripcion());
	            ps.setString(4, Utilidades.aSQL(c.getFecha_de_cita()));
	            ps.setDouble(5, c.getPrecio());
	           
	            if (ps.executeUpdate() > 0){
	            	rs = ps.executeQuery(consultar.getID());
	            	if (rs.next()){
	            		c.setCitaSimpleID(rs.getInt("id"));
	            		retorno = 1;
	            	}
	            }
	        } catch (Exception e) {
	            throw new Error("ERROR "+Mensajes.ALTA_CITA + e.getMessage() + " en " + this.getClass().getName());
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
	            Logger.getLogger(DAOCitasSimples.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BAJA_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		@Override
		public int modificar(CitaSimple c) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.modificar());
	            ps.setString(1, c.getCliente());
	            ps.setString(2, c.getEmpleado());
	            ps.setString(3, c.getDescripcion());
	            ps.setString(4, Utilidades.aSQL(c.getFecha_de_cita()));
	            ps.setDouble(5, c.getPrecio());
	            ps.setInt(6, c.getCitaSimpleID());
	            
	            if (ps.executeUpdate()>0){
	                retorno = 1;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitasSimples.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.MODIFICAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		@Override
		public CitaSimple obtener(Object key) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.obtener());
	            ps.setInt(1, (int)key);
	            rs = ps.executeQuery();
	            java.util.Date d = Utilidades.aUtil(rs.getString("fecha_registrada"));
                System.out.println("FECHA BD LISTAR: "+d);	     	            
	            while(rs.next()){
	                 cita = new CitaSimple(
	                		 rs.getInt("citaSimpleID"),
	                		 rs.getString("cliente"),
	                		 rs.getString("empleado"),
	                		 rs.getString("descripcion"),
	                		 d,
	                		 Utilidades.asLocalDateTime(rs.getString("fecha_de_cita")),
	                		 rs.getDouble("precio")
	                		 );
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitasSimples.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CLIENTE + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return cita;
		}

		@Override
		public ArrayList<CitaSimple> listar() {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listar("nombre"));
	            rs = ps.executeQuery();
	            java.util.Date d = Utilidades.aUtil(rs.getString("fecha_registrada"));
                System.out.println("FECHA BD LISTAR: "+d);	            
	            while(rs.next()){
	                 cita = new CitaSimple(
	                		 rs.getInt("citaSimpleID"),
	                		 rs.getString("cliente"),
	                		 rs.getString("empleado"),
	                		 rs.getString("descripcion"),
	                		 d,
	                		 Utilidades.asLocalDateTime(rs.getString("fecha_de_cita")),
	                		 rs.getDouble("precio")
	                		 );
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitasSimples.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_CITAS + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

		@Override
		public ArrayList<CitaSimple> filtro(String campo, String filter) {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.buscar(campo, "fecha_de_cita"));
	            ps.setString(1, "%"+filter+"%");
	            rs = ps.executeQuery();
	            java.util.Date d = Utilidades.aUtil(rs.getString("fecha_registrada"));
                System.out.println("FECHA BD LISTAR: "+d);	  	            
	            while(rs.next()){
	                 cita = new CitaSimple(
	                		 rs.getInt("citaSimpleID"),
	                		 rs.getString("cliente"),
	                		 rs.getString("empleado"),
	                		 rs.getString("descripcion"),
	                		 d,
	                		 Utilidades.asLocalDateTime(rs.getString("fecha_de_cita")),
	                		 rs.getDouble("precio")
	                		 );
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitasSimples.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}
		

	    /**
	     * Devuelve la lista de elementos de la busqueda between sobre columna columna_entre y con el filtro tipo con los objetos del tipo indicado
	     * @param desde fecha desde
	     * @param hasta fecha hasta
	     * @return la lista
	     */    
		public ArrayList<CitaSimple> entreFechas(LocalDate desde, LocalDate hasta) {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.entreFechas());
	            ps.setString(1, Utilidades.aSQL(desde));
	            ps.setString(2, Utilidades.aSQL(hasta));
	            rs = ps.executeQuery();
	            while(rs.next()){
		            java.util.Date d = Utilidades.aUtil(rs.getString("fecha_registrada"));
	                System.out.println("FECHA BD LISTAR: "+d);	  	            	
	                 cita = new CitaSimple(
	                		 rs.getInt("citaSimpleID"),
	                		 rs.getString("cliente"),
	                		 rs.getString("empleado"),
	                		 rs.getString("descripcion"),
	                		 d,
	                		 Utilidades.asLocalDateTime(rs.getString("fecha_de_cita")),
	                		 rs.getDouble("precio")
	                		 );
	                 System.out.println("DESDE LA BASE: "+Utilidades.aUtil(rs.getDate("fecha_registrada")));
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitasSimples.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR 320"+Mensajes.BUSCAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

		public ArrayList<CitaSimple> deHora(LocalDateTime fecha_y_hora) {
			// TODO Auto-generated method stub
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.deHora());
//	            System.out.println("De LocalDateTime:"+fecha_y_hora);
	            String sql = Utilidades.aSQL(fecha_y_hora);
//	            System.out.println("A SQL:"+sql);
	            ps.setString(1, sql);
	            rs = ps.executeQuery();
	            while(rs.next()){
	            	java.sql.Date fecha_de_cita = rs.getDate("fecha_registrada");
	            	System.out.println("  Date SQL: "+ fecha_de_cita);
	                 cita = new CitaSimple(
	                		 rs.getInt("citaSimpleID"),
	                		 rs.getString("cliente"),
	                		 rs.getString("empleado"),
	                		 rs.getString("descripcion"),
	                		 Utilidades.aUtil(fecha_de_cita),
	                		 Utilidades.asLocalDateTime(rs.getString("fecha_de_cita")),
	                		 rs.getDouble("precio")
	                		 );
	                 
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitasSimples.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

}
