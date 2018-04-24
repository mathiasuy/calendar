package grupouno.dao.consultas;

public class ConsultasTelefonosProveedores extends Consultas{
	/***   TelefonoProveedor  *****/
	
	/**
	 * proveedorID,nombre,telefono
	 * @return
	 */
	@Override
	public String alta(){
		return "INSERT INTO TelefonosProveedores (proveedorID,nombre,telefono) VALUES (?,?,?);";
	}

	/**
	 * id
	 * @return
	 */
	@Override
	public String baja(){
		return "DELETE FROM TelefonosProveedores WHERE id=?";
	}
	
	/**
	 * nombre,telefono,proveedorID,id
	 * @return
	 */
	@Override
	public String modificar(){
		return "UPDATE TelefonosProveedores SET nombre=?, telefono=?, proveedorID=? WHERE id=?";
	}
    	
	/**
	 * id
	 * @return
	 */
	@Override
	public String obtener(){
		return "SELECT * FROM TelefonosProveedores WHERE id=?";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	@Override
	public String buscar(String columna, String orden){
		return "SELECT * FROM TelefonosProveedores WHERE columna LIKE ? ORDER BY orden GROUP BY proveedorID"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	@Override
	public String listar(String orden){
		return "SELECT * FROM TelefonosProveedores ORDER BY orden GROUP BY proveedorID"
				.replaceAll("orden", orden);
	}
}
