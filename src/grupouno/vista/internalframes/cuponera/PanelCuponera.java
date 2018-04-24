package grupouno.vista.internalframes.cuponera;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCuponera extends JPanel
{
	private JTextField txtID;
	private JTextField txtCupones;
	private JTextField txtDescuento;
	private JTextField txtFechaDeInicio;
	private JTextField txtExpira;

	/**
	 * Create the panel.
	 */
	public PanelCuponera() 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 120, 150, 60, 0};
		gridBagLayout.rowHeights = new int[]{50, 30, 30, 30, 30, 30, 0, 30, 30, 40};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Crear Cuponera");
		lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 5;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.fill = GridBagConstraints.VERTICAL;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		txtID = new JTextField();
		GridBagConstraints gbc_txtID = new GridBagConstraints();
		gbc_txtID.insets = new Insets(0, 0, 5, 5);
		gbc_txtID.fill = GridBagConstraints.BOTH;
		gbc_txtID.gridx = 2;
		gbc_txtID.gridy = 1;
		add(txtID, gbc_txtID);
		txtID.setColumns(10);
		
		JLabel lblCupones = new JLabel("Cupones:");
		lblCupones.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCupones = new GridBagConstraints();
		gbc_lblCupones.anchor = GridBagConstraints.EAST;
		gbc_lblCupones.fill = GridBagConstraints.VERTICAL;
		gbc_lblCupones.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupones.gridx = 1;
		gbc_lblCupones.gridy = 2;
		add(lblCupones, gbc_lblCupones);
		
		txtCupones = new JTextField();
		GridBagConstraints gbc_txtCupones = new GridBagConstraints();
		gbc_txtCupones.insets = new Insets(0, 0, 5, 5);
		gbc_txtCupones.fill = GridBagConstraints.BOTH;
		gbc_txtCupones.gridx = 2;
		gbc_txtCupones.gridy = 2;
		add(txtCupones, gbc_txtCupones);
		txtCupones.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.anchor = GridBagConstraints.EAST;
		gbc_lblDescuento.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 1;
		gbc_lblDescuento.gridy = 3;
		add(lblDescuento, gbc_lblDescuento);
		
		txtDescuento = new JTextField();
		GridBagConstraints gbc_txtDescuento = new GridBagConstraints();
		gbc_txtDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescuento.fill = GridBagConstraints.BOTH;
		gbc_txtDescuento.gridx = 2;
		gbc_txtDescuento.gridy = 3;
		add(txtDescuento, gbc_txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio:");
		lblFechaDeInicio.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFechaDeInicio = new GridBagConstraints();
		gbc_lblFechaDeInicio.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeInicio.fill = GridBagConstraints.VERTICAL;
		gbc_lblFechaDeInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeInicio.gridx = 1;
		gbc_lblFechaDeInicio.gridy = 4;
		add(lblFechaDeInicio, gbc_lblFechaDeInicio);
		
		txtFechaDeInicio = new JTextField();
		GridBagConstraints gbc_txtFechaDeInicio = new GridBagConstraints();
		gbc_txtFechaDeInicio.insets = new Insets(0, 0, 5, 5);
		gbc_txtFechaDeInicio.fill = GridBagConstraints.BOTH;
		gbc_txtFechaDeInicio.gridx = 2;
		gbc_txtFechaDeInicio.gridy = 4;
		add(txtFechaDeInicio, gbc_txtFechaDeInicio);
		txtFechaDeInicio.setColumns(10);
		
		JLabel lblExpira = new JLabel("Expira:");
		lblExpira.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblExpira = new GridBagConstraints();
		gbc_lblExpira.anchor = GridBagConstraints.EAST;
		gbc_lblExpira.fill = GridBagConstraints.VERTICAL;
		gbc_lblExpira.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpira.gridx = 1;
		gbc_lblExpira.gridy = 5;
		add(lblExpira, gbc_lblExpira);
		
		txtExpira = new JTextField();
		GridBagConstraints gbc_txtExpira = new GridBagConstraints();
		gbc_txtExpira.insets = new Insets(0, 0, 5, 5);
		gbc_txtExpira.fill = GridBagConstraints.BOTH;
		gbc_txtExpira.gridx = 2;
		gbc_txtExpira.gridy = 5;
		add(txtExpira, gbc_txtExpira);
		txtExpira.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar  ");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 7;
		add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 8;
		add(btnCancelar, gbc_btnCancelar);

	}

}
