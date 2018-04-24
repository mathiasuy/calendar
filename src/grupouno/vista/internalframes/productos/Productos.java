package grupouno.vista.internalframes.productos;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;


public class Productos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
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
	public Productos() 
	{
		
		initComponent();
		
		//setBounds(100, 100, 450, 300);
			

	}
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.productos.PanelProductos panel = new grupouno.vista.internalframes.productos.PanelProductos();
		panel.setVisible(true);
		
		//GroupLayout layout = new GroupLayout(getContentPane());
		
		
		this.add(panel);
		
	}
}
