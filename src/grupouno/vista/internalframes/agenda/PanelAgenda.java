package grupouno.vista.internalframes.agenda;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import grupouno.controladores.FactoryControladores;
import grupouno.dto.CitaSimple;
import grupouno.utils.DateConvertUtils;
import grupouno.vista.ventana.Principal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;

import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JCheckBox;
import javax.swing.JSlider;

public class PanelAgenda extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSlider slider;
	private JCheckBox chckbxAutoAjuste ;
	private DefaultListModel<Semana> dlm;
	private static JTable table;
	private JList<Semana> list;
	private Year anio = Year.now();
	private JSpinner spnAnio;
	private String cabeceraDias[] = {"Horas","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};					
//	private Locale locale = new Locale("es", "UY");
	private final int CANT_MAX = 36;
	private Date desde;
	private Date hasta;
	private static ArrayList<LocalDate> ldias = new ArrayList<LocalDate>();
	private static ArrayList<LocalTime> lhoras = new ArrayList<>();
	private 		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd / MM yyyy");
	private static int fila(LocalTime lt){
		return lhoras.indexOf(lt)+1;
	}
	private static int columna(LocalDate ld){
		return ldias.indexOf(ld)+1;
	}
	
	public static void borrarCampo(LocalDate ld, LocalTime lt){
		table.setValueAt("", fila(lt),columna(ld)  );
		seleccionar(ld, lt);
	}
	
//	private JDesktopPane fondo;
	/**
	 * Create the panel.
	 */
	private void chkbox() {
		// TODO Auto-generated method stub
		if (chckbxAutoAjuste.isSelected()){
			slider.setEnabled(false);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}else {
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			slider.setEnabled(true);
			resize();
		}
	}	
	
	private void resize(){
		int w = 60*slider.getValue();
//		int h = 10*slider.getValue();
		if (w>20){
			Dimension d = new Dimension(w,table.getHeight());
			table.setPreferredSize(d);
			d = new Dimension(w,table.getTableHeader().getHeight());
			table.getTableHeader().setPreferredSize(d);
		}
	}
	
	public PanelAgenda()
	{
//		cita.addPropertyChangeListener(new PropertyChangeListener() {
			
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				// TODO Auto-generated method stub
//			System.out.print("cambio el valor la variable");	
//			}
//		});
		JPanel panel = this;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{67, 70, 10, 200, 200};
		gridBagLayout.rowHeights = new int[]{10, 0, 0, 0, 30, 0, 0, 0, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		panel.setLayout(gridBagLayout);
		
		JLabel lblSemana = new JLabel("Semana");
		GridBagConstraints gbc_lblSemana = new GridBagConstraints();
		gbc_lblSemana.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemana.gridx = 1;
		gbc_lblSemana.gridy = 1;
		add(lblSemana, gbc_lblSemana);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String asd = (String)table.getValueAt(0, table.getSelectedColumn());
					LocalDate fecha = LocalDate.parse(asd,dtf);
					LocalTime hora = (LocalTime)table.getValueAt(table.getSelectedRow(), 0);
					abrirVentana(fecha,  hora);
				} catch (Error er){
					JOptionPane.showMessageDialog(null, er.getMessage());
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});


		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridwidth = 3;
		gbc_table.gridheight = 8;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 3;
		gbc_table.gridy = 1;
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, gbc_table);
		
		
		spnAnio = new JSpinner();
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spnAnio, "#");
		spnAnio.setEditor(editor);
		spnAnio.setValue(this.anio.getValue());
		spnAnio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				try {
					int year = (int)spnAnio.getValue();
					if (year<0){
						spnAnio.setValue(0);
						year = 0;
					}
					if (Year.now().getValue()==(int)spnAnio.getValue()) {
						spnAnio.setBackground(Color.green);
					} else {
						spnAnio.setBackground(Color.WHITE);
					}
					anio = Year.of(year);
					cargarDatos();
				} catch (Error er){
					JOptionPane.showMessageDialog(null, er.getMessage());
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}				
		});

		GridBagConstraints gbc_spnAnio = new GridBagConstraints();
		gbc_spnAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnAnio.insets = new Insets(0, 0, 5, 5);
		gbc_spnAnio.gridx = 1;
		gbc_spnAnio.gridy = 2;
		add(spnAnio, gbc_spnAnio);
		
		list = new JList<Semana>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				cargarDatosTabla();
			}

		});

		this.setBackground(Color.white);
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 3;
		JScrollPane scr = new JScrollPane(list);
		add(scr, gbc_list);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				resize();
			}
		});
		

		chckbxAutoAjuste = new JCheckBox("Auto Ajuste");
		chckbxAutoAjuste.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				chkbox();
			}


		});
		GridBagConstraints gbc_chckbxAutoAjuste = new GridBagConstraints();
		gbc_chckbxAutoAjuste.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxAutoAjuste.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAutoAjuste.gridx = 1;
		gbc_chckbxAutoAjuste.gridy = 7;
		add(chckbxAutoAjuste, gbc_chckbxAutoAjuste);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 8;
		add(slider, gbc_slider);

		
		cargarDatos();
		chckbxAutoAjuste.setSelected(true);
		
	}
	
	public static void cargarLista(){
		try {
			
			FactoryControladores f = new FactoryControladores();
			ArrayList<CitaSimple> citass = null;

			for (LocalDate ld : ldias){
				citass = f.getCCitasSimples().entreFechas(ld, ld.plusDays(1));
				for (CitaSimple cs : citass){
					System.out.println(citass);
					int row = fila(cs.getFecha_de_cita().toLocalTime());
					int column = columna(ld);
					table.setValueAt(cs.getCliente(), row, column);
				}
			}
			
		    FormatoTabla ft = new FormatoTabla();
	        table.setDefaultRenderer (Object.class, ft );
	        table.setDefaultEditor(Object.class, null);
	        table.setRowHeight(25);
	        table.setRowSelectionAllowed(false);
//			table.getColumnModel().getColumn(0).setHeaderRenderer(new FormatoTabla(rows,columns));			
		} catch (Error er){
			JOptionPane.showMessageDialog(null, er.getMessage());
		} catch (Exception es) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, es.getMessage());
		}
	}

	private void cargarDatosTabla() {
		// TODO Auto-generated method stub
		try {
			if (list.getSelectedIndex() != -1){
				LocalDate semana = ((Semana)list.getSelectedValue()).ld;
				DefaultTableModel df = new DefaultTableModel(cabeceraDias, CANT_MAX+1);

				table.setModel(df);							

				int dayOfWeek = semana.getDayOfWeek().getValue();
//				System.out.println(dayOfWeek);
				ldias.clear();
				for (int i = 0; i < 7; i++) {
					LocalDate l = semana.minusDays(dayOfWeek-i-1);
					ldias.add(l);
					table.setValueAt(dtf.format(l), 0, i+1);
				}
				desde = DateConvertUtils.asUtilDate(ldias.get(0));
				hasta = DateConvertUtils.asUtilDate(ldias.get(6));
				Calendar cal = new GregorianCalendar();
				cal.setTime(desde);
				cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)+ 480);
				desde = cal.getTime();
				cal.setTime(hasta);
				cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)+ 480);
				for (int i = 1; i < CANT_MAX; i++) {
					cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)+ 30);
				}
				hasta = cal.getTime();
				lhoras.clear();
				lhoras.add(LocalTime.of(8, 00));
				int fila;
				for (fila = 1; fila < CANT_MAX; fila++){
					table.setValueAt(lhoras.get(fila-1), fila, 0);
					lhoras.add(lhoras.get(fila-1).plusMinutes(30));
				}
										
				table.setValueAt(lhoras.get(fila-1), fila, 0);
				cargarLista();
			}					
		} catch (Error er){
			JOptionPane.showMessageDialog(null, er.getMessage());
		} catch (Exception es) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, es.getMessage());
		}				
	}	
	
	private void abrirVentana(LocalDate fecha, LocalTime hora){
		Cita ventana = Cita.getCita(fecha,hora);
	
		ventana.setTitle("Agendar cita para el "+fecha+ " a las "+hora+ " horas.");
		Principal.fondo.add(ventana);
        ventana.setBounds(0, 0, 370,465);
        Dimension desktopSize = Principal.fondo.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
        ventana.setVisible(true);
        ventana.setClosable(true);
		
		ventana.toFront();
	}

	public static void seleccionar(LocalDate ld, LocalTime lt) {
		// TODO Auto-generated method stub
		table.changeSelection(fila(lt), columna(ld), false,false);
	}	
	
	

	public void cargarDatos() {
		try {
			dlm = new DefaultListModel<>();
			Semana k = new Semana(LocalDate.of(anio.getValue(), 1, 1));
			while (k.ld.getYear()!=anio.getValue()+1) {
				dlm.addElement(k);
				k = k.plusWeeks(1);
			};
			list.setModel(dlm);
			LocalDate da = LocalDate.now();
			
			if (anio.getValue() == Year.now().getValue()){
				list.setSelectedIndex(da.getDayOfYear()/7);
			}else{
				list.setSelectedIndex(0);
			}			
		} catch (Error er){
			JOptionPane.showMessageDialog(null, er.getMessage());
		} catch (Exception es) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, es.getMessage());
		}
	}
	
	
	private class Semana{
		private LocalDate ld;
		
		public Semana(LocalDate ld) {
			this.ld = ld;
		}
		
		public Semana plusWeeks(int dias) {
			return new Semana(ld.plusWeeks(1));
		}
		
		public String getMostrar() {
			Month mes = ld.getMonth();
			Calendar c = Calendar.getInstance();
			c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
			c.setMinimalDaysInFirstWeek(1);
			int semana = c.get(Calendar.WEEK_OF_MONTH);
			return mes.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + semana + " (" + ld.getDayOfMonth()  + " a " + (ld.getDayOfMonth()+7) + "/" + ld.getMonth().getValue() + ")";
		}

		@Override
		public String toString() {
			return getMostrar();
		}
		
	
	}
	
}

