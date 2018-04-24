package grupouno.vista.internalframes.vercupon;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelVercupon extends JPanel {
	private JTextField txtCliente;
	private JTextField txtServicio;
	private JTextField txtFecha;
	private JTextField txtPrecio;
	private JTextField txtDescuento;
	private JTextField txtTotal;

	/**
	 * Create the panel.
	 */
	public PanelVercupon() 
	{
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 125, 150, 150, 0};
		gridBagLayout.rowHeights = new int[]{50, 30, 40, 40, 40, 40, 40, 0, 40, 0, 40, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Ver Cupon");
		lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitle.gridwidth = 5;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.fill = GridBagConstraints.VERTICAL;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 2;
		add(lblCliente, gbc_lblCliente);
		
		txtCliente = new JTextField();
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.gridwidth = 2;
		gbc_txtCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCliente.fill = GridBagConstraints.BOTH;
		gbc_txtCliente.gridx = 2;
		gbc_txtCliente.gridy = 2;
		add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lbServicio = new JLabel("Servicio:");
		lbServicio.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lbServicio = new GridBagConstraints();
		gbc_lbServicio.fill = GridBagConstraints.VERTICAL;
		gbc_lbServicio.insets = new Insets(0, 0, 5, 5);
		gbc_lbServicio.gridx = 1;
		gbc_lbServicio.gridy = 3;
		add(lbServicio, gbc_lbServicio);
		
		txtServicio = new JTextField();
		GridBagConstraints gbc_txtServicio = new GridBagConstraints();
		gbc_txtServicio.gridwidth = 2;
		gbc_txtServicio.insets = new Insets(0, 0, 5, 5);
		gbc_txtServicio.fill = GridBagConstraints.BOTH;
		gbc_txtServicio.gridx = 2;
		gbc_txtServicio.gridy = 3;
		add(txtServicio, gbc_txtServicio);
		txtServicio.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.fill = GridBagConstraints.VERTICAL;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 4;
		add(lblFecha, gbc_lblFecha);
		
		txtFecha = new JTextField();
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.gridwidth = 2;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.fill = GridBagConstraints.BOTH;
		gbc_txtFecha.gridx = 2;
		gbc_txtFecha.gridy = 4;
		add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.fill = GridBagConstraints.VERTICAL;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 5;
		add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField();
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.gridwidth = 2;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.BOTH;
		gbc_txtPrecio.gridx = 2;
		gbc_txtPrecio.gridy = 5;
		add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 1;
		gbc_lblDescuento.gridy = 6;
		add(lblDescuento, gbc_lblDescuento);
		
		txtDescuento = new JTextField();
		GridBagConstraints gbc_txtDescuento = new GridBagConstraints();
		gbc_txtDescuento.gridwidth = 2;
		gbc_txtDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescuento.fill = GridBagConstraints.BOTH;
		gbc_txtDescuento.gridx = 2;
		gbc_txtDescuento.gridy = 6;
		add(txtDescuento, gbc_txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.fill = GridBagConstraints.VERTICAL;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 8;
		add(lblTotal, gbc_lblTotal);
		
		txtTotal = new JTextField();
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.gridwidth = 2;
		gbc_txtTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotal.fill = GridBagConstraints.BOTH;
		gbc_txtTotal.gridx = 2;
		gbc_txtTotal.gridy = 8;
		add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 10;
		add(btnCancelar, gbc_btnCancelar);
		
		JButton btnConcretado = new JButton("Concretado");
		btnConcretado.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnConcretado = new GridBagConstraints();
		gbc_btnConcretado.fill = GridBagConstraints.BOTH;
		gbc_btnConcretado.insets = new Insets(0, 0, 5, 5);
		gbc_btnConcretado.gridx = 3;
		gbc_btnConcretado.gridy = 10;
		add(btnConcretado, gbc_btnConcretado);

	}

}
