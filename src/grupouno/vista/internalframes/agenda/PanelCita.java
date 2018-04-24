package grupouno.vista.internalframes.agenda;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import grupouno.controladores.FactoryControladores;
import grupouno.dto.Cita;
import grupouno.dto.CitaSimple;
import grupouno.vista.ventana.Principal;

//import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PanelCita extends JPanel 
{
	private JTextField txtCliente;
	private JTextField txtEmpleado;
	private JTextField txtPrecio;
	private LocalDate fecha ;
	private LocalTime hora ;
	private JButton btnModificar;
	private JButton btnAceptar;
	private JButton btnBorrar;
    private Font negrilla = new Font( "Helvetica",Font.BOLD,18 );
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private JLabel lblNuevaCita;
	private JTextArea txtDescripcion;
	private JCheckBox checkBoxSalida;
	
	private void cerrar(LocalDate fecha, LocalTime horas) {
		// TODO Auto-generated method stub
		grupouno.vista.internalframes.agenda.Cita.getCita(fecha, hora).cerrar(fecha,hora);
	}	
	
	/**
	 * Create the panel.
	 */
	public PanelCita() 
	{
		new PanelCita(LocalDate.now(),LocalTime.now());
	}

	public PanelCita(LocalDate fecha, LocalTime hora) {
		this.fecha = fecha;
		this.hora =  hora;
//		JOptionPane.showMessageDialog(this, fecha + " " + hora);

		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{24, 48, 100, 100, 45};
		gridBagLayout.rowHeights = new int[]{33, 0, 0, 0, 30, 30, 30, 30, 0, 27, 59, 0, 30, 0, 0, 40, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		this.setBackground(Color.white);
		
		lblNuevaCita = new JLabel("");
		lblNuevaCita.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNuevaCita = new GridBagConstraints();
		gbc_lblNuevaCita.gridwidth = 2;
		gbc_lblNuevaCita.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaCita.gridx = 2;
		gbc_lblNuevaCita.gridy = 0;
		add(lblNuevaCita, gbc_lblNuevaCita);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 2;
		add(lblFecha, gbc_lblFecha);
		
		JLabel lblMensaje = new JLabel(hora + "  -  " + fecha.format(dtf));
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.gridwidth = 2;
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.gridx = 2;
		gbc_lblMensaje.gridy = 2;
		lblMensaje.setFont(negrilla);
		lblMensaje.setForeground(Color.red);
		add(lblMensaje, gbc_lblMensaje);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 4;
		add(lblCliente, gbc_lblCliente);
		
		txtCliente = new JTextField();
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.gridwidth = 2;
		gbc_txtCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCliente.fill = GridBagConstraints.BOTH;
		gbc_txtCliente.gridx = 2;
		gbc_txtCliente.gridy = 4;
		add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblEmpleado = new GridBagConstraints();
		gbc_lblEmpleado.anchor = GridBagConstraints.EAST;
		gbc_lblEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmpleado.gridx = 1;
		gbc_lblEmpleado.gridy = 6;
		add(lblEmpleado, gbc_lblEmpleado);
		
		txtEmpleado = new JTextField();
		GridBagConstraints gbc_txtEmpleado = new GridBagConstraints();
		gbc_txtEmpleado.gridwidth = 2;
		gbc_txtEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmpleado.fill = GridBagConstraints.BOTH;
		gbc_txtEmpleado.gridx = 2;
		gbc_txtEmpleado.gridy = 6;
		add(txtEmpleado, gbc_txtEmpleado);
		txtEmpleado.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 8;
		add(lblDescripcion, gbc_lblDescripcion);
		
		//		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 8;
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FactoryControladores f = new FactoryControladores();
					ArrayList<CitaSimple> citas = f.getCCitasSimples().deHora(LocalDateTime.of(fecha, hora));
					CitaSimple cita;
					for (CitaSimple cs : citas){
						cs.setCliente(txtCliente.getText());
						cs.setDescripcion(txtDescripcion.getText());
						cs.setEmpleado(txtEmpleado.getText());
//						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("");
						cs.setFecha_de_cita(LocalDateTime.of(fecha, hora));
						try{
							double d = Double.parseDouble(txtPrecio.getText());
							if (checkBoxSalida.isSelected()){
								if (d>0){
									cs.setPrecio(-d);									
								}else{
									cs.setPrecio(d);
								}
							}else {
								if (d<0){
									cs.setPrecio(d*-1);									
								}else {
									cs.setPrecio(d);
								}
							}
						}catch (NumberFormatException e){
							throw new Error("Solo se permiten números");
						}
						f.getCCitasSimples().modificar(cs);					
					}

					grupouno.vista.internalframes.agenda.PanelAgenda.cargarLista();
					cerrar(fecha, hora);
				} catch (Error er){
					JOptionPane.showMessageDialog(null, er.getMessage());
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}				
		});
				
				txtDescripcion = new JTextArea();
				GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
				gbc_txtDescripcion.gridwidth = 2;
				gbc_txtDescripcion.gridheight = 3;
				gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
				gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
				gbc_txtDescripcion.gridx = 2;
				gbc_txtDescripcion.gridy = 8;
				add(txtDescripcion, gbc_txtDescripcion);
				
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
				GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
				gbc_lblPrecio.anchor = GridBagConstraints.EAST;
				gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
				gbc_lblPrecio.gridx = 1;
				gbc_lblPrecio.gridy = 12;
				add(lblPrecio, gbc_lblPrecio);		
				
				txtPrecio = new JTextField();
				txtPrecio.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						txtPrecio.selectAll();
					}
				});
				txtPrecio.setText("0");
				GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
				gbc_txtPrecio.gridwidth = 2;
				gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
				gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPrecio.gridx = 2;
				gbc_txtPrecio.gridy = 12;
				add(txtPrecio, gbc_txtPrecio);
				txtPrecio.setColumns(10);
		//		add(dateChooser, gbc_dateChooser);
				
				JCheckBox chckbxConcretada = new JCheckBox("Concretada");
				chckbxConcretada.setFont(new Font("Arial", Font.PLAIN, 12));
				GridBagConstraints gbc_chckbxConcretada = new GridBagConstraints();
				gbc_chckbxConcretada.fill = GridBagConstraints.BOTH;
				gbc_chckbxConcretada.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxConcretada.gridx = 2;
				gbc_chckbxConcretada.gridy = 14;
				add(chckbxConcretada, gbc_chckbxConcretada);
		
		checkBoxSalida = new JCheckBox("Es salida");
		checkBoxSalida.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		checkBoxSalida.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_checkBoxSalida = new GridBagConstraints();
		gbc_checkBoxSalida.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxSalida.gridx = 3;
		gbc_checkBoxSalida.gridy = 14;
		add(checkBoxSalida, gbc_checkBoxSalida);
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 2;
		gbc_btnModificar.gridy = 15;
		add(btnModificar, gbc_btnModificar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FactoryControladores f = new FactoryControladores();
					CitaSimple cs = new CitaSimple();
					cs.setCliente(txtCliente.getText());
					cs.setDescripcion(txtDescripcion.getText());
					cs.setEmpleado(txtEmpleado.getText());
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("");
					cs.setFecha_de_cita(LocalDateTime.of(fecha, hora));
					try{
						if (checkBoxSalida.isSelected()){
							cs.setPrecio(-Double.parseDouble(txtPrecio.getText()));
						}else {
							cs.setPrecio(Double.parseDouble(txtPrecio.getText()));
						}
					}catch (NumberFormatException e){
						throw new Error("Solo se permiten números");
					}
					f.getCCitasSimples().alta(cs);
					grupouno.vista.internalframes.agenda.PanelAgenda.cargarLista();
					cerrar(fecha, hora);
				} catch (Error er){
					JOptionPane.showMessageDialog(null, er.getMessage());
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}				

		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(0==JOptionPane.showConfirmDialog(null, "¿Esta seguro de lo que hace?", "Alerta, va a borrar la cita! :'(!", JOptionPane.YES_NO_OPTION))
				{
					try {
						FactoryControladores f = new FactoryControladores();
						ArrayList<CitaSimple> citas = f.getCCitasSimples().deHora(LocalDateTime.of(fecha,hora));
						for (CitaSimple cs : citas){
							f.getCCitasSimples().baja(cs.getCitaSimpleID());
							grupouno.vista.internalframes.agenda.PanelAgenda.borrarCampo(fecha, hora);
							grupouno.vista.internalframes.agenda.PanelAgenda.cargarLista();
						}
						cerrar(fecha, hora);													
					} catch (Error er){
						JOptionPane.showMessageDialog(null, er.getMessage());
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		btnBorrar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 3;
		gbc_btnBorrar.gridy = 15;
		add(btnBorrar, gbc_btnBorrar);
		
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 16;
		add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrar(fecha, hora);
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 16;
		add(btnCancelar, gbc_btnCancelar);

		cargarDatos(fecha, hora);
	}
	
	private  void  cargarDatos(LocalDate fecha, LocalTime hora){
		try {
			FactoryControladores f = new FactoryControladores();
			ArrayList<CitaSimple> citas = f.getCCitasSimples().deHora(LocalDateTime.of(fecha, hora));
			
			for (CitaSimple cs : citas){
				txtCliente.setText(cs.getCliente());
				txtDescripcion.setText(cs.getDescripcion());
				txtEmpleado.setText(cs.getEmpleado());
				checkBoxSalida.setSelected(cs.getPrecio() < 0);
				txtPrecio.setText(cs.getPrecio() + "");
				
			}
			if (citas.isEmpty()){
				lblNuevaCita.setText("Nueva Cita");
				btnAceptar.setEnabled(true);
				btnModificar.setEnabled(false);
				btnBorrar.setEnabled(false);
			}else{
				lblNuevaCita.setText("Modificar/Borrar Cita");
				btnAceptar.setEnabled(false);
				btnModificar.setEnabled(true);
				btnBorrar.setEnabled(true);
			}
		} catch (Error er){
			JOptionPane.showMessageDialog(null, er.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
