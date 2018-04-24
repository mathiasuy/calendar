package grupouno.dao.consultas;

public class ConsultasProveedores extends Consultas{
	/***   Proveedor  *****/
	
	/**
	 * nombre,descripcion,direccion
	 * @return
	 */
	@Override
	public String alta(){
		return "INSERT INTO Proveedores (nombre,descripcion,direccion) VALUES (?,?,?);";
	}

	/**
	 * ProveedorID
	 * @return
	 */
	@Override
	public String baja(){
		return "DELETE FROM Proveedores WHERE ProveedorID=?";
	}
	
	/**
	 * nombre,descripcion,direccion,proveedorID
	 * @return
	 */
	@Override
	public String modificar(){
		return "UPDATE Proveedores SET nombre=?, descripcion=?, direccion=? WHERE proveedorID=?";
	}
    	
	/**
	 * proveedorID
	 * @return
	 */
	@Override
	public String obtener(){
		return "SELECT * FROM Proveedores WHERE proveedorID=?";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	@Override
	public String buscar(String columna, String orden){
		return "SELECT * FROM Proveedores WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	@Override
	public String listar(String orden){
		return "SELECT * FROM Proveedores ORDER BY orden"
				.replaceAll("orden", orden);
	}	
	
}