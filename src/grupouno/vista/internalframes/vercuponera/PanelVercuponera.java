package grupouno.vista.internalframes.vercuponera;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelVercuponera extends JPanel {
	private JTextField txtCliente;
	private JTextField txtExpira;

	/**
	 * Create the panel.
	 */
	public PanelVercuponera()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 125, 125, 0, 125, 125, 0};
		gridBagLayout.rowHeights = new int[]{0, 50, 30, 30, 30, 30, 30, 30, 100, 0, 40, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Ver Cuponera");
		lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 5;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 2;
		add(lblCliente, gbc_lblCliente);
		
		txtCliente = new JTextField();
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCliente.fill = GridBagConstraints.BOTH;
		gbc_txtCliente.gridx = 2;
		gbc_txtCliente.gridy = 2;
		add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblExpira = new JLabel("Expira:");
		lblExpira.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblExpira = new GridBagConstraints();
		gbc_lblExpira.anchor = GridBagConstraints.EAST;
		gbc_lblExpira.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpira.gridx = 4;
		gbc_lblExpira.gridy = 2;
		add(lblExpira, gbc_lblExpira);
		
		txtExpira = new JTextField();
		GridBagConstraints gbc_txtExpira = new GridBagConstraints();
		gbc_txtExpira.insets = new Insets(0, 0, 5, 5);
		gbc_txtExpira.fill = GridBagConstraints.BOTH;
		gbc_txtExpira.gridx = 5;
		gbc_txtExpira.gridy = 2;
		add(txtExpira, gbc_txtExpira);
		txtExpira.setColumns(10);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 5;
		gbc_list.gridwidth = 4;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.VERTICAL;
		gbc_list.gridx = 2;
		gbc_list.gridy = 4;
		add(list, gbc_list);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 4;
		gbc_btnAceptar.gridy = 10;
		add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 5;
		gbc_btnCancelar.gridy = 10;
		add(btnCancelar, gbc_btnCancelar);

	}

}
