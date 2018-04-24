package grupouno.dao;

import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasServicios;
import grupouno.dto.Descuento;
import grupouno.dto.Producto;
import grupouno.dto.Servicio;

public class DAOServicios implements IMetodosDAO<Servicio>{
	
	   private static int retorno = 0;
	    private PreparedStatement ps;
	    private Servicio servicio = null;
	    private ResultSet rs;            
	    private ArrayList<Servicio> l;
	    private final ConsultasServicios consultar = CONSULTAS.getConsultasServicios();
	    Descuento descuento = null;
	    
		@Override
		public int alta(Servicio c) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.alta());
	            ps.setString(1, c.getNombre());
	            ps.setInt(2, c.getDuracion());
	            ps.setString(3, c.getDescripcion());
	            ps.setDouble(4, c.getPrecio());
	           
	            if (ps.executeUpdate() > 0){
	            	rs = ps.executeQuery(consultar.getID());
	            	if (rs.next()){
	            		c.setServicioID(rs.getInt("id"));
	            		retorno = 1;
	            	}
	            }
	        } catch (Exception e) {
	            throw new Error("ERROR "+Mensajes.ALTA_SERVICIO + e.getMessage() + " en " + this.getClass().getName());
	        }finally{
	           CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		public int[] agregarDescuentoAServicio(int servicioID, ArrayList<Descuento> descuentos) {
			PreparedStatement prs = null;
			int[] affectedRecords = {};			
			Connection conexion = CONNECTION.getConnection();
			try {
				conexion.setAutoCommit(false);
				prs = conexion.prepareCall(consultar.agregarDescuentoAServicio());
				for (Descuento d : descuentos){
					prs.setInt(1, servicioID);
					prs.setInt(2, d.getDescuentoID());
					prs.addBatch();
				}
				 affectedRecords = prs.executeBatch();     
				conexion.commit();
			} catch (SQLException e) {
				try {
					conexion.rollback();
					throw new Error(Mensajes.AGREGAR_DESCENTOS);
				} catch (SQLException e2) {

				}
				// TODO: handle exception
			} finally {
				CONNECTION.cerrarConexion();
			}
			return affectedRecords;
		}

		public int[] agregarProductoAServicio(int servicioID, ArrayList<Producto> productos) {
			PreparedStatement prs = null;
			int[] affectedRecords = {};			
			Connection conexion = CONNECTION.getConnection();
			try {
				conexion.setAutoCommit(false);
				prs = conexion.prepareCall(consultar.agregarDescuentoAServicio());
				for (Producto d : productos){
					prs.setInt(1, servicioID);
					prs.setInt(2, d.getProductoID());
					prs.addBatch();
				}
				 affectedRecords = prs.executeBatch();     
				conexion.commit();
			} catch (SQLException e) {
				try {
					conexion.rollback();
					throw new Error(Mensajes.AGREGAR_PRODUTOS);
				} catch (SQLException e2) {
					// TODO: handle exception
				}
				// TODO: handle exception
			} finally {
				CONNECTION.cerrarConexion();
			}
			return affectedRecords;
		}		
		
		public int[] quitarDescuento(int servicioID, ArrayList<Descuento> descuentos) {
			 Connection conexion = CONNECTION.getConnection();
			 int[] affectedRows = {};
			 try {
				conexion.setAutoCommit(false);
				PreparedStatement prs = conexion.prepareStatement(consultar.quitarDescuentoAServicio());
				for (Descuento d : descuentos){
					prs.setInt(1, servicioID);
					prs.setInt(2, d.getDescuentoID());
					prs.addBatch();
				}
				affectedRows = prs.executeBatch();
				conexion.commit();
			} catch (SQLException e) {
				try {
					conexion.rollback();
					throw new Error(Mensajes.QUITAR_DESCUENTOS);
				} catch (SQLException e2) {
					
				}
			} finally{
				CONNECTION.cerrarConexion();
			}
			 return affectedRows;
		}
		
		
		public int[] quitarProductos(int servicioID, ArrayList<Producto> productos) {
			Connection conexion = CONNECTION.getConnection();
			int[] affectedRows = {};
			try {
				PreparedStatement prs = conexion.prepareStatement(consultar.quitarProductoAServicio());
				for (Producto p : productos){
					prs.setInt(1, servicioID);
					prs.setInt(2, p.getProductoID());
					prs.addBatch();
				}
				affectedRows = prs.executeBatch();
				conexion.commit();
			} catch (SQLException e) {
				try {
					conexion.rollback();
					throw new Error(Mensajes.QUITAR_PRODUCTOS);
				} catch (SQLException e2) {
					// TODO: handle exception
				}
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
	            Logger.getLogger(DAOServicios.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BAJA_SERVICIO + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		@Override
		public int modificar(Servicio c) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.modificar());
	            ps.setString(1, c.getNombre());
	            ps.setInt(2, c.getDuracion());
	            ps.setString(3, c.getDescripcion());
	            ps.setDouble(4, c.getPrecio());
	            ps.setInt(7, c.getServicioID());
	            if (ps.executeUpdate()>0){
	                retorno = 1;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOServicios.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.MODIFICAR_SERVICIO + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		@Override
		public Servicio obtener(Object key) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.obtener());
	            ps.setInt(1, (int)key);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 servicio = new Servicio(
	                		 rs.getString("nombre"),
	                		 rs.getInt("duracion"),
	                		 rs.getString("descripcion"),
	                		 rs.getDouble("precio"),
	                		 FACTORY_DAO.getDAOServicios().listarProductosXServicio(rs.getInt("servicioID")),
	                		 FACTORY_DAO.getDAOServicios().listarDescuentosXServicio(rs.getInt("servicioID"))
	                		 );
	                 servicio.setServicioID((int)key);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOServicios.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_SERVICIO + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return servicio;
		}

		@Override
		public ArrayList<Servicio> listar() {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listar("nombre"));
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 servicio = new Servicio(
	                		 rs.getString("nombre"),
	                		 rs.getInt("duracion"),
	                		 rs.getString("descripcion"),
	                		 rs.getDouble("precio"),
	                		 listarProductosXServicio(rs.getInt("servicioID")),
	                		 listarDescuentosXServicio(rs.getInt("servicioID"))
	                		 );
	                servicio.setServicioID(rs.getInt("ServicioID"));
	                l.add(servicio);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOServicios.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_SERVICIOS + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

		@Override
		public ArrayList<Servicio> filtro(String campo, String filter) {
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.buscar(campo, "nombre"));
	            ps.setString(1, "%"+filter+"%");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 servicio = new Servicio(
	                		 rs.getString("nombre"),
	                		 rs.getInt("duracion"),
	                		 rs.getString("descripcion"),
	                		 rs.getDouble("precio"),
	                		 listarProductosXServicio(rs.getInt("servicioID")),
	                		 listarDescuentosXServicio(rs.getInt("servicioID"))
	                		 );
	                servicio.setServicioID(rs.getInt("ServicioID"));
	                l.add(servicio);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOServicios.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_SERVICIOS + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

		/**
		 * Devuelve una lista de Descuentos asociados a el servicio servicioID
		 * @param servicioID
		 * @return
		 */
		public ArrayList<Descuento> listarDescuentosXServicio(int servicioID){
	        ArrayList<Descuento> descuentos = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listarDescuentosXServicio(true,true));
	            ps.setInt(1, servicioID);
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
	                descuento.setDescuentoID(rs.getInt("descuentoID"));
	                descuentos.add(descuento);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_DESCUENTOS + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return descuentos;
		}		
		
		public ArrayList<Producto> listarProductosXServicio(int servicioID) 
		{
			Producto producto = null;
	        ArrayList<Producto> productos = new ArrayList<>();
	        try 
	        {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listarProductosXServicio(true));
	            rs = ps.executeQuery();
	            while(rs.next())
	            {
	                producto = new Producto(
		                		 rs.getString("nombre"),
		                		 rs.getString("marca"),
		                		 rs.getDouble("precio"),
		                		 rs.getString("descripcion"),
		                		 FACTORY_DAO.getDAOProveedores().obtener(rs.getInt("proveedorID")),
		                		 rs.getInt("stock"),
		                		 rs.getBoolean("habilitado"),
		                		 FACTORY_DAO.getDAOProductos().listarDescuentosXProducto(rs.getInt("productoID"))
	                		 );
	                producto.setProductoID(rs.getInt("productoID"));
	                productos.add(producto);
	            }
	        } catch (SQLException ex) {
		        Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
		        throw new Error("ERROR "+Mensajes.LISTAR_PRODUCTOS + ex.getMessage() + " en " + this.getClass().getName());
		    }finally{
		        CONNECTION.cerrarConexion();
		    }
		    return productos;	        
		}
		
}
