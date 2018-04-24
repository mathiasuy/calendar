package grupouno.dao.consultas;

public class ConsultasClientes extends Consultas {
/***   Clientes *****/
	
	/**nombre,  documento, fecha_de_nacimiento, comentarios, telefono, usuario,
		contrasena, habilitado, descuentoID, OUT exito
	 * 
	 * @return
	 */
	@Override
	public String alta(){
		return "call AltaCliente(?,?,?,?,?,?,?,?,?,?)";
	}

	/**
	 * documento, OUT exito
	 * @return
	 */
	@Override
	public String baja(){
		return "call bajaCliente(?,?)";
	}
	
	/**
	 * personaID, nombre, documento, fecha_de_nacimiento,comentarios, telefono, usuario, contrasena, habilitado
	 * descuentoID, OUT exito
	 * @return
	 */
	@Override
	public String modificar(){
		return "call modificarCliente(?,?,?,?,?,?,?,?,?,?,?)";
	}
    	
	/**
	 * clienteID
	 * @return
	 */
	@Override
	public String obtener(){
		return "SELECT * FROM Clientes inner join Personas on Personas.personaID = Clientes.clienteID"
				+ " WHERE clienteID=?";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	@Override
	public String buscar(String columna, String orden)
	{
		return "SELECT * FROM Clientes inner join Personas"
				+ " on Personas.personaID = Clientes.clienteID"
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
		return "call filtroClientes("+filtro+")";
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	@Override
	public String listar(String orden)
	{
		return "SELECT * FROM Clientes inner join Personas"
				+ " on Personas.personaID = Clientes.clienteID"
				+ " ORDER BY orden"
				.replaceAll("orden", orden);
	}
	
	/**
	 *  clienteID, productoID
	 * @param orden
	 * @return BOOL
	 */
	public String tieneClienteConenioEnProducto()
	{
		return "SELECT tieneClienteConenioEnProducto(?.?)";
	}
	
	/**
	 *  clienteID,  servicioID
	 * @param orden
	 * @return BOOL
	 */
	public String tieneClienteConenioEnServicio()
	{
		return "SELECT tieneClienteConenioEnServicio(?,?)";
	}

}
