package grupouno.dao.consultas;

public class ConsultasProductos extends Consultas{
	/***   Producto  *****/
	
	/**
	 * nombre,marca,precio,descripcion,proveedorID,stock
	 * @return
	 */
	@Override
	public String alta(){
		return "INSERT INTO Productos "
				+ "(nombre,marca,precio,descripcion,proveedorID,stock) "
				+ "VALUES (?,?,?,?,?,?);";
	}

	/**
	 * ProductoID
	 * @return
	 */
	@Override
	public String baja(){
		return "DELETE FROM Productos WHERE ProductoID=?";
	}
	
	/**
	 * nombre,marca,precio,descripcion,proveedorID,stock, productoID
	 * @return
	 */
	@Override
	public String modificar(){
		return "UPDATE Productos SET"
				+ " nombre=?,marca=?,precio=?,descripcion=?,proveedorID=?,"
				+ " stock=? WHERE productoID=?";
	}
    	
	/**
	 * productoID
	 * @return
	 */
	@Override
	public String obtener(){
		return "SELECT * FROM Productos WHERE productoID=?";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	@Override
	public String buscar(String columna, String orden){
		return "SELECT * FROM Productos WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	@Override
	public String listar(String orden){
		return "SELECT * FROM Productos ORDER BY orden"
				.replaceAll("orden", orden);
	}	
		
	
	/**
	 *  productoID
	 * @param orden
	 * @return
	 */
	public String listarDescuentosXProducto(boolean habilitado, boolean es_por_convenio){
		return "call listarDescuentosXServicio(?,"+habilitado+","+es_por_convenio+")";
	}		
	
	/**
	 *  productoID, descuentoID
	 * @param orden
	 * @return
	 */
	public String agregarDescuentoAProducto(){
		return "INSERT INTO DescuentosProductos VALUES(?,?)";
	}		
	
	/**
	 *  productoID, descuentoID
	 * @param orden
	 * @return
	 */
	public String quitarDescuentoAProducto(){
		return "DELETE FROM DescuentosProductos WHERE descuentoID = ? AND ProductoID = ?";
	}

	public String listarProductosXProveedor(String orden) {
		// TODO Auto-generated method stub
		return "SELECT * FRMO Productos WHERE proveedorID=? ORDER BY orden".replaceAll("orden", orden);
	}		
	
}
