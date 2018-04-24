package grupouno.dao.consultas;

public class ConsultasDescuentos extends Consultas{
	/***   Descuentos  *****/
	
	/**
	 * nombre, es_por_convenio, descripcion, porcentaje, dias, fecha_de_expiracion
	 * @return
	 */
	@Override
	public String alta(){
		return "INSERT INTO Descuentos (nombre,es_por_convenio,descripcion,porcentaje,dias,fecha_de_expiracion) VALUES (?,?,?,?,?,?);";
	}

	/**
	 * descuentoID
	 * @return
	 */
	@Override
	public String baja(){
		return "DELETE FROM Descuentos WHERE descuentoID=?";
	}
	
	/**
	 * nombre, es_por_convenio, descripcion, porcentaje, dias, fecha_de_expiracion,descuentoID
	 * @return
	 */
	@Override
	public String modificar(){
		return "UPDATE Descuentos SET nombre=?, es_por_convenio=?, descripcion=?, porcentaje=?, dias=?, fecha_de_expiracion=? WHERE descuentoID=?";
	}
    	
	/**
	 * descuentoID
	 * @return
	 */
	@Override
	public String obtener(){
		return "SELECT * FROM Descuentos WHERE descuentoID=?";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	@Override
	public String buscar(String columna, String orden){
		return "SELECT * FROM Descuentos WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	@Override
	public String listar(String orden){
		return "SELECT * FROM Descuentos ORDER BY orden"
				.replaceAll("orden", orden);
	}

}
