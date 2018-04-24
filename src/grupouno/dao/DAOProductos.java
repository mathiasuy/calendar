package grupouno.dao;

import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasProductos;
import grupouno.dto.Descuento;
import grupouno.dto.Producto;

public class DAOProductos implements IMetodosDAO<Producto>{
	
	   private static int retorno = 0;
	    private PreparedStatement ps;
	    private Producto producto = null;
	    private ResultSet rs;            
	    private ArrayList<Producto> l;
	    private final ConsultasProductos consultar = CONSULTAS.getConsultasProductos();
		Descuento descuento = null;
		
		@Override
		public int alta(Producto c) {
			Connection conexion = CONNECTION.getConnection();
	        try {
	            ps = conexion.prepareStatement(consultar.alta());
	            
	            //DATOS BASICOS
	            ps.setString(1, c.getNombre());
	            ps.setString(2, c.getMarca());
	            ps.setDouble(3, c.getPrecio());
	            ps.setString(4, c.getDescripcion());
	            ps.setInt(5, c.getProveedor().getProveedorID());
	            ps.setInt(6, c.getStock());
	            
	            if (ps.executeUpdate() > 0){
	            	rs = ps.executeQuery(consultar.getID());
	            	if (rs.next()){
	            		c.setProductoID(rs.getInt("id"));
	            		retorno = 1;
	            	}
	            }	            
	        } catch (Exception e) {
	            throw new Error("ERROR "+Mensajes.ALTA_PRODUCTO + e.getMessage() + " en " + this.getClass().getName());
	        }finally{
	           CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		public int[] agregarDescuentos(int productoID, ArrayList<Descuento> ds) {
			PreparedStatement prs = null;
			int[] arreglo = {};
			Connection conexion = CONNECTION.getConnection();
			try {
				conexion.setAutoCommit(false);
				prs = conexion.prepareCall(consultar.agregarDescuentoAProducto());
				for (Descuento d : ds){
					prs.setInt(1, productoID);
					prs.setInt(2, d.getDescuentoID());
					prs.addBatch();
				}
				arreglo = prs.executeBatch();
				conexion.commit();
			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					throw new Error(Mensajes.AGREGAR_DESCENTOS);
				}
				e.printStackTrace();
			}finally{
				try {
					prs.close();
				} catch (SQLException ex) {
					
				}
			}
			return arreglo;
		}
				
		@Override
		public int baja(Object key) {
	        try {
	        	int[] des = eliminarDescuentos((int)key, obtener(key).getDescuentos());
	        	retorno = 0;
	        	
	        	for (int d : des){
	        		if (d == 0){
	        			retorno = 0;
	        		}
	        	}
	        	
	        	if (!(retorno == 0)){
		        	ps = CONNECTION.getConnection().prepareStatement(consultar.baja());
		            ps.setInt(1, (Integer.parseInt(key.toString())));
		            
		            if (ps.executeUpdate()>0){
		                retorno = 1;
		            }	        		
	        	}
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BAJA_PRODUCTO + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		public int[] eliminarDescuentos(int productoID, ArrayList<Descuento> ds) {
			PreparedStatement prs = null;
			int[] arreglo = {};
			try {
				Connection conexion = CONNECTION.getConnection();
				conexion.setAutoCommit(false);
				prs = conexion.prepareCall(consultar.quitarDescuentoAProducto());
				for (Descuento d : ds){
					prs.setInt(1, productoID);
					prs.setInt(2, d.getDescuentoID());
					prs.addBatch();
				}
				arreglo = prs.executeBatch();
				conexion.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Error(Mensajes.QUITAR_DESCENTOS);
			}finally{
				try {
					prs.close();
				} catch (SQLException ex) {
					
				}
			}
			return arreglo;
		}		
		
		@Override
		public int modificar(Producto c) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.modificar());
	            ps.setString(1, c.getNombre());
	            ps.setString(2, c.getMarca());
	            ps.setDouble(3, c.getPrecio());
	            ps.setString(4, c.getDescripcion());
	            ps.setInt(5, c.getProveedor().getProveedorID());
	            ps.setInt(6, c.getStock());
	            ps.setInt(7, c.getProductoID());
	            if (ps.executeUpdate()>0){
	                retorno = 1;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.MODIFICAR_PRODUCTO + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		
		@Override
		public Producto obtener(Object key) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.obtener());
	            ps.setInt(1, (int)key);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 producto = new Producto(
	                		 rs.getString("nombre"),
	                		 rs.getString("marca"),
	                		 rs.getDouble("precio"),
	                		 rs.getString("descripcion"),
	                		 FACTORY_DAO.getDAOProveedores().obtener(rs.getInt("proveedorID")),
	                		 rs.getInt("stock"),
	                		 rs.getBoolean("habilitado"),
	                		 listarDescuentosXProducto(rs.getInt("productoID"))
	                		 );
	                 producto.setProductoID((int)key);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_PRODUCTO + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return producto;
		}

		@Override
		public ArrayList<Producto> listar() 
		{
	        l = new ArrayList<>();
	        try 
	        {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listar("nombre"));
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
	                		 listarDescuentosXProducto(rs.getInt("productoID"))
	                		 );
	                producto.setProductoID(rs.getInt("productoID"));
	                l.add(producto);
	            }
	        } 
	        catch (SQLException ex)
	        {
	            Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_PRODUCTOS + ex.getMessage() + " en " + this.getClass().getName());
	        }
	        finally
	        {
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

		@Override
		public ArrayList<Producto> filtro(String campo, String filter)
		{
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.buscar(campo, "nombre"));
	            ps.setString(1, "%"+filter+"%");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                producto = new Producto(
	                		 rs.getString("nombre"),
	                		 rs.getString("marca"),
	                		 rs.getDouble("precio"),
	                		 rs.getString("descripcion"),
	                		 FACTORY_DAO.getDAOProveedores().obtener(rs.getInt("proveedorID")),
	                		 rs.getInt("stock"),
	                		 rs.getBoolean("habilitado"),
	                		 listarDescuentosXProducto(rs.getInt("productoID"))
	                		 );
	                producto.setProductoID(rs.getInt("productoID"));
	                l.add(producto);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_PRODUCTOS + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}
		
		/**
		 * Devuelve una lista de Productos asociados a el servicio productoID
		 * @param servicioID
		 * @return
		 */
		public ArrayList<Descuento> listarDescuentosXProducto(int productoID){
	        ArrayList<Descuento> descuentos = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listarDescuentosXProducto(false, false));
	            ps.setInt(1, productoID);
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

		public ArrayList<Producto> listarProductosXProveedor(int key) {
			// TODO Auto-generated method stub
	        l = new ArrayList<>();
	        try 
	        {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listarProductosXProveedor("nombre"));
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
	                		 listarDescuentosXProducto(rs.getInt("productoID"))
	                		 );
	                producto.setProductoID(rs.getInt("productoID"));
	                l.add(producto);
	            }
	        } 
	        catch (SQLException ex)
	        {
	            Logger.getLogger(DAOProductos.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_PRODUCTOS + ex.getMessage() + " en " + this.getClass().getName());
	        }
	        finally
	        {
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}		
}
