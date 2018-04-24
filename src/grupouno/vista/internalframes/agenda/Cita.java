package grupouno.vista.internalframes.agenda;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Cita extends JInternalFrame {

	private static Cita instancia = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cita frame = new Cita();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	
	public static Cita getCita(LocalDate fecha, LocalTime hora){
		if (instancia == null){
			instancia = new Cita(fecha, hora);
		}else{
			instancia.dispose();
			instancia = new Cita(fecha, hora);
		}
		return instancia;
	};
	
	/**
	 * Create the frame.
	 */
	private Cita(LocalDate fecha, LocalTime hora) {
		//setBounds(100, 100, 450, 300);
		initComponent(fecha,hora);
	}

	public void cerrar(LocalDate fecha,LocalTime hora){
		grupouno.vista.internalframes.agenda.PanelAgenda.seleccionar(fecha,hora);
		this.dispose();
	}
	
	private void initComponent(LocalDate fecha, LocalTime hora)
	{
		PanelCita pnl = new PanelCita(fecha,hora);
		FlowLayout gridLayout = new FlowLayout();
		getContentPane().setLayout(gridLayout);
		getContentPane().add(pnl);
		pnl.setVisible(true);
//		getContentPane().add(pnl, BorderLayout.NORTH);
	}

}
