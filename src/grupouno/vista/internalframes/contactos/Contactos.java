package grupouno.vista.internalframes.contactos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Contactos extends JInternalFrame
{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					Contactos frame = new Contactos();
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
	public Contactos() {
		//setBounds(100, 100, 450, 300);
		initComponent();

	}
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.contactos.PanelContactos panel = new grupouno.vista.internalframes.contactos.PanelContactos();
		panel.setVisible(true);
		
		//GroupLayout layout = new GroupLayout(getContentPane());
		
		
		this.add(panel);
		
	}

}
