package grupouno.vista.internalframes.agregarproductoaservicio;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelAgregarproductoaservicio extends JPanel 
{

	/**
	 * Create the panel.
	 */
	public PanelAgregarproductoaservicio()
	{
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 70, 0, 120, 50};
		gridBagLayout.rowHeights = new int[]{60, 0, 30, 30, 30, 30, 0, 0, 0, 30, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Agregar Producto A Servicio");
		lblTitle.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitle.gridwidth = 4;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblProdcutos = new JLabel("Prodcutos:");
		lblProdcutos.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblProdcutos = new GridBagConstraints();
		gbc_lblProdcutos.anchor = GridBagConstraints.EAST;
		gbc_lblProdcutos.fill = GridBagConstraints.VERTICAL;
		gbc_lblProdcutos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdcutos.gridx = 0;
		gbc_lblProdcutos.gridy = 2;
		add(lblProdcutos, gbc_lblProdcutos);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.gridheight = 8;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		add(list, gbc_list);
		
		JButton btnMarcarTodos = new JButton("Marcar Todos");
		GridBagConstraints gbc_btnMarcarTodos = new GridBagConstraints();
		gbc_btnMarcarTodos.anchor = GridBagConstraints.EAST;
		gbc_btnMarcarTodos.insets = new Insets(0, 0, 5, 5);
		gbc_btnMarcarTodos.gridx = 1;
		gbc_btnMarcarTodos.gridy = 10;
		add(btnMarcarTodos, gbc_btnMarcarTodos);
		
		JButton btnDesmarcarTodos = new JButton("Desmarcar Todos");
		GridBagConstraints gbc_btnDesmarcarTodos = new GridBagConstraints();
		gbc_btnDesmarcarTodos.insets = new Insets(0, 0, 5, 5);
		gbc_btnDesmarcarTodos.gridx = 2;
		gbc_btnDesmarcarTodos.gridy = 10;
		add(btnDesmarcarTodos, gbc_btnDesmarcarTodos);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.EAST;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 12;
		add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 12;
		add(btnCancelar, gbc_btnCancelar);
		
		

	}

}
