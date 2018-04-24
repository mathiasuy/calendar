package grupouno.vista.internalframes.clientes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Clientes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() 
	{
		//setBounds(100, 100, 450, 300);
		
		initComponent();

	}
	
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.clientes.PanelClientes panel = new grupouno.vista.internalframes.clientes.PanelClientes();
		panel.setVisible(true);
		
		//GroupLayout layout = new GroupLayout(getContentPane());
		
		
		this.add(panel);
		
	}

}
