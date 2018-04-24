package grupouno.conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Conectar {
//    private Conexion cdb;
	Connection conn = null;
    private static Conectar instancia;
    Properties p = new Properties(System.getProperties());
    public Conectar()   
    {
        if (conn==null){

        }
    }
    
    public synchronized static Conectar estado()
    {
            if (instancia==null){
            instancia = new Conectar();
        }
        return instancia;
    }
    
    public Connection getConnection() {
       	Connection conn = null;
    	try {
//    		Class.forName("com.mysql.jdbc.Driver");
//    		conn = DriverManager.getConnection("jdbc:mysql://localhost/peluqueria", "root", "");     
       	     File miDir = new File(".");
       	     String dir = "";
       	     try {
       	       dir = miDir.getCanonicalPath();
       	      // miDir.separatorChar = '\\';
       	       System.out.println(dir);
       	       }
       	     catch(Exception e) {
       	       e.printStackTrace();
       	       }
       		Class.forName("org.sqlite.JDBC");
//       		String url_mysql = "mysql://localhost/peluqueria";
//       		String sqlite = "sqlite:\\test.db";
//       		JOptionPane.showMessageDialog(null, "llego1="+"jdbc:sqlite:"+dir+File.separatorChar+"db"+File.separatorChar+"peluqueria.sqlite");
       		conn = DriverManager.getConnection("jdbc:sqlite:"+dir+File.separatorChar+"db"+File.separatorChar+"peluqueria.sqlite");
       		System.out.println("llego2");
		} catch (Exception e) {
			// TODO: handle exception
		}    	
        return conn;
    }
    
    public void cerrarConexion(){
        instancia = null;
    }

}
