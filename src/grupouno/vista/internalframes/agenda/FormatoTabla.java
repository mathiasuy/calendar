package grupouno.vista.internalframes.agenda;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class FormatoTabla extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font normal = new Font( "Arial",Font.BOLD,15 );
    Font negrilla = new Font( "Helvetica",Font.BOLD,18 );
    Font extra_negrilla = new Font( "Helvetica",Font.BOLD,19 );
    Font cursiva = new Font( "Times new roman",Font.ITALIC,12 );	
	
    public FormatoTabla()
    {
    }

    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {
    	table.setFont(normal);
    	this.setOpaque(true);
    	if (row==0){
    		if (column%2==0){
    			setBackground(new Color(255,117,117));    			
    		}else{
    			setBackground(new Color(255,173,173));
    		}
    		if (value instanceof String){
	            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
	            if (value.equals(LocalDate.now().format(dtf))){
	          	  setBackground(Color.CYAN);
	            }    			
    		}
    	}else if (column==0) {
          	if (value instanceof LocalTime){
	    		if (row %2 == 0) {
	    			setBackground(new Color(249,195,71));	
				} else {
					setBackground(new Color(243,206,118));	
				}
	    		table.setFont(negrilla);
        	}
		}else{
	        if (value instanceof String) {
	            if( row != 0 &&  column != 0 ){
	                setBackground(new Color(248,252,227));
	            }
	        }else{			
		    	if (column % 2==0) {
		    		if (row %2 == 0) {
		    			setBackground(new Color(255,242,112));	
					} else {
						setBackground(new Color(252,246,161));
							
					}
		    	}else{
		    		if (row %2 == 0) {
		    			setBackground(new Color(247,236,136));
					} else {
						setBackground(new Color(253,244	,165));
					}		    		
				}
	        }
	        if (selected) {
	    		setBackground(new Color(210,186,229));
			}
			if (focused) {
				setBackground(new Color(210,186,229));
			}
		}
 
    	table.setForeground(Color.black);
    	table.getTableHeader().setFont(new java.awt.Font("Tahoma", 1, 15));
    	table.getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 14, 162)));

      super.getTableCellRendererComponent(table, value, selected, focused, row, column);
      return this;
 }

}