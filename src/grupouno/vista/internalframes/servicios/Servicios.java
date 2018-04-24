package grupouno.vista.internalframes.servicios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Servicios extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicios frame = new Servicios();
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
	public Servicios() 
	{
		initComponent();
		//setBounds(100, 100, 450, 300);

	}
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.servicios.PanelServicios panel = new grupouno.vista.internalframes.servicios.PanelServicios();
		panel.setVisible(true);
		
		//GroupLayout layout = new GroupLayout(getContentPane());
		
		
		this.add(panel);
		
	}

}
