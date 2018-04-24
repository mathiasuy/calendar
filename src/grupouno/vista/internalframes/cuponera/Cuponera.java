package grupouno.vista.internalframes.cuponera;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Cuponera extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuponera frame = new Cuponera();
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
	public Cuponera() {
		//setBounds(100, 100, 450, 300);
		
		initComponent();

	}
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.cuponera.PanelCuponera panel = new grupouno.vista.internalframes.cuponera.PanelCuponera();
		panel.setVisible(true);
		
		this.add(panel);
		
	}

}
