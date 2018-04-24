package grupouno.dao.consultas;

public class ConsultasEmpleados extends Consultas{

	
/***   Empleados *****/
	
	/**nombre,  documento, fecha_de_nacimiento, comentarios, telefono, usuario, contrasena,
		habilitado, fecha_vencimiento_carnet_de_salud, sueldo, OUT exito
	 * 
	 * @return
	 */
	@Override
	public String alta(){
		return "call altaEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	/**
	 * documento, OUT exito
	 * @return
	 */
	@Override
	public String baja(){
		return "call bajaEmpleado(?,?)";
	}
	
	/**
	 * personaID, nombre, documento, fecha_de_nacimiento, comentarios, telefono, usuario, contrasena, habilitado, 
	 * vencimiento_carnet_de_salud, sueldo, OUT exito
	 * @return
	 */
	@Override
	public String modificar(){
		return "call modificarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)";
	}
    	
	/**
	 * empleadoID
	 * @return
	 */
	@Override
	public String obtener(){
		return "call obtenerEmpleado(?)";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	@Override
	public String buscar(String columna, String orden)
	{
		return "	SELECT Personas.*, Empleados.vencimiento_carnet_de_salud, Empleados.sueldo"
				+ " FROM Personas RIGHT JOIN Empleados on Personas.personaID = Empleados.empleadoID"
				+ " WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	
	
	/**
	 * 
	 * @param filtro
	 * @return
	 */
	public String filtro(String filtro)
	{
		return "call filtroEmpleados("+filtro+")";
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	@Override
	public String listar(String orden)
	{
		return "	SELECT Personas.*, Empleados.vencimiento_carnet_de_salud, Empleados.sueldo"
				+ " FROM Personas RIGHT JOIN Empleados on Personas.personaID = Empleados.empleadoID order by orden;"
				.replaceAll("orden", orden);
	}
}
