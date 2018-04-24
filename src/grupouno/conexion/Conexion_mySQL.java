package grupouno.conexion;

import java.sql.DriverManager;
import java.util.Properties;

public class Conexion_mySQL  extends Conexion{
    private String opciones;
    
    public Conexion_mySQL() throws Error {

        opciones = System.clearProperty("options");

        iniciardb();
    }

    @Override
    public void iniciardb() throws Error {

        try{

			
            //super.datosConexion = jdbc + host + "/" + database ;
            super.iniciardb();
        }
        catch(Exception e){
           throw new Error("Ha ocurrido un error al conectar a la base de datos");
        }
    }  
}
