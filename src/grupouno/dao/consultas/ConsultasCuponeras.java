package grupouno.dao.consultas;

public class ConsultasCuponeras extends Consultas{

	
	/**
	 * cuponeraID, clienteID, descuento, fecha_de_vencimiento
	 */
	@Override
	public String alta() {
		// TODO Auto-generated method stub
		return "INSERT INTO Cuponeras (cuponeraID, clienteID, descuento, fecha_de_vencimiento) VALUES "
				+ " (?,?,?,?);";
	}
	
	/**
	 * cuponeraID
	 */
	@Override
	public String baja() {
		return "DELETE Cuponeras WHERE "
				+ " cuponeraID=?";
	}

	/**
	 * Cuponeras SET cuponeraID=?, clienteID=?, descuento=?, fecha_de_vencimiento=?
	 */
	@Override
	public String modificar() {
		return "UPDATE Cuponeras SET cuponeraID=?, clienteID=?, descuento=?, fecha_de_vencimiento=? WHERE "
				+ " cuponeraID=?";
	}

	/**
	 * cuponeraID
	 */
	@Override
	public String obtener() {
		return "SELECT * FROM Cuponeras WHERE cuponeraID=?";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	@Override
	public String buscar(String columna, String orden){
		return "SELECT * FROM Cuponeras WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	@Override
	public String listar(String orden){
		return "SELECT * FROM Cuponeras ORDER BY orden"
				.replaceAll("orden", orden);
	}
	
	/**
	 * cuponeraID, servicioID, fecha_concretado
	 * @return cuponID
	 */
	public String agregarCuponACuponera(){
		return "INSERT INTO Cupon (cuponeraID, servicioID, fecha_concretado) VALUES "
				+ "(?,?,?)";
	}
	
	/**
	 * cuponID
	 * @return
	 */
	public String quitarCuponACuponera(){
		return "DELETE Cupon WHERE cuponID = ?";
	}
	

	/**
	 * cuponID
	 * @return
	 */

	public String listarCuponesXCuponera(String orden) {
		// TODO Auto-generated method stub
		return "SELECT * FROM Cupones WHERE cuponID=? ORDER BY orden".replaceAll("orden", orden);
	}
}
