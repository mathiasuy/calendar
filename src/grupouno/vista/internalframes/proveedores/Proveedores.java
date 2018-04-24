package grupouno.vista.internalframes.proveedores;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.GridBagConstraints;

public class Proveedores extends JInternalFrame {

	/**
	 * Launch the application.
	 
	 cacacacacaaca
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					Proveedores frame = new Proveedores();
					PanelProveedores panelProv =  new PanelProveedores();
					
					frame.add(panelProv);
					panelProv.setVisible(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the frame.
	 */
	public Proveedores() 
	{
		
		initComponent();
		
	}
	
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.proveedores.PanelProveedores panel = new grupouno.vista.internalframes.proveedores.PanelProveedores();
		panel.setVisible(true);

		
		this.add(panel);
		
	}
	
}
