package grupouno.vista.internalframes.descuentos;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelDescuentos<E> extends JPanel {
	private JTextField txtNombreCompleto;
	private JTextField txtDescuento;
	private JTextField txtFiltro;

	/**
	 * Create the panel.
	 */
	public PanelDescuentos() 
	{
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 100, 80, 80, 100, 80, 80, 0};
		gridBagLayout.rowHeights = new int[]{50, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0, 40, 0, 0, 40, 40, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Descuento");
		lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 6;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
		gbc_lblNombreCompleto.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCompleto.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCompleto.gridx = 1;
		gbc_lblNombreCompleto.gridy = 1;
		add(lblNombreCompleto, gbc_lblNombreCompleto);
		
		txtNombreCompleto = new JTextField();
		GridBagConstraints gbc_txtNombreCompleto = new GridBagConstraints();
		gbc_txtNombreCompleto.gridwidth = 2;
		gbc_txtNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreCompleto.fill = GridBagConstraints.BOTH;
		gbc_txtNombreCompleto.gridx = 2;
		gbc_txtNombreCompleto.gridy = 1;
		add(txtNombreCompleto, gbc_txtNombreCompleto);
		txtNombreCompleto.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.anchor = GridBagConstraints.EAST;
		gbc_lblDescuento.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 4;
		gbc_lblDescuento.gridy = 1;
		add(lblDescuento, gbc_lblDescuento);
		
		txtDescuento = new JTextField();
		GridBagConstraints gbc_txtDescuento = new GridBagConstraints();
		gbc_txtDescuento.gridwidth = 2;
		gbc_txtDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescuento.fill = GridBagConstraints.BOTH;
		gbc_txtDescuento.gridx = 5;
		gbc_txtDescuento.gridy = 1;
		add(txtDescuento, gbc_txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblExpira = new JLabel("Expira:");
		lblExpira.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblExpira = new GridBagConstraints();
		gbc_lblExpira.fill = GridBagConstraints.VERTICAL;
		gbc_lblExpira.anchor = GridBagConstraints.EAST;
		gbc_lblExpira.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpira.gridx = 1;
		gbc_lblExpira.gridy = 3;
		add(lblExpira, gbc_lblExpira);
		
//		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 3;
//		add(dateChooser, gbc_dateChooser);
		
		JLabel lblDias = new JLabel("Dias:");
		lblDias.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDias = new GridBagConstraints();
		gbc_lblDias.fill = GridBagConstraints.VERTICAL;
		gbc_lblDias.anchor = GridBagConstraints.EAST;
		gbc_lblDias.insets = new Insets(0, 0, 5, 5);
		gbc_lblDias.gridx = 4;
		gbc_lblDias.gridy = 3;
		add(lblDias, gbc_lblDias);
		
		JCheckBox chckbxLunes = new JCheckBox("Lunes");
		chckbxLunes.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxLunes = new GridBagConstraints();
		gbc_chckbxLunes.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxLunes.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxLunes.gridx = 5;
		gbc_chckbxLunes.gridy = 3;
		add(chckbxLunes, gbc_chckbxLunes);
		
		JCheckBox chckbxMartes = new JCheckBox("Martes");
		chckbxMartes.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxMartes = new GridBagConstraints();
		gbc_chckbxMartes.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMartes.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMartes.gridx = 6;
		gbc_chckbxMartes.gridy = 3;
		add(chckbxMartes, gbc_chckbxMartes);
		
		JCheckBox chckbxMiercoles = new JCheckBox("Miercoles");
		chckbxMiercoles.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxMiercoles = new GridBagConstraints();
		gbc_chckbxMiercoles.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMiercoles.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMiercoles.gridx = 5;
		gbc_chckbxMiercoles.gridy = 4;
		add(chckbxMiercoles, gbc_chckbxMiercoles);
		
		JCheckBox chckbxJueves = new JCheckBox("Jueves");
		chckbxJueves.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxJueves = new GridBagConstraints();
		gbc_chckbxJueves.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxJueves.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxJueves.gridx = 6;
		gbc_chckbxJueves.gridy = 4;
		add(chckbxJueves, gbc_chckbxJueves);
		
		JCheckBox chckbxEsConvenio = new JCheckBox("Es Convenio");
		chckbxEsConvenio.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxEsConvenio = new GridBagConstraints();
		gbc_chckbxEsConvenio.fill = GridBagConstraints.BOTH;
		gbc_chckbxEsConvenio.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEsConvenio.gridx = 2;
		gbc_chckbxEsConvenio.gridy = 5;
		add(chckbxEsConvenio, gbc_chckbxEsConvenio);
		
		JCheckBox chckbxViernes = new JCheckBox("Viernes");
		chckbxViernes.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxViernes = new GridBagConstraints();
		gbc_chckbxViernes.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxViernes.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxViernes.gridx = 5;
		gbc_chckbxViernes.gridy = 5;
		add(chckbxViernes, gbc_chckbxViernes);
		
		JCheckBox chckbxSabado = new JCheckBox("Sabado");
		chckbxSabado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxSabado = new GridBagConstraints();
		gbc_chckbxSabado.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxSabado.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSabado.gridx = 6;
		gbc_chckbxSabado.gridy = 5;
		add(chckbxSabado, gbc_chckbxSabado);
		
		JCheckBox chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxDomingo = new GridBagConstraints();
		gbc_chckbxDomingo.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxDomingo.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDomingo.gridx = 5;
		gbc_chckbxDomingo.gridy = 6;
		add(chckbxDomingo, gbc_chckbxDomingo);
		
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
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblProductos = new GridBagConstraints();
		gbc_lblProductos.fill = GridBagConstraints.VERTICAL;
		gbc_lblProductos.anchor = GridBagConstraints.EAST;
		gbc_lblProductos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProductos.gridx = 1;
		gbc_lblProductos.gridy = 8;
		add(lblProductos, gbc_lblProductos);
		
		JList<? extends E> listProductos = new JList();
		GridBagConstraints gbc_listProductos = new GridBagConstraints();
		gbc_listProductos.gridwidth = 2;
		gbc_listProductos.gridheight = 5;
		gbc_listProductos.insets = new Insets(0, 0, 5, 5);
		gbc_listProductos.fill = GridBagConstraints.BOTH;
		gbc_listProductos.gridx = 2;
		gbc_listProductos.gridy = 8;
		add(listProductos, gbc_listProductos);
		
		JLabel lblServicios = new JLabel("Servicios:");
		lblServicios.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblServicios = new GridBagConstraints();
		gbc_lblServicios.anchor = GridBagConstraints.EAST;
		gbc_lblServicios.fill = GridBagConstraints.VERTICAL;
		gbc_lblServicios.insets = new Insets(0, 0, 5, 5);
		gbc_lblServicios.gridx = 4;
		gbc_lblServicios.gridy = 8;
		add(lblServicios, gbc_lblServicios);
		
		JList<? extends E> listServicios = new JList();
		GridBagConstraints gbc_listServicios = new GridBagConstraints();
		gbc_listServicios.gridwidth = 2;
		gbc_listServicios.gridheight = 5;
		gbc_listServicios.insets = new Insets(0, 0, 5, 5);
		gbc_listServicios.fill = GridBagConstraints.BOTH;
		gbc_listServicios.gridx = 5;
		gbc_listServicios.gridy = 8;
		add(listServicios, gbc_listServicios);
		
		JButton btnMarcarTodo = new JButton("Marcar Todo");
		btnMarcarTodo.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnMarcarTodo = new GridBagConstraints();
		gbc_btnMarcarTodo.insets = new Insets(0, 0, 5, 5);
		gbc_btnMarcarTodo.gridx = 2;
		gbc_btnMarcarTodo.gridy = 13;
		add(btnMarcarTodo, gbc_btnMarcarTodo);
		
		JButton btnDesmarcartodo = new JButton("Desmarcar Todo");
		btnDesmarcartodo.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnDesmarcartodo = new GridBagConstraints();
		gbc_btnDesmarcartodo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDesmarcartodo.insets = new Insets(0, 0, 5, 5);
		gbc_btnDesmarcartodo.gridx = 3;
		gbc_btnDesmarcartodo.gridy = 13;
		add(btnDesmarcartodo, gbc_btnDesmarcartodo);
		
		JButton btnMarcarTodo_1 = new JButton("Marcar Todo");
		btnMarcarTodo_1.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnMarcarTodo_1 = new GridBagConstraints();
		gbc_btnMarcarTodo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMarcarTodo_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnMarcarTodo_1.gridx = 5;
		gbc_btnMarcarTodo_1.gridy = 13;
		add(btnMarcarTodo_1, gbc_btnMarcarTodo_1);
		
		JButton btnDesmarcarTodo = new JButton("Desmarcar Todo");
		btnDesmarcarTodo.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnDesmarcarTodo = new GridBagConstraints();
		gbc_btnDesmarcarTodo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDesmarcarTodo.insets = new Insets(0, 0, 5, 5);
		gbc_btnDesmarcarTodo.gridx = 6;
		gbc_btnDesmarcarTodo.gridy = 13;
		add(btnDesmarcarTodo, gbc_btnDesmarcarTodo);
		
		JCheckBox chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbxHabilitado = new GridBagConstraints();
		gbc_chckbxHabilitado.fill = GridBagConstraints.BOTH;
		gbc_chckbxHabilitado.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHabilitado.gridx = 2;
		gbc_chckbxHabilitado.gridy = 15;
		add(chckbxHabilitado, gbc_chckbxHabilitado);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 5;
		gbc_btnAceptar.gridy = 15;
		add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 15;
		add(btnCancelar, gbc_btnCancelar);

	}

}
