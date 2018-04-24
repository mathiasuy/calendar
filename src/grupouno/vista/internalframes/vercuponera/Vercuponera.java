package grupouno.vista.internalframes.vercuponera;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Vercuponera extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vercuponera frame = new Vercuponera();
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
	public Vercuponera() {
		//setBounds(100, 100, 450, 300);
		
		initComponent();

	}
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.vercuponera.PanelVercuponera panel = new grupouno.vista.internalframes.vercuponera.PanelVercuponera();
		panel.setVisible(true);
		
		this.add(panel);
		
	}

}
