package grupouno.dao.consultas;

public abstract class Consultas {

	public String getID(){
		return "select @@identity as id";
	}
	
	public abstract String alta();
	public abstract String baja();
	public abstract String modificar();
	public abstract String obtener();
	public abstract String buscar(String columna, String orden);
	public abstract String listar(String orden);
	
}
