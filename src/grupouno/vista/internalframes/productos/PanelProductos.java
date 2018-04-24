package grupouno.vista.internalframes.productos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
//import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelProductos extends JPanel
{
	
	GridBagConstraints gbc = new GridBagConstraints();
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField textDescripcion;
	private JTextField textField;
	private JTextField txtFiltro;
	private JTable table;
	private JTextField txtStock;
	
	
	/**
	 * Create the panel.
	 */
	public PanelProductos() 
	{
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 80, 140, 30, 30, 20, 100, 100, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 30, 30, 30, 30, 30, 30, 30, 30, 100, 0, 40, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblProductos = new GridBagConstraints();
		gbc_lblProductos.gridheight = 2;
		gbc_lblProductos.gridwidth = 5;
		gbc_lblProductos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProductos.gridx = 2;
		gbc_lblProductos.gridy = 0;
		add(lblProductos, gbc_lblProductos);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.fill = GridBagConstraints.VERTICAL;
		gbc_lblID.anchor = GridBagConstraints.EAST;
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
		
		JLabel lblFechaIngresado = new JLabel("Fecha Ingresado:");
		lblFechaIngresado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFechaIngresado = new GridBagConstraints();
		gbc_lblFechaIngresado.fill = GridBagConstraints.VERTICAL;
		gbc_lblFechaIngresado.anchor = GridBagConstraints.EAST;
		gbc_lblFechaIngresado.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaIngresado.gridx = 6;
		gbc_lblFechaIngresado.gridy = 2;
		add(lblFechaIngresado, gbc_lblFechaIngresado);
		
//		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 7;
		gbc_dateChooser.gridy = 2;
//		add(dateChooser, gbc_dateChooser);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
		gbc_lblNombreCompleto.fill = GridBagConstraints.BOTH;
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
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.fill = GridBagConstraints.VERTICAL;
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 1;
		gbc_lblMarca.gridy = 4;
		add(lblMarca, gbc_lblMarca);
		
		txtMarca = new JTextField();
		GridBagConstraints gbc_txtMarca = new GridBagConstraints();
		gbc_txtMarca.insets = new Insets(0, 0, 5, 5);
		gbc_txtMarca.fill = GridBagConstraints.BOTH;
		gbc_txtMarca.gridx = 2;
		gbc_txtMarca.gridy = 4;
		add(txtMarca, gbc_txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.fill = GridBagConstraints.VERTICAL;
		gbc_lblStock.anchor = GridBagConstraints.EAST;
		gbc_lblStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblStock.gridx = 6;
		gbc_lblStock.gridy = 4;
		add(lblStock, gbc_lblStock);
		
		txtStock = new JTextField();
		GridBagConstraints gbc_txtStock = new GridBagConstraints();
		gbc_txtStock.insets = new Insets(0, 0, 5, 5);
		gbc_txtStock.fill = GridBagConstraints.BOTH;
		gbc_txtStock.gridx = 7;
		gbc_txtStock.gridy = 4;
		add(txtStock, gbc_txtStock);
		txtStock.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.fill = GridBagConstraints.VERTICAL;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 5;
		add(lblPrecio, gbc_lblPrecio);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 6;
		add(lblDescripcion, gbc_lblDescripcion);
		
		textDescripcion = new JTextField();
		GridBagConstraints gbc_textDescripcion = new GridBagConstraints();
		gbc_textDescripcion.gridheight = 2;
		gbc_textDescripcion.gridwidth = 6;
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
		
		txtFiltro = new JTextField();
		GridBagConstraints gbc_txtFiltro = new GridBagConstraints();
		gbc_txtFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_txtFiltro.fill = GridBagConstraints.BOTH;
		gbc_txtFiltro.gridx = 2;
		gbc_txtFiltro.gridy = 9;
		add(txtFiltro, gbc_txtFiltro);
		txtFiltro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
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
		gbc_chckbxHabilitado.gridy = 12;
		add(chckbxHabilitado, gbc_chckbxHabilitado);
		
		JButton btnCrearCopia = new JButton("Crear Copia");
		btnCrearCopia.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCrearCopia = new GridBagConstraints();
		gbc_btnCrearCopia.fill = GridBagConstraints.VERTICAL;
		gbc_btnCrearCopia.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearCopia.gridx = 2;
		gbc_btnCrearCopia.gridy = 12;
		add(btnCrearCopia, gbc_btnCrearCopia);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.gridwidth = 3;
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 3;
		gbc_btnAgregar.gridy = 12;
		add(btnAgregar, gbc_btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.BOTH;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 6;
		gbc_btnModificar.gridy = 12;
		add(btnModificar, gbc_btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 7;
		gbc_btnEliminar.gridy = 12;
		add(btnEliminar, gbc_btnEliminar);
		

	}

}
