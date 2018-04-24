package grupouno.dao.consultas;

public class ConsultasUsuarios {
	/***   Usuario  *****/

	/**
	 *  usuario, pass, OUT tipo
	 * @param orden
	 * @return DEVUELVE UN CONJUNTO DE DATOS QUE REPRESENTA LA PERSONA
	 *  		SELECT * FROM Personas inner join Clientes 
	 */
	public String Login(){
		return "call Login(?,?,?)";
	}

	/**
	 * contrasena, usuario
	 * @return
	 */
	public String cambiarContrasena(){
		return "UPDATE Personas SET contrasena=? WHERE usuario=?";
	}
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	public String listar(String orden){
		return "SELECT * FROM Usuarios ORDER BY orden"
				.replaceAll("orden", orden);
	}

}
