package grupouno.dao.consultas;

public class ConsultasCitas extends Consultas{

	/**
	 * citaID, clienteID, empleadoID, descripcion, fecha_de_cita, concretada
	 */
	@Override
	public String alta() {
		// TODO Auto-generated method stub
		return "INSERT INTO Citas (citaID, clienteID, empleadoID, descripcion, fecha_de_cita, concretada) VALUES "
				+ " (?,?,?,?,?,?);";
	}
	
	/**
	 * citaID
	 */
	@Override
	public String baja() {
		return "DELETE Citas WHERE "
				+ " citaID=?";
	}

	/**
	 * citaID=?, clienteID=?, empleadoID=?, descripcion=?, fecha_de_cita=?, concretada=?
	 */
	@Override
	public String modificar() {
		return "UPDATE Citas SET citaID=?, clienteID=?, empleadoID=?, descripcion=?, fecha_de_cita=?, concretada=? WHERE "
				+ " citaID=?";
	}

	/**
	 * citaID
	 */
	@Override
	public String obtener() {
		return "SELECT * FROM Citas WHERE citaID=?";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	@Override
	public String buscar(String columna, String orden){
		return "SELECT * FROM Citas WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	@Override
	public String listar(String orden){
		return "SELECT * FROM Citas ORDER BY orden"
				.replaceAll("orden", orden);
	}
	
	
	/**
	 *  citaID,descuentoID,duracion,precio,servicioID
	 * @param orden
	 * @return itemID
	 */
	public String agregarItemACita(){
		return "INSERT INTO itemsCitas(citaID,descuentoID,duracion,precio,servicioID) VALUES "
				+ "(?,?,?,?,?)";
	}
	
	/**
	 *  itemID
	 * @param orden
	 * @return
	 */
	public String quitarItemACita(){
		return "DELETE FROM itemsCitas WHERE itemID=?";
	}		
	
	/**
	 *  citaID
	 * @param orden
	 * @return
	 */
	public String listarServiciosXCita(){
		return "SELECT * FROM ItemsCitas WHERE citaID=?";
	}			
	
	/**
	 *  fecha_inicio, fecha_fin
	 * @param orden
	 * @return
	 */
	public String listarCitasEntre(){
		return "call listarCitasEntre(?,?)";
	}			

	/**
	 *  fecha
	 * @param orden
	 * @return
	 */
	public String listarCitasDeldia(){
		return "call listarCitasEntre(?)";
	}				
	
	/**
	 * filtro
	 * @param columna: Puede ser: NombreCliente, NombreEmpleado, NombreServicio, DescripcionServicio, NombreDescuento, DescripcionDescuento
	 * @return lista de items con datos de citas y parametros de arriba
	 */
	public String filtroItemsCitas(String columna, String orden){
		return "SELECT" 
				+ " obtenerNombrePersona(Citas.clienteID) as Cliente,"
				+ " obtenerNombrePersona(Citas.empleadoID) as Empleado,"
				+ " Citas.*,"
				+ " ItemsCitas.*,"
				+ " obtenerNombreServicio(ItemsCitas.servicioID) as NombreServicio,"
				+ " obtenerDescripcionServicio(ItemsCitas.servicioID) as DescripcionServicio,"
				+ " obtenerNombreDescuento(ItemsCitas.descuentoID) as NombreDescuento,"
				+ " obtenerDescripcionDescuento(ItemsCitas.descuentoID) as DescripcionDescuento"
				+ " FROM ItemsCitas inner join Citas on ItemsCitas.citaID = Citas.citaID"
				+ " having columna like ? ORDER BY orden;".replaceAll("columna", columna).replaceAll("orden", orden);
	}

	/**
	 * 
	 * @param filtroEmpleado, filtroCliente, filtroNombreServicio, filtroDescripcionServicio
	 * @return lista de items con datos de citas y parametros de arriba
	 */
	public String filtroItemsCitas(){
		return "SELECT "
				+ " obtenerNombrePersona(Citas.clienteID) as Cliente,"
				+ " obtenerNombrePersona(Citas.empleadoID) as Empleado,"
				+ " Citas.*,"
				+ " ItemsCitas.*,"
				+ " obtenerNombreServicio(ItemsCitas.servicioID) as NombreServicio,"
				+ " obtenerDescripcionServicio(ItemsCitas.servicioID) as DescripcionServicio,"
				+ " obtenerNombreDescuento(ItemsCitas.descuentoID) as NombreDescuento,"
				+ " obtenerDescripcionDescuento(ItemsCitas.descuentoID) as DescripcionDescuento"
				+ " FROM ItemsCitas inner join Citas on ItemsCitas.citaID = Citas.citaID"
//				+ " where fecha_de_cita between ? AND ?"
				+ " having Empleado like ?" 
				+ " OR Cliente like ?"
				+ " OR NombreServicio like ?"
				+ " OR DescripcionServicio like ? "
				+ " order by fecha_de_cita";
	}

	
	/**
	 * desde, hasta, filtro
	 * @param columna: Puede ser: NombreCliente, NombreEmpleado, NombreServicio, DescripcionServicio, NombreDescuento, DescripcionDescuento
	 * @return lista de items con datos de citas y parametros de arriba
	 */
	public String filtroItemsCitasEntreFechas(String columna, String orden){
		return "SELECT" 
				+ " obtenerNombrePersona(Citas.clienteID) as Cliente,"
				+ " obtenerNombrePersona(Citas.empleadoID) as Empleado,"
				+ " Citas.*,"
				+ " ItemsCitas.*,"
				+ " obtenerNombreServicio(ItemsCitas.servicioID) as NombreServicio,"
				+ " obtenerDescripcionServicio(ItemsCitas.servicioID) as DescripcionServicio,"
				+ " obtenerNombreDescuento(ItemsCitas.descuentoID) as NombreDescuento,"
				+ " obtenerDescripcionDescuento(ItemsCitas.descuentoID) as DescripcionDescuento"
				+ " FROM ItemsCitas inner join Citas on ItemsCitas.citaID = Citas.citaID"
				+ " where fecha_de_cita between ? AND ?"
				+ " having columna like ? ORDER BY orden;".replaceAll("columna", columna).replaceAll("orden", orden);
	}

	public String listarItemsConServicio() {
		// TODO Auto-generated method stub
		return "SELEC * FROM ItemsCitas WHERE servicioID=?";
	}	
}
