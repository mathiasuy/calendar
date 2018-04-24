package grupouno.vista.internalframes.contactos;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class PanelContactos extends JPanel 
{
	GridBagLayout gridBagLayout = new GridBagLayout();
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JTextField txtFiltro;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelContactos()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 100, 100, 0, 100, 100, 50};
		gridBagLayout.rowHeights = new int[]{0, 30, 0, 30, 30, 30, 0, 30, 100, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitulo = new JLabel("Contactos");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridheight = 2;
		gbc_lblTitulo.gridwidth = 7;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 2;
		add(lblId, gbc_lblId);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 2;
		add(spinner, gbc_spinner);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 4;
		gbc_lblTelefono.gridy = 2;
		add(lblTelefono, gbc_lblTelefono);
		
		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.BOTH;
		gbc_txtTelefono.gridx = 5;
		gbc_txtTelefono.gridy = 2;
		add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
		gbc_lblNombreCompleto.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCompleto.fill = GridBagConstraints.VERTICAL;
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
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
		gbc_lblProveedor.anchor = GridBagConstraints.EAST;
		gbc_lblProveedor.fill = GridBagConstraints.VERTICAL;
		gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedor.gridx = 4;
		gbc_lblProveedor.gridy = 4;
		add(lblProveedor, gbc_lblProveedor);
		
		JComboBox comboBoxProveedor = new JComboBox();
		GridBagConstraints gbc_comboBoxProveedor = new GridBagConstraints();
		gbc_comboBoxProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxProveedor.fill = GridBagConstraints.BOTH;
		gbc_comboBoxProveedor.gridx = 5;
		gbc_comboBoxProveedor.gridy = 4;
		add(comboBoxProveedor, gbc_comboBoxProveedor);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFiltro = new GridBagConstraints();
		gbc_lblFiltro.anchor = GridBagConstraints.EAST;
		gbc_lblFiltro.fill = GridBagConstraints.VERTICAL;
		gbc_lblFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltro.gridx = 1;
		gbc_lblFiltro.gridy = 7;
		add(lblFiltro, gbc_lblFiltro);
		
		txtFiltro = new JTextField();
		GridBagConstraints gbc_txtFiltro = new GridBagConstraints();
		gbc_txtFiltro.gridwidth = 2;
		gbc_txtFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_txtFiltro.fill = GridBagConstraints.BOTH;
		gbc_txtFiltro.gridx = 2;
		gbc_txtFiltro.gridy = 7;
		add(txtFiltro, gbc_txtFiltro);
		txtFiltro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 2;
		gbc_btnAgregar.gridy = 10;
		add(btnAgregar, gbc_btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.gridwidth = 2;
		gbc_btnModificar.fill = GridBagConstraints.BOTH;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 3;
		gbc_btnModificar.gridy = 10;
		add(btnModificar, gbc_btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 5;
		gbc_btnEliminar.gridy = 10;
		add(btnEliminar, gbc_btnEliminar);

	}

}
