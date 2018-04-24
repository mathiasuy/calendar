package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dao.FactoryDAO;
import grupouno.dto.Proveedor;
import grupouno.dto.Usuario;
import grupouno.interfaces.IMetodos;

public class CUsuario 
{
	private FactoryDAO FACTORY_DAO = new FactoryDAO();

	public int Login(Usuario c) 	{
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOUsuarios().Login(c);
	}

	
	public int CambiarContrasena(String usuario,String contrasena) 	{
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAOUsuarios().cambiarContrasena(usuario, contrasena);
		
	}
	public ArrayList<Usuario> listar()	{
		return FACTORY_DAO.getDAOUsuarios().listar();
	} 

	

}
