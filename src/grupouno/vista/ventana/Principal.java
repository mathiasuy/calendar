package grupouno.vista.ventana;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grupouno.vista.internalframes.agregarproductoaservicio.Agregarproductoaservicio;
import grupouno.vista.internalframes.agregarserviciosacita.Agregarserviciosacita;
import grupouno.vista.internalframes.clientes.Clientes;
import grupouno.vista.internalframes.contactos.Contactos;
import grupouno.vista.internalframes.empleados.Empleados;
import grupouno.vista.internalframes.productos.Productos;
import grupouno.vista.internalframes.proveedores.PanelProveedores;
import grupouno.vista.internalframes.proveedores.Proveedores;
import grupouno.vista.internalframes.servicios.Servicios;
import grupouno.vista.internalframes.descuentos.Descuentos;
import grupouno.vista.internalframes.vercuponera.Vercuponera; 
import grupouno.vista.internalframes.vercupon.Vercupon;
import grupouno.vista.internalframes.cuponera.Cuponera;
import grupouno.vista.internalframes.agenda.Agenda;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Principal extends JFrame 
{
	private grupouno.vista.internalframes.productos.Productos ventana_administrar_productos;
	private grupouno.vista.internalframes.proveedores.Proveedores ventana_administrar_proveedores;
	private grupouno.vista.internalframes.agregarproductoaservicio.Agregarproductoaservicio ventana_administrar_agregarproductoaservicio;
	private grupouno.vista.internalframes.agregarserviciosacita.Agregarserviciosacita ventana_administrar_agregarserviciosacita;
	private grupouno.vista.internalframes.servicios.Servicios ventana_administrar_servicios;
	private grupouno.vista.internalframes.empleados.Empleados ventana_administrar_empleados;
	private grupouno.vista.internalframes.clientes.Clientes ventana_administrar_clientes;
	private grupouno.vista.internalframes.contactos.Contactos ventana_administrar_contactos;
	private grupouno.vista.internalframes.descuentos.Descuentos ventana_administrar_descuentos; 
	private grupouno.vista.internalframes.vercuponera.Vercuponera ventana_administrar_vercuponera;
	private grupouno.vista.internalframes.vercupon.Vercupon ventana_administrar_vercupon;
	private grupouno.vista.internalframes.cuponera.Cuponera ventana_administrar_cuponera;
	private grupouno.vista.internalframes.agenda.Agenda ventana_administrar_agenda;
	
	
	
	private JPanel contentPane;
	public static final JDesktopPane fondo = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		/*jf.setTitle("test");
		jf.setSize(500, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.getContentPane().add(panelProveedores);*/
		
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() 
	{
		this.setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1858, 933);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(fondo);
		
        try {
			fondo.setBorder(new Fondo());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen de fondo");
			e1.printStackTrace();
		}
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/grupouno/utils/icono.png")).getImage());
        this.setTitle("Gestion");        		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1914, 23);
		fondo.add(menuBar);
		
		////productos
		JMenu mnProductos = new JMenu("Productos");
		menuBar.add(mnProductos);
		
		JMenuItem mntmAdministrar = new JMenuItem("Administrar Productos");
		
		mntmAdministrar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ventana_administrar_productos = new Productos();
				ventana_administrar_productos.setTitle("Administrar Productos");
	            fondo.add(ventana_administrar_productos);
	            ventana_administrar_productos.setBounds(0, 0, 600, 500);
	            Dimension desktopSize = fondo.getSize();
	            Dimension FrameSize = ventana_administrar_productos.getSize();
	            ventana_administrar_productos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
	            ventana_administrar_productos.setVisible(true);
	            ventana_administrar_productos.setClosable(true);
	            ventana_administrar_productos.setIconifiable(true);
	            ventana_administrar_productos.setResizable(true);
	            ventana_administrar_productos.setMaximizable(true);
			}
		});
		
		

		JMenuItem mntmAdministrar_6 = new JMenuItem("Contactos");
		mnProductos.add(mntmAdministrar_6);
		mntmAdministrar_6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ventana_administrar_contactos = new Contactos();
	            ventana_administrar_contactos.setTitle("Administrar ventana_administrar_contactos");
	            fondo.add(ventana_administrar_contactos);
	            ventana_administrar_contactos.setBounds(0, 0, 600, 500);
	            Dimension desktopSize = fondo.getSize();
	            Dimension FrameSize = ventana_administrar_contactos.getSize();
	            ventana_administrar_contactos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
	            ventana_administrar_contactos.setVisible(true);
	            ventana_administrar_contactos.setClosable(true);
	            ventana_administrar_contactos.setIconifiable(true);
	            ventana_administrar_contactos.setResizable(true);
	            ventana_administrar_contactos.setMaximizable(true);			
				
			}
		});
		
		JMenuItem mntmAdministrar_1 = new JMenuItem("Administrar Proveedores");
		mnProductos.add(mntmAdministrar_1);
		mntmAdministrar_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
	            ventana_administrar_proveedores = new Proveedores();
	            ventana_administrar_proveedores.setTitle("Administrar ventana_administrar_proveedores");
	            fondo.add(ventana_administrar_proveedores);
	            ventana_administrar_proveedores.setBounds(0, 0, 650, 460);
	            Dimension desktopSize = fondo.getSize();
	            Dimension FrameSize = ventana_administrar_proveedores.getSize();
	            ventana_administrar_proveedores.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
	            ventana_administrar_proveedores.setVisible(true);
	            ventana_administrar_proveedores.setClosable(true);
	            ventana_administrar_proveedores.setIconifiable(true);
	            ventana_administrar_proveedores.setResizable(true);
	            ventana_administrar_proveedores.setMaximizable(true);
			}
		});
		mnProductos.add(mntmAdministrar);
		
		JMenuItem mntmAdministrar_3 = new JMenuItem("Administrar Servicios");
		mnProductos.add(mntmAdministrar_3);
		mntmAdministrar_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ventana_administrar_servicios = new Servicios();
	            ventana_administrar_servicios.setTitle("Administrar ventana_administrar_servicios");
	            fondo.add(ventana_administrar_servicios);
	            ventana_administrar_servicios.setBounds(0, 0, 850, 600);
	            Dimension desktopSize = fondo.getSize();
	            Dimension FrameSize = ventana_administrar_servicios.getSize();
	            ventana_administrar_servicios.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
	            ventana_administrar_servicios.setVisible(true);
	            ventana_administrar_servicios.setClosable(true);
	            ventana_administrar_servicios.setIconifiable(true);
	            ventana_administrar_servicios.setResizable(true);
	            ventana_administrar_servicios.setMaximizable(true);			
				
			}
		});
		

		JMenuItem mntmAdministrar_9 = new JMenuItem("Administrar Descuentos");
		mnProductos.add(mntmAdministrar_9);
		mntmAdministrar_9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					ventana_administrar_descuentos = new Descuentos();
					ventana_administrar_descuentos.setTitle("Administrar ventana_administrar_descuentos");
			        fondo.add(ventana_administrar_descuentos);
			        ventana_administrar_descuentos.setBounds(0, 0, 650, 600);
			        Dimension desktopSize = fondo.getSize();
			        Dimension FrameSize = ventana_administrar_descuentos.getSize();
			        ventana_administrar_descuentos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
			        ventana_administrar_descuentos.setVisible(true);
			        ventana_administrar_descuentos.setClosable(true);
			        ventana_administrar_descuentos.setIconifiable(true);
			        ventana_administrar_descuentos.setResizable(true);
			        ventana_administrar_descuentos.setMaximizable(true);			
						
			}
		});
		
		JMenuItem mntmAdministrar_4 = new JMenuItem("Administrar Empleados");
		mnProductos.add(mntmAdministrar_4);
		
		JMenuItem mntmAdministrar_5 = new JMenuItem("Administrar Clientes");
		mnProductos.add(mntmAdministrar_5);
		mntmAdministrar_5.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				ventana_administrar_clientes = new Clientes();
	            ventana_administrar_clientes.setTitle("Administrar ventana_administrar_clientes");
	            fondo.add(ventana_administrar_clientes);
	            ventana_administrar_clientes.setBounds(0, 0, 600, 500);
	            Dimension desktopSize = fondo.getSize();
	            Dimension FrameSize = ventana_administrar_clientes.getSize();
	            ventana_administrar_clientes.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
	            ventana_administrar_clientes.setVisible(true);
	            ventana_administrar_clientes.setClosable(true);
	            ventana_administrar_clientes.setIconifiable(true);
	            ventana_administrar_clientes.setResizable(true);
	            ventana_administrar_clientes.setMaximizable(true);			
				
			}
		});
		mntmAdministrar_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ventana_administrar_empleados = new Empleados();
	            ventana_administrar_empleados.setTitle("Administrar ventana_administrar_empleados");
	            fondo.add(ventana_administrar_empleados);
	            ventana_administrar_empleados.setBounds(0, 0, 600, 500);
	            Dimension desktopSize = fondo.getSize();
	            Dimension FrameSize = ventana_administrar_empleados.getSize();
	            ventana_administrar_empleados.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
	            ventana_administrar_empleados.setVisible(true);
	            ventana_administrar_empleados.setClosable(true);
	            ventana_administrar_empleados.setIconifiable(true);
	            ventana_administrar_empleados.setResizable(true);
	            ventana_administrar_empleados.setMaximizable(true);			
				
			}
		});
		/////////
		

		
		//Agenda
		JMenu mnAgenda = new JMenu("Agenda");
		menuBar.add(mnAgenda);
				

		JMenuItem mntmAdministrar_14 = new JMenuItem("Administrar");
		mntmAdministrar_14.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					ventana_administrar_agenda = new Agenda();
					ventana_administrar_agenda.setTitle("AGENDA");
			        fondo.add(ventana_administrar_agenda);
			        ventana_administrar_agenda.setBounds(0, 0, 800, 650);
			        Dimension desktopSize = fondo.getSize();
		            Dimension FrameSize = ventana_administrar_agenda.getSize();
		            ventana_administrar_agenda.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);     
			        ventana_administrar_agenda.setVisible(true);
			        ventana_administrar_agenda.setClosable(true);
			        ventana_administrar_agenda.setIconifiable(true);
			        ventana_administrar_agenda.setResizable(true);
			        ventana_administrar_agenda.setMaximizable(true);
		
			        try 
			        {
						ventana_administrar_agenda.setMaximum(true);
					} 
			        catch (PropertyVetoException e1)
			        {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        	
			}
		});		
		mnAgenda.add(mntmAdministrar_14);
		///////
		
		
		
		///////VER CUPON
		JMenu mnVercupon = new JMenu("Ver Cupon");
		menuBar.add(mnVercupon);
			

		JMenuItem mntmAdministrar_15 = new JMenuItem("Administrar");
		mntmAdministrar_15.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ventana_administrar_vercupon = new Vercupon();
				ventana_administrar_vercupon.setTitle("Administrar Ver Cupon");
				fondo.add(ventana_administrar_vercupon);
				ventana_administrar_vercupon.setBounds(0, 0, 550, 430);
			    Dimension desktopSize = fondo.getSize();
			    Dimension FrameSize = ventana_administrar_vercupon.getSize();
			    ventana_administrar_vercupon.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);     
	            ventana_administrar_vercupon.setVisible(true);
	            ventana_administrar_vercupon.setClosable(true);
	            ventana_administrar_vercupon.setIconifiable(true);
	            ventana_administrar_vercupon.setResizable(true);
	            ventana_administrar_vercupon.setMaximizable(true);
					
			   try 
			   {
				   ventana_administrar_vercupon.setMaximum(true);
			   }catch (PropertyVetoException e1){
					// TODO Auto-generated catch block
						e1.printStackTrace();
						}
						        	
				}
		});		
		mnVercupon.add(mntmAdministrar_15);
		////////////	
		
		
		//////Cuponera
		JMenu mnCuponera = new JMenu("Cuponera");
		menuBar.add(mnCuponera);
		
		JMenuItem mntmAdministrar_16 = new JMenuItem("Administrar");
		mntmAdministrar_16.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ventana_administrar_cuponera = new Cuponera();
				ventana_administrar_cuponera.setTitle("Administrar Cuponera");
				fondo.add(ventana_administrar_cuponera);
				ventana_administrar_cuponera.setBounds(0, 0, 800, 650);
			    Dimension desktopSize = fondo.getSize();
			    Dimension FrameSize = ventana_administrar_cuponera.getSize();
			    ventana_administrar_cuponera.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);     
			    ventana_administrar_cuponera.setVisible(true);
			    ventana_administrar_cuponera.setClosable(true);
			    ventana_administrar_cuponera.setIconifiable(true);
			    ventana_administrar_cuponera.setResizable(true);
			    ventana_administrar_cuponera.setMaximizable(true);
					
			   try 
			   {
				   ventana_administrar_cuponera.setMaximum(true);
			   }catch (PropertyVetoException e1){
					// TODO Auto-generated catch block
						e1.printStackTrace();
						}
						        	
				}
		});		
		mnCuponera.add(mntmAdministrar_16);
		////////////
		
		
		//////Vercuponera
		JMenu mnVercuponera = new JMenu("Ver Cuponera");
			menuBar.add(mnVercuponera);
			
			JMenuItem mntmAdministrar_17 = new JMenuItem("Administrar");
			mntmAdministrar_17.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ventana_administrar_vercuponera = new Vercuponera();
					ventana_administrar_vercuponera.setTitle("Administrar Ver Cuponera");
					fondo.add(ventana_administrar_vercuponera);
					ventana_administrar_vercuponera.setBounds(0, 0, 550, 400);
				    Dimension desktopSize = fondo.getSize();
				    Dimension FrameSize = ventana_administrar_vercuponera.getSize();
				    ventana_administrar_vercuponera.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);     
				    ventana_administrar_vercuponera.setVisible(true);
				    ventana_administrar_vercuponera.setClosable(true);
				    ventana_administrar_vercuponera.setIconifiable(true);
				    ventana_administrar_vercuponera.setResizable(true);
				    ventana_administrar_vercuponera.setMaximizable(true);
						
				   try 
				   {
					   ventana_administrar_vercuponera.setMaximum(true);
				   }catch (PropertyVetoException e1){
						// TODO Auto-generated catch block
							e1.printStackTrace();
							}
							        	
					}
			});		
			mnVercuponera.add(mntmAdministrar_17);
			////////////
		
		
	}
		
	
		
}

