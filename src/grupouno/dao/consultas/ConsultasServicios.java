package grupouno.dao.consultas;

public class ConsultasServicios extends Consultas{

	/**
	 * nombre,duracion,descripcion,precio,habilitado
	 */
	@Override
	public String alta() {
		// TODO Auto-generated method stub
		return "INSERT INTO Servicios (nombre,duracion,descripcion,precio,habilitado) "
				+ "VALUES (?,?,?,?,?)";
	}

	/**
	 * servicioID
	 */
	@Override
	public String baja() {
		// TODO Auto-generated method stub
		return "DELTE FROM Servicios WHERE servicioID=?";
	}

	/**
	 * nombre,duracion,descripcion,precio,habilitado,servicioID
	 */
	@Override
	public String modificar() {
		// TODO Auto-generated method stub
		return "UPDATE Servicios SET nombre=? ,duracion=? ,descripcion=? ,precio=? ,habilitado=? "
				+ "WHERE servicioID=?";
	}

	/**
	 * servicioID
	 */
	@Override
	public String obtener() {
		// TODO Auto-generated method stub
		return "SELECT * FROM Servicios WHERE servicioID=?";
	}

	/**
	 * 
	 */
	@Override
	public String buscar(String columna, String orden) {
		// TODO Auto-generated method stub
		return "SELECT * FROM Servicios WHERE columna like ? ORDER BY orden".replace("columna", columna)
				.replaceAll("orden", orden);
	}

	@Override
	public String listar(String orden) {
		// TODO Auto-generated method stub
		return "SELECT * FROM Servicios ORDER BY orden".replaceAll("orden", orden);
	}

	/**
	 * servicioID
	 * @param 
	 * @return
	 */
	public String listarDescuentosXServicio(boolean habilitado, boolean es_por_convenio) {
		return "call listarDescuentosXServicio(?,"+habilitado+","+es_por_convenio+")";
	}
	
	/**
	 * servicioID
	 * @param 
	 * @return
	 */
	public String listarProductosXServicio(boolean habilitado) {
		return "call listarProductosXServicio(?,"+habilitado+")";
	}

	/**
	 * servicioID, descuentoID
	 * @param 
	 * @return
	 */
	public String agregarDescuentoAServicio() {
		return "INSERT INTO DescuentosServicios VALUES(?,?)";
	}	
	
	/**
	 * servicioID, descuentoID
	 * @param 
	 * @return
	 */
	public String quitarDescuentoAServicio() {
		return "DELETE FROM DescuentosServicios WHERE descuentoID = ? AND servicioID = ?";
	}
	
	/**
	 * servicioID, productoID
	 * @param 
	 * @return
	 */
	public String agreagarProductoAServicio() {
		return "INSERT INTO ServiciosProductos VALUES(?,?)";
	}	
	
	/**
	 * servicioID, productoID
	 * @param 
	 * @return
	 */
	public String quitarProductoAServicio() {
		return "DELETE FROM ServiciosProductos WHERE ProductoID = ? AND ServicioID = ?";
	}			
	
}
