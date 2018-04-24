package grupouno.vista.internalframes.agenda;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class Agenda extends JInternalFrame {

	static JDesktopPane fondo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
//	public Agenda() {
//		//setBounds(100, 100, 450, 300);
//		
//		initComponent();
//	}
	
	public Agenda() {
		// TODO Auto-generated constructor stub
		initComponent();
	}

	private void initComponent()
	{
		
		grupouno.vista.internalframes.agenda.PanelAgenda panel = new grupouno.vista.internalframes.agenda.PanelAgenda();
		panel.setVisible(true);
		
		this.add(panel);
		
	}

}
