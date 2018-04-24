package grupouno.vista.internalframes.empleados;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEmpleados extends JPanel {

	GridBagConstraints gbc = new GridBagConstraints();
	private JTextField textField_1;
	private JTextField txtDocumento;
	private JTextField textDescripcion;
	private JTextField textFiltro;
	private JTable table;
	private JTextField txtTelefono;
	private JTextField txtSueldo;
	private JTextField txtCarnetDeSalud;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	
	/**
	 * Create the panel.
	 */
	public PanelEmpleados() 
	{
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 80, 140, 100, 20, 100, 120, 50};
		gridBagLayout.rowHeights = new int[]{50, 30, 30, 30, 30, 30, 30, 30, 0, 30, 100, 0, 0, 40, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitulo = new JLabel("Administrar Empleados");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 6;
		gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.fill = GridBagConstraints.VERTICAL;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 1;
		gbc_lblID.gridy = 1;
		add(lblID, gbc_lblID);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 1;
		add(spinner, gbc_spinner);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.fill = GridBagConstraints.BOTH;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 5;
		gbc_lblFechaDeNacimiento.gridy = 1;
		add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
//		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 6;
		gbc_dateChooser.gridy = 1;
//		add(dateChooser, gbc_dateChooser);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo :");
		lblNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
		gbc_lblNombreCompleto.fill = GridBagConstraints.BOTH;
		gbc_lblNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCompleto.gridx = 1;
		gbc_lblNombreCompleto.gridy = 2;
		add(lblNombreCompleto, gbc_lblNombreCompleto);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCarnetDeSalud = new JLabel("Carnet de salud:");
		GridBagConstraints gbc_lblCarnetDeSalud = new GridBagConstraints();
		gbc_lblCarnetDeSalud.anchor = GridBagConstraints.EAST;
		gbc_lblCarnetDeSalud.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarnetDeSalud.gridx = 5;
		gbc_lblCarnetDeSalud.gridy = 2;
		add(lblCarnetDeSalud, gbc_lblCarnetDeSalud);
		
		txtCarnetDeSalud = new JTextField();
		GridBagConstraints gbc_txtCarnetDeSalud = new GridBagConstraints();
		gbc_txtCarnetDeSalud.insets = new Insets(0, 0, 5, 5);
		gbc_txtCarnetDeSalud.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCarnetDeSalud.gridx = 6;
		gbc_txtCarnetDeSalud.gridy = 2;
		add(txtCarnetDeSalud, gbc_txtCarnetDeSalud);
		txtCarnetDeSalud.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 3;
		add(lblTelefono, gbc_lblTelefono);
		
		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.BOTH;
		gbc_txtTelefono.gridx = 2;
		gbc_txtTelefono.gridy = 3;
		add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSueldo = new GridBagConstraints();
		gbc_lblSueldo.anchor = GridBagConstraints.EAST;
		gbc_lblSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSueldo.gridx = 1;
		gbc_lblSueldo.gridy = 4;
		add(lblSueldo, gbc_lblSueldo);
		
		txtSueldo = new JTextField();
		GridBagConstraints gbc_txtSueldo = new GridBagConstraints();
		gbc_txtSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_txtSueldo.fill = GridBagConstraints.BOTH;
		gbc_txtSueldo.gridx = 2;
		gbc_txtSueldo.gridy = 4;
		add(txtSueldo, gbc_txtSueldo);
		txtSueldo.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 5;
		gbc_lblUsuario.gridy = 4;
		add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.BOTH;
		gbc_txtUsuario.gridx = 6;
		gbc_txtUsuario.gridy = 4;
		add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDocumento = new GridBagConstraints();
		gbc_lblDocumento.fill = GridBagConstraints.VERTICAL;
		gbc_lblDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDocumento.gridx = 1;
		gbc_lblDocumento.gridy = 5;
		add(lblDocumento, gbc_lblDocumento);
		
		txtDocumento = new JTextField();
		GridBagConstraints gbc_txtDocumento = new GridBagConstraints();
		gbc_txtDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_txtDocumento.fill = GridBagConstraints.BOTH;
		gbc_txtDocumento.gridx = 2;
		gbc_txtDocumento.gridy = 5;
		add(txtDocumento, gbc_txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.anchor = GridBagConstraints.EAST;
		gbc_lblContrasena.fill = GridBagConstraints.VERTICAL;
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 5;
		gbc_lblContrasena.gridy = 5;
		add(lblContrasena, gbc_lblContrasena);
		
		txtContrasena = new JTextField();
		GridBagConstraints gbc_txtContrasena = new GridBagConstraints();
		gbc_txtContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_txtContrasena.fill = GridBagConstraints.BOTH;
		gbc_txtContrasena.gridx = 6;
		gbc_txtContrasena.gridy = 5;
		add(txtContrasena, gbc_txtContrasena);
		txtContrasena.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 6;
		add(lblDescripcion, gbc_lblDescripcion);
		
		textDescripcion = new JTextField();
		GridBagConstraints gbc_textDescripcion = new GridBagConstraints();
		gbc_textDescripcion.gridheight = 2;
		gbc_textDescripcion.gridwidth = 5;
		gbc_textDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textDescripcion.gridx = 2;
		gbc_textDescripcion.gridy = 6;
		add(textDescripcion, gbc_textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFiltro = new GridBagConstraints();
		gbc_lblFiltro.anchor = GridBagConstraints.EAST;
		gbc_lblFiltro.fill = GridBagConstraints.VERTICAL;
		gbc_lblFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltro.gridx = 1;
		gbc_lblFiltro.gridy = 9;
		add(lblFiltro, gbc_lblFiltro);
		
		textFiltro = new JTextField();
		GridBagConstraints gbc_textFiltro = new GridBagConstraints();
		gbc_textFiltro.gridwidth = 3;
		gbc_textFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_textFiltro.fill = GridBagConstraints.BOTH;
		gbc_textFiltro.gridx = 2;
		gbc_textFiltro.gridy = 9;
		add(textFiltro, gbc_textFiltro);
		textFiltro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 10;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JCheckBox chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxHabilitado = new GridBagConstraints();
		gbc_chckbxHabilitado.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHabilitado.gridx = 1;
		gbc_chckbxHabilitado.gridy = 13;
		add(chckbxHabilitado, gbc_chckbxHabilitado);
		
		JButton btnCrearCopia = new JButton("Crear Copia");
		btnCrearCopia.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCrearCopia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnCrearCopia = new GridBagConstraints();
		gbc_btnCrearCopia.fill = GridBagConstraints.BOTH;
		gbc_btnCrearCopia.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearCopia.gridx = 2;
		gbc_btnCrearCopia.gridy = 13;
		add(btnCrearCopia, gbc_btnCrearCopia);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 3;
		gbc_btnAgregar.gridy = 13;
		add(btnAgregar, gbc_btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.BOTH;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 5;
		gbc_btnModificar.gridy = 13;
		add(btnModificar, gbc_btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 6;
		gbc_btnEliminar.gridy = 13;
		add(btnEliminar, gbc_btnEliminar);

	}

}
