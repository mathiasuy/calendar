package grupouno.vista.internalframes.agregarserviciosacita;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Agregarserviciosacita extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agregarserviciosacita frame = new Agregarserviciosacita();
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
	public Agregarserviciosacita() {
		//setBounds(100, 100, 450, 300);

	}

}
