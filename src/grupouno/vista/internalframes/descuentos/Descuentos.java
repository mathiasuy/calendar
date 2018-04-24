package grupouno.vista.internalframes.descuentos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Descuentos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Descuentos frame = new Descuentos();
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
	public Descuentos() {
		//setBounds(100, 100, 450, 300);
		
		initComponent();

	}
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.descuentos.PanelDescuentos panel = new grupouno.vista.internalframes.descuentos.PanelDescuentos();
		panel.setVisible(true);
		
		this.add(panel);
		
	}

}
