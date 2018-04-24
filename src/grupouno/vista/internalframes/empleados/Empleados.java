package grupouno.vista.internalframes.empleados;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Empleados extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleados frame = new Empleados();
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
	public Empleados() 
	{
		//setBounds(100, 100, 450, 300);
		
		initComponent();

	}
	
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.empleados.PanelEmpleados panel = new grupouno.vista.internalframes.empleados.PanelEmpleados();
		panel.setVisible(true);
		
		//GroupLayout layout = new GroupLayout(getContentPane());
		
		
		this.add(panel);
		
	}

}
