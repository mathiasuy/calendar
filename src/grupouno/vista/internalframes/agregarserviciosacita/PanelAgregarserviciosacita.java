package grupouno.vista.internalframes.agregarserviciosacita;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelAgregarserviciosacita extends JPanel 
{
	private JTextField txtFiltro;
	private JTextField txtDescuento;
	private JTextField txtTotal;

	/**
	 * Create the panel.
	 */
	public PanelAgregarserviciosacita() 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 80, 140, 100, 0};
		gridBagLayout.rowHeights = new int[]{0, 50, 30, 30, 30, 30, 30, 30, 30, 0, 30, 30, 30, 0, 0, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Agregar Servicios A Cita");
		lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitle.gridwidth = 3;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFiltro = new GridBagConstraints();
		gbc_lblFiltro.anchor = GridBagConstraints.EAST;
		gbc_lblFiltro.fill = GridBagConstraints.VERTICAL;
		gbc_lblFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltro.gridx = 1;
		gbc_lblFiltro.gridy = 2;
		add(lblFiltro, gbc_lblFiltro);
		
		txtFiltro = new JTextField();
		GridBagConstraints gbc_txtFiltro = new GridBagConstraints();
		gbc_txtFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_txtFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFiltro.gridx = 2;
		gbc_txtFiltro.gridy = 2;
		add(txtFiltro, gbc_txtFiltro);
		txtFiltro.setColumns(10);
		
		JLabel lblServicios = new JLabel("Servicios:");
		lblServicios.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblServicios = new GridBagConstraints();
		gbc_lblServicios.fill = GridBagConstraints.VERTICAL;
		gbc_lblServicios.anchor = GridBagConstraints.EAST;
		gbc_lblServicios.insets = new Insets(0, 0, 5, 5);
		gbc_lblServicios.gridx = 1;
		gbc_lblServicios.gridy = 4;
		add(lblServicios, gbc_lblServicios);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 6;
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 4;
		add(list, gbc_list);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.anchor = GridBagConstraints.EAST;
		gbc_lblDescuento.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 1;
		gbc_lblDescuento.gridy = 11;
		add(lblDescuento, gbc_lblDescuento);
		
		txtDescuento = new JTextField();
		GridBagConstraints gbc_txtDescuento = new GridBagConstraints();
		gbc_txtDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescuento.fill = GridBagConstraints.BOTH;
		gbc_txtDescuento.gridx = 2;
		gbc_txtDescuento.gridy = 11;
		add(txtDescuento, gbc_txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 12;
		add(lblTotal, gbc_lblTotal);
		
		txtTotal = new JTextField();
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotal.fill = GridBagConstraints.BOTH;
		gbc_txtTotal.gridx = 2;
		gbc_txtTotal.gridy = 12;
		add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.VERTICAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 14;
		add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 14;
		add(btnCancelar, gbc_btnCancelar);

	}

}
