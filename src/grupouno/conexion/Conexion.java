package grupouno.conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
    public Connection conn=null;
    public DatabaseMetaData dbmt;
    public String datosConexion;
    
    protected String jdbc;
    protected String driver;
    protected String host;
    protected String database;
    protected String username;
    protected String password;
    
    
    public Conexion() throws Error{
    	
        //obtenemos los parametros de el archivo de configuracion señalado en Inicio.java
        this.jdbc = System.getProperty("jdbc");
        this.driver = System.getProperty("driver");
        this.host = System.getProperty("host");
        this.database = System.getProperty("database");
        this.username = System.getProperty("username");
        this.password = System.getProperty("password");
        //
        
        try {
            iniciardb();
        } catch (Exception e) {
            throw new Error("Ha ocurrido un error al conectar a la base de datos");
        }
    }

    public void iniciardb() throws Error {
        try{
        	
//            Properties p = System.getProperties();
//			driver = p.getProperty("driver");
//			username = p.getProperty("usuario");
//			String pass = p.getProperty("password");
//			String url = p.getProperty("url");
//			String base = p.getProperty("bdatos");
        	
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://sqlstandard.database.windows.net:1433;database=peluqueria;user=mathias@sqlstandard;password=s3a8EtrEpr&?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");

//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost/peluqueria", "root", "");        	
//        	System.out.println("Preparando...");
//            this.datosConexion = jdbc + host + "/" + database;
//            System.out.println(datosConexion);
//            System.out.println("Cargando driver...");
//            Class.forName(driver).newInstance();
//            
//            System.out.println("Conectando...");
//            System.out.println("Datos conexion: "+datosConexion+" usuario: "+username+" pass:"+password);
//            System.out.println(" conn is "+conn==null?"null":"no null");
//            conn= DriverManager.getConnection(datosConexion, username, password);
            System.out.println("Conectado!");
        }
        catch(Exception e){
           throw new Error("Ha ocurrido un error al conectar a la base de datos");
        }
    }

}
