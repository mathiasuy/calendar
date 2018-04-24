package grupouno.vista.internalframes.proveedores;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import grupouno.controladores.CProveedores;
import grupouno.controladores.FactoryControladores;
import grupouno.dao.DAOProveedores;
import grupouno.dto.Proveedor;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;


public class PanelProveedores extends JPanel 
{

	TextField nombre,descripcion,direccion;
	
	GridBagConstraints gbc = new GridBagConstraints(); 
	private JTextField txtNombreCompleta;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblFiltro;
	private JTextField txtBusqueda;
	private JButton btnCrearCopia;
	private JButton btnAgregar;
	private JTable table;
	private JLabel lblTitulo;
	private JSpinner spinner;
	private JCheckBox chckbxHabilitado;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	
	/**
	 * Create the panel.
	 */
	public PanelProveedores() 
	{
		/*gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;*/
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{55, 100, 120, 120, 120, 120};
		gridBagLayout.rowHeights = new int[]{50, 30, 30, 30, 30, 30, 30, 30, 100, 0, 0, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		lblTitulo = new JLabel("Proveedores");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitulo.gridwidth = 6;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblProveedorID = new JLabel("ID:");
		lblProveedorID.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblProveedorID = new GridBagConstraints();
		gbc_lblProveedorID.anchor = GridBagConstraints.EAST;
		gbc_lblProveedorID.fill = GridBagConstraints.VERTICAL;
		gbc_lblProveedorID.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedorID.gridx = 1;
		gbc_lblProveedorID.gridy = 1;
		add(lblProveedorID, gbc_lblProveedorID);
		
		spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 1;
		add(spinner, gbc_spinner);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
		gbc_lblNombreCompleto.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombreCompleto.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCompleto.gridx = 1;
		gbc_lblNombreCompleto.gridy = 2;
		add(lblNombreCompleto, gbc_lblNombreCompleto);
		
		txtNombreCompleta = new JTextField();
		GridBagConstraints gbc_txtNombreCompleta = new GridBagConstraints();
		gbc_txtNombreCompleta.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreCompleta.fill = GridBagConstraints.BOTH;
		gbc_txtNombreCompleta.gridx = 2;
		gbc_txtNombreCompleta.gridy = 2;
		add(txtNombreCompleta, gbc_txtNombreCompleta);
		txtNombreCompleta.setColumns(10);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.fill = GridBagConstraints.VERTICAL;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 3;
		add(lblDireccion, gbc_lblDireccion);
		
		txtDireccion = new JTextField();
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccion.fill = GridBagConstraints.BOTH;
		gbc_txtDireccion.gridx = 2;
		gbc_txtDireccion.gridy = 3;
		add(txtDireccion, gbc_txtDireccion);
		txtDireccion.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 4;
		add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.gridheight = 2;
		gbc_txtDescripcion.gridwidth = 3;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.gridx = 2;
		gbc_txtDescripcion.gridy = 4;
		add(txtDescripcion, gbc_txtDescripcion);
		txtDescripcion.setColumns(10);
		
		lblFiltro = new JLabel("Filtro:");
		lblFiltro.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFiltro = new GridBagConstraints();
		gbc_lblFiltro.fill = GridBagConstraints.VERTICAL;
		gbc_lblFiltro.anchor = GridBagConstraints.EAST;
		gbc_lblFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltro.gridx = 1;
		gbc_lblFiltro.gridy = 7;
		add(lblFiltro, gbc_lblFiltro);
		
		txtBusqueda = new JTextField();
		GridBagConstraints gbc_txtBusqueda = new GridBagConstraints();
		gbc_txtBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_txtBusqueda.fill = GridBagConstraints.BOTH;
		gbc_txtBusqueda.gridx = 2;
		gbc_txtBusqueda.gridy = 7;
		add(txtBusqueda, gbc_txtBusqueda);
		txtBusqueda.setColumns(10);
		
		JScrollPane js = new JScrollPane();
		GridBagConstraints gbc_js = new GridBagConstraints();
		gbc_js.fill = GridBagConstraints.BOTH;
		gbc_js.gridwidth = 3;
		gbc_js.insets = new Insets(0, 0, 5, 5);
		gbc_js.gridx = 2;
		gbc_js.gridy = 8;
		this.add(js, gbc_js);
		
		table = new JTable();
		js.setViewportView(table);
		
		chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxHabilitado = new GridBagConstraints();
		gbc_chckbxHabilitado.fill = GridBagConstraints.BOTH;
		gbc_chckbxHabilitado.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHabilitado.gridx = 1;
		gbc_chckbxHabilitado.gridy = 10;
		add(chckbxHabilitado, gbc_chckbxHabilitado);
		
		
		btnCrearCopia = new JButton("Crear Copia");
		btnCrearCopia.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCrearCopia = new GridBagConstraints();
		gbc_btnCrearCopia.fill = GridBagConstraints.BOTH;
		gbc_btnCrearCopia.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearCopia.gridx = 2;
		gbc_btnCrearCopia.gridy = 10;
		add(btnCrearCopia, gbc_btnCrearCopia);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 3;
		gbc_btnAgregar.gridy = 10;
		add(btnAgregar, gbc_btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 4;
		gbc_btnModificar.gridy = 10;
		add(btnModificar, gbc_btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 5;
		gbc_btnEliminar.gridy = 10;
		add(btnEliminar, gbc_btnEliminar);
	
		cargarDatos();

	}

	
	
	
	
	private void cargarDatos(){
		//FactoryControladores f = new FactoryControladores();

		DAOProveedores d = new DAOProveedores();
		ArrayList<Proveedor> proveedores = d.listar();
		
		DefaultTableModel dft = new DefaultTableModel(new String[]{"Nombre","Descripcion", "Direccion"}, proveedores.size());
		table.setModel(dft);
		int fila = 0;
		for (Proveedor p : proveedores){
			table.setValueAt(p.getNombre(), fila, 0);
			table.setValueAt(p.getDescripcion(), fila, 1);
			table.setValueAt(p.getDireccion(), fila, 2);
			fila++;
		}
	}
}
