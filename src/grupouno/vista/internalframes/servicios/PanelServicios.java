package grupouno.vista.internalframes.servicios;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
//import com.toedter.calendar.JDateChooser;

public class PanelServicios extends JPanel 
{
	GridBagConstraints gbc = new GridBagConstraints();
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTable table;
	private JTextField txtFiltro;
	private JTextField txtPrecio;
	private JTextField txtDuracion;

	/**
	 * Create the panel.
	 */
	public PanelServicios() 
	{
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 80, 120, 20, 50, 50, 120, 120, 120, 120, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 30, 0, 30, 30, 30, 30, 30, 30, 30, 100, 0, 40, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblServicios = new GridBagConstraints();
		gbc_lblServicios.fill = GridBagConstraints.VERTICAL;
		gbc_lblServicios.gridheight = 2;
		gbc_lblServicios.gridwidth = 9;
		gbc_lblServicios.insets = new Insets(0, 0, 5, 5);
		gbc_lblServicios.gridx = 1;
		gbc_lblServicios.gridy = 0;
		add(lblServicios, gbc_lblServicios);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.fill = GridBagConstraints.VERTICAL;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 1;
		gbc_lblID.gridy = 2;
		add(lblID, gbc_lblID);
		
		txtID = new JTextField();
		GridBagConstraints gbc_txtID = new GridBagConstraints();
		gbc_txtID.insets = new Insets(0, 0, 5, 5);
		gbc_txtID.fill = GridBagConstraints.BOTH;
		gbc_txtID.gridx = 2;
		gbc_txtID.gridy = 2;
		add(txtID, gbc_txtID);
		txtID.setColumns(10);
		
	
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.fill = GridBagConstraints.BOTH;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 6;
		gbc_lblPrecio.gridy = 2;
		add(lblPrecio, gbc_lblPrecio);
		
		
		
		txtPrecio = new JTextField();
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.gridwidth = 2;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.BOTH;
		gbc_txtPrecio.gridx = 7;
		gbc_txtPrecio.gridy = 2;
		add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
		gbc_lblNombreCompleto.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombreCompleto.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCompleto.gridx = 1;
		gbc_lblNombreCompleto.gridy = 4;
		add(lblNombreCompleto, gbc_lblNombreCompleto);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.BOTH;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 4;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblFechaIngresado = new JLabel("Fecha Ingresado:");
		lblFechaIngresado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFechaIngresado = new GridBagConstraints();
		gbc_lblFechaIngresado.fill = GridBagConstraints.BOTH;
		gbc_lblFechaIngresado.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaIngresado.gridx = 6;
		gbc_lblFechaIngresado.gridy = 4;
		add(lblFechaIngresado, gbc_lblFechaIngresado);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.anchor = GridBagConstraints.EAST;
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 1;
		gbc_lblDuracion.gridy = 6;
		add(lblDuracion, gbc_lblDuracion);
		
		txtDuracion = new JTextField();
		GridBagConstraints gbc_txtDuracion = new GridBagConstraints();
		gbc_txtDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDuracion.fill = GridBagConstraints.BOTH;
		gbc_txtDuracion.gridx = 2;
		gbc_txtDuracion.gridy = 6;
		add(txtDuracion, gbc_txtDuracion);
		txtDuracion.setColumns(10);
		
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
		gbc_txtDescripcion.gridwidth = 7;
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
		gbc_lblFiltro.gridy = 10;
		add(lblFiltro, gbc_lblFiltro);
		
		txtFiltro = new JTextField();
		GridBagConstraints gbc_txtFiltro = new GridBagConstraints();
		gbc_txtFiltro.gridwidth = 4;
		gbc_txtFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_txtFiltro.fill = GridBagConstraints.BOTH;
		gbc_txtFiltro.gridx = 2;
		gbc_txtFiltro.gridy = 10;
		add(txtFiltro, gbc_txtFiltro);
		txtFiltro.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 11;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JCheckBox chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxHabilitado = new GridBagConstraints();
		gbc_chckbxHabilitado.fill = GridBagConstraints.BOTH;
		gbc_chckbxHabilitado.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHabilitado.gridx = 1;
		gbc_chckbxHabilitado.gridy = 13;
		add(chckbxHabilitado, gbc_chckbxHabilitado);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnProductos = new GridBagConstraints();
		gbc_btnProductos.fill = GridBagConstraints.BOTH;
		gbc_btnProductos.insets = new Insets(0, 0, 5, 5);
		gbc_btnProductos.gridx = 2;
		gbc_btnProductos.gridy = 13;
		add(btnProductos, gbc_btnProductos);
		
		JButton btnDescuentos = new JButton("Descuentos");
		btnDescuentos.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnDescuentos = new GridBagConstraints();
		gbc_btnDescuentos.gridwidth = 3;
		gbc_btnDescuentos.fill = GridBagConstraints.BOTH;
		gbc_btnDescuentos.insets = new Insets(0, 0, 5, 5);
		gbc_btnDescuentos.gridx = 3;
		gbc_btnDescuentos.gridy = 13;
		add(btnDescuentos, gbc_btnDescuentos);
		
		JButton btnCrearCopia = new JButton("Crear Copia");
		btnCrearCopia.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCrearCopia = new GridBagConstraints();
		gbc_btnCrearCopia.fill = GridBagConstraints.BOTH;
		gbc_btnCrearCopia.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearCopia.gridx = 6;
		gbc_btnCrearCopia.gridy = 13;
		add(btnCrearCopia, gbc_btnCrearCopia);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 7;
		gbc_btnAgregar.gridy = 13;
		add(btnAgregar, gbc_btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.BOTH;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 8;
		gbc_btnModificar.gridy = 13;
		add(btnModificar, gbc_btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 9;
		gbc_btnEliminar.gridy = 13;
		add(btnEliminar, gbc_btnEliminar);

	}

}
