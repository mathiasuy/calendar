package grupouno.controladores;

import java.util.ArrayList;
import java.util.Date;

import grupouno.dto.Descuento;
import grupouno.interfaces.IMetodosDAO;

public class CDescuentos  implements IMetodosDAO<Descuento>
{
	
	public void validar(Descuento c)
	{
		if(c.getFecha_de_expiracion().compareTo(new java.util.Date()) <= 0)
		{
			throw new Error("Fecha de expiracion es anterior a la fecha de hoy");
		}
		
		if(c.getNombre().trim().isEmpty())
		{
			throw new Error("Debe ingresar un Nombre");
		}
		
	}
	
	
	@Override
	public int alta(Descuento c) 
	{
		validar(c);
				
		
		return FACTORY_DAO.getDAODescuentos().alta(c);
	}
	
	

	@Override
	public int baja(Object key) 
	{	
		
		return FACTORY_DAO.getDAODescuentos().baja(key);
	}

	@Override
	public int modificar(Descuento c)
	{
		validar(c);
		
		ArrayList<Descuento> l = FACTORY_DAO.getDAODescuentos().listar();
		
		for(Descuento d:l)
		{
			if(d.getNombre().equals(c.getNombre()) &&
			   d.getDescuentoID() != c.getDescuentoID())
			{
				throw new Error("hay un elemento con el mismo Nombre");
				
			}
		}
		
		return FACTORY_DAO.getDAODescuentos().modificar(c);
	}

	@Override
	public Descuento obtener(Object key) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAODescuentos().obtener(key);
	}

	@Override
	public ArrayList<Descuento> listar() {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAODescuentos().listar();
	}

	@Override
	public ArrayList<Descuento> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return FACTORY_DAO.getDAODescuentos().filtro(campo, filter);
	}

}
