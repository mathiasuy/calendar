package grupouno.vista.internalframes.clientes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

public class PanelClientes extends JPanel 
{
	
	GridBagConstraints gbc = new GridBagConstraints(); 
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtComentarios;
	private JTextField textField_1;
	private JTable table;
	private JTextField txtDocumento;
	private JTextField txtConvenio;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JTextField txtDescripcion;
	/**
	 * Create the panel.
	 */
	public PanelClientes() 
	{
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 80, 140, 100, 0, 100, 120, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 30, 30, 30, 30, 0, 30, 30, 30, 100, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitulo = new JLabel("Clientes");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 4;
		gbc_lblTitulo.gridheight = 2;
		gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 2;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.fill = GridBagConstraints.VERTICAL;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 1;
		gbc_lblID.gridy = 2;
		add(lblID, gbc_lblID);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 2;
		add(spinner, gbc_spinner);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.fill = GridBagConstraints.VERTICAL;
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 5;
		gbc_lblFechaDeNacimiento.gridy = 2;
		add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
//		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 6;
		gbc_dateChooser.gridy = 2;
//		add(dateChooser, gbc_dateChooser);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
		gbc_lblNombreCompleto.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCompleto.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCompleto.gridx = 1;
		gbc_lblNombreCompleto.gridy = 3;
		add(lblNombreCompleto, gbc_lblNombreCompleto);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.BOTH;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblConvenio = new JLabel("Convenio:");
		lblConvenio.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblConvenio = new GridBagConstraints();
		gbc_lblConvenio.anchor = GridBagConstraints.EAST;
		gbc_lblConvenio.fill = GridBagConstraints.VERTICAL;
		gbc_lblConvenio.insets = new Insets(0, 0, 5, 5);
		gbc_lblConvenio.gridx = 5;
		gbc_lblConvenio.gridy = 3;
		add(lblConvenio, gbc_lblConvenio);
		
		txtConvenio = new JTextField();
		GridBagConstraints gbc_txtConvenio = new GridBagConstraints();
		gbc_txtConvenio.insets = new Insets(0, 0, 5, 5);
		gbc_txtConvenio.fill = GridBagConstraints.BOTH;
		gbc_txtConvenio.gridx = 6;
		gbc_txtConvenio.gridy = 3;
		add(txtConvenio, gbc_txtConvenio);
		txtConvenio.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.fill = GridBagConstraints.VERTICAL;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 4;
		add(lblTelefono, gbc_lblTelefono);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.BOTH;
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 4;
		add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JCheckBox chckbxUsaSistema = new JCheckBox("Usa Sistema");
		chckbxUsaSistema.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxUsaSistema = new GridBagConstraints();
		gbc_chckbxUsaSistema.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxUsaSistema.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUsaSistema.gridx = 6;
		gbc_chckbxUsaSistema.gridy = 4;
		add(chckbxUsaSistema, gbc_chckbxUsaSistema);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSueldo = new GridBagConstraints();
		gbc_lblSueldo.anchor = GridBagConstraints.EAST;
		gbc_lblSueldo.fill = GridBagConstraints.VERTICAL;
		gbc_lblSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSueldo.gridx = 1;
		gbc_lblSueldo.gridy = 5;
		add(lblSueldo, gbc_lblSueldo);
		
		txtComentarios = new JTextField();
		GridBagConstraints gbc_txtComentarios = new GridBagConstraints();
		gbc_txtComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_txtComentarios.fill = GridBagConstraints.BOTH;
		gbc_txtComentarios.gridx = 2;
		gbc_txtComentarios.gridy = 5;
		add(txtComentarios, gbc_txtComentarios);
		txtComentarios.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 5;
		gbc_lblUsuario.gridy = 5;
		add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 6;
		gbc_txtUsuario.gridy = 5;
		add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDocumento = new GridBagConstraints();
		gbc_lblDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDocumento.gridx = 1;
		gbc_lblDocumento.gridy = 6;
		add(lblDocumento, gbc_lblDocumento);
		
		txtDocumento = new JTextField();
		GridBagConstraints gbc_txtDocumento = new GridBagConstraints();
		gbc_txtDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_txtDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDocumento.gridx = 2;
		gbc_txtDocumento.gridy = 6;
		add(txtDocumento, gbc_txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.anchor = GridBagConstraints.EAST;
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 5;
		gbc_lblContrasena.gridy = 6;
		add(lblContrasena, gbc_lblContrasena);
		
		txtContrasena = new JTextField();
		GridBagConstraints gbc_txtContrasena = new GridBagConstraints();
		gbc_txtContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_txtContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContrasena.gridx = 6;
		gbc_txtContrasena.gridy = 6;
		add(txtContrasena, gbc_txtContrasena);
		txtContrasena.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 7;
		add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.gridheight = 2;
		gbc_txtDescripcion.gridwidth = 5;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.gridx = 2;
		gbc_txtDescripcion.gridy = 7;
		add(txtDescripcion, gbc_txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFiltro = new GridBagConstraints();
		gbc_lblFiltro.anchor = GridBagConstraints.EAST;
		gbc_lblFiltro.fill = GridBagConstraints.VERTICAL;
		gbc_lblFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltro.gridx = 1;
		gbc_lblFiltro.gridy = 9;
		add(lblFiltro, gbc_lblFiltro);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 9;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
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
		gbc_chckbxHabilitado.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxHabilitado.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHabilitado.gridx = 1;
		gbc_chckbxHabilitado.gridy = 12;
		add(chckbxHabilitado, gbc_chckbxHabilitado);
		
		JButton btnCrearCopia = new JButton("Crear Copia");
		btnCrearCopia.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCrearCopia = new GridBagConstraints();
		gbc_btnCrearCopia.fill = GridBagConstraints.BOTH;
		gbc_btnCrearCopia.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearCopia.gridx = 3;
		gbc_btnCrearCopia.gridy = 12;
		add(btnCrearCopia, gbc_btnCrearCopia);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.BOTH;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 5;
		gbc_btnModificar.gridy = 12;
		add(btnModificar, gbc_btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 6;
		gbc_btnEliminar.gridy = 12;
		add(btnEliminar, gbc_btnEliminar);

	}

}
