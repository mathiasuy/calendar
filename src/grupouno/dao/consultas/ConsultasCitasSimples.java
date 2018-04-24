package grupouno.dao.consultas;

public class ConsultasCitasSimples extends Consultas{

	/**
	 * cliente,empleado,descripcion,fecha_de_cita,precio
	 */
	@Override
	public String alta() {
		// TODO Auto-generated method stub
		return "INSERT INTO CitasSimples("
				+ "cliente,empleado,descripcion,fecha_de_cita,precio"
				+ ") VALUES (?,?,?,?,?)";
	}

	/**
	 * citaID
	 */
	@Override
	public String baja() {
		// TODO Auto-generated method stub
		return "DELETE FROM CitasSimples WHERE citaSimpleID=?";
	}

	/**
	 * cliente,empleado,descripcion,fecha_de_cita,precio,citaID
	 */
	@Override
	public String modificar() {
		// TODO Auto-generated method stub
		return "UPDATE CitasSimples SET cliente=?, empleado=?, descripcion=?, fecha_de_cita=?,precio=?"
				+ " WHERE citaSimpleID=?";
	}

	/**
	 * citaID
	 */
	@Override
	public String obtener() {
		// TODO Auto-generated method stub
		return "SELECT * FROM CitasSimples WHERE citaID=?";
	}

	/**
	 * filtro
	 */
	@Override
	public String buscar(String columna, String orden) {
		// TODO Auto-generated method stub
		return "SELECT * FROM CitasSimples WHERE columna LIKE ? ORDER BY orden".replaceAll("orden", orden);
	}

	/**
	 * 
	 */
	@Override
	public String listar(String orden) {
		// TODO Auto-generated method stub
		return "SELECT * FROM CitasSimples";
	}
	
	/**
	 * desde, hasta
	 * @return
	 */
	public String entreFechas() {
		// TODO Auto-generated method stub
		return "SELECT * FROM CitasSimples WHERE fecha_de_cita BETWEEN ? AND ?";
	}

	/**
	 * fecha_de_cita
	 * @return
	 */
	public String deHora() {
		// TODO Auto-generated method stub
		return "SELECT * FROM CitasSimples WHERE fecha_de_cita =?";
	}

}
