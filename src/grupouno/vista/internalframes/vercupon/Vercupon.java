package grupouno.vista.internalframes.vercupon;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Vercupon extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vercupon frame = new Vercupon();
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
	public Vercupon() {
		//setBounds(100, 100, 450, 300);
		
		initComponent();

	}
	
	private void initComponent()
	{
		
		grupouno.vista.internalframes.vercupon.PanelVercupon panel = new grupouno.vista.internalframes.vercupon.PanelVercupon();
		panel.setVisible(true);
		
		this.add(panel);
		
	}

}
