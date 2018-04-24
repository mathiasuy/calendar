package grupouno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dao.consultas.ConsultasCuponeras;
import grupouno.dto.Cupon;
import grupouno.dto.Cuponera;
import grupouno.dto.Descuento;
import grupouno.interfaces.IMetodosDAO;
import grupouno.utils.Utilidades;

public class DAOCuponeras implements IMetodosDAO<Cuponera>{
	

	   private static int retorno = 0;
	    private PreparedStatement ps;
	    private Cuponera Cuponera = null;
	    private ResultSet rs;            
	    private ArrayList<Cuponera> l;
	    private final ConsultasCuponeras consultar = CONSULTAS.getConsultasCuponeras();
		Descuento descuento = null;
		
		@Override
		public int alta(Cuponera c) {
			Connection conexion = CONNECTION.getConnection();
	        try {
	            ps = conexion.prepareStatement(consultar.alta());
	            
	            //DATOS BASICOS
	            ps.setInt(1, c.getCuponeraID());
	            ps.setInt(2, c.getCliente().getPersonaID());
	            ps.setDouble(3, c.getDescuento());
	            ps.setDate(4, Utilidades.aSQL(c.getFecha_de_vencimiento()));
	            
	            if (ps.executeUpdate() > 0){
	            	rs = ps.executeQuery(consultar.getID());
	            	if (rs.next()){
	            		c.setCuponeraID(rs.getInt("id"));
	            		retorno = 1;
	            	}
	            }	            
	            	            
	        } catch (Exception e) {
	            throw new Error("ERROR "+Mensajes.ALTA_CUPONERA + e.getMessage() + " en " + this.getClass().getName());
	        }finally{
	           CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		/**
		 * 
		 * @param CuponeraID
		 * @param ds
		 * @return id´s generadas Long
		 */
		public ArrayList<Long> agregarCupones(int CuponeraID, ArrayList<Cupon> ds) {
			PreparedStatement prs = null;
			ArrayList<Long> arreglo = new ArrayList<>();
			Connection conexion = CONNECTION.getConnection();
			try {
				conexion.setAutoCommit(false);
				prs = conexion.prepareCall(consultar.agregarCuponACuponera());
				for (Cupon d : ds){
					prs.setInt(1, CuponeraID);
					prs.setInt(2,d.getServicioID());
					prs.setDate(3, Utilidades.aSQL(d.getFecha_concretado()));
					prs.addBatch();
				}
				prs.executeBatch();
				ResultSet res = prs.getGeneratedKeys();
				//arreglo.addAll(res.getArray(1));
				while (res.next()){
					arreglo.add(res.getLong(1));
				};
				conexion.commit();
			} catch (SQLException e) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
					throw new Error(Mensajes.AGREGAR_ITEM_CUPONERA);
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
	        	ps = CONNECTION.getConnection().prepareStatement(consultar.baja());
	        	ps.setInt(1,(int)key);

	            if (ps.executeUpdate()>0){
	                retorno = 1;
	        	}
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCuponeras.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BAJA_CUPONERA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		public int[] eliminarCupones(int CuponeraID, ArrayList<Cupon> ds) {
			PreparedStatement prs = null;
			int[] arreglo = {};
			Connection conexion = CONNECTION.getConnection();
			try {
				conexion.setAutoCommit(false);
				prs = conexion.prepareCall(consultar.quitarCuponACuponera());
				for (Cupon d : ds){
					prs.setInt(1, d.getCuponID());
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
					throw new Error(Mensajes.QUITAR_ITEM_CUPONERA);
				}
				e.printStackTrace();
			}finally{
				CONNECTION.cerrarConexion();
			}
			return arreglo;
		}		
		
		@Override
		public int modificar(Cuponera c) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.modificar());
	            ps.setInt(1, c.getCuponeraID());
	            ps.setInt(2, c.getCliente().getPersonaID());
	            ps.setDouble(3, c.getDescuento());
	            ps.setDate(4, Utilidades.aSQL(c.getFecha_de_vencimiento()));
	            ps.setInt(7, c.getCuponeraID());
	            if (ps.executeUpdate()>0){
	                retorno = 1;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCuponeras.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.MODIFICAR_CUPONERA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return retorno;
		}

		
		@Override
		public Cuponera obtener(Object key) {
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.obtener());
	            ps.setInt(1, (int)key);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                 Cuponera = new Cuponera(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 rs.getDouble("descuento"),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_inicio")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_vencimiento")),
	                		 listarCuponesXCuponera(rs.getInt("cuponeraID"),"cuponID")
	                		 );
	                 Cuponera.setCuponeraID((int)key);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCuponeras.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.BUSCAR_CUPONERA + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return Cuponera;
		}

		public ArrayList<Cupon> listarCuponesXCuponera(int cuponeraID, String orden) {
			ArrayList<Cupon> cupones = new ArrayList<>();
			try {
				ps = CONNECTION.getConnection().prepareStatement(consultar.listarCuponesXCuponera(orden));
				ps.setInt(1, cuponeraID);
				rs = ps.executeQuery();
				while (rs.next()){
					Cupon cupon = new Cupon(
					rs.getInt("cuponID"),
					rs.getInt("cuponeraID"),
					rs.getInt("servicioID"),
					Utilidades.aUtil(rs.getDate("fecha_concretado"))
					);
					cupones.add(cupon);
				}
			} catch (SQLException e) {
				throw new Error(Mensajes.LISTAR_CUPONES);
			}finally{
	            CONNECTION.cerrarConexion();
	        }
			return cupones;
		}

		@Override
		public ArrayList<Cuponera> listar() 
		{
	        l = new ArrayList<>();
	        try 
	        {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.listar("nombre"));
	            rs = ps.executeQuery();
	            while(rs.next())
	            {
	                Cuponera = new Cuponera(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 rs.getDouble("descuento"),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_inicio")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_vencimiento")),
	                		 listarCuponesXCuponera(rs.getInt("cuponeraID"),"cuponID")
	                		 );
	                Cuponera.setCuponeraID(rs.getInt("CuponeraID"));
	                l.add(Cuponera);
	            }
	        } 
	        catch (SQLException ex)
	        {
	            Logger.getLogger(DAOCuponeras.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_CUPONERAS + ex.getMessage() + " en " + this.getClass().getName());
	        }
	        finally
	        {
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

		@Override
		public ArrayList<Cuponera> filtro(String campo, String filter)
		{
	        l = new ArrayList<>();
	        try {
	            ps = CONNECTION.getConnection().prepareStatement(consultar.buscar(campo, "nombre"));
	            ps.setString(1, "%"+filter+"%");
	            rs = ps.executeQuery();
	            while(rs.next()){
	                Cuponera = new Cuponera(
	                		 FACTORY_DAO.getDAOClientes().obtener(rs.getInt("clienteID")),
	                		 rs.getDouble("descuento"),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_inicio")),
	                		 Utilidades.aUtil(rs.getDate("fecha_de_vencimiento")),
	                		 listarCuponesXCuponera(rs.getInt("cuponeraID"),"cuponID")
	                		 );
	                Cuponera.setCuponeraID(rs.getInt("CuponeraID"));
	                l.add(Cuponera);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DAOCuponeras.class.getName()).log(Level.SEVERE, null, ex);
	            throw new Error("ERROR "+Mensajes.LISTAR_CUPONERAS + ex.getMessage() + " en " + this.getClass().getName());
	        }finally{
	            CONNECTION.cerrarConexion();
	        }
	        return l;
		}

}
