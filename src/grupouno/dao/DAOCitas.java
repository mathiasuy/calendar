package grupouno.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasCitas;
import grupouno.dao.consultas.ConsultasClientes;
import grupouno.dao.consultas.ConsultasCitas;
import grupouno.dto.Cita;
import grupouno.dto.Descuento;
import grupouno.dto.ItemCita;
import grupouno.dto.Producto;
import grupouno.dto.Servicio;
import grupouno.dto.Servicio;
import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

public class DAOCitas implements IMetodosDAO<Cita>{
	
	   private static int retorno = 0;
	    private PreparedStatement ps;
	    private Cita cita = null;
	    private ResultSet rs;            
	    private ArrayList<Cita> l;
	    private final ConsultasCitas consultar = CONSULTAS.getConsultasCitas();
	    
		@Override
		public int alta(Cita c) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.alta());
	            ps.setInt(1, c.getCitaID());
	            ps.setInt(2, c.getCliente().getPersonaID());
	            ps.setInt(3, c.getEmpleado().getPersonaID());
	            ps.setString(4, c.getDescripcion());
	            ps.setDate(5, Utilidades.aSQL(c.getFecha_de_cita()));
	            ps.setBoolean(6, c.isConcretada());
	           
	            if (ps.executeUpdate() > 0){
	            	rs = ps.executeQuery(consultar.getID());
	            	if (rs.next()){
	            		c.setCitaID(rs.getInt("id"));
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

		public ArrayList<Long> agregarItems(int citaID, ArrayList<ItemCita> items) {
			PreparedStatement prs = null;
			ArrayList<Long> keys = new ArrayList<>();			
			Connection conexion = CONNECTION.getConnection();
			try {
				conexion.setAutoCommit(false);
				prs = conexion.prepareCall(consultar.agregarItemACita());
				for (ItemCita d : items){
					prs.setInt(1, citaID);
					prs.setInt(2, d.getDescuento().getDescuentoID());
					prs.setInt(3, d.getDuracion());
					prs.setDouble(4, d.getPrecio());
					prs.setInt(5, d.getServicio().getServicioID());
					prs.addBatch();
				}
				prs.executeBatch();
				ResultSet res = prs.getGeneratedKeys();
				//arreglo.addAll(res.getArray(1));
				while (res.next()){
					keys.add(res.getLong(1));
				};				
				conexion.commit();
			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e2) {
					throw new Error(Mensajes.AGREGAR_ITEM_CITA);
				}
				// TODO: handle exception
			} finally {
				CONNECTION.cerrarConexion();
			}
			return keys;
		}
		
		/**
		 * 
		 * @param citaID
		 * @param items
		 * @return Filas afectadas
		 */
		public int[] quitarItems(int citaID, ArrayList<ItemCita> items) {
			 Connection conexion = CONNECTION.getConnection();
			 int[] affectedRows = {};
//			 ArrayList<Integer> afectadas = new ArrayList<>();
			 try {
				conexion.setAutoCommit(false);
				PreparedStatement prs = conexion.prepareStatement(consultar.quitarItemACita());
				for (ItemCita d : items){
					prs.setInt(1, citaID);
					prs.setInt(2, d.getItemID());
					prs.addBatch();
				}
				affectedRows = prs.executeBatch();
//				int k = 0;
//				afectadas.forEach((final Integer i )->k+=i);
//				if (k<items.size()){
//					throw new Error("No se pudieron eliminar todos  los elementos");
//				}
				conexion.commit();
			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e2) {
					throw new Error(Mensajes.QUITAR_ITEM_CITA);
				}
			} finally{
				CONNECTION.cerrarConexion();
			}
			 return affectedRows;
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
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BAJA_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		@Override
		public int modificar(Cita c) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.modificar());
	            ps.setInt(1, c.getCitaID());
	            ps.setInt(2, c.getCliente().getPersonaID());
	            ps.setInt(3, c.getEmpleado().getPersonaID());
	            ps.setString(4, c.getDescripcion());
	            ps.setDate(5, Utilidades.aSQL(c.getFecha_de_cita()));
	            ps.setBoolean(6, c.isConcretada());
	            
	            if (ps.executeUpdate()>0){
	                retorno = 1;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.MODIFICAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		@Override
		public Cita obtener(Object key) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.obtener());
	            ps.setInt(1, (int)key);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 cita = new Cita(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 FACTORY_DAO.getDAOEmpleados().obtener(rs.getInt("empleadoID")),
	                		 rs.getString("descripcion"),
	                		 Utilidades.aUtil(rs.getDate("fecha_registrada")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_cita")),
	                		 rs.getBoolean("concretada"),
	                		 listarItemsXCita(rs.getInt("citaID"))
	                		 );
	                 cita.setCitaID((int)key);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CLIENTE + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return cita;
		}

		public ArrayList<ItemCita> listarItemsXCita(int key) {
			ArrayList<ItemCita> items = new ArrayList<>();
			ResultSet res = null;
			try {
				ps = CONNECTION.getConnection().prepareStatement(consultar.listarServiciosXCita());
				ps.setInt(1, key);
				res = ps.executeQuery();
				while (res.next()){
					ItemCita item = new ItemCita(
	                		 rs.getInt("itemID"),
	                		 FACTORY_DAO.getDAODescuentos().obtener(rs.getInt("descuentoID")),
	                		 rs.getInt("duracion"),
	                		 rs.getDouble("precio"),
	                		 FACTORY_DAO.getDAOServicios().obtener(rs.getInt("servicioID"))
							);
					items.add(item);
				}
			} catch (SQLException e) {
				throw new Error(Mensajes.LISTAR_CITAS);
			}
			return items;
		}

		@Override
		public ArrayList<Cita> listar() {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listar("nombre"));
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 cita = new Cita(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 FACTORY_DAO.getDAOEmpleados().obtener(rs.getInt("empleadoID")),
	                		 rs.getString("descripcion"),
	                		 Utilidades.aUtil(rs.getDate("fecha_registrada")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_cita")),
	                		 rs.getBoolean("concretada"),
	                		 listarItemsXCita(rs.getInt("citaID"))
	                		 );
	                cita.setCitaID(rs.getInt("CitaID"));
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_CITAS + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

		@Override
		public ArrayList<Cita> filtro(String campo, String filter) {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.filtroItemsCitas(campo, "fecha_de_cita"));
	            ps.setString(1, "%"+filter+"%");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 cita = new Cita(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 FACTORY_DAO.getDAOEmpleados().obtener(rs.getInt("empleadoID")),
	                		 rs.getString("descripcion"),
	                		 Utilidades.aUtil(rs.getDate("fecha_registrada")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_cita")),
	                		 rs.getBoolean("concretada"),
	                		 listarItemsXCita(rs.getInt("citaID"))
	                		 );
	                cita.setCitaID(rs.getInt("CitaID"));
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
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
		public ArrayList<Cita> entreFechas(java.util.Date desde, java.util.Date hasta) {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.listarCitasEntre());
	            ps.setDate(1, Utilidades.aSQL(desde));
	            ps.setDate(2, Utilidades.aSQL(hasta));
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 cita = new Cita(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 FACTORY_DAO.getDAOEmpleados().obtener(rs.getInt("empleadoID")),
	                		 rs.getString("descripcion"),
	                		 Utilidades.aUtil(rs.getDate("fecha_registrada")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_cita")),
	                		 rs.getBoolean("concretada"),
	                		 listarItemsXCita(rs.getInt("citaID"))
	                		 );
	                cita.setCitaID(rs.getInt("CitaID"));
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

	    /**
	     * Devuelve la lista de elementos de la busqueda citas del día
	     * @param fecha 
	     * @return la lista
	     */    
		public ArrayList<Cita> delDia(java.util.Date dia) {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.listarCitasDeldia());
	            ps.setDate(1, Utilidades.aSQL(dia));
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 cita = new Cita(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 FACTORY_DAO.getDAOEmpleados().obtener(rs.getInt("empleadoID")),
	                		 rs.getString("descripcion"),
	                		 Utilidades.aUtil(rs.getDate("fecha_registrada")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_cita")),
	                		 rs.getBoolean("concretada"),
	                		 listarItemsXCita(rs.getInt("citaID"))
	                		 );
	                cita.setCitaID(rs.getInt("CitaID"));
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}		
		
		
	    /**
	     * Devuelve la lsita de objetos del tipo adecuado, igual que betweenByDate, pero ademas filtra por columna_filtro
	     * @param desde inicio del rango a aplicar sobre columna_entre
	     * @param hasta fin del rango a aplicar sobre columna_entre
	     * @param columna_filtro columna a aplicar el filtro filtro Puede ser: NombreCliente, NombreEmpleado, NombreServicio, DescripcionServicio, NombreDescuento, DescripcionDescuento
	     * @param filtro filtro a aplicar sobre columna_filtro
	     * @return 
	     */    
	    public ArrayList<Cita> entreFechasYFiltro(java.util.Date desde, java.util.Date hasta, String columna_filtro,String filtro){
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareCall(consultar.filtroItemsCitasEntreFechas(columna_filtro,"fecha_de_cita"));
	            ps.setDate(1, Utilidades.aSQL(desde));
	            ps.setDate(2, Utilidades.aSQL(hasta));
	            ps.setString(3, filtro);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 cita = new Cita(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 FACTORY_DAO.getDAOEmpleados().obtener(rs.getInt("empleadoID")),
	                		 rs.getString("descripcion"),
	                		 Utilidades.aUtil(rs.getDate("fecha_registrada")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_cita")),
	                		 rs.getBoolean("concretada"),
	                		 listarItemsXCita(rs.getInt("citaID"))
	                		 );
	                cita.setCitaID(rs.getInt("CitaID"));
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}
	    
		public ArrayList<Cita> filtro(String filter) {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.filtroItemsCitas());
	            ps.setString(1, "%"+filter+"%");
	            ps.setString(2, "%"+filter+"%");
	            ps.setString(3, "%"+filter+"%");
	            ps.setString(4, "%"+filter+"%");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 cita = new Cita(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 FACTORY_DAO.getDAOEmpleados().obtener(rs.getInt("empleadoID")),
	                		 rs.getString("descripcion"),
	                		 Utilidades.aUtil(rs.getDate("fecha_registrada")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_cita")),
	                		 rs.getBoolean("concretada"),
	                		 listarItemsXCita(rs.getInt("citaID"))
	                		 );
	                cita.setCitaID(rs.getInt("CitaID"));
	                l.add(cita);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCitas.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CITA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

		public ArrayList<ItemCita> listarItemsConServicio(int key) {
			// TODO Auto-generated method stub
			ArrayList<ItemCita> items = new ArrayList<>();
			ResultSet res = null;
			try {
				ps = CONNECTION.getConnection().prepareStatement(consultar.listarItemsConServicio());
				ps.setInt(1, key);
				res = ps.executeQuery();
				while (res.next()){
					ItemCita item = new ItemCita(
	                		 rs.getInt("itemID"),
	                		 FACTORY_DAO.getDAODescuentos().obtener(rs.getInt("descuentoID")),
	                		 rs.getInt("duracion"),
	                		 rs.getDouble("precio"),
	                		 FACTORY_DAO.getDAOServicios().obtener(rs.getInt("servicioID"))
							);
					items.add(item);
				}
			} catch (SQLException e) {
				throw new Error(Mensajes.LISTAR_CITAS);
			}
			return items;
		}	    

}
